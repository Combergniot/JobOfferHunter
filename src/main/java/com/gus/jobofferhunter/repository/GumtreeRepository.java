package com.gus.jobofferhunter.repository;

import com.gus.jobofferhunter.model.offer.Gumtree;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GumtreeRepository extends CrudRepository<Gumtree, Long> {
}
