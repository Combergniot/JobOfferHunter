package com.gus.jobofferhunter.service;

import com.gus.jobofferhunter.model.offer.Jober;
import com.gus.jobofferhunter.repository.JoberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoberService {

    private final JoberRepository joberRepository;

    public JoberService(JoberRepository joberRepository) {
        this.joberRepository = joberRepository;
    }

    public Iterable<Jober> list(){
        return joberRepository.findAll();
    }

    public Jober save(Jober jober){
        return joberRepository.save(jober);
    }

    public void save(List<Jober> joberList){
        joberRepository.save(joberList);
    }
}
