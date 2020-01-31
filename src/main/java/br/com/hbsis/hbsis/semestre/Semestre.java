package br.com.hbsis.hbsis.semestre;

import br.com.hbsis.hbsis.boletim.Boletim;
import br.com.hbsis.hbsis.utils.AbstractEntity;
import br.com.hbsis.hbsis.year.Year;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity(name = "semestre")
public class Semestre extends AbstractEntity {

    @Column(name = "nome_semestre", length = 50, nullable = false)
    private String nameSemestre;
    @Column(name = "data_de_inicio", nullable = false)
    private Date dateOfStart;
    @Column(name = "data_de_termino", nullable = false)
    private Date dateFinal;
    @ManyToOne
    @JoinColumn(name = "id_ano", nullable = false, referencedColumnName = "id")
    private Year year;
    @OneToMany(mappedBy = "semestre")
    private List<Boletim> boletims;

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

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public List<Boletim> getBoletims() {
        return boletims;
    }

    public void setBoletims(List<Boletim> boletims) {
        this.boletims = boletims;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Semestre)) return false;
        if (!super.equals(o)) return false;
        Semestre semestre = (Semestre) o;
        return nameSemestre.equals(semestre.nameSemestre) &&
                dateOfStart.equals(semestre.dateOfStart) &&
                dateFinal.equals(semestre.dateFinal) &&
                year.equals(semestre.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nameSemestre, dateOfStart, dateFinal, year);
    }
}
