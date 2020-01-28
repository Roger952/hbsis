package br.com.hbsis.hbsis.turmas;

import br.com.hbsis.hbsis.diciplina_professor.DisciplinaProfessor;
import br.com.hbsis.hbsis.turmas.Serie.Serie;
import br.com.hbsis.hbsis.utils.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "turma")
public class Turma extends AbstractEntity {

    @Column(name = "nome_turma", length = 50, unique = true, nullable = false)
    private String nameTurma;
    @Column(name = "quantidade_max_alunos", nullable = false)
    private Integer amountOfStudents;
    @ManyToOne
    @JoinColumn(name = "id_serie", nullable = false, referencedColumnName = "id")
    private Serie serie;

    @ManyToMany
    @JoinTable(name = "turma_materias",
            joinColumns = {@JoinColumn(name = "id_turma", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "id_disciplina_professor", referencedColumnName = "id")})
    List<DisciplinaProfessor> disciplinaProfessores;

    public String getNameTurma() {
        return nameTurma;
    }

    public void setNameTurma(String nameTurma) {
        this.nameTurma = nameTurma;
    }

    public Integer getAmountOfStudents() {
        return amountOfStudents;
    }

    public void setAmountOfStudents(Integer amountOfStudents) {
        this.amountOfStudents = amountOfStudents;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public List<DisciplinaProfessor> getDisciplinaProfessores() {
        return disciplinaProfessores;
    }

    public void setDisciplinaProfessores(List<DisciplinaProfessor> disciplinaProfessores) {
        this.disciplinaProfessores = disciplinaProfessores;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "nameTurma='" + nameTurma + '\'' +
                ", amountOfStudents=" + amountOfStudents +
                ", serie=" + serie +
                ", disciplinaProfessores=" + disciplinaProfessores +
                '}';
    }
}
