package com.gus.jobofferhunter.data;

import org.junit.Assert;
import org.junit.Test;

public class GumtreeScrapperTest extends DataCollectorSettings{

    GumtreeScrapper gumtreeScrapper = new GumtreeScrapper();

    @Test
    public void shouldSayThatLastPaginationNumberIsGreaterThan_100() throws Exception {
        Assert.assertTrue(gumtreeScrapper.findLastPaginationNumber() > 100);
        System.out.println(gumtreeScrapper.findLastPaginationNumber());
    }

}