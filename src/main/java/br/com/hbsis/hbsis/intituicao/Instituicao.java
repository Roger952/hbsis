package br.com.hbsis.hbsis.intituicao;

import br.com.hbsis.hbsis.utils.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity(name = "instituicao")
public class Instituicao extends AbstractEntity {

    @Column(name = "name_instituicao", length = 100, nullable = false)
    private String nameInstituicao;

    @Column(name = "type_instituicao", length = 100, nullable = false)
    private String typeInstituicao;

    public String getNameInstituicao() {
        return nameInstituicao;
    }

    public void setNameInstituicao(String nameInstituicao) {
        this.nameInstituicao = nameInstituicao;
    }

    public String getTypeInstituicao() {
        return typeInstituicao;
    }

    public void setTypeInstituicao(String typeInstituicao) {
        this.typeInstituicao = typeInstituicao;
    }

    public Instituicao() {
    }

    public Instituicao(String nameInstituicao, String typeInstituicao) {
        this.nameInstituicao = nameInstituicao;
        this.typeInstituicao = typeInstituicao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Instituicao)) return false;
        if (!super.equals(o)) return false;
        Instituicao that = (Instituicao) o;
        return Objects.equals(nameInstituicao, that.nameInstituicao) &&
                Objects.equals(typeInstituicao, that.typeInstituicao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nameInstituicao, typeInstituicao);
    }

    @Override
    public String toString() {
        return "Instituicao{" +
                ", nameInstituicao='" + nameInstituicao + '\'' +
                ", typeInstituicao='" + typeInstituicao + '\'' +
                '}';
    }
}
