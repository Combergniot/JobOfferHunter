package com.gus.jobofferhunter.repository;

import com.gus.jobofferhunter.model.offer.AllTheJobs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllTheJobsRepository extends CrudRepository<AllTheJobs, Long> {
}
