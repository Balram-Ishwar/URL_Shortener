package com.balram.urlShortner.service.impl;

import com.balram.urlShortner.domain.dto.url.UrlRequestDTO;
import com.balram.urlShortner.domain.dto.url.UrlResponseDTO;
import com.balram.urlShortner.enities.UrlEntity;
import com.balram.urlShortner.exceptions.model.UrlNotFoundException;
import com.balram.urlShortner.respository.UrlRepository;
import com.balram.urlShortner.service.UrlService;
import jakarta.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.net.URI;

import java.time.LocalDateTime;


@Service
//@AllArgsConstructor
public class UrlServiceImpl implements UrlService {

@Autowired
private UrlRepository urlRepository;



@Override
public UrlResponseDTO shortenUrl(UrlRequestDTO data, HttpServletRequest request) {
    String id;
    do {
        id = RandomStringUtils.randomAlphanumeric(5, 10);
    } while (urlRepository.existsById(id));

    UrlEntity urlEntity = new UrlEntity(id, data.url(), LocalDateTime.now());
    urlRepository.save(urlEntity);

    System.out.println("Stored URL: " + urlEntity.getUrl()); 

    String redirectUrl = request.getRequestURL().toString().replace("shorten-url", id);

    return new UrlResponseDTO(data.url(), redirectUrl);
}


@Override
public HttpHeaders redirect(String id) {
    UrlEntity url = urlRepository.findById(id)
            .orElseThrow(() -> new UrlNotFoundException(id));

    if (url.getUrl() == null || url.getUrl().isEmpty()) {
        throw new IllegalStateException("URL cannot be null or empty");
    }

    System.out.println("Redirecting to URL: " + url.getUrl());

    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(URI.create(url.getUrl()));
    return headers;
}

}