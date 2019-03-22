package com.gus.jobofferhunter.data;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class JobsPlScrapperTest extends DataCollectorSettings {

    JobsPlScrapper jobsPlScrapper = new JobsPlScrapper();

    private final String LINK = "https://www.jobs.pl/oferty/p-2";

    public Elements setUpElements() throws IOException {
        Document document = connectWith(LINK);
        Elements singleOfferList = document
                .select("div.offer-list");
        Elements singleOffer = singleOfferList
                .select("div.offer > div.details");
        return singleOffer;
    }

    @Test
    public void shouldSayThatLastPaginationNumberIsGreaterThan_100() throws Exception {
        Assert.assertTrue(jobsPlScrapper.findLastPaginationNumber() > 100);
        System.out.println(jobsPlScrapper.findLastPaginationNumber());
    }

    @Test
    public void shouldSayThatPositionIsNotNull() throws IOException {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(jobsPlScrapper.searchForPosition(element));
            System.out.println(jobsPlScrapper.searchForPosition(element));
        }
    }

    @Test
    public void shouldSayThatEmployerIsNotNull() throws IOException {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(jobsPlScrapper.searchForEmployer(element));
            System.out.println(jobsPlScrapper.searchForEmployer(element));
        }
    }

    @Test
    public void shouldSayThatDatePublishedIsNotNull() throws IOException {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(jobsPlScrapper.searchForDatePublished(element));
            System.out.println(jobsPlScrapper.searchForDatePublished(element));
        }
    }

    @Test
    public void shouldSayThatWorkplaceIsNotNull() throws IOException {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(jobsPlScrapper.searchForWorkplace(element));
            System.out.println(jobsPlScrapper.searchForWorkplace(element));
        }
    }

    @Test
    public void shouldSayThatUrlIsNotNull() throws IOException {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(jobsPlScrapper.searchForUrl(element));
            System.out.println(jobsPlScrapper.searchForUrl(element));
        }
    }

    @Test
    public void shouldSayThatDataIdIsNotNull() throws IOException {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(jobsPlScrapper.searchForDataId(element));
            System.out.println(jobsPlScrapper.searchForDataId(element));
        }
    }


}