package com.gus.jobofferhunter.service;

import com.gus.jobofferhunter.model.offer.PracujPl;
import com.gus.jobofferhunter.repository.PracujPlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracujPlService {

    private final PracujPlRepository pracujPlRepository;

    public PracujPlService(PracujPlRepository pracujPlRepository) {
        this.pracujPlRepository = pracujPlRepository;
    }

    public Iterable<PracujPl> list() {
        return pracujPlRepository.findAll();
    }

    public PracujPl save(PracujPl pracujPl) {
        return pracujPlRepository.save(pracujPl);
    }

    public void save(List<PracujPl> pracujPlList) {
        pracujPlRepository.save(pracujPlList);
    }
}
