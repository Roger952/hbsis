package br.com.hbsis.hbsis.teacher;

import br.com.hbsis.hbsis.annotations.AgeOfTeacherValidate;
import br.com.hbsis.hbsis.annotations.ContactNumberConstraint;
import br.com.hbsis.hbsis.annotations.ValidSex;
import br.com.hbsis.hbsis.diciplina_professor.DisciplinaProfessorDTO;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

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
    @AgeOfTeacherValidate(message = "Esta idade mão pode ser aceitada pelo sistema")
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

    private List<DisciplinaProfessorDTO> disciplinaProfessor;

    public TeacherDTO() {
    }

    public TeacherDTO(Long id, Long idInstituicao, String nameTeacher, String sex, Integer age, String telephone, String address, String email, String cpf, List<DisciplinaProfessorDTO> disciplinaProfessor) {
        this.id = id;
        this.idInstituicao = idInstituicao;
        this.nameTeacher = nameTeacher;
        this.sex = sex;
        this.age = age;
        this.telephone = telephone;
        this.address = address;
        this.email = email;
        this.cpf = cpf;
        this.disciplinaProfessor = disciplinaProfessor;
    }

    public static TeacherDTO of(Teacher teacher) {
        List<DisciplinaProfessorDTO> disciplinaDTOS = new ArrayList<>();

        teacher.getDisciplinas().forEach(disciplinaProfessor -> disciplinaDTOS.add(DisciplinaProfessorDTO.of(disciplinaProfessor)));
        return new TeacherDTO(
                teacher.getId(),
                teacher.getInstituicao().getId(),
                teacher.getNomeProfessor(),
                teacher.getSex(),
                teacher.getAge(),
                teacher.getTelephone(),
                teacher.getAddress(),
                teacher.getEmail(),
                teacher.getCpf(),
                disciplinaDTOS
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

    public List<DisciplinaProfessorDTO> getDisciplinaProfessor() {
        return disciplinaProfessor;
    }

    public void setDisciplinaProfessor(List<DisciplinaProfessorDTO> disciplinaProfessor) {
        this.disciplinaProfessor = disciplinaProfessor;
    }

    @Override
    public String toString() {
        return "TeacherDTO{" +
                "id=" + id +
                ", idInstituicao=" + idInstituicao +
                ", nameTeacher='" + nameTeacher + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", disciplinaProfessor=" + disciplinaProfessor +
                '}';
    }
}
