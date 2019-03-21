package com.gus.jobofferhunter.service;

import com.gus.jobofferhunter.model.offer.PracaOwi;
import com.gus.jobofferhunter.repository.PracaOwiRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracaOwiService {
    private final PracaOwiRepository pracaOwiRepository;

    public PracaOwiService(PracaOwiRepository pracaOwiRepository) {
        this.pracaOwiRepository = pracaOwiRepository;
    }

    public Iterable<PracaOwi> list() {
        return pracaOwiRepository.findAll();
    }

    public PracaOwi save(PracaOwi pracaOwi) {
        return pracaOwiRepository.save(pracaOwi);
    }

    public void save(List<PracaOwi> pracaOwiList) {
        pracaOwiRepository.save(pracaOwiList);
    }
}
