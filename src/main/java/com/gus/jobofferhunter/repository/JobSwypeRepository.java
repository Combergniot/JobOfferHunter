package com.gus.jobofferhunter.repository;

import com.gus.jobofferhunter.model.offer.JobSwype;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSwypeRepository extends CrudRepository<JobSwype, Long> {
}
