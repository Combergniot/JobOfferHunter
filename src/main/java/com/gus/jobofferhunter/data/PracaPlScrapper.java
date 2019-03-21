package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.service.PracaPlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PracaPlScrapper extends DataCollectorSettings{
    
    @Autowired
    PracaPlService pracaPlService;

    private static final Logger log = LoggerFactory.getLogger(PracaPlScrapper.class);

    public void collectData() {
    }
}
