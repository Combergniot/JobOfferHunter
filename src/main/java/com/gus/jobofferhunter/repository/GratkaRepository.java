package com.gus.jobofferhunter.repository;

import com.gus.jobofferhunter.model.offer.Gratka;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GratkaRepository extends CrudRepository<Gratka, Long> {


}
