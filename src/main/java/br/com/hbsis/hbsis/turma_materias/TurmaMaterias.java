package br.com.hbsis.hbsis.turma_materias;

import br.com.hbsis.hbsis.disciplina.Disciplina;
import br.com.hbsis.hbsis.turmas.Turma;
import br.com.hbsis.hbsis.utils.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity(name = "turma_materias")
public class TurmaMaterias extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "id_turma", referencedColumnName = "id")
    private Turma turma;
    @ManyToOne
    @JoinColumn(name = "id_disciplina", referencedColumnName = "id")
    private Disciplina disciplina;

    public TurmaMaterias() {
    }

    public TurmaMaterias(Turma turma, Disciplina disciplina) {
        this.turma = turma;
        this.disciplina = disciplina;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplinaProfessor) {
        this.disciplina = disciplinaProfessor;
    }

    @Override
    public String toString() {
        return "TurmaMaterias{" +
                "turma=" + turma +
                ", disciplinaProfessor=" + disciplina +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TurmaMaterias)) return false;
        if (!super.equals(o)) return false;
        TurmaMaterias that = (TurmaMaterias) o;
        return turma.equals(that.turma) &&
                disciplina.equals(that.disciplina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), turma, disciplina);
    }
}
