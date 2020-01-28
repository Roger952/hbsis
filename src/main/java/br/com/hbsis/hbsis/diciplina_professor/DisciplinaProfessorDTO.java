package br.com.hbsis.hbsis.diciplina_professor;

import javax.validation.constraints.NotNull;

public class DisciplinaProfessorDTO {

    private Long id;
    private Long disciplina;
    private Long teacher;

    public DisciplinaProfessorDTO() {
    }

    public DisciplinaProfessorDTO(Long id, Long disciplina, Long teacher) {
        this.id = id;
        this.disciplina = disciplina;
        this.teacher = teacher;
    }

    public static DisciplinaProfessorDTO of(DisciplinaProfessor disciplinaProfessor) {
        return new DisciplinaProfessorDTO(
                disciplinaProfessor.getId(),
                disciplinaProfessor.getDisciplina().getId(),
                disciplinaProfessor.getTeacher().getId()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Long disciplina) {
        this.disciplina = disciplina;
    }

    public Long getTeacher() {
        return teacher;
    }

    public void setTeacher(Long teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "DisciplinaProfessorDTO{" +
                "id=" + id +
                ", disciplina=" + disciplina +
                ", teacher=" + teacher +
                '}';
    }
}
