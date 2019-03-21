package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.service.PracaTobieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PracaTobieScrapper extends DataCollectorSettings{

    @Autowired
    PracaTobieService pracaTobieService;

    private static final Logger log = LoggerFactory.getLogger(PracaTobieScrapper.class);

    public void collectData() {
    }
}
