package br.com.hbsis.hbsis.boletim;

import br.com.hbsis.hbsis.disciplina.Disciplina;
import br.com.hbsis.hbsis.semestre.Semestre;
import br.com.hbsis.hbsis.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface IBoletimRepository extends JpaRepository<Boletim, Long> {

    boolean existsByDisciplinaAndSemestreAndStudent(Disciplina disciplina, Semestre semestre, Student student);

    List<Boletim> findByStudentAndSemestre (Student student, Semestre semestre);
}
