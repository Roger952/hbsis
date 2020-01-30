package br.com.hbsis.hbsis.atividade;

import br.com.hbsis.hbsis.annotations.ValidGrade;
import br.com.hbsis.hbsis.annotations.ValidStatus;

import javax.validation.constraints.Size;
import java.util.Date;

public class AtividadeDTO {

    private Long id;
    @Size(min = 1, max = 100)
    private String description;
    @ValidStatus
    private String status;
    private Date releaseDate;
    private Date endDate;
    private Long idTeacher;
    private Long idBoletim;
    @ValidGrade
    private Double grades;

    public AtividadeDTO() {
    }

    public AtividadeDTO(Long id, String description, String status, Date releaseDate, Date endDate, Long idTeacher, Long idBoletim, Double grades) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.releaseDate = releaseDate;
        this.endDate = endDate;
        this.idTeacher = idTeacher;
        this.idBoletim = idBoletim;
        this.grades = grades;
    }

    public static AtividadeDTO of(Atividade atividade) {
        return new AtividadeDTO(
                atividade.getId(),
                atividade.getDescription(),
                atividade.getStatus(),
                atividade.getReleaseDate(),
                atividade.getEndDate(),
                atividade.getTeacher().getId(),
                atividade.getBoletim().getId(),
                atividade.getGrades()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Long idTeacher) {
        this.idTeacher = idTeacher;
    }

    public Long getIdBoletim() {
        return idBoletim;
    }

    public void setIdBoletim(Long idBoletim) {
        this.idBoletim = idBoletim;
    }

    public Double getGrades() {
        return grades;
    }

    public void setGrades(Double grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "AtividadeDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", releaseDate=" + releaseDate +
                ", endDate=" + endDate +
                ", idTeacher=" + idTeacher +
                ", idBoletim=" + idBoletim +
                ", grades=" + grades +
                '}';
    }
}
