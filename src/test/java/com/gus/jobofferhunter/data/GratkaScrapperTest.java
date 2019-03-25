package com.gus.jobofferhunter.data;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class GratkaScrapperTest extends DataCollectorSettings {

    GratkaScrapper gratkaScrapper = new GratkaScrapper();
    private final String LINK = "https://gratka.pl/praca?page=3";
    String tittleBox = "div.sticker__bar";
    String parametersQuery = "ul.parameters__rolled";


    private Elements setUpElements(String query, String link) throws Exception {
        Document document = connectWith(link);
        Elements singleOffer = document.select(query);
        return singleOffer;
    }

    @Test
    public void shouldSayThatLastPaginationNumberIsGreaterThan_100() throws Exception {
        Assert.assertTrue(gratkaScrapper.findLastPaginationNumber() > 100);
        System.out.println(gratkaScrapper.findLastPaginationNumber());
    }

    @Test
    public void shouldSayThatCollectingLinksWorksFine() throws Exception {
        List<String> linksList = gratkaScrapper.collectLinkFromOneSite(LINK);
        Assert.assertFalse(linksList.isEmpty());
        Assert.assertTrue(linksList.size() > 25);
        for (int i = 0; i < linksList.size(); i++) {
            System.out.println(i + 1 + " " + linksList.get(i));
        }
    }

    @Test
    public void shouldSayThatPositionIsNotNull() throws Exception {
        List<String> linksList = gratkaScrapper.collectLinkFromOneSite(LINK);
        for (int i = 0; i < linksList.size(); i++) {
            for (Element element : setUpElements(tittleBox, linksList.get(i))) {
                Assert.assertNotNull(gratkaScrapper.searchForPosition(element));
                System.out.println(gratkaScrapper.searchForPosition(element));
            }
        }
    }

    @Test
    public void shouldSayThatSalaryIsNotNull() throws Exception {
        List<String> linksList = gratkaScrapper.collectLinkFromOneSite(LINK);
        for (int i = 0; i < linksList.size(); i++) {
            for (Element element : setUpElements(tittleBox, linksList.get(i))) {
                Assert.assertNotNull(gratkaScrapper.searchForSalary(element));
                System.out.println(gratkaScrapper.searchForSalary(element));
            }
        }
    }

    @Test
    public void shouldSayThatWorkplaceIsNotNull() throws Exception {
        List<String> linksList = gratkaScrapper.collectLinkFromOneSite(LINK);
        for (int i = 0; i < linksList.size(); i++) {
            for (Element element : setUpElements(parametersQuery, linksList.get(i))) {
                Assert.assertNotNull(gratkaScrapper.searchForWorkplace(element));
                System.out.println(gratkaScrapper.searchForWorkplace(element));
            }
        }
    }

    @Test
    public void shouldSayThatEmployerIsNotNull() throws Exception {
        List<String> linksList = gratkaScrapper.collectLinkFromOneSite(LINK);
        for (int i = 0; i < linksList.size(); i++) {
            for (Element element : setUpElements(parametersQuery, linksList.get(i))) {
                Assert.assertNotNull(gratkaScrapper.searchForEmployer(element));
                System.out.println(gratkaScrapper.searchForEmployer(element));
            }
        }
    }

    @Test
    public void shouldSayThatTypeOfWorkIsNotNull() throws Exception {
        List<String> linksList = gratkaScrapper.collectLinkFromOneSite(LINK);
        for (int i = 0; i < linksList.size(); i++) {
            for (Element element : setUpElements(parametersQuery, linksList.get(i))) {
                Assert.assertNotNull(gratkaScrapper.searchForTypeOfWork(element));
                System.out.println(gratkaScrapper.searchForTypeOfWork(element));
            }
        }
    }

    @Test
    public void shouldSayThatAdditionalOptionsIsNotNull() throws Exception {
        List<String> linksList = gratkaScrapper.collectLinkFromOneSite(LINK);
        for (int i = 0; i < linksList.size(); i++) {
            for (Element element : setUpElements(parametersQuery, linksList.get(i))) {
                Assert.assertNotNull(gratkaScrapper.searchForAdditionalOptions(element));
                System.out.println(gratkaScrapper.searchForAdditionalOptions(element));
            }
        }
    }

    @Test
    public void shouldSayThatBranchIsNotNull() throws Exception {
        List<String> linksList = gratkaScrapper.collectLinkFromOneSite(LINK);
        for (int i = 0; i < linksList.size(); i++) {
            Document document = connectWith(linksList.get(i));
            Assert.assertNotNull(gratkaScrapper.searchForBranch(document));
            System.out.println(gratkaScrapper.searchForBranch(document));
        }
    }

    @Test
    public void shouldSayThatDescriptionIsNotNull() throws Exception {
        List<String> linksList = gratkaScrapper.collectLinkFromOneSite(LINK);
        for (int i = 0; i < linksList.size(); i++) {
            Document document = connectWith(linksList.get(i));
            Assert.assertNotNull(gratkaScrapper.searchForDescription(document));
            System.out.println(gratkaScrapper.searchForDescription(document));
        }
    }
}


