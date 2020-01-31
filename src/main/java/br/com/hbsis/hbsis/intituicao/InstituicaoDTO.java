package br.com.hbsis.hbsis.intituicao;

public class InstituicaoDTO {

    private String nameInstituicao;
    private String typeInstituicao;

    public InstituicaoDTO() {
    }

    public InstituicaoDTO(Long id, String nameInstituicao, String typeInstituicao) {
        this.nameInstituicao = nameInstituicao;
        this.typeInstituicao = typeInstituicao;
    }

    public static InstituicaoDTO of(Instituicao instituicao) {
        return new InstituicaoDTO(
                instituicao.getId(),
                instituicao.getNameInstituicao(),
                instituicao.getTypeInstituicao()
        );
    }

    public String getNameInstituicao() {
        return nameInstituicao;
    }

    public void setNameInstituicao(String nameInstituicao) {
        this.nameInstituicao = nameInstituicao;
    }

    public String getTypeInstituicao() {
        return typeInstituicao;
    }

    public void setTypeInstituicao(String typeInstituicao) {
        this.typeInstituicao = typeInstituicao;
    }
}
