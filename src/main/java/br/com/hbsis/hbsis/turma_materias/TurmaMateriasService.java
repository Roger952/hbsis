package br.com.hbsis.hbsis.turma_materias;

import br.com.hbsis.hbsis.disciplina.DisciplinaService;
import br.com.hbsis.hbsis.turmas.TurmaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TurmaMateriasService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TurmaMateriasService.class);

    private final ITurmaMateriasRepository iTurmaMateriasRepository;
    private final TurmaService turmaService;
    private final DisciplinaService disciplinaService;

    public TurmaMateriasService(ITurmaMateriasRepository iTurmaMateriasRepository, TurmaService turmaService, DisciplinaService disciplinaService) {
        this.iTurmaMateriasRepository = iTurmaMateriasRepository;
        this.turmaService = turmaService;
        this.disciplinaService = disciplinaService;
    }

    public TurmaMateriasDTO save(TurmaMateriasDTO turmaMateriasDTO) {
        LOGGER.info("Salvando a relação entre turmas e disciplinas");

        TurmaMaterias turmaMaterias = of(turmaMateriasDTO);

        turmaMaterias = iTurmaMateriasRepository.save(turmaMaterias);

        return TurmaMateriasDTO.of(turmaMaterias);
    }

    private TurmaMaterias of(TurmaMateriasDTO turmaMateriasDTO) {
        return new TurmaMaterias(
                turmaService.findById(turmaMateriasDTO.getIdTurma()),
                disciplinaService.findById(turmaMateriasDTO.getIdDisciplinaTurma())
        );
    }
}
