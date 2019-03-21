package com.gus.jobofferhunter.data;

import org.junit.Test;

public class InfoPracaScrapperTest extends DataCollectorSettings{

    InfoPracaScrapper infoPracaScrapper = new InfoPracaScrapper();


    @Test
    public void shouldSayThatCollectStructureMethodWorksFine() throws Exception {
       infoPracaScrapper.collectStructure();
    }
}