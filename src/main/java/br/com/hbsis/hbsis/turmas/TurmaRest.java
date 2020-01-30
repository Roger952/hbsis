package br.com.hbsis.hbsis.turmas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(TurmaRest.class);

    private final TurmaService turmaService;

    @Autowired
    public TurmaRest(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @PostMapping
    public ResponseEntity<TurmaDTO> turmaDTO(@RequestBody TurmaDTO turmaDTO) {
        LOGGER.info("Enviando requisição para salvar a turma");

        return new ResponseEntity<>(turmaService.save(turmaDTO), HttpStatus.OK);
    }

    @GetMapping("findByInstituicaoAndNameTurma/{idIntituicao}/{nameInstituicao}")
    public ResponseEntity<List<Turma>> findByInstituicaoAndNameTurmaContaining(@PathVariable(name = "idIntituicao") Long id, @PathVariable(name = "nameInstituicao") String nameInstituicaoInsert) {
        return new ResponseEntity<>(turmaService.findByInstituicaoAndNameTurmaContaining(id, nameInstituicaoInsert), HttpStatus.OK);
    }
}
