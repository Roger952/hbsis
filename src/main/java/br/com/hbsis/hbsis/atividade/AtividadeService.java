package br.com.hbsis.hbsis.atividade;

import br.com.hbsis.hbsis.boletim.BoletimService;
import br.com.hbsis.hbsis.teacher.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AtividadeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AtividadeService.class);

    private final IAtividadeRepository iAtividadeRepository;
    private final TeacherService teacherService;
    private final BoletimService boletimService;

    public AtividadeService(IAtividadeRepository iAtividadeRepository, TeacherService teacherService, BoletimService boletimService) {
        this.iAtividadeRepository = iAtividadeRepository;
        this.teacherService = teacherService;
        this.boletimService = boletimService;
    }

    public AtividadeDTO save(AtividadeDTO atividadeDTO) {

        LOGGER.info("Salvando as atividades");

        validate(atividadeDTO);

        Atividade atividade = of(atividadeDTO);

        atividade = iAtividadeRepository.save(atividade);

        return AtividadeDTO.of(atividade);
    }

    public Atividade of(AtividadeDTO atividadeDTO) {
        return new Atividade(
                atividadeDTO.getDescription(),
                atividadeDTO.getStatus(),
                atividadeDTO.getReleaseDate(),
                atividadeDTO.getEndDate(),
                boletimService.findById(atividadeDTO.getIdBoletim()),
                teacherService.findById(atividadeDTO.getIdTeacher()),
                atividadeDTO.getGrades()
        );
    }

    private void validate(AtividadeDTO atividadeDTO) {
        LOGGER.info("Validando as atividades");

        if (atividadeDTO.getEndDate().before(atividadeDTO.getReleaseDate())) {
            throw new IllegalArgumentException("A data de termino não pode ser anterior a data de inicio");
        }
        if (StringUtils.isEmpty(atividadeDTO.getStatus())) {
            atividadeDTO.setStatus("Ativo");
        }

    }
}
