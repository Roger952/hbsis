package br.com.hbsis.hbsis.grau_ensino;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IGrauEnsinoRepository extends JpaRepository<GrauEnsino,Long> {

    Optional<GrauEnsino> findByNomeGrau (String nomeGrau);
}
