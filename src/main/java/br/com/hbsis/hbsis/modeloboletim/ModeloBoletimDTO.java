package br.com.hbsis.hbsis.modeloboletim;

public class ModeloBoletimDTO {

    private Long id;
    private String nameDisciplina;
    private String mediaPrimeiroSemestre;
    private String mediaSegundoSemestre;
    private String mediaerceiroSemestre;
    private Long year;
    private Long student;

    public ModeloBoletimDTO() {
    }

    public ModeloBoletimDTO(Long id, String nameDisciplina, String mediaPrimeiroSemestre, String mediaSegundoSemestre, String mediaerceiroSemestre, Long year, Long student) {
        this.id = id;
        this.nameDisciplina = nameDisciplina;
        this.mediaPrimeiroSemestre = mediaPrimeiroSemestre;
        this.mediaSegundoSemestre = mediaSegundoSemestre;
        this.mediaerceiroSemestre = mediaerceiroSemestre;
        this.year = year;
        this.student = student;
    }

    public static ModeloBoletimDTO of(ModeloBoletim modeloBoletim) {
        return new ModeloBoletimDTO(
                modeloBoletim.getId(),
                modeloBoletim.getNameDisciplina(),
                modeloBoletim.getMediaPrimeiroSemestre(),
                modeloBoletim.getMediaSegundoSemestre(),
                modeloBoletim.getMediaerceiroSemestre(),
                modeloBoletim.getYear().getId(),
                modeloBoletim.getStudent().getId()
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

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getStudent() {
        return student;
    }

    public void setStudent(Long student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "ModeloBoletimDTO{" +
                "id=" + id +
                ", nameDisciplina='" + nameDisciplina + '\'' +
                ", mediaPrimeiroSemestre='" + mediaPrimeiroSemestre + '\'' +
                ", mediaSegundoSemestre='" + mediaSegundoSemestre + '\'' +
                ", mediaerceiroSemestre='" + mediaerceiroSemestre + '\'' +
                ", year=" + year +
                ", student=" + student +
                '}';
    }
}
