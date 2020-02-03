package br.com.hbsis.hbsis.turmas.Serie;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SerieService {

    private final ISerieRepository iSerieRepository;

    public SerieService(ISerieRepository iSerieRepository) {
        this.iSerieRepository = iSerieRepository;
    }

    public Serie findByCodSerie(Long numberSerie) {
        Optional<Serie> serieOptional = iSerieRepository.findByNumberSerie(numberSerie);

        if (serieOptional.isPresent()) {
            return serieOptional.get();
        }
        throw new IllegalArgumentException("Não foi possivel encontar uma serie com este id");
    }
}
