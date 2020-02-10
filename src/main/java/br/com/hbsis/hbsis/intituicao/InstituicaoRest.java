package br.com.hbsis.hbsis.intituicao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools")
@CrossOrigin(origins = "*")
public class InstituicaoRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(InstituicaoRest.class);
    private final InstituicaoService instituicaoService;

    public InstituicaoRest(InstituicaoService instituicaoService) {
        this.instituicaoService = instituicaoService;
    }

    @GetMapping("/findALL")
    public List<Instituicao> findAll() {

        LOGGER.info("Enviando requisição para listar todos as escolas cadastradas no sistema");

        return instituicaoService.findALL();
    }

    @GetMapping("/findById/{id}")
    public Instituicao findById(@PathVariable(name = "id") Long id) {

        LOGGER.info("Enviando requisição para listar todos as escolas cadastradas no sistema");

        return instituicaoService.findById(id);
    }

    @GetMapping("/findByIntituicaoContainingName/{nameInstituicao}")
    public List<Instituicao> findByContainingNameInstituicao(@PathVariable(name = "nameInstituicao") String nameInstituicao) {

        return instituicaoService.findByNameInstituicaoContaining(nameInstituicao);
    }

    @PostMapping("/save")
    public InstituicaoDTO save(@RequestBody InstituicaoDTO instituicaoDTO){
        LOGGER.info("Salvando a instituição");
        return instituicaoService.save(instituicaoDTO);
    }
}
