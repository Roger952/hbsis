package br.com.hbsis.hbsis.diciplina_professor;

import br.com.hbsis.hbsis.disciplina.DisciplinaService;
import br.com.hbsis.hbsis.teacher.Teacher;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DisciplinaProfessorBridge {

    private final IDisciplinaProfessorRepository iDisciplinaProfessorRepository;
    private final DisciplinaService disciplinaService;

    public DisciplinaProfessorBridge(IDisciplinaProfessorRepository iDisciplinaProfessorRepository, DisciplinaService disciplinaService) {
        this.iDisciplinaProfessorRepository = iDisciplinaProfessorRepository;
        this.disciplinaService = disciplinaService;
    }

    public DisciplinaProfessor save(DisciplinaProfessorDTO disciplinaProfessorDTO, Teacher teacher) {


        DisciplinaProfessor disciplinaProfessor = new DisciplinaProfessor();

        disciplinaProfessor.setTeacher(teacher);
        disciplinaProfessor.setDisciplina(disciplinaService.findById(disciplinaProfessorDTO.getDisciplina()));

        disciplinaProfessor = iDisciplinaProfessorRepository.save(disciplinaProfessor);

        return disciplinaProfessor;
    }

    public DisciplinaProfessor findById(Long id) {
        Optional<DisciplinaProfessor> disciplinaProfessorOptional = iDisciplinaProfessorRepository.findById(id);

        if (disciplinaProfessorOptional.isPresent()) {
            return disciplinaProfessorOptional.get();
        }

        throw new IllegalArgumentException("Não foi encontrada nenhuma relação Disciplina/Professor que tenha este id");
    }

}
