package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.model.offer.JobsPl;
import com.gus.jobofferhunter.service.JobsPlService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

@Component
public class JobsPlScrapper extends DataCollectorSettings {

    @Autowired
    JobsPlService jobsPlService;

    private static final Logger log = LoggerFactory.getLogger(JobsPlScrapper.class);
    private Map<String, String> branchTree = new TreeMap<>();

    /**
     * Collects links to all websites with offers from the portal "jobs.pl".
     */
    private void collectBranchStructure() throws Exception {
        Document paginationPage = connectWith("https://www.jobs.pl/");
        Elements pagination = paginationPage
                .select("div.category-container >a.single-category");
        for (Element e : pagination) {
            String category = e.text();
            String url = e.attr("abs:href");
            branchTree.put(category, url);
        }
    }

    private void collectStructure() throws Exception {
        log.info("The page structure is being downloaded...");
//        collectBranchStructure();
//        paginationList.addAll(branchTree.values());
        paginationList.add("https://www.jobs.pl/oferty");
        for (int i = 0; i < paginationList.size(); i++) {
            Document paginationPage = connectWith(paginationList.get(i));

            Elements pagination = paginationPage.select("div.pagination > p >a.next");
            for (Element e : pagination) {
                String url = e.attr("abs:href");
                paginationList.add(url);
            }
            log.info(paginationList.get(i));
        }
        log.info("Page structure downloaded!");
    }

    public int findLastPaginationNumber() throws Exception {
        Document paginationPage = connectWith("https://www.jobs.pl/oferty");
        Elements pagination = paginationPage
                .select("div.pagination >p");
        String searchedNumber = pagination.select("span.empty").next().text();
        int lastPaginationNumber = Integer.parseInt(searchedNumber);
        return lastPaginationNumber;
    }

    private void fillPaginationList() throws Exception {
        int lastPaginationNumber = findLastPaginationNumber();
        for (int i = 1; i <= lastPaginationNumber; i++) {
            paginationList.add("https://www.jobs.pl/oferty/p-" + i);
        }
//        System.out.println(paginationList.toString());
    }

    /**
     * Collects basic data from all single job offer from the portal "jobs.pl".
     */
    private void collectData() throws Exception {
        log.info("The data downloading is in progress...");
        for (int i = 0; i < paginationList.size(); i++) {
            Document singleOffer = connectWith(paginationList.get(i));
            Elements jobOfferList = singleOffer
                    .select("div.offer-list");
            Elements singleOfferBox = jobOfferList
                    .select("div.offer > div.details");
            for (Element element : singleOfferBox) {
                JobsPl jobsPl = new JobsPl();
                jobsPl.setPosition(searchForPosition(element));
                jobsPl.setUrl(searchForUrl(element));
                jobsPl.setEmployer(searchForEmployer(element));
                jobsPl.setDatePublished(searchForDatePublished(element));
                jobsPl.setWorkplace(searchForWorkplace(element));
                jobsPl.setDataId(searchForDataId(element));
                jobsPl.setWebPage("jobs.pl");
                jobsPl.setDataSearch(LocalDateTime.now().format(formatter));
//                jobsPl.setBranch(paginationList.get(i));
                jobsPlService.save(jobsPl);
                log.info("The data from single offer was downloaded...");
            }
        }
        log.info("All data from the Jobs.pl has been downloaded");
    }

    /**
     * Alternative method for collecting data from jobs.pl in case Proxy 502 Error.
     */
    public void collectTestData() throws Exception {
        log.info("The data downloading is in progress...");
        for (int counter = 1; counter < 4067; counter++) {
            Thread.sleep(3000+(long)Math.random()*4000);
            Document singleOffer = null;
            try {
                singleOffer = connectWith("https://www.jobs.pl/oferty/p-" + counter);

            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements jobOfferList = singleOffer.select("div.right-23");
            Elements singleOfferBox = jobOfferList.select("div.offer > div.details");
            for (Element element : singleOfferBox) {
                JobsPl jobsPl = new JobsPl();
                jobsPl.setPosition(searchForPosition(element));
                jobsPl.setUrl(searchForUrl(element));
                jobsPl.setEmployer(searchForEmployer(element));
                jobsPl.setDatePublished(searchForDatePublished(element));
                jobsPl.setWorkplace(searchForWorkplace(element));
                jobsPl.setDataId(searchForDataId(element));
                jobsPl.setWebPage("jobs.pl");
                jobsPl.setDataSearch(LocalDateTime.now().format(formatter));
//                jobsPl.setBranch(paginationList.get(i));
                jobsPlService.save(jobsPl);
                log.info("The data from single offer was downloaded...");
            }
            counter++;
        }
        log.info("All data from the Jobs.pl has been downloaded");
    }

    public void test() throws Exception {
        log.info("The data downloading is in progress...");
        Document singleOffer = connectWith("https://www.jobs.pl/oferty/prawo/p-13");
        Elements jobOfferList = singleOffer.select("div.offer-list");
        Elements singleOfferBox = jobOfferList.select("div.offer > div.details");
        for (Element element : singleOfferBox) {
            JobsPl jobsPl = new JobsPl();
            jobsPl.setPosition(searchForPosition(element));
            jobsPl.setUrl(searchForUrl(element));
            jobsPl.setEmployer(searchForEmployer(element));
            jobsPl.setDatePublished(searchForDatePublished(element));
            jobsPl.setWorkplace(searchForWorkplace(element));
            jobsPl.setWebPage("jobs.pl");
            jobsPl.setBranch("Do zrobienia");
            jobsPl.setDataId(searchForDataId(element));
            jobsPl.setDataSearch(LocalDateTime.now().format(formatter));
            jobsPlService.save(jobsPl);
            log.info("The data from single offer was downloaded...");
        }
        log.info("All data from the Jobs.pl has been downloaded");
    }

    public void downloadAll() throws Exception {
//        collectStructure();
        fillPaginationList();
        collectData();
    }

    /**
     * Path to values from single job offer.
     */
    private String searchForPosition(Element element) {
        String position =
                element.select("p.title").text();
        return position;
    }

    private String searchForEmployer(Element element) {
        String employer =
                element.select("p.employer").text();
        return employer;
    }

    private String searchForDatePublished(Element element) {
        String datePublished =
                element.select("p.date").text();
        return datePublished;
    }

    private String searchForWorkplace(Element element) {
        String workplace =
                element.select("p.localization").text();
        return workplace;
    }

    private String searchForUrl(Element element) {
        String url =
                element.select("p.title > a").attr("abs:href");
        return url;
    }

    private String searchForDataId(Element element) {
        String url = searchForUrl(element);
        String dataId =
                url.substring(searchForUrl(element).length() - 7, searchForUrl(element).length());
        return dataId;
    }

}


