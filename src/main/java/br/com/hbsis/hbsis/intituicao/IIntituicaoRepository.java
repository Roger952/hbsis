package br.com.hbsis.hbsis.intituicao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface IIntituicaoRepository extends JpaRepository<Instituicao, Long> {

    List<Instituicao> findByNameInstituicaoContaining(String nomeInstituicao);
}
