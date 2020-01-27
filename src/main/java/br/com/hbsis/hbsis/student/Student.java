package br.com.hbsis.hbsis.student;

import br.com.hbsis.hbsis.utils.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

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
                '}';
    }
}
