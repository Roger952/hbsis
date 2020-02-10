package br.com.hbsis.hbsis.modelo_boletim;

import br.com.hbsis.hbsis.boletim.Boletim;
import br.com.hbsis.hbsis.semestre.Semestre;
import br.com.hbsis.hbsis.student.Student;
import br.com.hbsis.hbsis.student.StudentService;
import br.com.hbsis.hbsis.turma_materias.TurmaMaterias;
import br.com.hbsis.hbsis.year.Year;
import br.com.hbsis.hbsis.year.YearService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Service
public class ModeloBoletimService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModeloBoletimService.class);

    private final IModeloBoletimRepository iModeloBoletimRepository;
    private final YearService yearService;
    private final StudentService studentService;

    public ModeloBoletimService(IModeloBoletimRepository iModeloBoletimRepository, YearService yearService, StudentService studentService) {
        this.iModeloBoletimRepository = iModeloBoletimRepository;
        this.yearService = yearService;
        this.studentService = studentService;
    }

    public ModeloBoletimDTO save(ModeloBoletimDTO modeloBoletimDTO) {

        LOGGER.info("Salvando Alterações feitas no boletim");

        ModeloBoletim modeloBoletim = of(modeloBoletimDTO);

        modeloBoletim = iModeloBoletimRepository.save(modeloBoletim);

        return ModeloBoletimDTO.of(modeloBoletim);

    }

    private ModeloBoletim of(ModeloBoletimDTO modeloBoletimDTO) {
        return new ModeloBoletim(
                modeloBoletimDTO.getNameDisciplina(),
                modeloBoletimDTO.getMediaPrimeiroSemestre(),
                modeloBoletimDTO.getMediaSegundoSemestre(),
                modeloBoletimDTO.getMediaerceiroSemestre(),
                modeloBoletimDTO.getNameStudent(),
                modeloBoletimDTO.getNameTurma(),
                modeloBoletimDTO.getNameYear(),
                modeloBoletimDTO.getNameSchool(),
                yearService.findById(modeloBoletimDTO.getYear()),
                studentService.findById(modeloBoletimDTO.getStudent())
        );
    }

    public void autoUpdateModeloBoletim(Boletim boletim) {

        LOGGER.info("Obtendo as informações para realizar o update do modelo do boletim");

        Optional<ModeloBoletim> modeloBoletimOptional = iModeloBoletimRepository.findByNameDisciplinaAndYearAndStudent(boletim.getDisciplina().getNameDisciplina(), boletim.getSemestre().getYear(), boletim.getStudent());

        if (modeloBoletimOptional.isPresent()) {

            ModeloBoletim modeloBoletim = modeloBoletimOptional.get();

            switch (boletim.getSemestre().getNameSemestre()) {
                case "Primeiro Semestre":
                    modeloBoletim.setMediaPrimeiroSemestre(String.valueOf(boletim.getMediaFinal()));
                    break;
                case "Segundo Semestre":
                    modeloBoletim.setMediaSegundoSemestre(String.valueOf(boletim.getMediaFinal()));
                    break;
                case "Terceiro Semestre":
                    modeloBoletim.setMediaerceiroSemestre(String.valueOf(boletim.getMediaFinal()));
                    break;
                default:
                    LOGGER.error("Semestre incompativel");
                    break;
            }

            iModeloBoletimRepository.save(modeloBoletim);
        }
    }

    public void autoSaveModeloBoletim(TurmaMaterias turmaMaterias, Semestre semestre, Student student) {
        Optional<ModeloBoletim> modeloBoletimOptional = iModeloBoletimRepository.findByNameDisciplinaAndYearAndStudent(turmaMaterias.getDisciplina().getNameDisciplina(), semestre.getYear(), student);
        Calendar calendar = new GregorianCalendar();
        if (!modeloBoletimOptional.isPresent()) {
            ModeloBoletimDTO modeloBoletimDTO = new ModeloBoletimDTO(
                    null,
                    turmaMaterias.getDisciplina().getNameDisciplina(),
                    "0",
                    "0",
                    "0",
                    student.getNameStudent(),
                    turmaMaterias.getTurma().getNameTurma(),
                    String.valueOf(calendar.get(Calendar.YEAR)),
                    turmaMaterias.getTurma().getInstituicao().getNameInstituicao(),
                    semestre.getYear().getId(),
                    student.getId()
            );

            save(modeloBoletimDTO);
        }
    }

    private List<ModeloBoletimDTO> findByStudent(Long idStudent) {

        List<ModeloBoletimDTO> modeloBoletimDTOS = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();

        Year year = yearService.findByYearName(String.valueOf(calendar.get(Calendar.YEAR)));
        Student student = studentService.findById(idStudent);

        for (ModeloBoletim modeloBoletim : iModeloBoletimRepository.findByYearAndStudent(year, student)) {
            modeloBoletimDTOS.add(ModeloBoletimDTO.of(modeloBoletim));
        }

        return modeloBoletimDTOS;
    }

    public byte[] exportReport(Long idStudent) throws FileNotFoundException, JRException {

        List<ModeloBoletimDTO> boletimDTOS = findByStudent(idStudent);

        File file = ResourceUtils.getFile("classpath:ExportBoletim.jrxml");

        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(boletimDTOS);

        Map<String, Object> map = new HashMap<>();

        map.put("createdBy", "Modelo Boletim");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, dataSource);

        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
