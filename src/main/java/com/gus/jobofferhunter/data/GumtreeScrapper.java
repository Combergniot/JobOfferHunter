package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.model.offer.Gumtree;
import com.gus.jobofferhunter.service.GumtreeService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class GumtreeScrapper extends DataCollectorSettings {

    @Autowired
    GumtreeService gumtreeService;

    private static final Logger log = LoggerFactory.getLogger(GumtreeScrapper.class);

    private String findLastPaginationAdress() throws Exception {
        Document paginationPage = connectWith("https://www.gumtree.pl/s-oferty-pracy/v1c8p1");
        Elements pagination = paginationPage
                .select("div.pagination");
        String lastPaginationAdress = pagination.select("a.last.follows").attr("abs:href");
//        System.out.println(lastPaginationNumber);
        return lastPaginationAdress;
    }

    public int findLastPaginationNumber() throws Exception {
        Document lastPaginationPage = connectWith(findLastPaginationAdress());
        String searchedNumber = lastPaginationPage.select("span.current").text();
        int lastPaginationNumber = Integer.parseInt(searchedNumber);
        return lastPaginationNumber;
    }

    private void fillPaginationList() throws Exception {
        int lastPaginationNumber = findLastPaginationNumber();
        for (int i = 1; i <= lastPaginationNumber; i++) {
            paginationList.add("https://www.gumtree.pl/s-oferty-pracy/page-" + i + "/v1c8p" + i);
        }
//      System.out.println(paginationList.toString());
    }


    public void collectLinks() throws Exception {
        log.info("The links to job offers are being downloaded...");
        fillPaginationList();
        for (int i = 0; i < paginationList.size(); i++) {
            Document linkCollection = connectWith(paginationList.get(i));
            Elements content = linkCollection.select("div.view>ul");
            Elements url = content.select("div.container");
            for (Element element : url) {
                String link = element.select("div.title > a.href-link").attr("abs:href");
                jobOffersList.add(link);
                System.out.println(link);
            }
        }
        removeDuplicatesFromList();
        log.info("Links to all job offers from gumtree.pl has been downloaded!");
    }

    public List<String> createListLinksFromOneSite(String url) throws Exception{
             Document linkCollection = connectWith(url);
            Elements content = linkCollection.select("div.view>ul");
            Elements elements = content.select("div.container");
            for (Element element : elements) {
                String link  = element.select("div.title > a.href-link").attr("abs:href");
                jobOffersList.add(link);
            }
       return removeDuplicatesFromList();
    }

    public void collectData() throws Exception {
        log.info("The data downloading is in progress...");
        for (int i = 0; i < jobOffersList.size(); i++) {
//            Thread.sleep(2000 + (long) Math.random() * 3000);
            Document singleOffer = connectWith(jobOffersList.get(i));
            Gumtree gumtree = new Gumtree();
            Elements content = singleOffer.select("ul.selMenu");
            for (Element element : content) {
                gumtree.setDatePublished(searchForDatePublished(element));
                gumtree.setWorkplace(searchForWorkplace(element));
                gumtree.setAnnouncedBy(searchForAnnouncedBy(element));
                gumtree.setTypeOfWork(searchForTypeOfWork(element));
                gumtree.setContractType(searchForContractType(element));
            }
            gumtree.setDataSearch(LocalDateTime.now().format(formatter));
            gumtree.setDescription(searchForDescription(singleOffer));
            gumtree.setPosition(searchForPosition(singleOffer));
            gumtree.setDataID(searchForDataId(singleOffer));
            gumtree.setBranch(searchForBranch(singleOffer));
            gumtree.setWebPage("gumtree.pl");
            gumtree.setUrl(jobOffersList.get(i));
            gumtree.setEmployer("");
            gumtreeService.save(gumtree);
            log.info("The data from single offer was downloaded...");
        }
        log.info("All data from the gumtree.pl has been downloaded");
    }

    public void test() throws Exception {
        Document singleOffer = connectWith("https://www.gumtree.pl/a-praca-na-produkcji/wolomin/pracownik-produkcji/1002334877370910475604809");
        Gumtree gumtree = new Gumtree();
        Elements content = singleOffer.select("ul.selMenu");
        for (Element element : content) {
            gumtree.setDatePublished(searchForDatePublished(element));
            gumtree.setWorkplace(searchForWorkplace(element));
            gumtree.setAnnouncedBy(searchForAnnouncedBy(element));
            gumtree.setTypeOfWork(searchForTypeOfWork(element));
            gumtree.setContractType(searchForContractType(element));
        }
        gumtree.setDataSearch(LocalDateTime.now().format(formatter));
        gumtree.setDescription(searchForDescription(singleOffer));
        gumtree.setPosition(searchForPosition(singleOffer));
        gumtree.setDataID(searchForDataId(singleOffer));
        gumtree.setBranch(searchForBranch(singleOffer));
        gumtree.setWebPage("gumtree.pl");
        gumtree.setUrl("url");
        gumtree.setEmployer("");
        gumtreeService.save(gumtree);
    }

    public void downloadAll() throws Exception {
        collectLinks();
        collectData();
    }

    //    TODO - zostawic tylko branze
    public String searchForBranch(Document singleOffer) {
        try {
            String branch = singleOffer.select("span.microdata").last().text();
            return branch;
        } catch (NullPointerException e) {
            return "brak danych";
        }
    }

    //    TODO - zostawic sam numer
    public String searchForDataId(Document singleOffer) {
        String dataId = singleOffer.select("div.breadcrumbs > span.title").text();
        return dataId;
    }

    public String searchForPosition(Document singleOffer) {
        String position = singleOffer.select("h1.item-title >span.myAdTitle").text();
        return position;
    }

    public String searchForDescription(Document singleOffer) {
        String description = singleOffer.select("div.description").text();
        return description;
    }

    public String searchForContractType(Element element) {
        String searchForContractType = element
                .getElementsContainingOwnText("Rodzaj umowy")
                .next()
                .text();
        return searchForContractType;
    }

    public String searchForTypeOfWork(Element element) {
        String searchForTypeOfWork = element
                .getElementsContainingOwnText("Rodzaj pracy")
                .next()
                .text();
        return searchForTypeOfWork;
    }

    public String searchForAnnouncedBy(Element element) {
        String announcedBy = element
                .getElementsContainingOwnText("Ogłaszane przez")
                .next()
                .text();
        return announcedBy;
    }

    public String searchForWorkplace(Element element) {
        String workplace = element.select("div.location").text();
        return workplace;
    }

    public String searchForDatePublished(Element element) {
        String datePublished =
                element.getElementsContainingOwnText("Data dodania").next().text();
        return datePublished;
    }
}
