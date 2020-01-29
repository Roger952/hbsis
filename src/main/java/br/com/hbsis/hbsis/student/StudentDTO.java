package br.com.hbsis.hbsis.student;

import br.com.hbsis.hbsis.annotations.AgeOfTeacherValidate;
import br.com.hbsis.hbsis.annotations.ContactNumberConstraint;
import br.com.hbsis.hbsis.annotations.ValidSex;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StudentDTO {

    private Long id;
    @NotNull(message = "O nome do Estudante não pode estar nulo")
    @Size(min = 1, max = 100, message = "Numero de caracteres não suportado")
    private String nameStudent;
    @NotNull(message = "A matricula não pode estar nula")
    @Size(min = 1, max = 100, message = "Numero de caracteres não suportado")
    private String registration;
    @NotNull(message = "Informe o sexo do estudante")
    @Size(min = 1, max = 10, message = "Numero de caracteres não suportado")
    @ValidSex
    private String sex;
    @NotNull(message = "Informe a idade do estudante")
    private Integer age;
    @Size(min = 1, max = 11, message = "Numero de caracteres não suportado")
    @ContactNumberConstraint
    private String telephone;
    @Size(min = 1, max = 200, message = "Numero de caracteres não suportado")
    private String address;
    @NotNull(message = "Informe o email do estudante")
    @Size(min = 1, max = 250, message = "Numero de caracteres não suportado")
    @Email(message = "email com formato invalido")
    private String email;
    @CPF
    @NotNull(message = "Informe o cpf do Aluno")
    @Size(min = 1, max = 14, message = "Numero de caracters não suportado")
    private String cpf;
    @NotNull
    private Long idTurma;

    public StudentDTO(Long id, String nameStudent, String registration, String sex, Integer age, String telephone, String address, String email, String cpf, Long idTurma) {
        this.id = id;
        this.nameStudent = nameStudent;
        this.registration = registration;
        this.sex = sex;
        this.age = age;
        this.telephone = telephone;
        this.address = address;
        this.email = email;
        this.cpf = cpf;
        this.idTurma = idTurma;
    }

    public static StudentDTO of(Student student) {
        return new StudentDTO(
                student.getId(),
                student.getNameStudent(),
                student.getRegistration(),
                student.getSex(),
                student.getAge(),
                student.getTelephone(),
                student.getAddress(),
                student.getEmail(),
                student.getCpf(),
                student.getTurma().getId()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
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

    public Long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Long idTurma) {
        this.idTurma = idTurma;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", nameStudent='" + nameStudent + '\'' +
                ", registration='" + registration + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idTurma=" + idTurma +
                '}';
    }
}
