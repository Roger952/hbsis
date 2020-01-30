package br.com.hbsis.hbsis.year;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IYearRepository extends JpaRepository<Year, Long> {

    Optional<Year> findByNameYear(String year);
}
