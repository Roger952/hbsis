package br.com.hbsis.hbsis.grau_ensino;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class GrauEnsinoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GrauEnsino.class);

    private final IGrauEnsinoRepository iGrauEnsinoRepository;

    @Autowired
    public GrauEnsinoService(IGrauEnsinoRepository iGrauEnsinoRepository) {
        this.iGrauEnsinoRepository = iGrauEnsinoRepository;
    }

    public Set<GrauEnsino> findAll() {
        LOGGER.info("Procurando todos os graus disponiveis");
        return new HashSet<>(iGrauEnsinoRepository.findAll());
    }

    public GrauEnsino findByNameGrau(String nomeGrau) {

        Optional<GrauEnsino> grauEnsinoOptional = iGrauEnsinoRepository.findByNomeGrau(nomeGrau);

        if (grauEnsinoOptional.isPresent()) {
            return grauEnsinoOptional.get();
        }

        throw new IllegalArgumentException("Não foi possivel encontrar o grau com o nome" + nomeGrau);
    }
}
