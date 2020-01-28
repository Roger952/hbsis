package br.com.hbsis.hbsis.disciplina;

import br.com.hbsis.hbsis.teacher.TeacherDTO;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaDTO {

    private String nameDisciplina;
    private List<TeacherDTO> teachers;

    public DisciplinaDTO() {
    }

    public DisciplinaDTO(String nameDisciplina, List<TeacherDTO> teachers) {
        this.nameDisciplina = nameDisciplina;
        this.teachers = teachers;
    }

    public static DisciplinaDTO of(Disciplina disciplina) {

        List<TeacherDTO> teachers = new ArrayList<>();

        disciplina.getTeachers().forEach(teacher -> teachers.add(TeacherDTO.of(teacher)));

        return new DisciplinaDTO(
                disciplina.getNameDisciplina(),
                teachers
        );
    }

    public String getNameDisciplina() {
        return nameDisciplina;
    }

    public void setNameDisciplina(String nameDisciplina) {
        this.nameDisciplina = nameDisciplina;
    }

    public List<TeacherDTO> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TeacherDTO> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "DisciplinaDTO{" +
                "nameDisciplina='" + nameDisciplina + '\'' +
                ", teachers=" + teachers +
                '}';
    }
}
