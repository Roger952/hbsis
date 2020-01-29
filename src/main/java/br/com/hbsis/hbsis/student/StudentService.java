package br.com.hbsis.hbsis.student;

import br.com.hbsis.hbsis.turmas.TurmaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);

    private final IStudentRepository iStudentRepository;
    private final TurmaService turmaService;

    public StudentService(IStudentRepository iStudentRepository, TurmaService turmaService) {
        this.iStudentRepository = iStudentRepository;
        this.turmaService = turmaService;
    }

    public StudentDTO save(StudentDTO studentDTO) {
        LOGGER.info("Salvando o estudante");

        validate(studentDTO);

        Student student = of(studentDTO);

        student = iStudentRepository.save(student);

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

        if (iStudentRepository.existsByCpf(studentDTO.getCpf())){
            throw new IllegalArgumentException("Já existe um aluno cadatrado com este cpf");
        }
        if (iStudentRepository.existsByEmail(studentDTO.getEmail())){
            throw new IllegalArgumentException("Já existe um aluno cadastrado com este email");
        }
        if (iStudentRepository.existsByRegistration(studentDTO.getRegistration())){
            throw new IllegalArgumentException("Já existe um aluno cadastrado com esta matricula");
        }
        if (studentDTO.getTelephone().matches("(\\(\\d{2}\\)\\s)(\\d{4,5}-\\d{4})")){
            studentDTO.setTelephone(studentDTO.getTelephone().replaceAll("[^0-9]", ""));
        }
    }
}
