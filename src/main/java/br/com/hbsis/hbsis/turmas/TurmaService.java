package br.com.hbsis.hbsis.turmas;

import br.com.hbsis.hbsis.intituicao.InstituicaoService;
import br.com.hbsis.hbsis.turma_materias.TurmaMateriasDTO;
import br.com.hbsis.hbsis.turma_materias.TurmaMateriasService;
import br.com.hbsis.hbsis.turmas.Serie.SerieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TurmaService.class);

    private final ITurmaRepository iTurmaRepository;
    private final SerieService serieService;
    private final InstituicaoService instituicaoService;
    private final TurmaMateriasService turmaMateriasService;

    public TurmaService(ITurmaRepository iTurmaRepository, SerieService serieService, InstituicaoService instituicaoService, @Lazy TurmaMateriasService turmaMateriasService) {
        this.iTurmaRepository = iTurmaRepository;
        this.serieService = serieService;
        this.instituicaoService = instituicaoService;
        this.turmaMateriasService = turmaMateriasService;
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

        saveDisciplinas(turmaDTO.getTurmaMateriasDTOList(), turma.getId());

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

    private void saveDisciplinas(List<TurmaMateriasDTO> turmaMateriasDTOS, Long idTurma) {

        for (TurmaMateriasDTO turmaMateriasDTO : turmaMateriasDTOS) {
            turmaMateriasDTO.setIdTurma(idTurma);
            turmaMateriasService.save(turmaMateriasDTO);
        }
    }
}
