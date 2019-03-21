package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.model.offer.MoneyPl;
import com.gus.jobofferhunter.service.MoneyPlService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MoneyPlScrapper extends DataCollectorSettings {

    @Autowired
    MoneyPlService moneyPlService;

    private static final Logger log = LoggerFactory.getLogger(MoneyPlScrapper.class);

    /**
     * Collects links to all websites with offers from the portal "praca.money.pl".
     */
    private void collectStructure() throws Exception {
        log.info("The page structure is being downloaded...");
        paginationList.add("https://praca.money.pl/oferty,pracy,wyszukaj,0.html?slowo=&zawod=&wojewodztwo=&okres=");
        for (int i = 0; i < paginationList.size(); i++) {
            Document paginationPage = connectWith(paginationList.get(i));

            Elements pagination = paginationPage.select("a.next");
            for (Element e : pagination) {
                String url = e.attr("abs:href");
                paginationList.add(url);
            }
            System.out.println(paginationList.get(i));
        }
        log.info("Page structure downloaded!");
    }

    public int findLastPaginationNumber() throws Exception {
        Document document = connectWith("https://praca.money.pl/oferty,pracy,wyszukaj,0.html?slowo=&zawod=&wojewodztwo=&okres=");
        int lastPaginationNumber = Integer.valueOf(document.select("div.pager>a").last().text());
        log.info("Pagination number: " + lastPaginationNumber);
        return lastPaginationNumber;
    }


    public void fillPaginationList() throws Exception {
        int lastPaginationNumber = findLastPaginationNumber();
        for (int i = 1; i <= lastPaginationNumber; i++) {
            paginationList.add("https://praca.money.pl/oferty,pracy,wyszukaj,0-p" + i + ".html?slowo=&zawod=&wojewodztwo=&okres=");
        }
//        System.out.println(paginationList.toString());
    }


    /**
     * Collects basic data from all single job offer from the portal "praca.money.pl".
     */
    public void collectData() throws Exception {
        log.info("The data downloading is in progress...");
        for (int i = 0; i < paginationList.size(); i++) {
            Document singleOffer = connectWith(paginationList.get(i));
            Elements jobOfferTable = singleOffer.select("table.lista-ofert");
            Elements singleOfferBox = jobOfferTable.select("tr");
            for (Element element : singleOfferBox) {
                MoneyPl moneyPl = new MoneyPl();
                moneyPl.setPosition(searchForPosition(element));
                moneyPl.setEmployer(searchForEmployer(element));
                moneyPl.setDatePublished(searchForDatePublished(element));
                moneyPl.setWorkplace(searchForWorkplace(element));
                moneyPl.setWebPage(searchForWebPage(element));
                moneyPl.setUrl(searchForUrl(element));
                moneyPl.setDataSearch(LocalDateTime.now().format(formatter));
                moneyPlService.save(moneyPl);
                log.info("The data from single offer was downloaded...");
            }
            log.info("All data from the Money.pl has been downloaded");
        }
    }


    public void downloadALL() throws Exception {
//        collectStructure();
        fillPaginationList();
        collectData();
    }

    /**
     * Path to values from single job offer.
     */
    public String searchForPosition(Element element) {
        String position
                = element.select("span.oferta").text();
        return position;
    }

    public String searchForEmployer(Element element) {
        String employer
                  = element.select("span.firma").text();
        return employer;
    }

    public String searchForDatePublished(Element element) {
        String datePublished =
                element.select("span.data").text();
            return datePublished;
    }

    public String searchForWorkplace(Element element) {
        String workplace =
                element.select("span.city").text();
        return workplace;
    }

    public String searchForWebPage(Element element) {
        String webPage =
                element.getElementsByTag("img").attr("alt");
        return webPage;
    }

    public String searchForUrl(Element element) {
        String url = element.select("a").attr("abs:href");
        return url;
    }

}

