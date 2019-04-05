package com.gus.jobofferhunter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OfferNotFoundException extends RuntimeException {

    public OfferNotFoundException(String s) {
        super(s);
    }
}
