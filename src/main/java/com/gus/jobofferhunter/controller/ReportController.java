package com.gus.jobofferhunter.controller;

import com.gus.jobofferhunter.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {

    protected final Logger logger = LoggerFactory.getLogger(ReportController.class);

    @Autowired
    private GazetaPracaRepository gazetaPracaRepository;
    @Autowired
    private GoldenLineRepository goldenLineRepository;
    @Autowired
    private GratkaRepository gratkaRepository;
    @Autowired
    private MoneyPlRepository moneyPlRepository;
    @Autowired
    private OlxRepository olxRepository;
    @Autowired
    private PracujPlRepository pracujPlRepository;
    @Autowired
    private LinkedinRepository linkedinRepository;


//    @GetMapping("/main_report")
//    public String getMainReport(Model model) {
//        model.addAttribute("jobOffers", jobOfferRepository.findAll());
//        return "mainReport";
//    }

    @GetMapping("/goldenline")
    public String getGoldenLineReport(Model model) {
        model.addAttribute("goldenLineOffers", goldenLineRepository.findAll());
        return "goldenline";
    }

    @GetMapping("/gratka")
    public String getGratkaReport(Model model) {
        model.addAttribute("gratkaOffers", gratkaRepository.findAll());
        return "gratka";
    }

    @GetMapping("/linkedin")
    public String getLinkedinReport(Model model) {
        model.addAttribute("linkedinOffers", linkedinRepository.findAll());
        return "linkedin";
    }

    @GetMapping("/gazetapraca")
    public String getGazetaPracaReport(Model model) {
        model.addAttribute("gazetaPracaOffers", gazetaPracaRepository.findAll());
        return "gazetapraca";
    }

    @GetMapping("/pracujpl")
    public String getPracujPlReport(Model model) {
        model.addAttribute("pracujPlOffers", pracujPlRepository.findAll());
        return "pracujpl";
    }

    @GetMapping("/olx")
    public String getOlxReport(Model model) {
        model.addAttribute("olxOffers", olxRepository.findAll());
        return "olx";
    }

    @GetMapping("/moneypl")
    public String getMoneyPlReport(Model model) {
        model.addAttribute("moneyPlOffers", moneyPlRepository.findAll());
        return "money";
    }

    @GetMapping("/cbop")
    public String getCbopReport(Model model) {
        model.addAttribute("cbopOffers", moneyPlRepository.findAll());
        return "cbop";
    }




}
