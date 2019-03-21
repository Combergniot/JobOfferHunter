package com.gus.jobofferhunter.data;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;


public class MoneyPlScrapperTest extends DataCollectorSettings {

    MoneyPlScrapper moneyPlScrapper = new MoneyPlScrapper();

    private final String LINK = "https://praca.money.pl/oferty,pracy,wyszukaj,0-p4.html?slowo=&zawod=&wojewodztwo=&okres=";


    public Elements setUpElements() throws IOException {
        Document singleOffer = connectWith(LINK);
        Elements jobOfferTable = singleOffer.select("table.lista-ofert");
        Elements singleOfferBox = jobOfferTable.select("tr");
        return singleOfferBox;
    }

    @Test
    public void shouldSayThatLastPaginationNumberIsGreaterThan_100() throws Exception {
        Assert.assertTrue(moneyPlScrapper.findLastPaginationNumber() > 100);
    }

    @Test
    public void shouldSayThatPositionsIsNotNull() throws Exception {
        for (Element element : setUpElements()) {
            Assert.assertThat(moneyPlScrapper.searchForPosition(element), is(notNullValue()));
            System.out.println(moneyPlScrapper.searchForPosition(element));
        }

    }

    @Test
    public void shouldSayThatEmployerIsNotNull() throws Exception {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(moneyPlScrapper.searchForEmployer(element));
            System.out.println(moneyPlScrapper.searchForEmployer(element));
        }
    }

    @Test
    public void shouldSayThatDatePublishedIsNotNull() throws Exception {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(moneyPlScrapper.searchForDatePublished(element));
            System.out.println(moneyPlScrapper.searchForDatePublished(element));
        }

    }


    @Test
    public void shouldSayThatWorkplaceIsNotNull() throws Exception {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(moneyPlScrapper.searchForWorkplace(element));
            System.out.println(moneyPlScrapper.searchForWorkplace(element));
        }
    }


    @Test
    public void shouldSayThatWebPageIsNotNull() throws Exception {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(moneyPlScrapper.searchForWebPage(element));
            System.out.println(moneyPlScrapper.searchForWebPage(element));
        }
    }

    @Test
    public void shouldSayThatUrlIsNotNull() throws Exception {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(moneyPlScrapper.searchForUrl(element));
            System.out.println(moneyPlScrapper.searchForUrl(element));
        }
    }
}

