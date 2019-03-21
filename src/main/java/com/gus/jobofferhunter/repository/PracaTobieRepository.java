package com.gus.jobofferhunter.repository;

import com.gus.jobofferhunter.model.offer.PracaTobie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracaTobieRepository extends CrudRepository<PracaTobie, Long> {
}
