package com.gus.jobofferhunter.service;

import com.gus.jobofferhunter.model.offer.PracaPl;
import com.gus.jobofferhunter.repository.PracaPlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracaPlService {

    private final PracaPlRepository pracaPlRepository;

    public PracaPlService(PracaPlRepository pracaPlRepository) {
        this.pracaPlRepository = pracaPlRepository;
    }

    public Iterable<PracaPl>list(){
        return pracaPlRepository.findAll();
    }

    public PracaPl save (PracaPl pracaPl){
        return pracaPlRepository.save(pracaPl);
    }

    public void save(List<PracaPl> pracaPlList){
        pracaPlRepository.save(pracaPlList);
    }
}
