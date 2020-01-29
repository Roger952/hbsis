package br.com.hbsis.hbsis.disciplina;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DisciplinaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DisciplinaService.class);

    private final IDisciplinaRepository iDisciplinaRepository;

    public DisciplinaService(IDisciplinaRepository iDisciplinaRepository) {
        this.iDisciplinaRepository = iDisciplinaRepository;
    }

    public Disciplina withoutDTO(DisciplinaDTO disciplinaDTO) {
        Disciplina disciplina = new Disciplina();
        disciplina.setNameDisciplina(disciplinaDTO.getNameDisciplina());
        disciplina.setId(disciplinaDTO.getId());
        return disciplina;
    }

    public Disciplina findById(Long id) {
        Optional<Disciplina> disciplinaOptional = iDisciplinaRepository.findById(id);

        if (disciplinaOptional.isPresent()) {
            return disciplinaOptional.get();
        }

        throw new IllegalArgumentException("Não foi encontrado nenhuma Disciplina com este ID");
    }

    public Disciplina findByNameDisciplina(String nameDisciplina) {
        Optional<Disciplina> disciplinaOptional = iDisciplinaRepository.findByNameDisciplina(nameDisciplina);

        if (disciplinaOptional.isPresent()) {
            return disciplinaOptional.get();
        }

        throw new IllegalArgumentException("Não foi encontrado nenhuma Disciplina com este ID");
    }
}
