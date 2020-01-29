package br.com.hbsis.hbsis.intituicao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstituicaoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InstituicaoService.class);

    private final IIntituicaoRepository iIntituicaoRepository;

    public InstituicaoService(IIntituicaoRepository iIntituicaoRepository) {
        this.iIntituicaoRepository = iIntituicaoRepository;
    }

    public Instituicao findById(Long id) {
        Optional<Instituicao> instituicaoOptional = iIntituicaoRepository.findById(id);

        if (instituicaoOptional.isPresent()) {
            LOGGER.info("Intitução encontrada");
            return instituicaoOptional.get();
        }

        throw new IllegalArgumentException("Não foi encontrado nenhuma instituição com id: [{}]" + id);
    }

    public List<Instituicao> findALL() {

        LOGGER.info("Listando todos as escolas cadastradas no Sistema");

        return iIntituicaoRepository.findAll();
    }
}
