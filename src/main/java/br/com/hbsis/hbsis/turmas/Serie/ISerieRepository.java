package br.com.hbsis.hbsis.turmas.Serie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface ISerieRepository extends JpaRepository<Serie, Long> {

    Optional<Serie> findByNumberSerie(Long numberSerie);
}
