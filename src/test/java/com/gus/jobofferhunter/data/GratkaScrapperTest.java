package com.gus.jobofferhunter.data;

import org.junit.Assert;
import org.junit.Test;

public class GratkaScrapperTest extends DataCollectorSettings{

    GratkaScrapper gratkaScrapper = new GratkaScrapper();

    @Test
    public void shouldSayThatLastPaginationNumberIsGreaterThan_100() throws Exception {
        Assert.assertTrue(gratkaScrapper.findLastPaginationNumber() > 100);
        System.out.println(gratkaScrapper.findLastPaginationNumber());
    }

}