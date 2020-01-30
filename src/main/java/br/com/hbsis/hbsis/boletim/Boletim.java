package br.com.hbsis.hbsis.boletim;

import br.com.hbsis.hbsis.disciplina.Disciplina;
import br.com.hbsis.hbsis.semestre.Semestre;
import br.com.hbsis.hbsis.student.Student;
import br.com.hbsis.hbsis.utils.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity(name = "boletim")
public class Boletim extends AbstractEntity {

    @Column(name = "media_final", nullable = false)
    private Double mediaFinal;

    @ManyToOne
    @JoinColumn(name = "id_disciplina", nullable = false)
    private Disciplina disciplina;

    @ManyToOne
    @JoinColumn(name = "id_aluno", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_semestre", nullable = false)
    private Semestre semestre;

    public Boletim() {
    }

    public Boletim(Double mediaFinal, Disciplina disciplina, Student student, Semestre semestre) {
        this.mediaFinal = mediaFinal;
        this.disciplina = disciplina;
        this.student = student;
        this.semestre = semestre;
    }

    public Double getMediaFinal() {

        return mediaFinal;
    }

    public void setMediaFinal(Double mediaFinal) {
        this.mediaFinal = mediaFinal;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return "Boletim{" +
                "mediaFinal=" + mediaFinal +
                ", disciplina=" + disciplina +
                ", student=" + student +
                ", semestre=" + semestre +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Boletim)) return false;
        if (!super.equals(o)) return false;
        Boletim boletim = (Boletim) o;
        return mediaFinal.equals(boletim.mediaFinal) &&
                disciplina.equals(boletim.disciplina) &&
                student.equals(boletim.student) &&
                semestre.equals(boletim.semestre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mediaFinal, disciplina, student, semestre);
    }
}
