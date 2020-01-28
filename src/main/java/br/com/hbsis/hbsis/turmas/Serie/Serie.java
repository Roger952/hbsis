package br.com.hbsis.hbsis.turmas.Serie;

import br.com.hbsis.hbsis.utils.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "serie")
public class Serie extends AbstractEntity {

    @Column(name = "numero_serie", nullable = false, unique = true)
    private Long numberSerie;
    @Column(name = "nome_serie", nullable = false, unique = true, length = 25)
    private String nameSerie;

    public Long getNumberSerie() {
        return numberSerie;
    }

    public void setNumberSerie(Long numberSerie) {
        this.numberSerie = numberSerie;
    }

    public String getNameSerie() {
        return nameSerie;
    }

    public void setNameSerie(String nameSerie) {
        this.nameSerie = nameSerie;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "numberSerie=" + numberSerie +
                ", nameSerie='" + nameSerie + '\'' +
                '}';
    }
}
