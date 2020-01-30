package br.com.hbsis.hbsis.turma_materias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ITurmaMaterias extends JpaRepository<TurmaMaterias, Long> {

}
