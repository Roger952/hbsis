package br.com.hbsis.hbsis.boletim;

public class BoletimDTO {

    private Long id;
    private Double mediaFinal;
    private Long disciplina;
    private Long student;
    private Long semestre;

    public BoletimDTO() {
    }

    public BoletimDTO(Long id, Double mediaFinal, Long disciplina, Long student, Long semestre) {
        this.id = id;
        this.mediaFinal = mediaFinal;
        this.disciplina = disciplina;
        this.student = student;
        this.semestre = semestre;
    }

    public static BoletimDTO of(Boletim boletim) {
        return new BoletimDTO(
                boletim.getId(),
                boletim.getMediaFinal(),
                boletim.getDisciplina().getId(),
                boletim.getStudent().getId(),
                boletim.getSemestre().getId()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(Double mediaFinal) {
        this.mediaFinal = mediaFinal;
    }

    public Long getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Long disciplina) {
        this.disciplina = disciplina;
    }

    public Long getStudent() {
        return student;
    }

    public void setStudent(Long student) {
        this.student = student;
    }

    public Long getSemestre() {
        return semestre;
    }

    public void setSemestre(Long semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return "BoletimDTO{" +
                "id=" + id +
                ", mediaFinal=" + mediaFinal +
                ", disciplina=" + disciplina +
                ", student=" + student +
                ", semestre=" + semestre +
                '}';
    }
}
