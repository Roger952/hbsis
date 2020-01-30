package br.com.hbsis.hbsis.atividade;

import br.com.hbsis.hbsis.boletim.Boletim;
import br.com.hbsis.hbsis.teacher.Teacher;
import br.com.hbsis.hbsis.utils.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.Objects;

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
    @JoinColumn(name = "id_boletim", referencedColumnName = "id", nullable = false)
    private Boletim boletim;
    @ManyToOne
    @JoinColumn(name = "id_professor", referencedColumnName = "id", nullable = false)
    private Teacher teacher;
    @Column(name = "notas")
    private Double grades;

    public Atividade() {
    }

    public Atividade(String description, String status, Date releaseDate, Date endDate, Boletim boletim, Teacher teacher, Double grades) {
        this.description = description;
        this.status = status;
        this.releaseDate = releaseDate;
        this.endDate = endDate;
        this.boletim = boletim;
        this.teacher = teacher;
        this.grades = grades;
    }

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

    public Boletim getBoletim() {
        return boletim;
    }

    public void setBoletim(Boletim boletim) {
        this.boletim = boletim;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Double getGrades() {
        return grades;
    }

    public void setGrades(Double grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Atividade{" +
                "description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", releaseDate=" + releaseDate +
                ", endDate=" + endDate +
                ", boletim=" + boletim +
                ", teacher=" + teacher +
                ", grades=" + grades +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Atividade)) return false;
        if (!super.equals(o)) return false;
        Atividade atividade = (Atividade) o;
        return description.equals(atividade.description) &&
                status.equals(atividade.status) &&
                releaseDate.equals(atividade.releaseDate) &&
                endDate.equals(atividade.endDate) &&
                boletim.equals(atividade.boletim) &&
                teacher.equals(atividade.teacher) &&
                grades.equals(atividade.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description, status, releaseDate, endDate, boletim, teacher, grades);
    }
}
