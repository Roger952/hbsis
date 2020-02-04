package br.com.hbsis.hbsis.boletim;

import br.com.hbsis.hbsis.atividade.Atividade;
import br.com.hbsis.hbsis.disciplina.DisciplinaService;
import br.com.hbsis.hbsis.modelo_boletim.ModeloBoletimService;
import br.com.hbsis.hbsis.semestre.Semestre;
import br.com.hbsis.hbsis.semestre.SemestreService;
import br.com.hbsis.hbsis.student.Student;
import br.com.hbsis.hbsis.student.StudentService;
import br.com.hbsis.hbsis.turma_materias.TurmaMaterias;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoletimService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BoletimService.class);

    private final IBoletimRepository iBoletimRepository;
    private final SemestreService semestreService;
    private final StudentService studentService;
    private final DisciplinaService disciplinaService;
    private final ModeloBoletimService modeloBoletimService;


    public BoletimService(IBoletimRepository iBoletimRepository, SemestreService semestreService, StudentService studentService, DisciplinaService disciplinaService, ModeloBoletimService modeloBoletimService) {
        this.iBoletimRepository = iBoletimRepository;
        this.semestreService = semestreService;
        this.studentService = studentService;
        this.disciplinaService = disciplinaService;
        this.modeloBoletimService = modeloBoletimService;
    }

    public BoletimDTO save(BoletimDTO boletimDTO) {
        LOGGER.info("Salvando o boletim inserido");

        validate(boletimDTO);

        Boletim boletim = of(boletimDTO);

        boletim = iBoletimRepository.save(boletim);

        return BoletimDTO.of(boletim);
    }

    private void validate(BoletimDTO boletimDTO) {

        LOGGER.info("Validando o Boletim inserido");

        if (existRepeatedBoletim(boletimDTO)) {
            throw new IllegalArgumentException("Já existe um boletim aberto com estas infomações");
        }
        if (StringUtils.isEmpty(boletimDTO.getMediaFinal())) {
            boletimDTO.setMediaFinal((double) 0);
        }
        if (boletimDTO.getMediaFinal() > 10) {
            throw new IllegalArgumentException("Media Inválida");
        }
    }

    private boolean existRepeatedBoletim(BoletimDTO boletimDTO) {
        return iBoletimRepository.existsByDisciplinaAndSemestreAndStudent(
                disciplinaService.findById(boletimDTO.getDisciplina()),
                semestreService.findById(boletimDTO.getSemestre()),
                studentService.findById(boletimDTO.getStudent())
        );
    }

    private Boletim of(BoletimDTO boletimDTO) {
        return new Boletim(
                boletimDTO.getMediaFinal(),
                disciplinaService.findById(boletimDTO.getDisciplina()),
                studentService.findById(boletimDTO.getStudent()),
                semestreService.findById(boletimDTO.getSemestre())
        );
    }

    public Boletim findById(Long id) {
        Optional<Boletim> boletimOptional = iBoletimRepository.findById(id);

        if (boletimOptional.isPresent()) {
            return boletimOptional.get();
        }

        throw new IllegalArgumentException("Não foi encontrado um Boetim com este Id");
    }

    public void autoUpdateBoletimForIdBoletim(Long id) {

        Optional<Boletim> boletimOptional = iBoletimRepository.findById(id);

        if (boletimOptional.isPresent()) {

            Boletim boletim = boletimOptional.get();

            boletim = iBoletimRepository.save(updateMedia(boletim, boletim.getAtividadeSet()));

            modeloBoletimService.autoUpdateModeloBoletim(boletim);
        } else {
            LOGGER.info("Não foi encontrado um boletim com este Id");
        }
    }

    private Boletim updateMedia(Boletim boletim, List<Atividade> atividades) {

        double somaAtividades = 0;
        int contador = 0;

        for (Atividade atividade : atividades) {
            somaAtividades += atividade.getGrades();
            contador++;
            boletim.setMediaFinal(somaAtividades / contador);
        }

        return boletim;
    }

    public List<BoletimDTO> findByStudentAndYear(Long idStudent, String year) {

        List<BoletimDTO> boletimListDTO = new ArrayList<>();

        for (Semestre semestre : semestreService.findByYear(year)) {

            for (Boletim boletim : iBoletimRepository.findByStudentAndSemestre(studentService.findById(idStudent), semestre)) {
                boletimListDTO.add(BoletimDTO.of(boletim));
            }
        }

        return boletimListDTO;
    }

    public void autoSaveBoletim(String year, Student student) {

        List<Semestre> semestreList = semestreService.findByYear(year);

        for (Semestre semestre : semestreList) {
            for (TurmaMaterias turmaMaterias : student.getTurma().getTurmaMaterias()) {
                Boletim boletim = new Boletim();

                boletim.setStudent(student);
                boletim.setDisciplina(turmaMaterias.getDisciplina());
                boletim.setSemestre(semestre);

                modeloBoletimService.autoSaveModeloBoletim(turmaMaterias, semestre, student);

                save(BoletimDTO.of(boletim));
            }
        }
    }
}
