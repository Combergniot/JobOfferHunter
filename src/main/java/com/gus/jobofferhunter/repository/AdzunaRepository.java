package com.gus.jobofferhunter.repository;

import com.gus.jobofferhunter.model.offer.Adzuna;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdzunaRepository extends CrudRepository<Adzuna, Long> {
}
