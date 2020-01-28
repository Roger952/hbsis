package br.com.hbsis.hbsis.teacher;

import br.com.hbsis.hbsis.intituicao.InstituicaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class TeacherService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherService.class);

    private final ITeacherRepository iTeacherRepository;
    private final InstituicaoService instituicaoService;

    public TeacherService(ITeacherRepository iTeacherRepository, InstituicaoService instituicaoService) {
        this.iTeacherRepository = iTeacherRepository;
        this.instituicaoService = instituicaoService;
    }

    public TeacherDTO save(TeacherDTO teacherDTO) {

        LOGGER.info("Saving teacher");

        validate(teacherDTO);

        Teacher teacher = iTeacherRepository.save(setInformation(teacherDTO));

        return TeacherDTO.of(teacher);
    }

    private Teacher setInformation(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
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
            throw new IllegalArgumentException("Já existe outro professor cadastrado com este cpf");
        }
        if (iTeacherRepository.existsByEmail(teacherDTO.getEmail())) {
            throw new IllegalArgumentException("Já existe um professor cadastrado com este email");
        }
        if (teacherDTO.getTelephone().matches("(\\(\\d{2}\\)\\s)(\\d{4,5}-\\d{4})")) {
            teacherDTO.setTelephone(teacherDTO.getTelephone().replaceAll("[^0-9]", ""));
        }
    }
}