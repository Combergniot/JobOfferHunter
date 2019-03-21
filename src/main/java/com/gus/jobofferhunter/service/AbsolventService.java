package com.gus.jobofferhunter.service;

import com.gus.jobofferhunter.model.offer.Absolvent;
import com.gus.jobofferhunter.repository.AbsolventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbsolventService {

    private final AbsolventRepository absolventRepository;

    public AbsolventService(AbsolventRepository absolventRepository) {
        this.absolventRepository = absolventRepository;
    }

    public Iterable<Absolvent> list() {
        return absolventRepository.findAll();
    }

    public Absolvent save(Absolvent absolvent) {
        return absolventRepository.save(absolvent);
    }

    public void save(List<Absolvent> absolventList){
        absolventRepository.save(absolventList);
    }

}
