package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.service.GazetaPracaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GazetaPracaScrapper extends DataCollectorSettings{

    @Autowired
    GazetaPracaService gazetaPracaService;

    private static final Logger log = LoggerFactory.getLogger(GazetaPracaScrapper.class);

}
