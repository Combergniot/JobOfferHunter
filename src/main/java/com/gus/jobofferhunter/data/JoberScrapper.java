package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.service.JoberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JoberScrapper extends DataCollectorSettings {

    @Autowired
    JoberService joberService;

    private static final Logger log = LoggerFactory.getLogger(JoberScrapper.class);

    public void collectData() {
    }
}
