package br.com.hbsis.hbsis.modeloboletim;

import br.com.hbsis.hbsis.student.Student;
import br.com.hbsis.hbsis.utils.AbstractEntity;
import br.com.hbsis.hbsis.year.Year;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity(name = "modelo_boletim")
public class ModeloBoletim extends AbstractEntity {

    @Column(name = "diciplina", length = 50, nullable = false)
    private String nameDisciplina;

    @Column(name = "media_primeiro_semestre", length = 50, nullable = false)
    private String mediaPrimeiroSemestre;

    @Column(name = "media_segundo_semestre", length = 50, nullable = false)
    private String mediaSegundoSemestre;

    @Column(name = "media_terceiro_semestre", length = 50, nullable = false)
    private String mediaerceiroSemestre;

    @ManyToOne
    @JoinColumn(name = "ano", referencedColumnName = "id")
    private Year year;

    @ManyToOne
    @JoinColumn(name = "id_aluno", referencedColumnName = "id")
    private Student student;

    public ModeloBoletim() {
    }

    public ModeloBoletim(String nameDisciplina, String mediaPrimeiroSemestre, String mediaSegundoSemestre, String mediaerceiroSemestre, Year year, Student student) {
        this.nameDisciplina = nameDisciplina;
        this.mediaPrimeiroSemestre = mediaPrimeiroSemestre;
        this.mediaSegundoSemestre = mediaSegundoSemestre;
        this.mediaerceiroSemestre = mediaerceiroSemestre;
        this.year = year;
        this.student = student;
    }

    public String getNameDisciplina() {
        return nameDisciplina;
    }

    public void setNameDisciplina(String nameDisciplina) {
        this.nameDisciplina = nameDisciplina;
    }

    public String getMediaPrimeiroSemestre() {
        return mediaPrimeiroSemestre;
    }

    public void setMediaPrimeiroSemestre(String mediaPrimeiroSemestre) {
        this.mediaPrimeiroSemestre = mediaPrimeiroSemestre;
    }

    public String getMediaSegundoSemestre() {
        return mediaSegundoSemestre;
    }

    public void setMediaSegundoSemestre(String mediaSegundoSemestre) {
        this.mediaSegundoSemestre = mediaSegundoSemestre;
    }

    public String getMediaerceiroSemestre() {
        return mediaerceiroSemestre;
    }

    public void setMediaerceiroSemestre(String mediaerceiroSemestre) {
        this.mediaerceiroSemestre = mediaerceiroSemestre;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModeloBoletim)) return false;
        if (!super.equals(o)) return false;
        ModeloBoletim that = (ModeloBoletim) o;
        return nameDisciplina.equals(that.nameDisciplina) &&
                mediaPrimeiroSemestre.equals(that.mediaPrimeiroSemestre) &&
                mediaSegundoSemestre.equals(that.mediaSegundoSemestre) &&
                mediaerceiroSemestre.equals(that.mediaerceiroSemestre) &&
                year.equals(that.year) &&
                student.equals(that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nameDisciplina, mediaPrimeiroSemestre, mediaSegundoSemestre, mediaerceiroSemestre, year, student);
    }

    @Override
    public String toString() {
        return "ModeloBoletim{" +
                "nameDisciplina='" + nameDisciplina + '\'' +
                ", mediaPrimeiroSemestre='" + mediaPrimeiroSemestre + '\'' +
                ", mediaSegundoSemestre='" + mediaSegundoSemestre + '\'' +
                ", mediaerceiroSemestre='" + mediaerceiroSemestre + '\'' +
                ", year=" + year +
                ", student=" + student +
                '}';
    }
}
