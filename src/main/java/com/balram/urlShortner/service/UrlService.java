package com.balram.urlShortner.service;

import com.balram.urlShortner.domain.dto.url.UrlRequestDTO;
import com.balram.urlShortner.domain.dto.url.UrlResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;



public interface UrlService {

    UrlResponseDTO shortenUrl(UrlRequestDTO data, HttpServletRequest request);

    HttpHeaders redirect(String id);
}