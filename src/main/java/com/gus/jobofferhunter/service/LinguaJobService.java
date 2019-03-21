package com.gus.jobofferhunter.service;

import com.gus.jobofferhunter.model.offer.LinguaJob;
import com.gus.jobofferhunter.repository.LinguaJobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinguaJobService {
    private final LinguaJobRepository linguaJobRepository;

    public LinguaJobService(LinguaJobRepository linguaJobRepository) {
        this.linguaJobRepository = linguaJobRepository;
    }

    public Iterable<LinguaJob> list() {
        return linguaJobRepository.findAll();
    }

    public LinguaJob save(LinguaJob linguaJob) {
        return linguaJobRepository.save(linguaJob);
    }

    public void save(List<LinguaJob> linguaJobList) {
        linguaJobRepository.save(linguaJobList);
    }
}
