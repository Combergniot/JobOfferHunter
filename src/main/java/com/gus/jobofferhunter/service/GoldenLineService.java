package com.gus.jobofferhunter.service;

import com.gus.jobofferhunter.model.offer.GoldenLine;
import com.gus.jobofferhunter.repository.GoldenLineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoldenLineService {

    private final GoldenLineRepository goldenLineRepository;

    public GoldenLineService(GoldenLineRepository goldenLineRepository) {
        this.goldenLineRepository = goldenLineRepository;
    }

    public Iterable<GoldenLine> list() {
        return goldenLineRepository.findAll();
    }

    public GoldenLine save(GoldenLine goldenLine) {
        return goldenLineRepository.save(goldenLine);
    }

    public void save(List<GoldenLine> goldenLineList) {
        goldenLineRepository.save(goldenLineList);
    }
}
