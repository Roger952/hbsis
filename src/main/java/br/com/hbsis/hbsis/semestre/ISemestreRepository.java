package br.com.hbsis.hbsis.semestre;

import br.com.hbsis.hbsis.year.Year;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface ISemestreRepository extends JpaRepository<Semestre, Long> {

    List<Semestre> findByYear (Year year);
}
