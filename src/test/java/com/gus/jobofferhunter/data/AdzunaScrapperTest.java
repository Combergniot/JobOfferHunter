package com.gus.jobofferhunter.data;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AdzunaScrapperTest extends DataCollectorSettings{

    AdzunaScrapper adzunaScrapper = new AdzunaScrapper();

    private final String LINK = "https://www.adzuna.pl/search?loc=133355&p=5";

    public Elements setUpElements() throws IOException {
        Document singleOffer = connectWith(LINK);
        Elements jobOfferTable = singleOffer.select("div.sr");
        Elements singleOfferBox = jobOfferTable.select("div.a");
        return singleOfferBox;
    }

    @Test
    public void shouldSayThatSampleResponseIsNotNull(){
     Assert.assertNotNull(adzunaScrapper.getSampleResponse());
     System.out.println(adzunaScrapper.getSampleResponse());
    }

    @Test
    public void shouldSayThatCategoriesResponseIsNotNull(){
        Assert.assertNotNull(adzunaScrapper.getCategories());
        System.out.println(adzunaScrapper.getCategories());
    }

    @Test
    public void shouldSayThatTheLastPaginationNumberForPolandIsGreaterThan_10000() throws Exception {
        Assert.assertTrue(adzunaScrapper.findLastPaginationNumber() > 10000);
        System.out.println(adzunaScrapper.findLastPaginationNumber());
    }

    @Test
    public void shouldSayThatPositionIsNotNull() throws IOException {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(adzunaScrapper.searchForPosition(element));
            System.out.println(adzunaScrapper.searchForPosition(element));
        }
    }

    @Test
    public void shouldSayThatEmployerIsNotNull() throws IOException {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(adzunaScrapper.searchForEmployer(element));
            System.out.println(adzunaScrapper.searchForEmployer(element));
        }
    }

    @Test
    public void shouldSayThatWorkplaceIsNotNull() throws IOException {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(adzunaScrapper.searchForWorkplace(element));
            System.out.println(adzunaScrapper.searchForWorkplace(element));
        }
    }

    @Test
    public void shouldSayThatUrlIsNotNull() throws IOException {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(adzunaScrapper.searchForUrl(element));
            System.out.println(adzunaScrapper.searchForUrl(element));
        }
    }

    @Test
    public void shouldSayThatSalaryIsNotNull() throws IOException {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(adzunaScrapper.searchForSalary(element));
            System.out.println(adzunaScrapper.searchForSalary(element));
        }
    }

}