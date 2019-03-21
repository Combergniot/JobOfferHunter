package com.gus.jobofferhunter.data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class DataCollectorSettings {

    protected static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) " +
                    "AppleWebKit/537.36 (KHTML, like Gecko) " +
                    "Chrome/45.0.2454.101 Safari/537.36";
    protected static final String REFERRER = "http://www.google.com";
    protected static final String PROXY_HOST = "webproxy.stat.intra";
    protected static final int PROXY_PORT = 8080;
    protected static final int TIMEOUT = 10 * 1000;

    protected List<String> paginationList = new ArrayList<>();
    protected List<String> jobOffersList = new ArrayList<>();
    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    protected Set<String> paginationSet = new HashSet<>();


    protected List removeDuplicatesFromList() {
        paginationSet.addAll(jobOffersList);
        jobOffersList.clear();
        jobOffersList.addAll(paginationSet);
        return jobOffersList;
    }

    protected Document connectWith(String link) throws IOException {
        Document document = Jsoup.connect(link)
                .proxy(PROXY_HOST, PROXY_PORT)
                .userAgent(USER_AGENT)
                .referrer(REFERRER)
                .timeout(TIMEOUT)
                .ignoreHttpErrors(true)
                .followRedirects(true)
                .get();
        return document;
    }
}


