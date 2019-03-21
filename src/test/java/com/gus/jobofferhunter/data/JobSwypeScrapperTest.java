package com.gus.jobofferhunter.data;

import org.junit.Assert;
import org.junit.Test;

public class JobSwypeScrapperTest extends DataCollectorSettings{

    JobSwypeScrapper jobSwypeScrapper = new JobSwypeScrapper();

    @Test
    public void shouldSayThatLastPaginationNumberIsGreaterThan_100() throws Exception {
        Assert.assertTrue(jobSwypeScrapper.findLastPaginationNumber() > 100);
        System.out.println(jobSwypeScrapper.findLastPaginationNumber());
    }

}