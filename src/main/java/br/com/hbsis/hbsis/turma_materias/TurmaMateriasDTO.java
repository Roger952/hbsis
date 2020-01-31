package br.com.hbsis.hbsis.turma_materias;

public class TurmaMateriasDTO {

    private Long id;
    private Long idTurma;
    private Long idDisciplinaTurma;

    public TurmaMateriasDTO() {
    }

    public TurmaMateriasDTO(Long id, Long idTurma, Long idDisciplinaTurma) {
        this.id = id;
        this.idTurma = idTurma;
        this.idDisciplinaTurma = idDisciplinaTurma;
    }

    public static TurmaMateriasDTO of(TurmaMaterias turmaMaterias) {
        return new TurmaMateriasDTO(
                turmaMaterias.getId(),
                turmaMaterias.getTurma().getId(),
                turmaMaterias.getDisciplina().getId()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Long idTurma) {
        this.idTurma = idTurma;
    }

    public Long getIdDisciplinaTurma() {
        return idDisciplinaTurma;
    }

    public void setIdDisciplinaTurma(Long idDisciplinaTurma) {
        this.idDisciplinaTurma = idDisciplinaTurma;
    }

    @Override
    public String toString() {
        return "TurmaMateriasDTO{" +
                "id=" + id +
                ", idTurma=" + idTurma +
                ", idDisciplinaTurma=" + idDisciplinaTurma +
                '}';
    }
}
