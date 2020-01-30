package br.com.hbsis.hbsis.semestre;

import br.com.hbsis.hbsis.teacher.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SemestreService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherService.class);
    private final ISemestreRepository iSemestreRepository;

    public SemestreService(ISemestreRepository iSemestreRepository) {
        this.iSemestreRepository = iSemestreRepository;
    }

    public Semestre findById(Long id){
        Optional<Semestre> optionalSemestre = iSemestreRepository.findById(id);
        if (optionalSemestre.isPresent()){
            return optionalSemestre.get();
        }
        throw new IllegalArgumentException("Não foi encontrado um Semestre com este id");
    }
}
