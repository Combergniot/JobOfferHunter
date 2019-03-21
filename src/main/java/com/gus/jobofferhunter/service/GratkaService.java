package com.gus.jobofferhunter.service;

import com.gus.jobofferhunter.model.offer.Gratka;
import com.gus.jobofferhunter.repository.GratkaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GratkaService {


    private final GratkaRepository gratkaRepository;

    public GratkaService(GratkaRepository gratkaRepository) {
        this.gratkaRepository = gratkaRepository;
    }

    public Iterable<Gratka> list() {
        return gratkaRepository.findAll();
    }

    public Gratka save(Gratka gratka) {
        return gratkaRepository.save(gratka);
    }

    public void save(List<Gratka> gratkaList) {
        gratkaRepository.save(gratkaList);
    }

}