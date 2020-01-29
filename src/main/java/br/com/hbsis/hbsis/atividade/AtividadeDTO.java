package br.com.hbsis.hbsis.atividade;

import java.util.Date;

public class AtividadeDTO {
    private String description;
    private String status;
    private Date releaseDate;
    private Date endDate;
    private Long idSemestre;
    private Long idTurma;
    private Long idStudent;

    public AtividadeDTO() {
    }

    public AtividadeDTO(String description, String status, Date releaseDate, Date endDate, Long idSemestre, Long idTurma, Long idStudent) {
        this.description = description;
        this.status = status;
        this.releaseDate = releaseDate;
        this.endDate = endDate;
        this.idSemestre = idSemestre;
        this.idTurma = idTurma;
        this.idStudent = idStudent;
    }

    public static AtividadeDTO of(Atividade atividade) {
        return new AtividadeDTO(
                atividade.getDescription(),
                atividade.getStatus(),
                atividade.getReleaseDate(),
                atividade.getEndDate(),
                atividade.getSemestre().getId(),
                atividade.getTurma().getId(),
                atividade.getStudent().getId()
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

    public Long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Long idTurma) {
        this.idTurma = idTurma;
    }

    @Override
    public String toString() {
        return "AtividadeDTO{" +
                "description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", releaseDate=" + releaseDate +
                ", endDate=" + endDate +
                ", idSemestre=" + idSemestre +
                ", idTurma=" + idTurma +
                ", idStudent=" + idStudent +
                '}';
    }
}
