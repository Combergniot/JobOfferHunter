package com.gus.jobofferhunter.repository;

import com.gus.jobofferhunter.model.offer.PracaPl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracaPlRepository extends CrudRepository <PracaPl, Long> {
}
