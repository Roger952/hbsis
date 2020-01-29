package br.com.hbsis.hbsis.atividade;

import org.springframework.stereotype.Service;

@Service
public class AtividadeService {

    private final IAtividadeRepository iAtividadeRepository;

    public AtividadeService(IAtividadeRepository iAtividadeRepository) {
        this.iAtividadeRepository = iAtividadeRepository;
    }
}
