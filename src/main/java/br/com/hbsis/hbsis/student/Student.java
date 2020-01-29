package br.com.hbsis.hbsis.student;

import br.com.hbsis.hbsis.turmas.Turma;
import br.com.hbsis.hbsis.utils.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity(name = "estudante")
public class Student extends AbstractEntity {

    @Column(name = "name_estudante", length = 100, nullable = false)
    private String nameStudent;

    @Column(name = "matricula", length = 50, nullable = false, unique = true)
    private String registration;

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

    @ManyToOne
    @JoinColumn(name = "id_turma", nullable = false, referencedColumnName = "id")
    private Turma turma;

    public Student() {
    }

    public Student(String nameStudent, String registration, String sex, Integer age, String telephone, String address, String email, String cpf, Turma turma) {
        this.nameStudent = nameStudent;
        this.registration = registration;
        this.sex = sex;
        this.age = age;
        this.telephone = telephone;
        this.address = address;
        this.email = email;
        this.cpf = cpf;
        this.turma = turma;
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

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nameStudent='" + nameStudent + '\'' +
                ", registration='" + registration + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", turma=" + turma +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return nameStudent.equals(student.nameStudent) &&
                registration.equals(student.registration) &&
                sex.equals(student.sex) &&
                age.equals(student.age) &&
                telephone.equals(student.telephone) &&
                address.equals(student.address) &&
                email.equals(student.email) &&
                cpf.equals(student.cpf) &&
                turma.equals(student.turma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nameStudent, registration, sex, age, telephone, address, email, cpf, turma);
    }
}
