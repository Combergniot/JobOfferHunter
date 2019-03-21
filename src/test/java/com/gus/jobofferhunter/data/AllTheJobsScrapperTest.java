package com.gus.jobofferhunter.data;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class AllTheJobsScrapperTest extends DataCollectorSettings {

    AllTheJobsScrapper allTheJobsScrapper = new AllTheJobsScrapper();


    public Elements setUpElements() throws Exception {
        List<String> linkListTest = allTheJobsScrapper.collectLinksFromOneLink();
        Document singleOffer = connectWith(linkListTest.get(0));
        Elements singleOfferBox = singleOffer.select("div#offer_main_info");
        return singleOfferBox;
    }

    public Document setUpContent() throws Exception {
        List<String> linkListTest = allTheJobsScrapper.collectLinksFromOneLink();
        Document singleOffer = connectWith(linkListTest.get(0));
        return singleOffer;
    }


    @Test
    public void shouldSayThatLastPaginationNumberIsGreaterThan_80() throws IOException {
        Assert.assertTrue(allTheJobsScrapper.findLastPaginationNumber() > 80);
        System.out.println(allTheJobsScrapper.findLastPaginationNumber());
    }

    @Test
    public void shouldSayThatLastLinkInPaginationListIsCorrect() throws Exception {
        List<String> linkListTest = allTheJobsScrapper.fillPaginationList();
        System.out.println(linkListTest.get(linkListTest.size() - 1));
        Assert.assertEquals(
                "https://allthejobs.pl/praca/,p" +
                        allTheJobsScrapper.findLastPaginationNumber(),
                linkListTest.get(linkListTest.size() - 1));
    }

    @Test
    public void shouldSayThatListLinksFromOnePaginationListLinkIsEqual_25() throws Exception {
        List<String> linkListTest = allTheJobsScrapper.collectLinksFromOneLink();
        Assert.assertTrue(linkListTest.size() == 25);
        for (int i = 0; i < linkListTest.size(); i++) {
            System.out.println(i + 1 + ": " + linkListTest.get(i));
        }
    }

    @Test
    public void shouldSayThatPositionIsNotNull() throws Exception {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(allTheJobsScrapper.searchForPosition(element));
            System.out.println(allTheJobsScrapper.searchForPosition(element));
        }
    }

    @Test
    public void shouldSayThatEmployerIsNotNull() throws Exception {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(allTheJobsScrapper.searchForEmployer(element));
            System.out.println(allTheJobsScrapper.searchForEmployer(element));
        }
    }

    @Test
    public void shouldSayThatWorkplaceIsNotNull() throws Exception {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(allTheJobsScrapper.searchForWorkplace(element));
            System.out.println(allTheJobsScrapper.searchForWorkplace(element));
        }
    }

    @Test
    public void shouldSayThatDatePublishedIsNotNull() throws Exception {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(allTheJobsScrapper.searchForDatePublished(element));
            System.out.println(allTheJobsScrapper.searchForDatePublished(element));
        }
    }

    @Test
    public void shouldSayThatUpdateDateIsNotNull() throws Exception {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(allTheJobsScrapper.searchForUpdateDate(element));
            System.out.println(allTheJobsScrapper.searchForUpdateDate(element));
        }
    }

    @Test
    public void shouldSayThatEmploymentTypeIsNotNull() throws Exception {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(allTheJobsScrapper.searchForEmploymentType(element));
            System.out.println(allTheJobsScrapper.searchForEmploymentType(element));
        }
    }

    @Test
    public void shouldSayThatPositionLevelIsNotNull() throws Exception {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(allTheJobsScrapper.searchForPositionLevel(element));
            System.out.println(allTheJobsScrapper.searchForPositionLevel(element));
        }
    }

    @Test
    public void shouldSayThatSalaryIsNotNull() throws Exception {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(allTheJobsScrapper.searchForSalary(element));
            System.out.println(allTheJobsScrapper.searchForSalary(element));
        }
    }

    @Test
    public void shouldSayThatWebPageIsNotNull() throws Exception {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(allTheJobsScrapper.searchForWebPage(element));
            System.out.println(allTheJobsScrapper.searchForWebPage(element));
        }
    }

    @Test
    public void shouldSayThatOriginalUrlIsNotNull() throws Exception {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(allTheJobsScrapper.searchForOriginalUrl(element));
            System.out.println(allTheJobsScrapper.searchForOriginalUrl(element));
        }
    }

    @Test
    public void shouldSayThatDescriptionIsNotNull() throws Exception {
        Document document = setUpContent();
        Assert.assertNotNull(allTheJobsScrapper.searchForDescription(document));
        System.out.println(allTheJobsScrapper.searchForDescription(document));
    }


}