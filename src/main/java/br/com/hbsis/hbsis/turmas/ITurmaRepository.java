package br.com.hbsis.hbsis.turmas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurmaRepository extends JpaRepository<Turma, Long> {

    boolean existsByNameTurma(String nameTurma);
}
