package br.com.hbsis.hbsis.turmas.Serie;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SerieService {

    private final ISerieRepository iSerieRepository;

    public SerieService(ISerieRepository iSerieRepository) {
        this.iSerieRepository = iSerieRepository;
    }

    public Serie findById(Long id){
        Optional<Serie> serieOptional = iSerieRepository.findById(id);

        if (serieOptional.isPresent()){
            return serieOptional.get();
        }
        throw new IllegalArgumentException("Não foi possivel encontar uma serie com este id");
    }
}
