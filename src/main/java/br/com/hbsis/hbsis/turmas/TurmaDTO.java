package br.com.hbsis.hbsis.turmas;

import br.com.hbsis.hbsis.diciplina_professor.DisciplinaProfessorDTO;

import java.util.ArrayList;
import java.util.List;

public class TurmaDTO {

    private Long id;
    private String nameTurma;
    private Integer amountOfStudents;
    private Long idSerie;
    List<DisciplinaProfessorDTO> disciplinaProfessorDTOS;

    public TurmaDTO() {
    }

    public TurmaDTO(Long id, String nameTurma, Integer amountOfStudents, Long idSerie, List<DisciplinaProfessorDTO> disciplinaProfessorDTOS) {
        this.id = id;
        this.nameTurma = nameTurma;
        this.amountOfStudents = amountOfStudents;
        this.idSerie = idSerie;
        this.disciplinaProfessorDTOS = disciplinaProfessorDTOS;
    }

    public static TurmaDTO of(Turma turma) {

        List<DisciplinaProfessorDTO> disciplinaProfessorDTOS = new ArrayList<>();
        turma.getDisciplinaProfessores().forEach(disciplinaProfessor -> disciplinaProfessorDTOS.add(DisciplinaProfessorDTO.of(disciplinaProfessor)));
        return new TurmaDTO(
                turma.getId(),
                turma.getNameTurma(),
                turma.getAmountOfStudents(),
                turma.getSerie().getId(),
                disciplinaProfessorDTOS
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameTurma() {
        return nameTurma;
    }

    public void setNameTurma(String nameTurma) {
        this.nameTurma = nameTurma;
    }

    public Integer getAmountOfStudents() {
        return amountOfStudents;
    }

    public void setAmountOfStudents(Integer amountOfStudents) {
        this.amountOfStudents = amountOfStudents;
    }

    public Long getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Long idSerie) {
        this.idSerie = idSerie;
    }

    public List<DisciplinaProfessorDTO> getDisciplinaProfessorDTOS() {
        return disciplinaProfessorDTOS;
    }

    public void setDisciplinaProfessorDTOS(List<DisciplinaProfessorDTO> disciplinaProfessorDTOS) {
        this.disciplinaProfessorDTOS = disciplinaProfessorDTOS;
    }

    @Override
    public String toString() {
        return "TurmaDTO{" +
                "id=" + id +
                ", nameTurma='" + nameTurma + '\'' +
                ", amountOfStudents=" + amountOfStudents +
                ", idSerie=" + idSerie +
                ", disciplinaProfessorDTOS=" + disciplinaProfessorDTOS +
                '}';
    }
}
