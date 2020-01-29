package br.com.hbsis.hbsis.intituicao;

import br.com.hbsis.hbsis.teacher.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstituicaoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherService.class);

    private final IIntituicaoRepository iIntituicaoRepository;

    public InstituicaoService(IIntituicaoRepository iIntituicaoRepository) {
        this.iIntituicaoRepository = iIntituicaoRepository;
    }

    public Instituicao findById(Long id){
        Optional<Instituicao> instituicaoOptional = iIntituicaoRepository.findById(id);

        if (instituicaoOptional.isPresent()){
            LOGGER.info("Intitução encontrada");
            return instituicaoOptional.get();
        }

        throw new IllegalArgumentException("Não foi encontrado nenhuma instituição com id: [{}]" + id);
    }
}
