package br.com.hbsis.hbsis.semestre;

import br.com.hbsis.hbsis.utils.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity(name = "semestre")
public class Semestre extends AbstractEntity {

    @Column(name = "nome_semestre", length = 50, nullable = false)
    private String nameSemestre;
    @Column(name = "data_de_inicio", nullable = false)
    private Date dateOfStart;
    @Column(name = "data_de_termino", nullable = false)
    private Date dateFinal;
    @Column(name = "ano", nullable = false)
    private Long year;

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
        return "Semestre{" +
                "nameSemestre='" + nameSemestre + '\'' +
                ", dateOfStart=" + dateOfStart +
                ", dateFinal=" + dateFinal +
                ", year=" + year +
                '}';
    }
}
