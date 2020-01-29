package br.com.hbsis.hbsis.atividade;

import java.util.Date;
import java.util.Objects;

public class AtividadeDTO {
    private String description;
    private String status;
    private Date releaseDate;
    private Date endDate;
    private Long idSemestre;
    private Long idTeacher;
    private Long idDisciplina;
    private Long idStudent;
    private Double grades;

    public AtividadeDTO() {
    }

    public AtividadeDTO(String description, String status, Date releaseDate, Date endDate, Long idSemestre, Long idTeacher, Long idDisciplina, Long idStudent, Double grades) {
        this.description = description;
        this.status = status;
        this.releaseDate = releaseDate;
        this.endDate = endDate;
        this.idSemestre = idSemestre;
        this.idTeacher = idTeacher;
        this.idDisciplina = idDisciplina;
        this.idStudent = idStudent;
        this.grades = grades;
    }

    public static AtividadeDTO of(Atividade atividade) {
        return new AtividadeDTO(
                atividade.getDescription(),
                atividade.getStatus(),
                atividade.getReleaseDate(),
                atividade.getEndDate(),
                atividade.getSemestre().getId(),
                atividade.getTeacher().getId(),
                atividade.getDisciplina().getId(),
                atividade.getStudent().getId(),
                atividade.getGrades()
        );
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

    public Long getIdSemestre() {
        return idSemestre;
    }

    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }

    public void setIdSemestre(Long idSemestre) {
        this.idSemestre = idSemestre;
    }

    public Long getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Long idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Double getGrades() {
        return grades;
    }

    public void setGrades(Double grades) {
        this.grades = grades;
    }

    public Long getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Long idTeacher) {
        this.idTeacher = idTeacher;
    }

    @Override
    public String toString() {
        return "AtividadeDTO{" +
                "description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", releaseDate=" + releaseDate +
                ", endDate=" + endDate +
                ", idSemestre=" + idSemestre +
                ", idTeacher=" + idTeacher +
                ", idDisciplina=" + idDisciplina +
                ", idStudent=" + idStudent +
                ", grades=" + grades +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AtividadeDTO)) return false;
        AtividadeDTO that = (AtividadeDTO) o;
        return description.equals(that.description) &&
                status.equals(that.status) &&
                releaseDate.equals(that.releaseDate) &&
                endDate.equals(that.endDate) &&
                idSemestre.equals(that.idSemestre) &&
                idTeacher.equals(that.idTeacher) &&
                idDisciplina.equals(that.idDisciplina) &&
                idStudent.equals(that.idStudent) &&
                grades.equals(that.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, status, releaseDate, endDate, idSemestre, idTeacher, idDisciplina, idStudent, grades);
    }
}
