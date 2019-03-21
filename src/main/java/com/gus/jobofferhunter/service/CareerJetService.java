package com.gus.jobofferhunter.service;

import com.gus.jobofferhunter.model.offer.CareerJet;
import com.gus.jobofferhunter.repository.CareerJetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareerJetService {
    private final CareerJetRepository careerJetRepository;

    public CareerJetService(CareerJetRepository careerJetRepository) {
        this.careerJetRepository = careerJetRepository;
    }

    public Iterable<CareerJet> list() {
        return careerJetRepository.findAll();
    }

    public CareerJet save(CareerJet careerJet) {
        return careerJetRepository.save(careerJet);
    }

    public void save(List<CareerJet> careerJetList) {
        careerJetRepository.save(careerJetList);
    }
}
