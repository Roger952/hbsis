package br.com.hbsis.hbsis.diciplina_professor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface IDisciplinaProfessorRepository extends JpaRepository<DisciplinaProfessor, Long> {
}
