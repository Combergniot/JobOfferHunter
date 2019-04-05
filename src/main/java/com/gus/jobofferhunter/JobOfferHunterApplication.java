package com.gus.jobofferhunter;

import com.gus.jobofferhunter.data.Scrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobOfferHunterApplication implements CommandLineRunner {

    @Autowired
    Scrapper scrapper;


    public static void main(String[] args) {
        SpringApplication.run(JobOfferHunterApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

//        scrapper.downloadDataFromPracujPl();

    }




}

