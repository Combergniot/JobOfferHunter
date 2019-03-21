package com.gus.jobofferhunter.service;

import com.gus.jobofferhunter.model.offer.InfoPraca;
import com.gus.jobofferhunter.repository.InfoPracaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoPracaService {
    private final InfoPracaRepository infoPracaRepository;

    public InfoPracaService(InfoPracaRepository infoPracaRepository) {
        this.infoPracaRepository = infoPracaRepository;
    }

    public Iterable<InfoPraca> list() {
        return infoPracaRepository.findAll();
    }

    public InfoPraca save(InfoPraca infoPraca) {
        return infoPracaRepository.save(infoPraca);
    }

    public void save(List<InfoPraca> infoPracaList) {
        infoPracaRepository.save(infoPracaList);
    }
}
