package com.gus.jobofferhunter.repository;

import com.gus.jobofferhunter.model.offer.MoneyPl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyPlRepository extends CrudRepository <MoneyPl, Long>{
}
