package com.gus.jobofferhunter.model.offer;

import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;


@MappedSuperclass
public abstract class JobOffer implements Serializable{

    private String datePublished; //data dodania ogłoszenia

    private String webPage; //serwis pobrania np. olx.pl

    private String position; //stanowisko, tytuł ogłoszenia

    private String employer; //firma, pracodawca

    @Lob
    private String workplace; //miejsce pracy

    private String dataSearch; //data przeszukania, scrapowania


    public JobOffer(String datePublished, String webPage, String position, String employer, String workplace, String dataSearch) {
        this.datePublished = datePublished;
        this.webPage = webPage;
        this.position = position;
        this.employer = employer;
        this.workplace = workplace;
        this.dataSearch = dataSearch;
    }

    public JobOffer() {
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getDataSearch() {
        return dataSearch;
    }

    public void setDataSearch(String dataSearch) {
        this.dataSearch = dataSearch;
    }
}

