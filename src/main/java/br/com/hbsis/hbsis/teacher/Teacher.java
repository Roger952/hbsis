package br.com.hbsis.hbsis.teacher;

import br.com.hbsis.hbsis.diciplina_professor.DisciplinaProfessor;
import br.com.hbsis.hbsis.intituicao.Instituicao;
import br.com.hbsis.hbsis.utils.AbstractEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "professor")
public class Teacher extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "id_instituicao", nullable = false)
    private Instituicao instituicao;

    @Column(name = "nome_professor", nullable = false, length = 100)
    private String nomeProfessor;

    @Column(name = "sexo", length = 10, nullable = false)
    private String sex;

    @Column(name = "idade", nullable = false)
    private Integer age;

    @Column(name = "telefone", length = 11)
    private String telephone;

    @Column(name = "endereco", length = 200)
    private String address;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    private String cpf;

    @OneToMany(mappedBy = "teacher")
    private List<DisciplinaProfessor> disciplinas;

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
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

    public List<DisciplinaProfessor> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<DisciplinaProfessor> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "instituicao=" + instituicao +
                ", nomeProfessor='" + nomeProfessor + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", disciplinas=" + disciplinas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return instituicao.equals(teacher.instituicao) &&
                nomeProfessor.equals(teacher.nomeProfessor) &&
                sex.equals(teacher.sex) &&
                age.equals(teacher.age) &&
                telephone.equals(teacher.telephone) &&
                address.equals(teacher.address) &&
                email.equals(teacher.email) &&
                cpf.equals(teacher.cpf) &&
                disciplinas.equals(teacher.disciplinas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), instituicao, nomeProfessor, sex, age, telephone, address, email, cpf, disciplinas);
    }
}
