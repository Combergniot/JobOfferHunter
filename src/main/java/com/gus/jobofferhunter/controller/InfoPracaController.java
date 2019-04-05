package com.gus.jobofferhunter.controller;

import com.google.common.collect.Iterables;
import com.gus.jobofferhunter.exceptions.OfferNotFoundException;
import com.gus.jobofferhunter.model.offer.InfoPraca;
import com.gus.jobofferhunter.service.InfoPracaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/infopraca")
@CrossOrigin
public class InfoPracaController {

    @Autowired
    private InfoPracaService infoPracaService;

    @GetMapping("/all")
    public Iterable<InfoPraca> getAllOffers() {
        Iterable<InfoPraca> infoPracaIterable = infoPracaService.list();
        if (Iterables.size(infoPracaIterable) == 0) {
            throw new OfferNotFoundException("Offers from InfoPraca they were not downloaded");
        }
        return infoPracaIterable;
    }

    @GetMapping("/{id}")
    public InfoPraca getOfferById(@PathVariable Long id) {
        InfoPraca infoPraca = infoPracaService.findById(id);
        if (infoPraca == null) {
            throw new OfferNotFoundException("Offer with ID: " + id + " does not exist");
        }
        return infoPraca;
    }

    @GetMapping("/region={region}")
    public Iterable<InfoPraca> getOffersByRegion(@PathVariable String region) {
        Iterable<InfoPraca> infoPracaIterable = infoPracaService.findByRegion(region);
        if (Iterables.size(infoPracaIterable) == 0) {
            throw new OfferNotFoundException("Offers in region: " + region + " do not exist");
        }
        return infoPracaIterable;
    }

    @GetMapping("/workplace={workplace}")
    public Iterable<InfoPraca> getOffersByWorkplace(@PathVariable String workplace) {
        Iterable<InfoPraca> infoPracaIterable = infoPracaService.findByWorkplace(workplace);
        if (Iterables.size(infoPracaIterable) == 0) {
            throw new OfferNotFoundException("Offers in workplace: " + workplace + " do not exist");
        }
        return infoPracaIterable;
    }

    @GetMapping("/employer={employer}")
    public Iterable<InfoPraca> getOffersByEmployer(@PathVariable String employer) {
        Iterable<InfoPraca> infoPracaIterable = infoPracaService.findByEmployer(employer);
        if (Iterables.size(infoPracaIterable) == 0) {
            throw new OfferNotFoundException("Offers in workplace: " + employer + " do not exist");
        }
        return infoPracaIterable;
    }

    @GetMapping("/position={position}")
    public Iterable<InfoPraca> getOffersByPosition(@PathVariable String position) {
        Iterable<InfoPraca> infoPracaIterable = infoPracaService.findByPosition(position);
        if (Iterables.size(infoPracaIterable) == 0) {
            throw new OfferNotFoundException("Offers about position: " + position + " do not exist");
        }
        return infoPracaIterable;
    }

    @GetMapping("/date={datePublished}")
    public Iterable<InfoPraca> getOffersByDatePublished(@PathVariable String datePublished) {
        Iterable<InfoPraca> infoPracaIterable = infoPracaService.findByDatePublished(datePublished);
        if (Iterables.size(infoPracaIterable) == 0) {
            throw new OfferNotFoundException("Offers published in: " + datePublished + " do not exist");
        }
        return infoPracaIterable;
    }

}
