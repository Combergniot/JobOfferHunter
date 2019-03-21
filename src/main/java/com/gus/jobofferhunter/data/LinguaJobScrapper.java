package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.model.offer.LinguaJob;
import com.gus.jobofferhunter.service.LinguaJobService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LinguaJobScrapper extends DataCollectorSettings {

    @Autowired
    LinguaJobService linguaJobService;

    private static final Logger log = LoggerFactory.getLogger(LinguaJob.class);

    public int findLastPaginationNumber() throws Exception {
        Document paginationPage = connectWith("http://www.linguajob.pl/szukaj/?p=1");

        Elements pagination = paginationPage
                .select("div.strony");
        String searchedNumber = pagination.select("a.notcurrent").last().text();
        int lastPaginationNumber = Integer.parseInt(searchedNumber);
        log.info("Pagination size on LinguaJob: "+ lastPaginationNumber);
        return lastPaginationNumber;
    }

    private void fillPaginationList() throws Exception {
        int lastPaginationNumber = findLastPaginationNumber();
        for (int i = 1; i <= lastPaginationNumber; i++) {
            paginationList.add("http://www.linguajob.pl/szukaj/?p=" + i);
        }
        System.out.println(paginationList.toString());
    }

    public void collectData() throws Exception {
        fillPaginationList();
        log.info("The data downloading is in progress...");
        for (int i = 0; i < paginationList.size(); i++) {
            Document singleOffer = connectWith(paginationList.get(i));
            Elements jobOfferTable = singleOffer.select("div#ogloszenia");
            Elements singleOfferBox = jobOfferTable.select("div.ogloszenie");
            for (Element element : singleOfferBox) {
                LinguaJob linguaJob = new LinguaJob();
                linguaJob.setPosition(searchForPosition(element));
                linguaJob.setWorkplace(searchForWorkplace(element));
                linguaJob.setEmployer(searchForEmployer(element));
                linguaJob.setDatePublished(searchForDatePublished(element));
                linguaJob.setBranch(searchForBranch(element));
                linguaJob.setSecondLanguage(searchForSecondLanguage(element));
                linguaJob.setLanguage(searchForLanguage(element));
                linguaJob.setUrl(searchForUrl(element));
                linguaJob.setWebPage("LinguaJob");
                linguaJob.setDataSearch(LocalDateTime.now().format(formatter));
                linguaJobService.save(linguaJob);
                log.info("The data from single offer was downloaded...");
            }
            log.info("All data from the LinguaJob has been downloaded");
        }
    }


    public String searchForUrl(Element element) {
        String url = element.select("div.right>a").attr("abs:href");
        return url;
    }


    public String searchForWorkplace(Element element) {
        String workplace =
                 element.select("p.miasto>span>a").text();
        return workplace;
    }

    public String searchForLanguage(Element element) {
        String language =
                element.getElementsContainingOwnText("Język:").next().text();
        return language;
    }

    public String searchForSecondLanguage(Element element) {
        String secondLanguage =
                element.getElementsContainingOwnText("Język:").next().next().text();
        return secondLanguage;
    }


    public String searchForBranch(Element element) {
        String branch =element.getElementsContainingOwnText("Branża:").next().text();
        return  branch;
    }


    public String searchForDatePublished(Element element) {
        String datePublished = element.select("p.miasto").text();
        String correctDate = null;
        try {
            correctDate = datePublished.substring(0, datePublished.lastIndexOf("|")-1);
        } catch (StringIndexOutOfBoundsException e) {
            return datePublished;
        }
        return correctDate;
    }

    public String searchForEmployer(Element element) {
        String employer =element.select("h3>a").last().text();
        return employer;
    }

    public String searchForPosition(Element element) {
        String position =element.select("h3>a>span").text();
        return position;
    }
}
