package br.com.hbsis.hbsis.modeloboletim;

import br.com.hbsis.hbsis.student.Student;
import br.com.hbsis.hbsis.year.Year;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IModeloBoletimRepository extends JpaRepository<ModeloBoletim, Long> {
    List<ModeloBoletim> findByYearAndStudent(Year year, Student student);

    Optional<ModeloBoletim> findByNameDisciplinaAndYearAndStudent(String nomeDisciplina, Year year, Student student);
}
