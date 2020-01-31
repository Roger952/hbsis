package br.com.hbsis.hbsis.turmas;

import br.com.hbsis.hbsis.intituicao.Instituicao;
import br.com.hbsis.hbsis.turma_materias.TurmaMaterias;
import br.com.hbsis.hbsis.turmas.Serie.Serie;
import br.com.hbsis.hbsis.utils.AbstractEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "turma")
public class Turma extends AbstractEntity {

    @Column(name = "nome_turma", length = 50, unique = true, nullable = false)
    private String nameTurma;
    @Column(name = "quantidade_max_alunos", nullable = false)
    private Integer amountOfStudents;
    @ManyToOne
    @JoinColumn(name = "id_serie", nullable = false, referencedColumnName = "id")
    private Serie serie;
    @ManyToOne
    @JoinColumn(name = "id_instituicao", nullable = false, referencedColumnName = "id")
    private Instituicao instituicao;
    @OneToMany(mappedBy = "turma")
    private List<TurmaMaterias> turmaMaterias;

    public Turma() {
    }

    public Turma(String nameTurma, Integer amountOfStudents, Serie serie, Instituicao instituicao) {
        this.nameTurma = nameTurma;
        this.amountOfStudents = amountOfStudents;
        this.serie = serie;
        this.instituicao = instituicao;
    }

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

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public List<TurmaMaterias> getTurmaMaterias() {
        return turmaMaterias;
    }

    public void setTurmaMaterias(List<TurmaMaterias> turmaMaterias) {
        this.turmaMaterias = turmaMaterias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Turma)) return false;
        if (!super.equals(o)) return false;
        Turma turma = (Turma) o;
        return nameTurma.equals(turma.nameTurma) &&
                amountOfStudents.equals(turma.amountOfStudents) &&
                serie.equals(turma.serie) &&
                instituicao.equals(turma.instituicao) &&
                turmaMaterias.equals(turma.turmaMaterias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nameTurma, amountOfStudents, serie, instituicao, turmaMaterias);
    }

    @Override
    public String toString() {
        return "Turma{" +
                "nameTurma='" + nameTurma + '\'' +
                ", amountOfStudents=" + amountOfStudents +
                ", serie=" + serie +
                ", instituicao=" + instituicao +
                ", turmaMaterias=" + turmaMaterias +
                '}';
    }
}
