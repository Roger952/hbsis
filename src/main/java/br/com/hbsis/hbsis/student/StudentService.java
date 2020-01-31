package br.com.hbsis.hbsis.student;

import br.com.hbsis.hbsis.boletim.BoletimService;
import br.com.hbsis.hbsis.turmas.TurmaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    private final IStudentRepository iStudentRepository;
    private final TurmaService turmaService;
    private final BoletimService boletimService;

    public StudentService(IStudentRepository iStudentRepository, TurmaService turmaService, @Lazy BoletimService boletimService) {
        this.iStudentRepository = iStudentRepository;
        this.turmaService = turmaService;
        this.boletimService = boletimService;
    }

    public StudentDTO save(StudentDTO studentDTO) {
        LOGGER.info("Salvando o estudante");

        validate(studentDTO);

        Student student = of(studentDTO);

        student = iStudentRepository.save(student);

        Calendar calendar = new GregorianCalendar();

        boletimService.autoSaveBoletim(String.valueOf(calendar.get(Calendar.YEAR)), student);

        return StudentDTO.of(student);
    }

    private Student of(StudentDTO studentDTO) {

        LOGGER.info("Removing DTO");

        return new Student(
                studentDTO.getNameStudent(),
                studentDTO.getRegistration(),
                studentDTO.getSex(),
                studentDTO.getAge(),
                studentDTO.getTelephone(),
                studentDTO.getAddress(),
                studentDTO.getEmail(),
                studentDTO.getCpf(),
                turmaService.findById(studentDTO.getIdTurma())
        );
    }

    private void validate(StudentDTO studentDTO) {
        LOGGER.info("Validating students DTO");

        if (iStudentRepository.existsByCpf(studentDTO.getCpf())) {
            throw new IllegalArgumentException("Já existe um aluno cadatrado com este cpf");
        }
        if (iStudentRepository.existsByEmail(studentDTO.getEmail())) {
            throw new IllegalArgumentException("Já existe um aluno cadastrado com este email");
        }
        if (iStudentRepository.existsByRegistration(studentDTO.getRegistration())) {
            throw new IllegalArgumentException("Já existe um aluno cadastrado com esta matricula");
        }
        if (studentDTO.getTelephone().matches("(\\(\\d{2}\\)\\s)(\\d{4,5}-\\d{4})")) {
            studentDTO.setTelephone(studentDTO.getTelephone().replaceAll("[^0-9]", ""));
        }
    }

    public Student findById(Long id) {
        Optional<Student> studentOptional = iStudentRepository.findById(id);

        if (studentOptional.isPresent()) {
            return studentOptional.get();
        }

        throw new IllegalArgumentException("Não foi possivel encontrar um estudante com ete id");
    }

    public List<Student> findByTurmaAndNameStudentContaining(Long idTurma, String nameSrudentContaining) {
        return iStudentRepository.findByTurmaAndNameStudentContaining(turmaService.findById(idTurma), nameSrudentContaining);
    }

    public Student findByRegister(String register) {
        Optional<Student> studentOptional = iStudentRepository.findByRegistration(register);

        if (studentOptional.isPresent()) {
            return studentOptional.get();
        }
        throw new IllegalArgumentException("Não foi possivel encontrar um estudante com ete id");
    }

}
