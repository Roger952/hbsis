package br.com.hbsis.hbsis.atividade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface IAtividadeRepository extends JpaRepository<Atividade, Long> {
}
