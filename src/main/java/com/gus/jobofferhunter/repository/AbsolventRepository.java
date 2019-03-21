package com.gus.jobofferhunter.repository;

import com.gus.jobofferhunter.model.offer.Absolvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsolventRepository extends CrudRepository<Absolvent, Long> {
}
