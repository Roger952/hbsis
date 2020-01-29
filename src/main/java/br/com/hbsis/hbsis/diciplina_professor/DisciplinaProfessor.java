package br.com.hbsis.hbsis.diciplina_professor;

import br.com.hbsis.hbsis.disciplina.Disciplina;
import br.com.hbsis.hbsis.teacher.Teacher;
import br.com.hbsis.hbsis.utils.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity(name = "disciplina_professor")
public class DisciplinaProfessor extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "id_disciplina", referencedColumnName = "id")
    private Disciplina disciplina;
    @ManyToOne
    @JoinColumn(name = "id_professor", referencedColumnName = "id")
    private Teacher teacher;

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "DisciplinaProfessorDTO{" +
                "disciplina=" + disciplina +
                ", teacher=" + teacher +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DisciplinaProfessor)) return false;
        if (!super.equals(o)) return false;
        DisciplinaProfessor that = (DisciplinaProfessor) o;
        return disciplina.equals(that.disciplina) &&
                teacher.equals(that.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), disciplina, teacher);
    }
}
