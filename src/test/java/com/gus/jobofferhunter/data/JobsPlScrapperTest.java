package com.gus.jobofferhunter.data;

import org.junit.Assert;
import org.junit.Test;

public class JobsPlScrapperTest extends DataCollectorSettings {

    JobsPlScrapper jobsPlScrapper = new JobsPlScrapper();

    @Test
    public void shouldSayThatLastPaginationNumberIsGreaterThan_100() throws Exception {
        Assert.assertTrue(jobsPlScrapper.findLastPaginationNumber() > 100);
        System.out.println(jobsPlScrapper.findLastPaginationNumber());
    }

}