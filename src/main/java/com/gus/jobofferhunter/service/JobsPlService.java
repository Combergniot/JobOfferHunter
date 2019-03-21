package com.gus.jobofferhunter.service;

import com.gus.jobofferhunter.model.offer.JobsPl;
import com.gus.jobofferhunter.repository.JobsPlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobsPlService {

    private final JobsPlRepository jobsPlRepository;

    public JobsPlService(JobsPlRepository jobsPlRepository) {
        this.jobsPlRepository = jobsPlRepository;
    }

    public Iterable<JobsPl> list(){
        return jobsPlRepository.findAll();
    }

    public JobsPl save(JobsPl jobsPl){
        return jobsPlRepository.save(jobsPl);
    }

    public void save(List<JobsPl> jobsPlList){
      jobsPlRepository.save(jobsPlList);
    }
}
