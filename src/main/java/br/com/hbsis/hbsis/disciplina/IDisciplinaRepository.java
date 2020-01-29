package br.com.hbsis.hbsis.disciplina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface IDisciplinaRepository extends JpaRepository<Disciplina, Long> {
    Optional<Disciplina> findByNameDisciplina(String nameDisciplina);
}
