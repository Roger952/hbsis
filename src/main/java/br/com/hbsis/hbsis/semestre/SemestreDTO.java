package br.com.hbsis.hbsis.semestre;

import java.util.Date;

public class SemestreDTO {

    private Long id;
    private String nameSemestre;
    private Date dateOfStart;
    private Date dateFinal;
    private Long year;

    public SemestreDTO() {
    }

    public SemestreDTO(Long id, String nameSemestre, Date dateOfStart, Date dateFinal, Long year) {
        this.id = id;
        this.nameSemestre = nameSemestre;
        this.dateOfStart = dateOfStart;
        this.dateFinal = dateFinal;
        this.year = year;
    }

    public static SemestreDTO of(Semestre semestre) {
        return new SemestreDTO(
                semestre.getId(),
                semestre.getNameSemestre(),
                semestre.getDateOfStart(),
                semestre.getDateFinal(),
                semestre.getYear().getId()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSemestre() {
        return nameSemestre;
    }

    public void setNameSemestre(String nameSemestre) {
        this.nameSemestre = nameSemestre;
    }

    public Date getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(Date dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public Date getDateFinal() {
        return dateFinal;
    }

    public void setDateFinal(Date dateFinal) {
        this.dateFinal = dateFinal;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "SemestreDTO{" +
                "id=" + id +
                ", nameSemestre='" + nameSemestre + '\'' +
                ", dateOfStart=" + dateOfStart +
                ", dateFinal=" + dateFinal +
                ", year=" + year +
                '}';
    }
}
