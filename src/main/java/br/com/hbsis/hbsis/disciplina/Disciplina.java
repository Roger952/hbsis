package br.com.hbsis.hbsis.disciplina;

import br.com.hbsis.hbsis.diciplina_professor.DisciplinaProfessor;
import br.com.hbsis.hbsis.utils.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "discipilna")
public class Disciplina extends AbstractEntity {

    @Column(name = "nome_Disciplina", length = 100, nullable = false, unique = true)
    private String nameDisciplina;

    @OneToMany(mappedBy = "disciplina")
    private List<DisciplinaProfessor> disciplinaProfessors;

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

    public List<DisciplinaProfessor> getDisciplinaProfessors() {
        return disciplinaProfessors;
    }

    public void setDisciplinaProfessors(List<DisciplinaProfessor> disciplinaProfessors) {
        this.disciplinaProfessors = disciplinaProfessors;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "nameDisciplina='" + nameDisciplina + '\'' +
                ", disciplinaProfessors=" + disciplinaProfessors +
                '}';
    }
}
