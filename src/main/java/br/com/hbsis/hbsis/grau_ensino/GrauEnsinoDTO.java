package br.com.hbsis.hbsis.grau_ensino;

public class GrauEnsinoDTO {

    private Long id;
    private String nomeGrau;

    public GrauEnsinoDTO() {
    }

    public GrauEnsinoDTO(Long id, String nomeGrau) {
        this.id = id;
        this.nomeGrau = nomeGrau;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeGrau() {
        return nomeGrau;
    }

    public void setNomeGrau(String nomeGrau) {
        this.nomeGrau = nomeGrau;
    }

    @Override
    public String toString() {
        return "GrauEnsinoDTO{" +
                "id=" + id +
                ", nomeGrau='" + nomeGrau + '\'' +
                '}';
    }
}
