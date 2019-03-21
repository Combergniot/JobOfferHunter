package com.gus.jobofferhunter.model.offer;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor

@Entity
@DiscriminatorValue("pracujpl")
public class PracujPl extends JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String employmentType; //specjalista, dyrektor/prezes, etc.

    private String validThrough; //data ważności ogłoszenia

    private String emploLink; // link do danych o pracodawcy, można wyciągnąć NIP i lokalizację

    private String dataID; // unikalny ID ze strony

    private String region;

// na Lob?
    private String branch;

    @Lob
    private String url;

    public PracujPl() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getValidThrough() {
        return validThrough;
    }

    public void setValidThrough(String validThrough) {
        this.validThrough = validThrough;
    }

    public String getEmploLink() {
        return emploLink;
    }

    public void setEmploLink(String emploLink) {
        this.emploLink = emploLink;
    }

    public String getDataID() {
        return dataID;
    }

    public void setDataID(String dataID) {
        this.dataID = dataID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
