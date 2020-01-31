package br.com.hbsis.hbsis.boletim;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boletins")
public class BoletimRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BoletimRest.class);

    private final BoletimService boletimService;

    public BoletimRest(BoletimService boletimService) {
        this.boletimService = boletimService;
    }

    @PostMapping
    public BoletimDTO save(@RequestBody BoletimDTO boletimDTO) {
        LOGGER.info("Enviando Requisição para sarvar o Boletim inserido");

        return boletimService.save(boletimDTO);
    }

    @GetMapping("/extractBoletim/{idStudante}/{idAno}")
    public List<BoletimDTO> extractBoletim(@PathVariable(name = "idStudante") Long idStudent, @PathVariable(name = "idAno") Long idYear) {
        LOGGER.info("Extraindo o boletim");

        return boletimService.findByStudentAndYear(idStudent, idYear);
    }
}
