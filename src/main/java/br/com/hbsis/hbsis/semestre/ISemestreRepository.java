package br.com.hbsis.hbsis.semestre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ISemestreRepository extends JpaRepository<Semestre, Long> {
}
