package com.gus.jobofferhunter.repository;


import com.gus.jobofferhunter.model.offer.PracujPl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracujPlRepository extends CrudRepository <PracujPl, Long> {


}
