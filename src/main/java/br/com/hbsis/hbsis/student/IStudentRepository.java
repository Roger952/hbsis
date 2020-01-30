package br.com.hbsis.hbsis.student;

import br.com.hbsis.hbsis.turmas.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface IStudentRepository extends JpaRepository<Student, Long> {

    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);

    boolean existsByRegistration(String registration);

    List<Student> findByTurmaAndNameStudentContaining(Turma turma, String nameStudentContaining);

    Optional<Student> findByRegistration(String registration);
}
