package com.gus.jobofferhunter.processing;

import org.springframework.stereotype.Component;

@Component
public class PracujPlDataProcessing extends DataSourceDAO{

    public void read() throws Exception {
        readDataBase();
        writeResultSet();
        close();
    }


    }


