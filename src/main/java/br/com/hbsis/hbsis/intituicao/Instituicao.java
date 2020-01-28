package br.com.hbsis.hbsis.intituicao;

import br.com.hbsis.hbsis.utils.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

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

    @Override
    public String toString() {
        return "Instituicao{" +
                ", nameInstituicao='" + nameInstituicao + '\'' +
                ", typeInstituicao='" + typeInstituicao + '\'' +
                '}';
    }
}
