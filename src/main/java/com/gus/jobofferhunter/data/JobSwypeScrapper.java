package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.model.offer.JobSwype;
import com.gus.jobofferhunter.service.JobSwypeService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;


@Component
public class JobSwypeScrapper extends DataCollectorSettings {

    @Autowired
    JobSwypeService jobSwypeService;

    private static final Logger log = LoggerFactory.getLogger(JobSwype.class);

    public int findLastPaginationNumber() throws IOException {
        Document navbar = connectWith("https://www.jobswype.pl/praca?title=&location=&radius=0&sorting=&display=&page=");
        String element = navbar.select("p.text-center.small").text();
        String corrections =
                element
                        .replaceAll("Około ", "")
                        .replaceAll(" wyników", "")
                        .replace(".", "");
        Integer lastPaginationNumber = Integer.parseInt(corrections) / 10;
//        System.out.println(lastPaginationNumber);
        return lastPaginationNumber;
    }

    private void fillPaginationList() throws IOException {
        int number = findLastPaginationNumber();
        for (int i = 1; i <= number; i++) {
            String link = "https://www.jobswype.pl/praca?title=&location=&radius=0&sorting=&display=&page=";
            paginationList.add(link + i);
        }
    }

    public void collectData() throws IOException, InterruptedException {
        fillPaginationList();
        for (int i = 0; i < paginationList.size(); i++) {
            Thread.sleep(3000 + (long) Math.random() * 2000);
            Document singleOffer = connectWith(paginationList.get(i));

            Elements content = singleOffer.select("div#content>div.job.card.mb-1");
            for (Element element : content) {
                JobSwype jobSwype = new JobSwype();
                jobSwype.setPosition(searchForPosition(element));
                jobSwype.setWebPage("JobSwype");
                jobSwype.setDataSearch(LocalDateTime.now().format(formatter));
                jobSwype.setUrl(searchForUrl(element));
                jobSwype.setWorkplace(searchForWorkplace(element));
                jobSwype.setDatePublished(searchForDatePublished(element));
                jobSwype.setTypeOfWork(searchForTypeOfWork(element));
                jobSwype.setEmployer(searchForEmployer(element));
                jobSwype.setSalary(searchForSalary(element));
                jobSwypeService.save(jobSwype);
                log.info("The data from single page was downloaded...");
            }
            log.info("Links to all job offers from JobSwype.pl has been downloaded!");
        }

    }

    public String searchForSalary(Element element) {
        String salary =
                element.select("span.delimiter.d-none.job-salary").text();
        return salary;
    }

    public String searchForEmployer(Element element) {
        String employer = element.select("span.delimiter.d-none.job-company").text();
        return employer;
    }

    public String searchForUrl(Element element) {
        String url =
                element.select("a.ext-link")
                        .attr("abs:href");
        return url;
    }

    public String searchForTypeOfWork(Element element) {
        String typeOfWork = element.select("span.delimiter")
                .first()
                .text();
        return typeOfWork;
    }

     public String searchForWorkplace(Element element) {
        String workplace =
                element.select("span.delimiter:gt(2)")
                        .not("span.delimiter.d-none.job-company")
                        .not("span.delimiter.d-none.job-salary")
                        .text();
        return workplace;
    }

    public String searchForPosition(Element element) {
        String position = element.select("div.card-header").text();
        return position;
    }

    public String searchForDatePublished(Element element) {
        String datePublished = element.select("span.job-date").text();
        return datePublished;
    }

}
