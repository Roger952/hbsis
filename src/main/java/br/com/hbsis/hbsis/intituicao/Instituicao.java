package br.com.hbsis.hbsis.intituicao;

import javax.persistence.*;

@Entity(name = "instituicao")
public class Instituicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_intituicao", length = 100, nullable = false)
    private String nameInstituicao;

    @Column(name = "type_intituicao", length = 100, nullable = false)
    private String typeInstituicao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
                "id=" + id +
                ", nameInstituicao='" + nameInstituicao + '\'' +
                ", typeInstituicao='" + typeInstituicao + '\'' +
                '}';
    }
}
