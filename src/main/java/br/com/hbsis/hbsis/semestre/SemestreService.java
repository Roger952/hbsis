package br.com.hbsis.hbsis.semestre;

import br.com.hbsis.hbsis.year.YearService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SemestreService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SemestreService.class);
    private final ISemestreRepository iSemestreRepository;
    private final YearService yearService;

    public SemestreService(ISemestreRepository iSemestreRepository, YearService yearService) {
        this.iSemestreRepository = iSemestreRepository;
        this.yearService = yearService;
    }

    public Semestre findById(Long id) {
        Optional<Semestre> optionalSemestre = iSemestreRepository.findById(id);
        if (optionalSemestre.isPresent()) {
            return optionalSemestre.get();
        }
        throw new IllegalArgumentException("Não foi encontrado um Semestre com este id");
    }

    public List<Semestre> findByYearId (Long idYear){
        return iSemestreRepository.findByYear(yearService.findById(idYear));
    }
}
