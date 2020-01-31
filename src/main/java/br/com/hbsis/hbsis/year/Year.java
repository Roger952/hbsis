package br.com.hbsis.hbsis.year;

import br.com.hbsis.hbsis.semestre.Semestre;
import br.com.hbsis.hbsis.utils.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

@Entity(name = "ano")
public class Year extends AbstractEntity {

    @Column(name = "nome_ano", nullable = false, unique = true, length = 50)
    private String nameYear;

    @OneToMany(mappedBy = "year")
    private List<Semestre> semestres;

    public String getNameYear() {
        return nameYear;
    }

    public void setNameYear(String nameYear) {
        this.nameYear = nameYear;
    }

    public List<Semestre> getSemestres() {
        return semestres;
    }

    public void setSemestres(List<Semestre> semestres) {
        this.semestres = semestres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Year)) return false;
        if (!super.equals(o)) return false;
        Year year = (Year) o;
        return nameYear.equals(year.nameYear) &&
                semestres.equals(year.semestres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nameYear, semestres);
    }

    @Override
    public String toString() {
        return "Year{" +
                "nameYear='" + nameYear + '\'' +
                ", semestres=" + semestres +
                '}';
    }
}
