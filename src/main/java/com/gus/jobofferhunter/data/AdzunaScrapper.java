package com.gus.jobofferhunter.data;

//https://developer.adzuna.com/overview
//

import com.gus.jobofferhunter.api.AdzunaApiService;
import com.gus.jobofferhunter.model.offer.Adzuna;
import com.gus.jobofferhunter.service.AdzunaService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;


//Czy pobierać dane z innych krajów? Generowanie danych przez API

@Component
public class AdzunaScrapper extends DataCollectorSettings {

    private static final Logger log = LoggerFactory.getLogger(AdzunaScrapper.class);
    AdzunaApiService adzunaApiService = new AdzunaApiService();
    @Autowired
    AdzunaService adzunaService;

    public String getSampleResponse() {
        try {
            Document paginationPage = connectWith(
                    "http://api.adzuna.com/v1/api/jobs/pl/search/" +
                            "1" +
                            "?app_id=" + adzunaApiService.getApplicationId() +
                            "&app_key=" + adzunaApiService.getApplicationKey() +
                            "&results_per_page=1&content-type=text");

            String content = paginationPage.text();
            return content;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getCategories() {
        try {
            Document paginationPage = connectWith(
                    "http://api.adzuna.com/v1/api/jobs/pl/" +
                            "categories" +
                            "?app_id=" + adzunaApiService.getApplicationId() +
                            "&app_key=" + adzunaApiService.getApplicationKey() +
                            "&&content-type=text");
            String content = paginationPage.text();
            return content;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int findLastPaginationNumber() throws Exception {
        Document paginationPage = connectWith("https://www.adzuna.pl/search?w=Polska");
        Elements pagination = paginationPage
                .select("table.pg>tbody>tr>td");
        String lastPaginationText = pagination.get(9).text();
        int lastPaginationNumber = Integer.parseInt(lastPaginationText);
        return lastPaginationNumber;
    }

    public void fillPaginationList() throws Exception {
        for (int i = 1; i <= findLastPaginationNumber(); i++) {
            paginationList.add("https://www.adzuna.pl/search?loc=133355&p=" + i);
        }
        System.out.println(paginationList.toString());
    }

    public void collectData() throws Exception {
        fillPaginationList();
        log.info("The data downloading is in progress...");
        for (int i = 0; i < paginationList.size(); i++) {
            Document singleOffer = connectWith(paginationList.get(i));

            Elements jobOfferTable = singleOffer.select("div.sr");
            Elements singleOfferBox = jobOfferTable.select("div.a");
            for (Element element : singleOfferBox) {
                Adzuna adzuna = new Adzuna();
                adzuna.setPosition(searchForPosition(element));
                adzuna.setEmployer(searchForEmployer(element));
                adzuna.setWorkplace(searchForWorkplace(element));
                adzuna.setUrl(searchForUrl(element));
                adzuna.setSalary(searchForSalary(element));
                adzuna.setDataSearch(LocalDateTime.now().format(formatter));
                adzuna.setWebPage("Adzuna");
                adzunaService.save(adzuna);
                log.info("The data from single offer was downloaded...");
            }
            log.info("All data from the Adzuna has been downloaded");
        }
    }

    public String searchForSalary(Element element) {
        String salary = element.select("p.at>span.at_sl").text();
        return salary;
    }

    public String searchForUrl(Element element) {
        String url = element.select("h2>a").first().attr("abs:href");
        return url;
    }

    public String searchForWorkplace(Element element) {
        String workplace = element.select("p.as>span.loc").text();
        return workplace;
    }


    public String searchForEmployer(Element element) {
        String employer = element.select("p.as").text();
        return employer.substring(0, employer.indexOf(" - "));
    }

    public String searchForPosition(Element element) {
        String position = element.select("h2>a>strong").text();
        return position;
    }


}




