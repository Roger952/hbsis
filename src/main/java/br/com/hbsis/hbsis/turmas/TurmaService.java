package br.com.hbsis.hbsis.turmas;

import br.com.hbsis.hbsis.intituicao.InstituicaoService;
import br.com.hbsis.hbsis.turmas.Serie.SerieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TurmaService.class);

    private final ITurmaRepository iTurmaRepository;
    private final SerieService serieService;
    private final InstituicaoService instituicaoService;

    public TurmaService(ITurmaRepository iTurmaRepository, SerieService serieService, InstituicaoService instituicaoService) {
        this.iTurmaRepository = iTurmaRepository;
        this.serieService = serieService;
        this.instituicaoService = instituicaoService;
    }

    public Turma findById(Long id) {
        Optional<Turma> turmaOptional = iTurmaRepository.findById(id);
        if (turmaOptional.isPresent()) {
            return turmaOptional.get();
        }
        throw new IllegalArgumentException("Turma não encontrada");
    }

    public TurmaDTO save(TurmaDTO turmaDTO) {
        LOGGER.info("Salvando a turma inserida");

        validate(turmaDTO);

        Turma turma = of(turmaDTO);

        turma = iTurmaRepository.save(turma);

        return TurmaDTO.of(turma);
    }

    private Turma of(TurmaDTO turmaDTO) {

        LOGGER.info("Removing DTO");

        return new Turma(
                turmaDTO.getNameTurma(),
                turmaDTO.getAmountOfStudents(),
                serieService.findById(turmaDTO.getIdSerie()),
                instituicaoService.findById(turmaDTO.getIdInstituicao())
        );
    }

    private void validate(TurmaDTO turmaDTO) {
        LOGGER.info("Validando a turma inserida");

        if (iTurmaRepository.existsByNameTurma(turmaDTO.getNameTurma())) {
            throw new IllegalArgumentException("Já existe uma turma cadastrada com este nome");
        }
    }

    public List<Turma> findByInstituicaoAndNameTurmaContaining(Long idInstituicao, String nameInstitucao) {
        return iTurmaRepository.findByInstituicaoAndNameTurmaContaining(instituicaoService.findById(idInstituicao), nameInstitucao);
    }
}
