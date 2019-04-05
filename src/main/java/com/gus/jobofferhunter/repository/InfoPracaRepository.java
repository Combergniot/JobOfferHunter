package com.gus.jobofferhunter.repository;

import com.gus.jobofferhunter.model.offer.InfoPraca;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoPracaRepository extends CrudRepository<InfoPraca, Long> {

    InfoPraca findById(Long id);

    Iterable<InfoPraca> findByRegion(String region);

    Iterable<InfoPraca> findByWorkplace(String workplace);

    Iterable<InfoPraca> findByEmployer(String employer);

    Iterable<InfoPraca> findByDatePublished(String datePublished);

    Iterable<InfoPraca> findByPosition(String position);
}
