package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.model.offer.Olx;
import com.gus.jobofferhunter.service.OlxService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OlxScrapper extends DataCollectorSettings {

    @Autowired
    OlxService olxService;

    private static final Logger log = LoggerFactory.getLogger(OlxScrapper.class);
    private List<String> paginationBranchList = new ArrayList<>();

    /**
     * Collects links to all websites with offers from the portal "olx.pl".
     */
    public void collectStructure() throws Exception {
        log.info("The page structure is being downloaded...");
        paginationList.add("https://www.olx.pl/praca/");
        for (int i = 0; i < paginationList.size(); i++) {
            Document paginationPage = connectWith(paginationList.get(i));
            Elements pagination = paginationPage.select("span.fbold.next.abs.large>a.link");
            for (Element e : pagination) {
                String url = e.attr("abs:href");
                paginationList.add(url);
            }
//            System.out.println(paginationList.get(i));
        }

        log.info("Page structure downloaded!");
    }

    public Map<String, String> createBranchList() throws IOException {
        Map<String, String> branchMap = new HashMap<>();
        Document document = connectWith("https://www.olx.pl/praca/");
        Elements branchLinks = document.select("div.inner>ul>li");
        for (Element element : branchLinks
        ) {
            String key = element.select("a.topLink.tdnone").text();
            String value = element.select("a.topLink.tdnone").attr("abs:href");
            branchMap.put(key, value);
        }
        return branchMap;
    }

    public int findLastPaginationNumberFromLink(String link) throws IOException {
        Document document = connectWith(link);
        int lastPaginationNumber =
                Integer.valueOf(document.select("div.pager.rel.clr>span.item.fleft").last().text());
        return lastPaginationNumber;
    }

    //Todo - wykorzystaj klucz branzy
    public void fillBranchList() throws Exception {
        Map<String, String> branchMap = createBranchList();
        for (Map.Entry<String, String> entry : branchMap.entrySet()) {
//            String key = entry.getKey();
            String value = entry.getValue();
            int lastPaginationNumber = findLastPaginationNumberFromLink(value);
//            System.out.println(lastPaginationNumber + " " + key + " " + value);
            for (int i = 1; i <= lastPaginationNumber; i++) {
                paginationBranchList.add(value + "?page=" + i);
            }
//                System.out.println(paginationBranchList.toString());
        }
    }

    public List<String> fillBranchListFromOneSite(String link) throws IOException {
        int lastPaginationNumber = findLastPaginationNumberFromLink(link);
        for (int i = 1; i <= lastPaginationNumber; i++) {
            paginationBranchList.add(link + "?page=" + i);
        }
        return paginationBranchList;
    }

    /**
     * Collects links to all single offers from the portal "www.olx.pl/praca".
     */
    public void collectLinks() throws Exception {
        log.info("The links to job offers are being downloaded...");
        for (int i = 0; i < paginationBranchList.size(); i++) {
            Document linkCollection = connectWith(paginationBranchList.get(i));
            Elements content = linkCollection.select("tr.wrap");
            Elements url = content.select("h3.lheight22.margintop5>a");
            for (Element element : url) {
                String link = element.attr("href");
                jobOffersList.add(link);
            }
            log.info(jobOffersList.get(i));
        }
        removeDuplicatesFromList();
        log.info("Links to all job offers has been downloaded!");
    }


    public List<String> collectLinksFromOneSite(String link) throws IOException{
        Document linkCollection = connectWith(link);
        Elements content = linkCollection.select("tr.wrap");
        Elements url = content.select("h3.lheight22.margintop5>a");
        for (Element element : url) {
            String linkToJobOffer = element.attr("href");
            jobOffersList.add(linkToJobOffer);
        }
        return removeDuplicatesFromList();
    }

    /**
     * Collects data from all single job offer from the portal "www.olx.pl/praca".
     */
    public void collectData() throws Exception {
        log.info("The data downloading is in progress...");
        for (int i = 0; i < jobOffersList.size(); i++) {
            Document singleOffer = connectWith(jobOffersList.get(i));

            Olx olx = new Olx();
            Elements titleBox = singleOffer.select("div.offer-titlebox");
            for (Element element : titleBox) {
                olx.setPosition(searchForPosition(element));
                olx.setWorkplace(searchForWorkplace(element));
                olx.setDatePublished(searchForDatePublished(element));
                olx.setHourPublished(searchForHourPublished(element));
                olx.setAdId(searchForAdId(element));
            }
            Elements offersParameter = singleOffer.select("ul.offer-parameters");
            for (Element element : offersParameter) {
                olx.setFormOfEmployment(searchForFormOfEmployment(element));
                olx.setContractType(searchForContractType(element));
                olx.setRequired(searchForRequired(element));
                olx.setManagerialPosition(searchForManagerialPosition(element));
            }
            olx.setBranch(searchForBranch(singleOffer));
            olx.setDescription(searchForDescription(singleOffer));
            olx.setSalary(searchForSalary(singleOffer));
            olx.setEmployer(searchForEmployer(singleOffer));
            olx.setWebPage("olx.pl");
            olx.setDataSearch(LocalDateTime.now().format(formatter));
            olx.setUrl(jobOffersList.get(i));
            olxService.save(olx);
            log.info("The data from single offer was downloaded...");
        }
        log.info("All data from the Olx.pl has been downloaded");
    }

    public void test() throws Exception {
        log.info("The data downloading is in progress...");
        Document singleOffer = connectWith("https://www.olx.pl/oferta/kierownik-zmiany-CID4-IDrJtmP.html#e883c731b3");

        Olx olx = new Olx();
        Elements titleBox = singleOffer.select("div.offer-titlebox");
        for (Element element : titleBox) {
            olx.setPosition(searchForPosition(element));
            olx.setWorkplace(searchForWorkplace(element));
            olx.setDatePublished(searchForDatePublished(element));
            olx.setHourPublished(searchForHourPublished(element));
            olx.setAdId(searchForAdId(element));
        }
        Elements offersParameter = singleOffer.select("ul.offer-parameters");
        for (Element element : offersParameter) {
            olx.setFormOfEmployment(searchForFormOfEmployment(element));
            olx.setContractType(searchForContractType(element));
            olx.setRequired(searchForRequired(element));
            olx.setManagerialPosition(searchForManagerialPosition(element));
        }
        olx.setBranch(searchForBranch(singleOffer));
        olx.setDescription(searchForDescription(singleOffer));
        olx.setSalary(searchForSalary(singleOffer));
        olx.setEmployer(searchForEmployer(singleOffer));
        olx.setWebPage("olx.pl");
        olx.setDataSearch(LocalDateTime.now().format(formatter));
        olxService.save(olx);
        log.info("The data from single offer was downloaded...");
    }

    public void downloadAll() throws Exception {
//        collectStructure();
        fillBranchList();
        collectLinks();
        collectData();
    }

    /**
     * Path to values from single job offer.
     */
    public String searchForSalary(Document singleOffer) {
        String salary = singleOffer.select("div.price-label").text();
        return salary;
    }

    public String searchForDescription(Document singleOffer) {
        String description = singleOffer.select("div#textContent").text();
        return description;
    }

    public String searchForBranch(Document singleOffer) {
        String branch = singleOffer.select("li.inline").next().next().text();
        return branch;
    }

    public String searchForEmployer(Document singleOffer) {
        String advertiser =
                singleOffer.select("div.offer-user__details >h4>a").text();
        return advertiser;
    }

    public String searchForPosition(Element element) {
        String position = element.select("h1").text();
        return position;
    }

    public String searchForWorkplace(Element element) {
        String workplace = element.select("strong").text();
        return workplace;
    }

    public String searchForDatePublished(Element element) {
        String dateInfoBox = element.select("em").text();
        String datePublished = dateInfoBox.substring(dateInfoBox.indexOf(",") + 2, dateInfoBox.length() - 26);
        return datePublished;
    }

    public String searchForHourPublished(Element element) {
        try {
            String dateInfoBox = element.select("em").text();
            String hourPublished = dateInfoBox.substring(9, dateInfoBox.indexOf(","));
            return hourPublished;
        } catch (Exception e) {
            e.printStackTrace();
            return "Do poprawki";
        }
    }

    public String searchForAdId(Element element) {
        String idBox = element.select("em>small").text();
        String adId = idBox.substring(15);
        return adId;
    }

    public String searchForFormOfEmployment(Element element) {
        String formOfEmployment =
                element.select("strong").first().text();
        return formOfEmployment;
    }

    public String searchForContractType(Element element) {
        String contractType =
                element.getElementsContainingOwnText("Typ umowy:").select("strong").text();
        return contractType;
    }

    public String searchForRequired(Element element) {
        String required =
                element.getElementsContainingOwnText("Wymagane:").select("strong").text();
        return required;
    }

    public String searchForManagerialPosition(Element element) {
        String managerialPositon =
                element.getElementsContainingOwnText("Kadra kierownicza:").select("strong").text();
        return managerialPositon;
    }


}






