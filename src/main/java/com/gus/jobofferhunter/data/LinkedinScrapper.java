package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.service.LinkedinService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//TODO - https://developer.linkedin.com/docs/rest-api - sprawdzić

@Component
public class LinkedinScrapper extends DataCollectorSettings {

    @Autowired
    LinkedinService linkedinService;

    private static final Logger log = LoggerFactory.getLogger(LinkedinScrapper.class);

    /**
     * Collects links to all websites with offers from the portal "https://pl.linkedin.com/jobs/".
     * Notice: If you would like to crawl LinkedIn, please email whitelist-crawl@linkedin.com to apply for white listing.
     */
    public void collectStructure() throws Exception {
        List<String> paginationList = new ArrayList<>();
        paginationList.add("https://pl.linkedin.com/jobs/view-all");
        for (int i = 0; i < paginationList.size(); i++) {
            Document paginationPage = connectWith(paginationList.get(i));
            Elements pagination = paginationPage.select("div.search-results-pagination");
            for (Element e : pagination) {
                String url = pagination
                        .select("ul>a.next-prev-container.next.btn")
                        .attr("abs:href");
                System.out.println(url);
//                paginationList.add(url);
            }
            System.out.println(paginationList.get(i));
        }
    }

    /**
     * Collects links to all single offers from the portal "https://pl.linkedin.com/jobs/".
     */
    public void collectLinks () throws Exception {


    }



}

