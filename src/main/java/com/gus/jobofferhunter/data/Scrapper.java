package com.gus.jobofferhunter.data;

import com.gus.jobofferhunter.processing.PracujPlDataProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Scrapper {

    @Autowired
    GratkaScrapper gratkaScrapper;
    @Autowired
    MoneyPlScrapper moneyPlScrapper;
    @Autowired
    OlxScrapper olxScrapper;
    @Autowired
    PracujPlScrapper pracujPlScrapper;
    @Autowired
    GoldenLineScrapper goldenLineScrapper;
    @Autowired
    LinkedinScrapper linkedinScrapper;
    @Autowired
    JobsPlScrapper jobsPlScrapper;
    @Autowired
    AllTheJobsScrapper allTheJobsScrapper;
    @Autowired
    GumtreeScrapper gumtreeScrapper;
    @Autowired
    CareerJetScrapper careerJetScrapper;
    @Autowired
    InfoPracaScrapper infoPracaScrapper;
    @Autowired
    AbsolventScrapper absolventScrapper;
    @Autowired
    PracujPlDataProcessing pracujPlDataProcessing;
    @Autowired
    AdzunaScrapper adzunaScrapper;
    @Autowired
    GazetaPracaScrapper gazetaPracaScrapper;
    @Autowired
    PracaOwiScrapper pracaOwiScrapper;
    @Autowired
    JobSwypeScrapper jobSwypeScrapper;
    @Autowired
    LinguaJobScrapper linguaJobScrapper;
    @Autowired
    JoberScrapper joberScrapper;
    @Autowired
    PracaPlScrapper pracaPlScrapper;
    @Autowired
    PracaTobieScrapper pracaTobieScrapper;


    public void downloadDataFromPracujPl() throws Exception {
        pracujPlScrapper.downloadAll();
    }

    public void downloadDataFromGratka() throws Exception {
        gratkaScrapper.downloadAll();
    }

    public void downloadDataFromOlx() throws Exception {
        olxScrapper.downloadAll();
    }

    public void downloadDataFromMoneyPl() throws Exception {
        moneyPlScrapper.downloadALL();
    }

    public void downloadDataFromGoldenLine() throws Exception {
        System.out.println("WORK IN PROGRESS! GoldenLine Scrapper is currently under technical maintenance");
    }

    public void downloadDataFromLinkedin() throws Exception {
        System.out.println("WORK IN PROGRESS! Linkedin Scrapper is currently under technical maintenance");
        System.out.println("ACCESS DENIED!");
    }

    public void downloadDataFromJobsPl() throws Exception {
        jobsPlScrapper.downloadAll();
    }

    public void downloadDataFromAllTheJobs() throws Exception {
        allTheJobsScrapper.downloadAll();
    }

    public void downloadDataFromGumtree() throws Exception {
        gumtreeScrapper.downloadAll();
    }

    public void downloadDataFromCareerJet() throws Exception {
        System.out.println("WORK IN PROGRESS! CareerJet Scrapper is currently under technical maintenance");
        System.out.println("PAGINATION LIMIT!");
    }

    public void downloadDataFromInfoPraca() throws Exception {
        infoPracaScrapper.downloadAll();
    }

    public void downloadDataFromAbsolvent() throws Exception {
        System.out.println("WORK IN PROGRESS! Absolvent Scrapper is currently under technical maintenance");
    }

    public void downloadDataFromAdzuna() throws Exception {
        adzunaScrapper.collectData();
    }

    public void downloadDataFromGazetaPraca() throws Exception {
        System.out.println("WORK IN PROGRESS! GazetaPraca Scrapper is currently under technical maintenance");
    }

    public void downloadDataFromPracaOwi() throws Exception {
        System.out.println("WORK IN PROGRESS! PracaOwi Scrapper is currently under technical maintenance");
    }

    public void downloadDataFromJobSwype() throws Exception {
        jobSwypeScrapper.collectData();
    }

    public void downloadDataFromLinguaJob() throws Exception {
        linguaJobScrapper.collectData();
    }

    public void downloadDataFromJober()throws Exception{
        System.out.println("WORK IN PROGRESS!Jober Scrapper is currently under technical maintenance");
        joberScrapper.collectData();
    }

    public void downloadDataFromPracaPl()throws Exception{
        System.out.println("WORK IN PROGRESS!PracaPl Scrapper is currently under technical maintenance");
        pracaPlScrapper.collectData();
    }

    public void downloadDataFromPracaTobie()throws Exception{
        System.out.println("WORK IN PROGRESS! PracaTobie Scrapper is currently under technical maintenance");
        pracaTobieScrapper.collectData();
    }

//    public void test() throws Exception {
//        olxScrapper.findLastPaginationNumber();
//    }


}
