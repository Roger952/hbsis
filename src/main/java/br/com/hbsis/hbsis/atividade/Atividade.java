package br.com.hbsis.hbsis.atividade;

import br.com.hbsis.hbsis.disciplina.Disciplina;
import br.com.hbsis.hbsis.semestre.Semestre;
import br.com.hbsis.hbsis.student.Student;
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
    @JoinColumn(name = "id_semestre", referencedColumnName = "id", nullable = false)
    private Semestre semestre;
    @ManyToOne
    @JoinColumn(name = "id_disciplina", referencedColumnName = "id", nullable = false)
    private Disciplina disciplina;
    @ManyToOne
    @JoinColumn(name = "id_professor", referencedColumnName = "id", nullable = false)
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "id_estudante", referencedColumnName = "id", nullable = false)
    private Student student;
    @Column(name = "notas")
    private Double grades;

    public Atividade() {
    }

    public Atividade(String description, String status, Date releaseDate, Date endDate, Semestre semestre, Disciplina disciplina, Teacher teacher, Student student, Double grades) {
        this.description = description;
        this.status = status;
        this.releaseDate = releaseDate;
        this.endDate = endDate;
        this.semestre = semestre;
        this.disciplina = disciplina;
        this.teacher = teacher;
        this.student = student;
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

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Double getGrades() {
        return grades;
    }

    public void setGrades(Double grades) {
        this.grades = grades;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Atividade{" +
                "description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", releaseDate=" + releaseDate +
                ", endDate=" + endDate +
                ", semestre=" + semestre +
                ", disciplina=" + disciplina +
                ", teacher=" + teacher +
                ", student=" + student +
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
                semestre.equals(atividade.semestre) &&
                disciplina.equals(atividade.disciplina) &&
                teacher.equals(atividade.teacher) &&
                student.equals(atividade.student) &&
                grades.equals(atividade.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description, status, releaseDate, endDate, semestre, disciplina, teacher, student, grades);
    }
}
