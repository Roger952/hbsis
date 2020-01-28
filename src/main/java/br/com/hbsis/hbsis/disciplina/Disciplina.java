package br.com.hbsis.hbsis.disciplina;

import br.com.hbsis.hbsis.teacher.Teacher;
import br.com.hbsis.hbsis.utils.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "discipilna")
public class Disciplina extends AbstractEntity {

    @Column(name = "nome_Disciplina", length = 100, nullable = false, unique = true)
    private String nameDisciplina;

    @ManyToMany
    @JoinTable(name = "disciplina_professor",
            joinColumns = {@JoinColumn(name = "id_disciplina", nullable = false, referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "id_professor", nullable = false, referencedColumnName = "id")})
    private List<Teacher> teachers;

    public String getNameDisciplina() {
        return nameDisciplina;
    }

    public void setNameDisciplina(String nameDisciplina) {
        this.nameDisciplina = nameDisciplina;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "nameDisciplina='" + nameDisciplina + '\'' +
                ", teachers=" + teachers +
                '}';
    }
}
