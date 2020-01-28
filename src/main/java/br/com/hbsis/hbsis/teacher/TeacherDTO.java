package br.com.hbsis.hbsis.teacher;

import br.com.hbsis.hbsis.annotations.ContactNumberConstraint;
import br.com.hbsis.hbsis.annotations.ValidSex;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TeacherDTO {

    private Long id;

    @NotNull(message = "Informe a instituição que este professor pertence")
    private Long idInstituicao;

    @NotNull(message = "O nome do professor não pode estar nulo")
    @Size(min = 1, max = 100, message = "Numero de caracteres não suportado")
    private String nameTeacher;

    @ValidSex(message = "Sexo com o formato errado")
    @Size(min = 1, max = 10, message = "Numero de caracteres não suportado")
    private String sex;

    @NotNull(message = "Informe a idade do professor")
    private Integer age;

    @ContactNumberConstraint(message = "Numero inserido não valido")
    @Size(min = 8, max = 15, message = "Numero de caracteres não suportado")
    private String telephone;

    @Size(min = 1, max = 200, message = "Numero de caracteres não suportado")
    private String address;

    @NotNull(message = "Informe o email do professor")
    @Email(message = "Email com padrao incorreto")
    @Size(min = 1, max = 250, message = "Numero de caracteres não suportado")
    private String email;

    @CPF(message = "cpf invalido")
    @NotNull(message = "Informe o cpf do professor")
    @Size(min = 1, max = 14, message = "Numero de caracters não suportado")
    private String cpf;

    public TeacherDTO() {
    }

    public TeacherDTO(Long id, Long idInstituicao, String nameTeacher, String sex, Integer age, String telephone, String address, String email, String cpf) {
        this.id = id;
        this.idInstituicao = idInstituicao;
        this.nameTeacher = nameTeacher;
        this.sex = sex;
        this.age = age;
        this.telephone = telephone;
        this.address = address;
        this.email = email;
        this.cpf = cpf;
    }

    public static TeacherDTO of(Teacher teacher) {
        return new TeacherDTO(
                teacher.getId(),
                teacher.getInstituicao().getId(),
                teacher.getNomeProfessor(),
                teacher.getSex(),
                teacher.getAge(),
                teacher.getTelephone(),
                teacher.getAddress(),
                teacher.getEmail(),
                teacher.getCpf()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdInstituicao() {
        return idInstituicao;
    }

    public void setIdInstituicao(Long idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
