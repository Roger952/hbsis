package br.com.hbsis.hbsis.atividade;

import br.com.hbsis.hbsis.disciplina.DisciplinaService;
import br.com.hbsis.hbsis.semestre.SemestreService;
import br.com.hbsis.hbsis.student.StudentService;
import br.com.hbsis.hbsis.teacher.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AtividadeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AtividadeService.class);

    private final IAtividadeRepository iAtividadeRepository;
    private final StudentService studentService;
    private final DisciplinaService disciplinaService;
    private final SemestreService semestreService;
    private final TeacherService teacherService;

    public AtividadeService(IAtividadeRepository iAtividadeRepository, StudentService studentService, DisciplinaService disciplinaService, SemestreService semestreService, TeacherService teacherService) {
        this.iAtividadeRepository = iAtividadeRepository;
        this.studentService = studentService;
        this.disciplinaService = disciplinaService;
        this.semestreService = semestreService;
        this.teacherService = teacherService;
    }

    public AtividadeDTO save(AtividadeDTO atividadeDTO) {

        LOGGER.info("Salvando as atividades");

        validate(atividadeDTO);

        Atividade atividade = of(atividadeDTO);

        atividade = iAtividadeRepository.save(atividade);

        return AtividadeDTO.of(atividade);
    }

    public Atividade of(AtividadeDTO atividadeDTO) {
        return new Atividade(
                atividadeDTO.getDescription(),
                atividadeDTO.getStatus(),
                atividadeDTO.getReleaseDate(),
                atividadeDTO.getEndDate(),
                semestreService.findById(atividadeDTO.getIdSemestre()),
                disciplinaService.findById(atividadeDTO.getIdDisciplina()),
                teacherService.findById(atividadeDTO.getIdTeacher()),
                studentService.findById(atividadeDTO.getIdStudent()),
                atividadeDTO.getGrades()
        );
    }

    private void validate(AtividadeDTO atividadeDTO) {
        LOGGER.info("Validando as atividades");

        if (atividadeDTO.getEndDate().before(atividadeDTO.getReleaseDate())) {
            throw new IllegalArgumentException("A data de termino não pode ser anterior a data de inicio");
        }
        if (StringUtils.isEmpty(atividadeDTO.getStatus())) {
            atividadeDTO.setStatus("Ativo");
        }

    }
}
