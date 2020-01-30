package br.com.hbsis.hbsis.turmas;

import br.com.hbsis.hbsis.intituicao.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface ITurmaRepository extends JpaRepository<Turma, Long> {

    boolean existsByNameTurma(String nameTurma);

    List<Turma> findByInstituicaoAndNameTurmaContaining(Instituicao instituicao, String nameTurma);
}
