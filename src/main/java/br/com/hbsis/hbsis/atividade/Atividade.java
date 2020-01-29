package br.com.hbsis.hbsis.atividade;

import br.com.hbsis.hbsis.semestre.Semestre;
import br.com.hbsis.hbsis.student.Student;
import br.com.hbsis.hbsis.turmas.Turma;
import br.com.hbsis.hbsis.utils.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity(name = "atividade")
public class Atividade extends AbstractEntity {

    @Column(name = "descricao_atividade", length = 100, nullable = false)
    private String description;
    @Column(name = "status", length = 10, nullable = false)
    private String status;
    @Column(name = "data_lancamento", nullable = false)
    private Date releaseDate;
    @Column(name = "data_entrega", nullable = false)
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "id_semestre", referencedColumnName = "id", nullable = false)
    private Semestre semestre;
    @ManyToOne
    @JoinColumn(name = "id_turma_materia", referencedColumnName = "id", nullable = false)
    private Turma turma;
    @ManyToOne
    @JoinColumn(name = "id_estudante", referencedColumnName = "id", nullable = false)
    private Student student;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Atividade{" +
                "description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", releaseDate=" + releaseDate +
                ", endDate=" + endDate +
                ", semestre=" + semestre +
                ", turma=" + turma +
                ", student=" + student +
                '}';
    }
}
