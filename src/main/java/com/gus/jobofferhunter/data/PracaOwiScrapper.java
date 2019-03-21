package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.model.offer.PracaOwi;
import com.gus.jobofferhunter.service.PracaOwiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PracaOwiScrapper extends DataCollectorSettings {

    @Autowired
    PracaOwiService pracaOwiService;

    private static final Logger log = LoggerFactory.getLogger(PracaOwi.class);
}
