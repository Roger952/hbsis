package br.com.hbsis.hbsis.modelo_boletim;

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

    @Column(name = "nome_estudante", nullable = false, length = 100)
    private String nameStudent;

    @Column(name = "nome_turma", nullable = false, length = 50)
    private String nameTurma;

    @Column(name = "nome_ano", nullable = false, length = 4)
    private String nameYear;

    @Column(name = "nome_escola", nullable = false, length = 100)
    private String nameSchool;

    @ManyToOne
    @JoinColumn(name = "ano", referencedColumnName = "id")
    private Year year;

    @ManyToOne
    @JoinColumn(name = "id_aluno", referencedColumnName = "id")
    private Student student;

    public ModeloBoletim() {
    }

    public ModeloBoletim(String nameDisciplina, String mediaPrimeiroSemestre, String mediaSegundoSemestre, String mediaerceiroSemestre, String nameStudent, String nameTurma, String nameYear, String nameSchool, Year year, Student student) {
        this.nameDisciplina = nameDisciplina;
        this.mediaPrimeiroSemestre = mediaPrimeiroSemestre;
        this.mediaSegundoSemestre = mediaSegundoSemestre;
        this.mediaerceiroSemestre = mediaerceiroSemestre;
        this.nameStudent = nameStudent;
        this.nameTurma = nameTurma;
        this.nameYear = nameYear;
        this.nameSchool = nameSchool;
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

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getNameTurma() {
        return nameTurma;
    }

    public void setNameTurma(String nameTurma) {
        this.nameTurma = nameTurma;
    }

    public String getNameYear() {
        return nameYear;
    }

    public void setNameYear(String nameYear) {
        this.nameYear = nameYear;
    }

    public String getNameSchool() {
        return nameSchool;
    }

    public void setNameSchool(String nameSchool) {
        this.nameSchool = nameSchool;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModeloBoletim)) return false;
        if (!super.equals(o)) return false;
        ModeloBoletim that = (ModeloBoletim) o;
        return Objects.equals(nameDisciplina, that.nameDisciplina) &&
                Objects.equals(mediaPrimeiroSemestre, that.mediaPrimeiroSemestre) &&
                Objects.equals(mediaSegundoSemestre, that.mediaSegundoSemestre) &&
                Objects.equals(mediaerceiroSemestre, that.mediaerceiroSemestre) &&
                Objects.equals(nameStudent, that.nameStudent) &&
                Objects.equals(nameTurma, that.nameTurma) &&
                Objects.equals(nameYear, that.nameYear) &&
                Objects.equals(nameSchool, that.nameSchool) &&
                Objects.equals(year, that.year) &&
                Objects.equals(student, that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nameDisciplina, mediaPrimeiroSemestre, mediaSegundoSemestre, mediaerceiroSemestre, nameStudent, nameTurma, nameYear, nameSchool, year, student);
    }

    @Override
    public String toString() {
        return "ModeloBoletim{" +
                "nameDisciplina='" + nameDisciplina + '\'' +
                ", mediaPrimeiroSemestre='" + mediaPrimeiroSemestre + '\'' +
                ", mediaSegundoSemestre='" + mediaSegundoSemestre + '\'' +
                ", mediaerceiroSemestre='" + mediaerceiroSemestre + '\'' +
                ", nameStudent='" + nameStudent + '\'' +
                ", nameTurma='" + nameTurma + '\'' +
                ", nameYear='" + nameYear + '\'' +
                ", nameSchool='" + nameSchool + '\'' +
                ", year=" + year +
                ", student=" + student +
                '}';
    }
}
