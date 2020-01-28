package br.com.hbsis.hbsis.turma_materias;

import br.com.hbsis.hbsis.diciplina_professor.DisciplinaProfessor;
import br.com.hbsis.hbsis.turmas.Turma;
import br.com.hbsis.hbsis.utils.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "turma_materias")
public class TurmaMaterias extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "id_turma", referencedColumnName = "id")
    private Turma turma;
    @ManyToOne
    @JoinColumn(name = "id_disciplina_professor", referencedColumnName = "id")
    private DisciplinaProfessor disciplinaProfessor;

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public DisciplinaProfessor getDisciplinaProfessor() {
        return disciplinaProfessor;
    }

    public void setDisciplinaProfessor(DisciplinaProfessor disciplinaProfessor) {
        this.disciplinaProfessor = disciplinaProfessor;
    }

    @Override
    public String toString() {
        return "TurmaMaterias{" +
                "turma=" + turma +
                ", disciplinaProfessor=" + disciplinaProfessor +
                '}';
    }
}
