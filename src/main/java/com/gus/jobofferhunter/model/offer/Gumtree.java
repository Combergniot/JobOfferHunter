package com.gus.jobofferhunter.model.offer;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor

@Entity
@DiscriminatorValue("gumtree")
public class Gumtree extends JobOffer{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String announcedBy; //np. osobę prywatną

    private String typeOfWork; //np. dorywcza/stała

    private String contractType; //np. umowa zlecenie

    private String branch;

    private String dataID; // unikalny ID ze strony

    @Lob
    private String description;

    @Lob
    private String url;


    public Gumtree() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnnouncedBy() {
        return announcedBy;
    }

    public void setAnnouncedBy(String announcedBy) {
        this.announcedBy = announcedBy;
    }

    public String getTypeOfWork() {
        return typeOfWork;
    }

    public void setTypeOfWork(String typeOfWork) {
        this.typeOfWork = typeOfWork;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDataID() {
        return dataID;
    }

    public void setDataID(String dataID) {
        this.dataID = dataID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
