package com.gus.jobofferhunter.data;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class OlxScrapperTest extends DataCollectorSettings {

    OlxScrapper olxScrapper = new OlxScrapper();

    private final String LINK = "https://www.olx.pl/praca/";
    private final String TITLE_BOX = "div.offer-titlebox";
    private final String OFFER_PARAMETER = "ul.offer-parameters";

    private Elements setUpElements(String selector) throws IOException {
        Document document = connectWith(olxScrapper
                .collectLinksFromOneSite("https://www.olx.pl/praca/informatyka/?page=2")
                .get(0));
        Elements elements = document.select(selector);
        return elements;
    }

    private Document setUpDocument() throws IOException {
        Document document = connectWith(olxScrapper
                .collectLinksFromOneSite("https://www.olx.pl/praca/informatyka/?page=2")
                .get(0));
        return document;
    }


    @Test
    public void shouldSayThatBranchMapIsCollectedInRightWay() throws IOException {
        Map<String, String> branchMap = olxScrapper.createBranchList();
        Assert.assertTrue(branchMap.values().contains("https://www.olx.pl/praca/sprzedaz/"));
        Assert.assertTrue(branchMap.values().contains("https://www.olx.pl/praca/gastronomia/"));
        Assert.assertTrue(branchMap.values().contains("https://www.olx.pl/praca/inne-oferty-pracy/"));
        Assert.assertTrue(branchMap.keySet().contains("Administracja biurowa"));
        Assert.assertTrue(branchMap.keySet().contains("HR"));
        Assert.assertTrue(branchMap.keySet().contains("Wykładanie towaru / inwentar."));

    }

    @Test
    public void shouldSayThatSearchingOfTheLastPaginationNumberWorksInRightWay() throws IOException {
        System.out.println(olxScrapper.findLastPaginationNumberFromLink(LINK));
        Assert.assertTrue(olxScrapper.findLastPaginationNumberFromLink(LINK) == 500);
        Assert.assertTrue(olxScrapper.findLastPaginationNumberFromLink("https://www.olx.pl/praca/sprzedaz/") > 25);
        Assert.assertTrue(olxScrapper.findLastPaginationNumberFromLink("https://www.olx.pl/praca/gastronomia/") > 25);
    }

    @Test
    public void shouldSayThatFillingBranchListWorksFine() throws IOException {
        List<String> linkList = olxScrapper.fillBranchListFromOneSite("https://www.olx.pl/praca/hr/");
        Assert.assertFalse(linkList.isEmpty());
        System.out.println(linkList);

    }

    @Test
    public void shouldSayThatFillingLinkListWorksFine() throws IOException {
        List<String> branchList = olxScrapper.fillBranchListFromOneSite("https://www.olx.pl/praca/hr/");
        List<String> linkList = olxScrapper.collectLinksFromOneSite(branchList.get(branchList.size() - 1));
        Assert.assertFalse(linkList.isEmpty());
        System.out.println(linkList);
    }

    @Test
    public void shouldSayThatPositionIsNotNull() throws IOException {
        for (Element element : setUpElements(TITLE_BOX)) {
            Assert.assertNotNull(olxScrapper.searchForPosition(element));
            System.out.println(olxScrapper.searchForPosition(element));
        }
    }

    @Test
    public void shouldSayThatWorkplaceIsNotNull() throws IOException {
        for (Element element : setUpElements(TITLE_BOX)) {
            Assert.assertNotNull(olxScrapper.searchForWorkplace(element));
            System.out.println(olxScrapper.searchForWorkplace(element));
        }
    }

    @Test
    public void shouldSayThatDatePublishedIsNotNull() throws IOException {
        for (Element element : setUpElements(TITLE_BOX)) {
            Assert.assertNotNull(olxScrapper.searchForDatePublished(element));
            System.out.println(olxScrapper.searchForDatePublished(element));
        }
    }

    @Test
    public void shouldSayThatHourPublishedIsNotNull() throws IOException {
        for (Element element : setUpElements(TITLE_BOX)) {
            Assert.assertNotNull(olxScrapper.searchForHourPublished(element));
            System.out.println(olxScrapper.searchForHourPublished(element));
        }
    }

    @Test
    public void shouldSayThatAdIdIsNotNull() throws IOException {
        for (Element element : setUpElements(TITLE_BOX)) {
            Assert.assertNotNull(olxScrapper.searchForAdId(element));
            System.out.println(olxScrapper.searchForAdId(element));
        }
    }


    @Test
    public void shouldSayThatManagerialPositionIsNotNull() throws IOException {
        for (Element element : setUpElements(OFFER_PARAMETER)) {
            Assert.assertNotNull(olxScrapper.searchForManagerialPosition(element));
            System.out.println(olxScrapper.searchForManagerialPosition(element));
        }
    }

    @Test
    public void shouldSayThatRequiredFieldIsNotNull() throws IOException {
        for (Element element : setUpElements(OFFER_PARAMETER)) {
            Assert.assertNotNull(olxScrapper.searchForRequired(element));
            System.out.println(olxScrapper.searchForRequired(element));
        }
    }

    @Test
    public void shouldSayThatContractTypeIsNotNull() throws IOException {
        for (Element element : setUpElements(OFFER_PARAMETER)) {
            Assert.assertNotNull(olxScrapper.searchForContractType(element));
            System.out.println(olxScrapper.searchForContractType(element));
        }
    }

    @Test
    public void shouldSayThatFormOfEmploymentIsNotNull() throws IOException {
        for (Element element : setUpElements(OFFER_PARAMETER)) {
            Assert.assertNotNull(olxScrapper.searchForFormOfEmployment(element));
            System.out.println(olxScrapper.searchForFormOfEmployment(element));
        }
    }

    @Test
    public void shouldSayThatBranchIsNotNull() throws IOException {
        Assert.assertNotNull(olxScrapper.searchForBranch(setUpDocument()));
        System.out.println(olxScrapper.searchForBranch((setUpDocument())));
    }

    @Test
    public void shouldSayThatDescriptionIsNotNull() throws IOException {
        Assert.assertNotNull(olxScrapper.searchForDescription(setUpDocument()));
        System.out.println(olxScrapper.searchForDescription((setUpDocument())));
    }

    @Test
    public void shouldSayThatSalaryIsNotNull() throws IOException {
        Assert.assertNotNull(olxScrapper.searchForSalary(setUpDocument()));
        System.out.println(olxScrapper.searchForSalary((setUpDocument())));
    }

    @Test
    public void shouldSayThatEmployerIsNotNull() throws IOException {
        Assert.assertNotNull(olxScrapper.searchForEmployer(setUpDocument()));
        System.out.println(olxScrapper.searchForEmployer((setUpDocument())));
    }



}