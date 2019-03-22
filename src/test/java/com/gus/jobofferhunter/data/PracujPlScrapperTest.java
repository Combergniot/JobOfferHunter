package com.gus.jobofferhunter.data;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class PracujPlScrapperTest extends DataCollectorSettings {

    PracujPlScrapper pracujPlScrapper = new PracujPlScrapper();
    private final String LINK = "https://www.pracuj.pl/praca?pn=2";
    private String applyBoxSelector = "div.apply";
    private String branchParameterSelector = "div.content";

    private Elements setUpElements(String selector) throws IOException {
        Document document = connectWith(
                pracujPlScrapper
                        .collectLinkFromOneSite(LINK)
                        .get(2));
        Elements elements = document.select(selector);
        return elements;
    }

    @Test
    public void shouldSayThatTheLastPaginationNumberIsGreaterThan_250() throws Exception {
        Assert.assertTrue(pracujPlScrapper.findLastPaginationNumber() > 250);
    }

    @Test
    public void shouldSayThatLinkListSizeIsEqual_50() throws IOException {
        List<String> linkList = pracujPlScrapper.collectLinkFromOneSite(LINK);
        System.out.println("Number links: " + linkList.size());
        for (int i = 0; i <linkList.size(); i++) {
            System.out.println(i+1 + ": " + linkList.get(i));
        }
        Assert.assertTrue(linkList.size() == 50);
    }

    @Test
    public void shouldSayThatPositionIsNotNull() throws IOException {
        for (Element element : setUpElements(applyBoxSelector)) {
            Assert.assertNotNull(pracujPlScrapper.searchForPosition(element));
            System.out.println(pracujPlScrapper.searchForPosition(element));
        }
    }

    @Test
    public void shouldSayThatEmployerIsNotNull() throws IOException {
        for (Element element : setUpElements(applyBoxSelector)) {
            Assert.assertNotNull(pracujPlScrapper.searchForEmployer(element));
            System.out.println(pracujPlScrapper.searchForEmployer(element));
        }
    }

    @Test
    public void shouldSayThatWorkplaceIsNotNull() throws IOException {
        for (Element element : setUpElements(applyBoxSelector)) {
            Assert.assertNotNull(pracujPlScrapper.searchForWorkplace(element));
            System.out.println(pracujPlScrapper.searchForWorkplace(element));
        }
    }

    @Test
    public void shouldSayThatEmploymentTypeIsNotNull() throws IOException {
        for (Element element : setUpElements(applyBoxSelector)) {
            Assert.assertNotNull(pracujPlScrapper.searchForEmploymentType(element));
            System.out.println(pracujPlScrapper.searchForEmploymentType(element));
        }
    }

    @Test
    public void shouldSayThatDatePublishedIsNotNull() throws IOException {
        for (Element element : setUpElements(applyBoxSelector)) {
            Assert.assertNotNull(pracujPlScrapper.searchForDatePublished(element));
            System.out.println(pracujPlScrapper.searchForDatePublished(element));
        }
    }

    @Test
    public void shouldSayThatValidThroughIsNotNull() throws IOException {
        for (Element element : setUpElements(applyBoxSelector)) {
            Assert.assertNotNull(pracujPlScrapper.searchForValidThrough(element));
            System.out.println(pracujPlScrapper.searchForValidThrough(element));
        }
    }

    @Test
    public void shouldSayThatEmploLinkIsNotNull() throws IOException {
        for (Element element : setUpElements(applyBoxSelector)) {
            Assert.assertNotNull(pracujPlScrapper.searchForEmploLink(element));
            System.out.println(pracujPlScrapper.searchForEmploLink(element));
        }
    }

    @Test
    public void shouldSayThatRegionIsNotNull() throws IOException {
        for (Element element : setUpElements(applyBoxSelector)) {
            Assert.assertNotNull(pracujPlScrapper.searchForRegion(element));
            System.out.println(pracujPlScrapper.searchForRegion(element));
        }
    }

    @Test
    public void shouldSayThatBranchIsNotNull() throws IOException {
        for (Element element : setUpElements(branchParameterSelector)) {
            Assert.assertNotNull(pracujPlScrapper.searchForBranch(element));
            System.out.println(pracujPlScrapper.searchForBranch(element));
        }
    }

}