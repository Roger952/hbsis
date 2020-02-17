package br.com.hbsis.hbsis.grau_ensino;

import br.com.hbsis.hbsis.utils.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity(name = "grau_ensino")
public class GrauEnsino extends AbstractEntity {

    @Column(name = "name_grau", unique = true, nullable = false, length = 50)
    private String nomeGrau;

    public GrauEnsino() {
    }

    public GrauEnsino(String nomeGrau) {
        this.nomeGrau = nomeGrau;
    }

    public String getNomeGrau() {
        return nomeGrau;
    }

    public void setNomeGrau(String nomeGrau) {
        this.nomeGrau = nomeGrau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GrauEnsino that = (GrauEnsino) o;
        return Objects.equals(nomeGrau, that.nomeGrau);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nomeGrau);
    }

    @Override
    public String toString() {
        return "GrauEnsino{" +
                ", nomeGrau='" + nomeGrau + '\'' +
                '}';
    }
}
