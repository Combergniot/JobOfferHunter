package com.gus.jobofferhunter.service;

import com.gus.jobofferhunter.model.offer.Olx;
import com.gus.jobofferhunter.repository.OlxRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OlxService {

    private final OlxRepository olxRepository;

    public OlxService(OlxRepository olxRepository) {
        this.olxRepository = olxRepository;
    }

    public Iterable<Olx> list() {
        return olxRepository.findAll();
    }

    public Olx save(Olx olx) {
        return olxRepository.save(olx);
    }

    public void save(List<Olx> olxList) {
        olxRepository.save(olxList);
    }
}
