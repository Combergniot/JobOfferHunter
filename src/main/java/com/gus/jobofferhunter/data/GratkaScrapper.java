package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.model.offer.Gratka;
import com.gus.jobofferhunter.service.GratkaService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

//TODO Ze skryptu mozna wyodrębnic samą nazwę miejscowosc, forme zatrudnienia i ID oferty.
// Datę publikacji by trzeba razem z linkiem pobierac, jako hashmapę

@Component
public class GratkaScrapper extends DataCollectorSettings {

    @Autowired
    GratkaService gratkaService;

    private static final Logger log = LoggerFactory.getLogger(GratkaScrapper.class);


    public int findLastPaginationNumber() throws Exception {
        Document paginationPage = connectWith("https://gratka.pl/praca");
        Elements pagination = paginationPage
                .select("div.pagination");
        String searchedNumber = pagination.select("span.pagination__separator").next().text();
        String lastNumber = searchedNumber.substring(0, searchedNumber.length() - 4);
        int lastPaginationNumber = Integer.parseInt(lastNumber);
        return lastPaginationNumber;
    }

    private void fillPaginationList() throws Exception {
        int lastPaginationNumber = findLastPaginationNumber();
        for (int i = 1; i <= lastPaginationNumber; i++) {
            paginationList.add("https://gratka.pl/praca?page=" + i);
        }
//        System.out.println(paginationList.toString());
    }

    /**
     * Collects links to all websites with offers from the portal "gratka.pl".
     */
    private void collectStructure() throws Exception {
        log.info("The page structure is being downloaded...");
        paginationList.add("https://gratka.pl/praca");
        for (int i = 0; i < paginationList.size(); i++) {
            Document paginationPage = connectWith(paginationList.get(i));
            Elements pagination = paginationPage.select("a.pagination__nextPage");
            String url = pagination.attr("abs:href");
            paginationList.add(url);
            log.info(paginationList.get(i));
        }
        paginationList.removeAll(Arrays.asList("", null));
        log.info("Page structure downloaded!");
    }

    /**
     * Collects links to all single offers from the portal "gratka.pl".
     */
    public void collectLinks() throws Exception {
        fillPaginationList();
        log.info("The links to job offers are being downloaded...");
        for (int i = 0; i < paginationList.size(); i++) {
            Document linkCollection = connectWith(paginationList.get(i));

            Element content = linkCollection.getElementById("leftColumn");
            Elements url = content.select("article.teaser");
            for (Element element : url) {
                String link = element
                        .select("a.teaser__anchor")
                        .attr("abs:href");
                jobOffersList.add(link);
                System.out.println(link);
            }
        }
        removeDuplicatesFromList();
        log.info("Links to all job offers has been downloaded!");
    }

    public List<String> collectLinkFromOneSite(String link) throws Exception {
        Document linkCollection = connectWith(link);
        Element content = linkCollection.getElementById("leftColumn");
        Elements elements = content.select("article.teaser");
        for (Element element : elements) {
            String url = element.select("a.teaser__anchor")
                    .attr("abs:href");
            jobOffersList.add(url);
        }
        return jobOffersList;
    }


    /**
     * Collects data from all single job offer from the portal "gratka.pl".
     */
    public void collectData() throws Exception {
        log.info("The data downloading is in progress...");
        for (int i = 0; i < jobOffersList.size(); i++) {
            Document singleOffer = connectWith(jobOffersList.get(i));
            Elements mainTable = singleOffer.select("div.sticker__bar");
            Gratka gratka = new Gratka();
            for (Element element : mainTable) {
                gratka.setPosition(searchForPosition(element));
                gratka.setSalary(searchForSalary(element));
            }
            Elements parameters = mainTable.select("ul.parameters__rolled");
            for (Element element : parameters) {
                gratka.setWorkplace(searchForWorkplace(element));
                gratka.setEmployer(searchForEmployer(element));
                gratka.setTypeOfWork(searchForTypeOfWork(element));
                gratka.setPositionLevel(searchForPositionLevel(element));
                gratka.setAdditionalOptions(searchForAdditionalOptions(element));
            }
            gratka.setDescription(searchForDescription(singleOffer));
            gratka.setBranch(searchForBranch(singleOffer));
            gratka.setWebPage("gratka.pl");
            gratka.setDataSearch(LocalDateTime.now().format(formatter));
            gratka.setUrl(jobOffersList.get(i));
            gratkaService.save(gratka);
            log.info("The data from single offer was downloaded...");
        }
    }

    public void test() throws Exception {
        Document singleOffer = connectWith("https://gratka.pl/praca/pracownik-porzadkowy/ob/10572959");
        Elements mainTable = singleOffer.select("div.sticker__bar");
        Gratka gratka = new Gratka();
        for (Element element : mainTable) {
            gratka.setPosition(searchForPosition(element));
            gratka.setSalary(searchForSalary(element));
        }
        Elements parameters = mainTable.select("ul.parameters__rolled");
        for (Element element : parameters) {
            gratka.setWorkplace(searchForWorkplace(element));
            gratka.setEmployer(searchForEmployer(element));
            gratka.setTypeOfWork(searchForTypeOfWork(element));
            gratka.setPositionLevel(searchForPositionLevel(element));
            gratka.setAdditionalOptions(searchForAdditionalOptions(element));
        }
        gratka.setDescription(searchForDescription(singleOffer));
        gratka.setBranch(searchForBranch(singleOffer));
        gratka.setWebPage("gratka.pl");
        gratka.setDataSearch(LocalDateTime.now().format(formatter));
        gratkaService.save(gratka);
        log.info("The data from single offer was downloaded...");
    }

    public String searchForAdditionalOptions(Element element) {
        try {
            String additionalOptions =
                    element.getElementsContainingOwnText("Dodatkowe opcje").next().text();
            return additionalOptions;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String searchForDescription(Document singleOffer) {
        String description = singleOffer.select("div.description__container").text();
        return description;
    }

    public String searchForBranch(Document singleOffer) {
        try {
            String branch =
                    singleOffer.select("ul.breadcrumb__list > li").last().text();
            return branch;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return "brak danych";
        }
    }

    public String searchForPositionLevel(Element element) {
        String positionLevel =
                element.getElementsContainingOwnText("Poziom stanowiska").next().text();
        return positionLevel;
    }

    public String searchForTypeOfWork(Element element) {
        String typeOfWork =
                element.getElementsContainingOwnText("Rodzaj pracy").next().text();
        return typeOfWork;
    }

    public String searchForEmployer(Element element) {
        String employer =
                element.getElementsContainingOwnText("Imię / Nazwa firmy").next().text();
        return employer;
    }

    public String searchForWorkplace(Element element) {
        String workplace =
                element.getElementsContainingOwnText("Lokalizacja").next().text();
        return workplace;
    }

    public String searchForSalary(Element element) {
        String salary = element.select("div.priceInfo").text();
        return salary;
    }

    public String searchForPosition(Element element) {
        String title = element.select("h1.sticker__title").text();
        return title;
    }

    public void downloadAll() throws Exception {
        collectLinks();
        collectData();
    }


}

