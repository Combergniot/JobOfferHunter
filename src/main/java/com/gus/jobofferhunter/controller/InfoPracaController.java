package com.gus.jobofferhunter.controller;

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
    public Iterable<InfoPraca> getAllOffers(){
        return infoPracaService.list();
    }

    @GetMapping("/{id}")
    public InfoPraca getOfferById(@PathVariable Long id){
        return infoPracaService.findById(id);
    }

    @GetMapping("/region={region}")
    public Iterable<InfoPraca> getOffersByRegion(@PathVariable String region){
        return infoPracaService.findByRegion(region);
    }

    @GetMapping("/workplace={workplace}")
    public Iterable<InfoPraca> getOffersByWorkplace(@PathVariable String workplace){
        return infoPracaService.findByWorkplace(workplace);
    }

    @GetMapping("/employer={employer}")
    public Iterable<InfoPraca> getOffersByEmployer(@PathVariable String employer){
        return infoPracaService.findByEmployer(employer);
    }

    @GetMapping("/position={position}")
    public Iterable<InfoPraca> getOffersByPosition(@PathVariable String position){
        return infoPracaService.findByPosition(position);
    }

    @GetMapping("/datePublished={datePublished}")
    public Iterable<InfoPraca> getOffersByDatePublished(@PathVariable String datePublished){
        return infoPracaService.findByDatePublished(datePublished);
    }

}
