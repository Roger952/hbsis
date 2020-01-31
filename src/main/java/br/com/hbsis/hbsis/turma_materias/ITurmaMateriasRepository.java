package br.com.hbsis.hbsis.turma_materias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ITurmaMateriasRepository extends JpaRepository<TurmaMaterias, Long> {

}
