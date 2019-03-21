package com.gus.jobofferhunter.service;

import com.gus.jobofferhunter.model.offer.Adzuna;
import com.gus.jobofferhunter.repository.AdzunaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdzunaService {
    private final AdzunaRepository adzunaRepository;

    public AdzunaService(AdzunaRepository adzunaRepository) {
        this.adzunaRepository = adzunaRepository;
    }

    public Iterable<Adzuna> list() {
        return adzunaRepository.findAll();
    }

    public Adzuna save(Adzuna adzuna) {
        return adzunaRepository.save(adzuna);
    }

    public void save(List<Adzuna> adzunaList) {
        adzunaRepository.save(adzunaList);
    }
}
