package com.gus.jobofferhunter.repository;

import com.gus.jobofferhunter.model.offer.Linkedin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkedinRepository extends CrudRepository <Linkedin, Long> {
}
