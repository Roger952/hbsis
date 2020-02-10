package br.com.hbsis.hbsis.modelo_boletim;

import net.sf.jasperreports.engine.JRException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/modeloboletim")
public class ModeloBoletimRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ModeloBoletimRest.class);

    private final ModeloBoletimService modeloBoletimService;

    @Autowired
    public ModeloBoletimRest(ModeloBoletimService modeloBoletimService) {
        this.modeloBoletimService = modeloBoletimService;
    }

    @GetMapping("/extract-boletim/{idAluno}")
    public HttpEntity<byte[]> findByStudentId(@PathVariable(name = "idAluno") Long idAluno) throws FileNotFoundException, JRException {

        LOGGER.info("Procurando o boletim do estudante informado");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_PDF);

        return new ResponseEntity<>(modeloBoletimService.exportReport(idAluno), httpHeaders, HttpStatus.OK);
    }
}
