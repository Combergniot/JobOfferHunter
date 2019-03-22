package com.gus.jobofferhunter.data;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class InfoPracaScrapperTest extends DataCollectorSettings{

    InfoPracaScrapper infoPracaScrapper = new InfoPracaScrapper();

    private final String LINK = "https://www.infopraca.pl/praca?q=&lc=&pg=6";

    private Elements setUpElements() throws IOException {
        Document document = connectWith(LINK);
        Elements singleOffer = document
                .select("ul#results-list>li");
         return singleOffer;
    }


//    @Test
//    public void shouldSayThatCollectStructureMethodWorksFine() throws Exception {
//       infoPracaScrapper.collectStructure();
//    }

    @Test
    public void shouldSayThatPositionIsNotNull() throws IOException {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(infoPracaScrapper.searchForPosition(element));
            System.out.println(infoPracaScrapper.searchForPosition(element));
        }
    }

    @Test
    public void shouldSayThatEmployerIsNotNull() throws IOException {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(infoPracaScrapper.searchForEmployer(element));
            System.out.println(infoPracaScrapper.searchForEmployer(element));
        }
    }

    @Test
    public void shouldSayThatWorkplaceIsNotNull() throws IOException {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(infoPracaScrapper.searchForWorkplace(element));
            System.out.println(infoPracaScrapper.searchForWorkplace(element));
        }
    }

    @Test
    public void shouldSayThatDatePublishedIsNotNull() throws IOException {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(infoPracaScrapper.searchForDatePublished(element));
            System.out.println(infoPracaScrapper.searchForDatePublished(element));
        }
    }

    @Test
    public void shouldSayThatUrlIsNotNull() throws IOException {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(infoPracaScrapper.searchForUrl(element));
            System.out.println(infoPracaScrapper.searchForUrl(element));
        }
    }

    @Test
    public void shouldSayThatRegionIsNotNull() throws IOException {
        for (Element element : setUpElements()) {
            Assert.assertNotNull(infoPracaScrapper.searchForRegion(element));
            System.out.println(infoPracaScrapper.searchForRegion(element));
        }
    }




}