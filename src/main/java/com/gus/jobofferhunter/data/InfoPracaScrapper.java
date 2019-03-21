package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.model.offer.InfoPraca;
import com.gus.jobofferhunter.service.InfoPracaService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class InfoPracaScrapper extends DataCollectorSettings {

    @Autowired
    InfoPracaService infoPracaService;

    private static final Logger log = LoggerFactory.getLogger(InfoPraca.class);

    /**
     * Collects links to all websites with offers from the portal "infopraca.pl".
     */
    public void collectStructure() throws Exception {
        log.info("The page structure is being downloaded...");
        paginationList.add("https://www.infopraca.pl/praca?q=&lc=");
        for (int i = 0; i < paginationList.size(); i++) {
            Document paginationPage = connectWith(paginationList.get(i));
            Elements pagination = paginationPage
                    .select("ul.pagination li > a[title = Dalej]");
            for (Element element : pagination) {
                String url = element
                        .attr("abs:href");
                paginationList.add(url);
            }
            System.out.println(paginationList.get(i));
        }
        log.info("Page structure downloaded!");
    }

    public void test() throws Exception {
        Document singleOffer = connectWith("https://www.infopraca.pl/praca?sort=last_update&pg=200");
        Elements content = singleOffer.select("ul#results-list>li");
        for (Element element : content) {
            InfoPraca infoPraca = new InfoPraca();
            infoPraca.setPosition(searchForPosition(element));
            infoPraca.setEmployer(searchForEmployer(element));
            infoPraca.setWorkplace(searchForWorkplace(element));
            infoPraca.setRegion(searchForRegion(element));
            infoPraca.setDatePublished(searchForDatePublished(element));
            infoPraca.setUrl(searchForUrl(element));
            infoPraca.setDataSearch(LocalDateTime.now().format(formatter));
            infoPraca.setWebPage("infopraca.pl");
            infoPracaService.save(infoPraca);
        }
    }

    public void collectData() throws Exception {
        log.info("The data downloading is in progress...");
        for (int i = 0; i < paginationList.size(); i++) {
            Document singleOffer = connectWith(paginationList.get(i));
            Elements content = singleOffer.select("ul#results-list>li");
            for (Element element : content) {
                InfoPraca infoPraca = new InfoPraca();
                infoPraca.setPosition(searchForPosition(element));
                infoPraca.setEmployer(searchForEmployer(element));
                infoPraca.setWorkplace(searchForWorkplace(element));
                infoPraca.setRegion(searchForRegion(element));
                infoPraca.setDatePublished(searchForDatePublished(element));
                infoPraca.setUrl(searchForUrl(element));
                infoPraca.setDataSearch(LocalDateTime.now().format(formatter));
                infoPraca.setWebPage("infopraca.pl");
                infoPracaService.save(infoPraca);
                log.info("The data from single offer was downloaded...");
            }
        }
        log.info("All data from the infopraca.pl has been downloaded");
    }

    public void downloadAll() throws Exception {
        collectStructure();
        collectData();
    }

    private String searchForRegion(Element element) {
        String region = element.select("h4.serp-one-location > span.p-region").text();
        return region;
    }

    private String searchForUrl(Element element) {
        String url = element.select("h2.p-job-title > a").attr("abs:href");
        return url;
    }

    private String searchForDatePublished(Element element) {
        String datePublished = element.select("span.last-update").text();
        String correction = null;
        try {
            correction =
                    datePublished.substring(datePublished.indexOf(":") + 2, datePublished.length());
            String finalDate = correction.replaceAll(" dni temu", "");
            if (finalDate.equals("Dzisiaj")) {
                String today =
                        String.valueOf(LocalDate.now());
                return today;
            }
            if (finalDate.equals("wczoraj")) {
                String yesterday =
                        String.valueOf(LocalDate.now().minusDays(1));
                return yesterday;
            } else {
                String previousDays =
                        String.valueOf(LocalDate.now().minusDays(Long.parseLong(finalDate)));
                return previousDays;
            }
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
            return datePublished;
        }
    }

    private String searchForWorkplace(Element element) {
        String workplace = element.select("h4.serp-one-location > span.p-locality").text();
        return workplace;
    }

    private String searchForEmployer(Element element) {
        String employer = element.select("h3.p-name.company").text();
        return employer;
    }

    private String searchForPosition(Element element) {
        String position = element.select("h2.p-job-title").text();
        return position;
    }
}
