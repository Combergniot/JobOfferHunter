package com.gus.jobofferhunter.service;

import com.gus.jobofferhunter.model.offer.AllTheJobs;
import com.gus.jobofferhunter.repository.AllTheJobsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllTheJobsService {

    private final AllTheJobsRepository allTheJobsRepository;

    public AllTheJobsService(AllTheJobsRepository allTheJobsRepository) {
        this.allTheJobsRepository = allTheJobsRepository;
    }

    public Iterable<AllTheJobs> list() {
        return allTheJobsRepository.findAll();
    }

    public AllTheJobs save(AllTheJobs allTheJobs) {
        return allTheJobsRepository.save(allTheJobs);
    }

    public void save(List<AllTheJobs> allTheJobsList) {
        allTheJobsRepository.save(allTheJobsList);
    }
}
