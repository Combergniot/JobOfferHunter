package com.gus.jobofferhunter.repository;

import com.gus.jobofferhunter.model.offer.Jober;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoberRepository extends CrudRepository<Jober, Long> {
}
