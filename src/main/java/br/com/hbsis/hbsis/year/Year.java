package br.com.hbsis.hbsis.year;

import br.com.hbsis.hbsis.utils.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity(name = "ano")
public class Year extends AbstractEntity {

    @Column(name = "nome_ano", nullable = false, unique = true, length = 50)
    private String nameYear;

    public Year() {
    }

    public String getNameYear() {
        return nameYear;
    }

    public void setNameYear(String nameYear) {
        this.nameYear = nameYear;
    }

    @Override
    public String toString() {
        return "Year{" +
                "nameYear='" + nameYear + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Year)) return false;
        if (!super.equals(o)) return false;
        Year year = (Year) o;
        return nameYear.equals(year.nameYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nameYear);
    }
}
