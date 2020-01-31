package br.com.hbsis.hbsis.disciplina;

import br.com.hbsis.hbsis.utils.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity(name = "discipilna")
public class Disciplina extends AbstractEntity {

    @Column(name = "nome_Disciplina", length = 100, nullable = false, unique = true)
    private String nameDisciplina;

    public Disciplina() {
    }

    public Disciplina(Long id, String nameDisciplina) {
        this.setId(id);
        this.nameDisciplina = nameDisciplina;
    }

    public Disciplina(String nameDisciplina) {
        this.nameDisciplina = nameDisciplina;
    }

    public String getNameDisciplina() {
        return nameDisciplina;
    }

    public void setNameDisciplina(String nameDisciplina) {
        this.nameDisciplina = nameDisciplina;
    }


    @Override
    public String toString() {
        return "Disciplina{" +
                "nameDisciplina='" + nameDisciplina + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Disciplina)) return false;
        if (!super.equals(o)) return false;
        Disciplina that = (Disciplina) o;
        return Objects.equals(nameDisciplina, that.nameDisciplina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nameDisciplina);
    }
}
