package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.model.offer.Absolvent;
import com.gus.jobofferhunter.service.AbsolventService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AbsolventScrapper extends DataCollectorSettings {

    @Autowired
    AbsolventService absolventService;

    private static final Logger log = LoggerFactory.getLogger(Absolvent.class);

    public void collectStructure() throws Exception {
        log.info("The page structure is being downloaded...");

        Document paginationPage = connectWith("https://www.absolvent.pl/oferty-pracy?p=2&jt=praca-praktyka-staz&pp=15");

        System.out.println(paginationPage.select("div.main").text());

//        Elements elements = paginationPage.select("div.pagination");
////        for (Element element : elements) {
////            String link = element.select("a.next-prev").attr("href");
////            System.out.println(link);
////        }
    }
}


