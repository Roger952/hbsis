package br.com.hbsis.hbsis.modelo_boletim;

public class ModeloBoletimDTO {

    private Long id;
    private String nameDisciplina;
    private String mediaPrimeiroSemestre;
    private String mediaSegundoSemestre;
    private String mediaerceiroSemestre;
    private String nameStudent;
    private String nameTurma;
    private String nameYear;
    private String nameSchool;
    private Long year;
    private Long student;

    public ModeloBoletimDTO() {
    }

    public ModeloBoletimDTO(Long id, String nameDisciplina, String mediaPrimeiroSemestre, String mediaSegundoSemestre, String mediaerceiroSemestre, String nameStudent, String nameTurma, String nameYear, String nameSchool, Long year, Long student) {
        this.id = id;
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

    public static ModeloBoletimDTO of(ModeloBoletim modeloBoletim) {
        return new ModeloBoletimDTO(
                modeloBoletim.getId(),
                modeloBoletim.getNameDisciplina(),
                modeloBoletim.getMediaPrimeiroSemestre(),
                modeloBoletim.getMediaSegundoSemestre(),
                modeloBoletim.getMediaerceiroSemestre(),
                modeloBoletim.getNameStudent(),
                modeloBoletim.getNameTurma(),
                modeloBoletim.getNameYear(),
                modeloBoletim.getNameSchool(),
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
    public String toString() {
        return "ModeloBoletimDTO{" +
                "id=" + id +
                ", nameDisciplina='" + nameDisciplina + '\'' +
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
