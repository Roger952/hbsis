package br.com.hbsis.hbsis.teacher;

import br.com.hbsis.hbsis.diciplina_professor.DisciplinaProfessor;
import br.com.hbsis.hbsis.diciplina_professor.DisciplinaProfessorBridge;
import br.com.hbsis.hbsis.diciplina_professor.DisciplinaProfessorDTO;
import br.com.hbsis.hbsis.intituicao.InstituicaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherService.class);

    private final ITeacherRepository iTeacherRepository;
    private final InstituicaoService instituicaoService;
    private final DisciplinaProfessorBridge disciplinaProfessorBridge;

    public TeacherService(ITeacherRepository iTeacherRepository, InstituicaoService instituicaoService, DisciplinaProfessorBridge disciplinaProfessorBridge) {
        this.iTeacherRepository = iTeacherRepository;
        this.instituicaoService = instituicaoService;
        this.disciplinaProfessorBridge = disciplinaProfessorBridge;
    }

    public TeacherDTO save(TeacherDTO teacherDTO) {

        LOGGER.info("Saving teacher");

        Teacher teacher = new Teacher();

        validate(teacherDTO);

        teacher = iTeacherRepository.save(withoutDTO(teacherDTO, teacher));

        teacher.setDisciplinas(parseDisciplinaDTOToDisciplinaToSave(teacherDTO.getDisciplinaProfessor(), teacher));

        return TeacherDTO.of(teacher);
    }

    public Teacher withoutDTO(TeacherDTO teacherDTO, Teacher teacher) {
        teacher.setNomeProfessor(teacherDTO.getNameTeacher());
        teacher.setCpf(teacherDTO.getCpf());
        teacher.setAddress(teacherDTO.getAddress());
        teacher.setAge(teacherDTO.getAge());
        teacher.setEmail(teacherDTO.getEmail());
        teacher.setSex(teacherDTO.getSex());
        teacher.setTelephone(teacherDTO.getTelephone());
        teacher.setInstituicao(instituicaoService.findById(teacherDTO.getIdInstituicao()));
        return teacher;
    }

    private void validate(TeacherDTO teacherDTO) {
        LOGGER.info("Validando o professor inserido");

        if (StringUtils.isEmpty(teacherDTO.getNameTeacher())) {
            throw new IllegalArgumentException("O nome do professor esta vazio");
        }
        if (StringUtils.isEmpty(teacherDTO.getAddress())) {
            throw new IllegalArgumentException("O endereço do professor esta vazio");
        }
        if (StringUtils.isEmpty(teacherDTO.getAge())) {
            throw new IllegalArgumentException("A idade do professor esta vazio");
        }
        if (StringUtils.isEmpty(teacherDTO.getCpf())) {
            throw new IllegalArgumentException("O cpf do professor esta vazio");
        }
        if (StringUtils.isEmpty(teacherDTO.getIdInstituicao())) {
            throw new IllegalArgumentException("O id da instituição esta vazio");
        }
        if (StringUtils.isEmpty(teacherDTO.getSex())) {
            throw new IllegalArgumentException("O sexo do professor esta vazio");
        }
        if (StringUtils.isEmpty(teacherDTO.getTelephone())) {
            throw new IllegalArgumentException("O telefone do professor esta vazio");
        }
        if (iTeacherRepository.existsByCpf(teacherDTO.getCpf())) {
            if (StringUtils.isEmpty(teacherDTO.getId())) {
                throw new IllegalArgumentException("Já existe outro professor cadastrado com este cpf");
            } else if (!findById(teacherDTO.getId()).getCpf().equalsIgnoreCase(teacherDTO.getCpf())) {
                throw new IllegalArgumentException("Não é permitido mudar o cpf do professor");
            }
        }
        if (iTeacherRepository.existsByEmail(teacherDTO.getEmail()) && StringUtils.isEmpty(teacherDTO.getId())) {
            throw new IllegalArgumentException("Já existe um professor cadastrado com este email");
        }
        if (teacherDTO.getTelephone().matches("(\\(\\d{2}\\)\\s)(\\d{4,5}-\\d{4})")) {
            teacherDTO.setTelephone(teacherDTO.getTelephone().replaceAll("[^0-9]", ""));
        }
    }

    public void update(TeacherDTO teacherDTO, Long id) {

        Optional<Teacher> teacherOptional = iTeacherRepository.findById(id);
        if (teacherOptional.isPresent()) {

            Teacher teacher = teacherOptional.get();

            teacherDTO.setId(id);

            validate(teacherDTO);

            iTeacherRepository.save(withoutDTO(teacherDTO, teacher));

        }
    }

    public TeacherDTO findByIdTeacherDTO(Long id) {
        Optional<Teacher> teacherOptional = iTeacherRepository.findById(id);
        if (teacherOptional.isPresent()) {
            return TeacherDTO.of(teacherOptional.get());
        }
        throw new IllegalArgumentException("Professor com id: ... [{}]" + id + " não encontrado");
    }

    public Teacher findById(Long id) {
        Optional<Teacher> teacherOptional = iTeacherRepository.findById(id);
        if (teacherOptional.isPresent()) {
            return teacherOptional.get();
        }
        throw new IllegalArgumentException("Professor com id: ... [{}]" + id + " não encontrado");
    }

    public List<DisciplinaProfessor> parseDisciplinaDTOToDisciplinaToSave(List<DisciplinaProfessorDTO> disciplinaProfessorDTOS, Teacher teacher) {
        List<DisciplinaProfessor> disciplinaProfessors = new ArrayList<>();

        for (DisciplinaProfessorDTO disciplinaProfessorDTO : disciplinaProfessorDTOS) {
            DisciplinaProfessor disciplinaProfessor = disciplinaProfessorBridge.save(disciplinaProfessorDTO, teacher);

            disciplinaProfessors.add(disciplinaProfessor);
        }

        return disciplinaProfessors;
    }
}