
package com.gus.jobofferhunter.repository;

import com.gus.jobofferhunter.model.offer.GazetaPraca;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GazetaPracaRepository extends CrudRepository<GazetaPraca, Long> {
    
}
