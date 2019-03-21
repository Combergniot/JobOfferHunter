package com.gus.jobofferhunter.repository;

import com.gus.jobofferhunter.model.offer.CareerJet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerJetRepository extends CrudRepository<CareerJet, Long> {
}
