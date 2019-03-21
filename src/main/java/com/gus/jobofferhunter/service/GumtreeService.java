package com.gus.jobofferhunter.service;

import com.gus.jobofferhunter.model.offer.Gumtree;
import com.gus.jobofferhunter.repository.GumtreeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GumtreeService {
    private final GumtreeRepository gumtreeRepository;

    public GumtreeService(GumtreeRepository gumtreeRepository) {
        this.gumtreeRepository = gumtreeRepository;
    }

    public Iterable<Gumtree> list() {
        return gumtreeRepository.findAll();
    }

    public Gumtree save(Gumtree gumtree) {
        return gumtreeRepository.save(gumtree);
    }

    public void save(List<Gumtree> gumtreeList) {
        gumtreeRepository.save(gumtreeList);
    }
}
