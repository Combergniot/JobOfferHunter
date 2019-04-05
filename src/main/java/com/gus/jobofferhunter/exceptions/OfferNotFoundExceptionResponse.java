package com.gus.jobofferhunter.exceptions;

public class OfferNotFoundExceptionResponse {
    private String projectNotFound;

    public OfferNotFoundExceptionResponse(String projectNotFound) {
        this.projectNotFound = projectNotFound;
    }

    public String getProjectNotFound() {
        return projectNotFound;
    }

    public void setProjectNotFound(String projectNotFound) {
        this.projectNotFound = projectNotFound;
    }
}
