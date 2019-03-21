package com.gus.jobofferhunter.repository;

import com.gus.jobofferhunter.model.offer.Olx;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OlxRepository extends CrudRepository <Olx, Long>{
}
