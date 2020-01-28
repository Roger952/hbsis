package br.com.hbsis.hbsis.teacher;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/teachers")
public class TeacherRest {

    private final TeacherService teacherService;

    public TeacherRest(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<TeacherDTO> save(@Valid @RequestBody TeacherDTO teacherDTO) {

        teacherDTO = teacherService.save(teacherDTO);

        return new ResponseEntity<>(teacherDTO, HttpStatus.OK);
    }
}
