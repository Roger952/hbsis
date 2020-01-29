package br.com.hbsis.hbsis.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

    boolean existsByCpf (String cpf);
    boolean existsByEmail(String email);
    boolean existsByRegistration (String registration);
}
