package com.gus.jobofferhunter.repository;

import com.gus.jobofferhunter.model.offer.JobsPl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsPlRepository extends CrudRepository<JobsPl, Long> {
}
