package com.gus.jobofferhunter.data;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class JobSwypeScrapperTest extends DataCollectorSettings {

    JobSwypeScrapper jobSwypeScrapper = new JobSwypeScrapper();

    private final String LINK = "https://www.jobswype.pl/praca?title=&location=&radius=0&sorting=&display=&page=3";

    private Elements setUpElements() throws IOException {
        Document document = connectWith(LINK);
        Elements singleOffer = document.select("div#content>div.job.card.mb-1");
        return singleOffer;
    }

    @Test
    public void shouldSayThatLastPaginationNumberIsGreaterThan_1000() throws Exception {
        Assert.assertTrue(jobSwypeScrapper.findLastPaginationNumber() > 1000);
        System.out.println(jobSwypeScrapper.findLastPaginationNumber());
    }

    @Test
    public void shouldSayThatPositionIsNotNull() throws IOException {
        for (Element element: setUpElements()) {
            Assert.assertNotNull(jobSwypeScrapper.searchForPosition(element));
            System.out.println(jobSwypeScrapper.searchForPosition(element));
        }
    }

    @Test
    public void shouldSayThatDatePublishedIsNotNull() throws IOException {
        for (Element element: setUpElements()) {
            Assert.assertNotNull(jobSwypeScrapper.searchForDatePublished(element));
            System.out.println(jobSwypeScrapper.searchForDatePublished(element));
        }
    }

    @Test
    public void shouldSayThatWorkplaceIsNotNull() throws IOException {
        for (Element element: setUpElements()) {
            Assert.assertNotNull(jobSwypeScrapper.searchForWorkplace(element));
            System.out.println(jobSwypeScrapper.searchForWorkplace(element));
        }
    }

    @Test
    public void shouldSayThatTypeOfWorkIsNotNull() throws IOException {
        for (Element element: setUpElements()) {
            Assert.assertNotNull(jobSwypeScrapper.searchForTypeOfWork(element));
            System.out.println(jobSwypeScrapper.searchForTypeOfWork(element));
        }
    }

    @Test
    public void shouldSayThatEmployerIsNotNull() throws IOException {
        for (Element element: setUpElements()) {
            Assert.assertNotNull(jobSwypeScrapper.searchForEmployer(element));
            System.out.println(jobSwypeScrapper.searchForEmployer(element));
        }
    }

    @Test
    public void shouldSayThatSalaryIsNotNull() throws IOException {
        for (Element element: setUpElements()) {
            Assert.assertNotNull(jobSwypeScrapper.searchForSalary(element));
            System.out.println(jobSwypeScrapper.searchForSalary(element));
        }
    }




}