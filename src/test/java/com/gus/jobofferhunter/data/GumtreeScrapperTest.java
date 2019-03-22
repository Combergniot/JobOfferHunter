package com.gus.jobofferhunter.data;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GumtreeScrapperTest extends DataCollectorSettings {

    GumtreeScrapper gumtreeScrapper = new GumtreeScrapper();

    private final String LINK = "https://www.gumtree.pl/s-oferty-pracy/page-2/v1c8p2";

    private Document setUpDocument() throws Exception {
        Document document = connectWith(
                gumtreeScrapper
                        .createListLinksFromOneSite(LINK)
                        .get(2));
        return document;
    }

    private Elements setUpElements() throws Exception {
        Document document = connectWith(
                gumtreeScrapper
                        .createListLinksFromOneSite(LINK)
                        .get(2));
        Elements elements = document.select("ul.selMenu");
        return elements;
    }


    @Test
    public void shouldSayThatLastPaginationNumberIsGreaterThan_100() throws Exception {
        Assert.assertTrue(gumtreeScrapper.findLastPaginationNumber() > 100);
        System.out.println(gumtreeScrapper.findLastPaginationNumber());
    }

    @Test
    public void shouldSayThatCollectingLinksWorksFine() throws Exception {
        List<String> listLink = gumtreeScrapper.createListLinksFromOneSite(LINK);
        Assert.assertFalse(listLink.isEmpty());
        for (int i = 0; i < listLink.size(); i++) {
            System.out.println(i + ": " + listLink.get(i));
        }
    }

    @Test
    public void shouldSayThatPositionIsNotNull() throws Exception {
        Document document = setUpDocument();
        Assert.assertNotNull(gumtreeScrapper.searchForPosition(document));
        System.out.println(gumtreeScrapper.searchForPosition(document));
    }

    @Test
    public void shouldSayThatDataIdIsNotNull() throws Exception {
        Document document = setUpDocument();
        Assert.assertNotNull(gumtreeScrapper.searchForDataId(document));
        System.out.println(gumtreeScrapper.searchForDataId(document));
    }

    @Test
    public void shouldSayThatDescriptionIsNotNull() throws Exception {
        Document document = setUpDocument();
        Assert.assertNotNull(gumtreeScrapper.searchForDescription(document));
        System.out.println(gumtreeScrapper.searchForDescription(document));
    }

    @Test
    public void shouldSayThatBranchIsNotNull() throws Exception {
        Document document = setUpDocument();
        Assert.assertNotNull(gumtreeScrapper.searchForBranch(document));
        System.out.println(gumtreeScrapper.searchForBranch(document));
    }

    @Test
    public void shouldSayThatContractTypeIsNotNull() throws Exception {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(gumtreeScrapper.searchForContractType(element));
            System.out.println(gumtreeScrapper.searchForContractType(element));
        }
    }

    @Test
    public void shouldSayThatTypeOfWorkIsNotNull() throws Exception {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(gumtreeScrapper.searchForTypeOfWork(element));
            System.out.println(gumtreeScrapper.searchForTypeOfWork(element));
        }
    }

    @Test
    public void shouldSayThatAnnouncedByFieldIsNotNull() throws Exception {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(gumtreeScrapper.searchForAnnouncedBy(element));
            System.out.println(gumtreeScrapper.searchForAnnouncedBy(element));
        }
    }

    @Test
    public void shouldSayThatWorkplaceIsNotNull() throws Exception {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(gumtreeScrapper.searchForWorkplace(element));
            System.out.println(gumtreeScrapper.searchForWorkplace(element));
        }
    }

    @Test
    public void shouldSayThatDatePublishedIsNotNull() throws Exception {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(gumtreeScrapper.searchForDatePublished(element));
            System.out.println(gumtreeScrapper.searchForDatePublished(element));
        }
    }
}


