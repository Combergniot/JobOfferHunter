package com.gus.jobofferhunter.service;

import com.gus.jobofferhunter.exceptions.OfferNotFoundException;
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

    public InfoPraca findById(Long id) {
        InfoPraca infoPraca = infoPracaRepository.findById(id);
        if (infoPraca == null) {
            throw new OfferNotFoundException("Job offer with ID: " + id + " does not exist");
        }
        return infoPraca;
    }

    public Iterable<InfoPraca> findByRegion(String region) {
        return infoPracaRepository.findByRegion(region);
    }

    public Iterable<InfoPraca> findByWorkplace(String workplace) {
        return infoPracaRepository.findByWorkplace(workplace);
    }

    public Iterable<InfoPraca> findByPosition(String position) {
        return infoPracaRepository.findByPosition(position);
    }

    public Iterable<InfoPraca> findByEmployer(String employer) {
        return infoPracaRepository.findByEmployer(employer);
    }

    public Iterable<InfoPraca> findByDatePublished(String datePublished) {
        return infoPracaRepository.findByDatePublished(datePublished);
    }


}
