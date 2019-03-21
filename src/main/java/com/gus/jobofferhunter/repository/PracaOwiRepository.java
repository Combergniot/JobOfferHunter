package com.gus.jobofferhunter.repository;

import com.gus.jobofferhunter.model.offer.PracaOwi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracaOwiRepository extends CrudRepository<PracaOwi, Long> {
}
