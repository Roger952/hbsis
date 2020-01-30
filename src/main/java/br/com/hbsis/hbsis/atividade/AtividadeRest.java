package br.com.hbsis.hbsis.atividade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atividades")
public class AtividadeRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AtividadeRest.class);

    private final AtividadeService atividadeService;

    public AtividadeRest(AtividadeService atividadeService) {
        this.atividadeService = atividadeService;
    }

    @PostMapping
    private AtividadeDTO save(@RequestBody AtividadeDTO atividadeDTO){
        LOGGER.info("Enviando requisição para salvar as aitividades inseridas");
        return atividadeService.save(atividadeDTO);
    }
}
