package com.balram.urlShortner.exceptions.model;

import lombok.Getter;


//@ControllerAdvice
@Getter
public class UrlNotFoundException extends RuntimeException {
    private final String urlId;

    public UrlNotFoundException(String urlId) {
        super(String.format("Url %s not found ", urlId));
        this.urlId = urlId;
    }
}