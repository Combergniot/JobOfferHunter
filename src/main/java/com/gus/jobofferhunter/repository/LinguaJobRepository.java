package com.gus.jobofferhunter.repository;

import com.gus.jobofferhunter.model.offer.LinguaJob;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinguaJobRepository extends CrudRepository<LinguaJob, Long> {
}
