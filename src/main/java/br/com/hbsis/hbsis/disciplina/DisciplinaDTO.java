package br.com.hbsis.hbsis.disciplina;

public class DisciplinaDTO {

    private Long id;
    private String nameDisciplina;

    public DisciplinaDTO() {
    }

    public DisciplinaDTO(Long id, String nameDisciplina) {
        this.id = id;
        this.nameDisciplina = nameDisciplina;
    }

    public static DisciplinaDTO of(Disciplina disciplina) {

        return new DisciplinaDTO(
                disciplina.getId(),
                disciplina.getNameDisciplina()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameDisciplina() {
        return nameDisciplina;
    }

    public void setNameDisciplina(String nameDisciplina) {
        this.nameDisciplina = nameDisciplina;
    }

    @Override
    public String toString() {
        return "DisciplinaDTO{" +
                "id=" + id +
                ", nameDisciplina='" + nameDisciplina + '\'' +
                '}';
    }
}
