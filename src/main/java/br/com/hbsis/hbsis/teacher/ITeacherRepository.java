package br.com.hbsis.hbsis.teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ITeacherRepository extends JpaRepository<Teacher, Long> {
    boolean existsByCpf(String cpf);
}
