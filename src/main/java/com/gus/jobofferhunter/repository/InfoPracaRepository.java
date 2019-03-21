package com.gus.jobofferhunter.repository;

import com.gus.jobofferhunter.model.offer.InfoPraca;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoPracaRepository extends CrudRepository<InfoPraca, Long> {
}
