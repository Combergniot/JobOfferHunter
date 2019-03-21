package com.gus.jobofferhunter.service;

import com.gus.jobofferhunter.model.offer.PracaTobie;
import com.gus.jobofferhunter.repository.PracaTobieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracaTobieService {

    private final PracaTobieRepository pracaTobieRepository;

    public PracaTobieService(PracaTobieRepository pracaTobieRepository) {
        this.pracaTobieRepository = pracaTobieRepository;
    }

    public Iterable<PracaTobie> list() {
        return pracaTobieRepository.findAll();
    }

    public PracaTobie save(PracaTobie pracaTobie) {
        return pracaTobieRepository.save(pracaTobie);
    }

    public void save(List<PracaTobie> pracaTobieList) {
        pracaTobieRepository.save(pracaTobieList);
    }
}
