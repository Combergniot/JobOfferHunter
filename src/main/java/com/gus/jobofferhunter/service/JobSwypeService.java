package com.gus.jobofferhunter.service;


import com.gus.jobofferhunter.model.offer.JobSwype;
import com.gus.jobofferhunter.repository.JobSwypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSwypeService {
    private final JobSwypeRepository jobSwypeRepository;

    public JobSwypeService(JobSwypeRepository jobSwypeRepository) {
        this.jobSwypeRepository = jobSwypeRepository;
    }

    public Iterable<JobSwype> list() {
        return jobSwypeRepository.findAll();
    }

    public JobSwype save(JobSwype jobSwype) {
        return jobSwypeRepository.save(jobSwype);
    }

    public void save(List<JobSwype> jobSwypeList) {
        jobSwypeRepository.save(jobSwypeList);
    }
}
