package com.gus.jobofferhunter.service;

import com.gus.jobofferhunter.model.offer.GazetaPraca;
import com.gus.jobofferhunter.repository.GazetaPracaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GazetaPracaService {

    private final GazetaPracaRepository gazetaPracaRepository;

    public GazetaPracaService(GazetaPracaRepository gazetaPracaRepository) {
        this.gazetaPracaRepository = gazetaPracaRepository;
    }


    public Iterable<GazetaPraca> list() {
        return gazetaPracaRepository.findAll();
    }

    public GazetaPraca save(GazetaPraca gazetaPraca) {
        return gazetaPracaRepository.save(gazetaPraca);
    }

    public void save(List<GazetaPraca> gazetaPracaListList) {
        gazetaPracaRepository.save(gazetaPracaListList);
    }
}
