package br.com.hbsis.hbsis.intituicao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIntituicaoRepository extends JpaRepository<Instituicao, Long> {
}
