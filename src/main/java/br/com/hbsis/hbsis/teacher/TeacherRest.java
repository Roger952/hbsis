package br.com.hbsis.hbsis.teacher;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/{id}")
    public ResponseEntity<TeacherDTO> findById(@PathVariable("id") Long id) {

        TeacherDTO teacherDTO = teacherService.findByIdTeacherDTO(id);

        return new ResponseEntity<>(teacherDTO, HttpStatus.OK);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<TeacherDTO> update(@PathVariable(name = "id") Long id, @RequestBody TeacherDTO teacherDTO) {
        teacherService.update(teacherDTO, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
