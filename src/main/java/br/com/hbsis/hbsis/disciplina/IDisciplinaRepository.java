package br.com.hbsis.hbsis.disciplina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
