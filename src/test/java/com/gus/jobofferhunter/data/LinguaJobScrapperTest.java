package com.gus.jobofferhunter.data;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class LinguaJobScrapperTest extends DataCollectorSettings {

    LinguaJobScrapper linguaJobScrapper = new LinguaJobScrapper();

    private final String LINK = "http://www.linguajob.pl/szukaj/?p=2";

    private Elements setUpElements() throws IOException {
        Document document = connectWith(LINK);
        Elements jobOfferTable = document.select("div#ogloszenia");
        Elements singleOfferBox = jobOfferTable.select("div.ogloszenie");
        return singleOfferBox;
    }

    @Test
    public void shouldSayThatLastPaginationNumberIsGreaterThan_5() throws Exception {
        Assert.assertTrue(linguaJobScrapper.findLastPaginationNumber() > 5);
    }

    @Test
    public void shouldSayThatPositionIsNotNull() throws IOException {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(linguaJobScrapper.searchForPosition(element));
            System.out.println(linguaJobScrapper.searchForPosition(element));
        }
    }

    @Test
    public void shouldSayThatEmployerIsNotNull() throws IOException {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(linguaJobScrapper.searchForEmployer(element));
            System.out.println(linguaJobScrapper.searchForEmployer(element));
        }
    }

    @Test
    public void shouldSayThatDatePublishedIsNotNull() throws IOException {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(linguaJobScrapper.searchForDatePublished(element));
            System.out.println(linguaJobScrapper.searchForDatePublished(element));
        }
    }

    @Test
    public void shouldSayThatDateBranchIsNotNull() throws IOException {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(linguaJobScrapper.searchForBranch(element));
            System.out.println(linguaJobScrapper.searchForBranch(element));
        }
    }

    @Test
    public void shouldSayThatSecondLanguageIsNotNull() throws IOException {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(linguaJobScrapper.searchForSecondLanguage(element));
            System.out.println(linguaJobScrapper.searchForSecondLanguage(element));
        }
    }

    @Test
    public void shouldSayThatLanguageIsNotNull() throws IOException {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(linguaJobScrapper.searchForLanguage(element));
            System.out.println(linguaJobScrapper.searchForLanguage(element));
        }
    }

    @Test
    public void shouldSayThatWorkplaceIsNotNull() throws IOException {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(linguaJobScrapper.searchForWorkplace(element));
            System.out.println(linguaJobScrapper.searchForWorkplace(element));
        }
    }

    @Test
    public void shouldSayThatUrlIsNotNull() throws IOException {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(linguaJobScrapper.searchForUrl(element));
            System.out.println(linguaJobScrapper.searchForUrl(element));
        }
    }

}