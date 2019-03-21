package com.gus.jobofferhunter.repository;

import com.gus.jobofferhunter.model.offer.GoldenLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoldenLineRepository extends CrudRepository <GoldenLine, Long> {
}
