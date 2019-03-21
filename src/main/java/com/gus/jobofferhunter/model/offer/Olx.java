package com.gus.jobofferhunter.model.offer;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor

@Entity
@DiscriminatorValue("olx")
public class Olx extends JobOffer  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String contractType;

    private String formOfEmployment;

    private String branch;

    private String salary;

    private String adId;

    private String required;

    private String managerialPosition;

    private String hourPublished;

    @Lob
    private String description;

    @Lob
    private String url;

    public Olx() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getFormOfEmployment() {
        return formOfEmployment;
    }

    public void setFormOfEmployment(String formOfEmployment) {
        this.formOfEmployment = formOfEmployment;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public String getManagerialPosition() {
        return managerialPosition;
    }

    public void setManagerialPosition(String managerialPosition) {
        this.managerialPosition = managerialPosition;
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


    public String getHourPublished() {
        return hourPublished;
    }

    public void setHourPublished(String hourPublished) {
        this.hourPublished = hourPublished;
    }
}
