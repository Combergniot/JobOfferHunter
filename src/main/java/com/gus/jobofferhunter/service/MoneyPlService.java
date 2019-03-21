package com.gus.jobofferhunter.service;

import com.gus.jobofferhunter.model.offer.MoneyPl;
import com.gus.jobofferhunter.repository.MoneyPlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoneyPlService {

    private final MoneyPlRepository moneyPlRepository;

    public MoneyPlService(MoneyPlRepository moneyPlRepository) {
        this.moneyPlRepository = moneyPlRepository;
    }

    public Iterable<MoneyPl> list() {
        return moneyPlRepository.findAll();
    }

    public MoneyPl save(MoneyPl moneyPl) {
        return moneyPlRepository.save(moneyPl);
    }

    public void save(List<MoneyPl> moneyPlList) {
        moneyPlRepository.save(moneyPlList);
    }

}
