package com.gus.jobofferhunter.service;

import com.gus.jobofferhunter.model.offer.Linkedin;
import com.gus.jobofferhunter.repository.LinkedinRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkedinService {

    private final LinkedinRepository linkedinRepository;

    public LinkedinService(LinkedinRepository linkedinRepository) {
        this.linkedinRepository = linkedinRepository;
    }

    public Iterable<Linkedin> list() {
        return linkedinRepository.findAll();
    }

    public Linkedin save(Linkedin linkedin) {
        return linkedinRepository.save(linkedin);
    }

    public void save(List<Linkedin> linkedinList) {
        linkedinRepository.save(linkedinList);
    }
}
