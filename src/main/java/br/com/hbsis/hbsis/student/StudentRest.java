package br.com.hbsis.hbsis.student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("student")
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
}
