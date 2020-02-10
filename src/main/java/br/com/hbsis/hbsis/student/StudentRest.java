package br.com.hbsis.hbsis.student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentRest.class);
    private final StudentService studentService;

    public StudentRest(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentDTO save(@Valid @RequestBody StudentDTO studentDTO) {

        LOGGER.info("Enviando requisição para salvar o estudante inserido");

        return studentService.save(studentDTO);
    }

    @GetMapping("findByInstituicaoAndNameTurma/{idTurma}/{nameTurmaInserted}")
    public ResponseEntity<List<Student>> findByInstituicaoAndNameTurmaContaining(@PathVariable(name = "idTurma") Long idTurma,
                                                                                 @PathVariable(name = "nameTurmaInserted") String nameTurmaInserted) {

        return new ResponseEntity<>(studentService.findByTurmaAndNameStudentContaining(idTurma, nameTurmaInserted), HttpStatus.OK);
    }

    @GetMapping("/findByResgister/{register}")
    public ResponseEntity<Student> findByRegister(@PathVariable(name = "register") String register) {

        return new ResponseEntity<>(studentService.findByRegister(register), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public List<StudentDTO> findAll() {
        return studentService.findAll();
    }
}
