package br.com.hbsis.hbsis.year;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class YearService {

    private final IYearRepository iYearRepository;

    public YearService(IYearRepository iYearRepository) {
        this.iYearRepository = iYearRepository;
    }

    public Year findById(Long id) {
        Optional<Year> yearOptional = iYearRepository.findById(id);

        if (yearOptional.isPresent()) {
            return yearOptional.get();
        }

        throw new IllegalArgumentException("Não foi possivel encontrar o ano");
    }

    public Year findByYearName(String mameYear) {
        Optional<Year> yearOptional = iYearRepository.findByNameYear(mameYear);

        if (yearOptional.isPresent()) {
            return yearOptional.get();
        }

        throw new IllegalArgumentException("Não foi possivel encontrar o ano");
    }
}
