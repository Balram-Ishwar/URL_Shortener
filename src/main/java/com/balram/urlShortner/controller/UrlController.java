package com.balram.urlShortner.controller;

import com.balram.urlShortner.domain.dto.url.UrlRequestDTO;
import com.balram.urlShortner.domain.dto.url.UrlResponseDTO;
import com.balram.urlShortner.service.UrlService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UrlController {
    @Autowired
    private UrlService urlService;

    @PostMapping("/shorten-url")
    public ResponseEntity<UrlResponseDTO> shortenUrl(@RequestBody UrlRequestDTO data, HttpServletRequest request){
        return ResponseEntity.ok(urlService.shortenUrl(data,request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> redirect(@PathVariable("id") String id) {
        System.out.println("Received ID: " + id); // Log the ID
        HttpHeaders headers = urlService.redirect(id);

        if (headers == null || !headers.containsKey(HttpHeaders.LOCATION)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
        }

        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
    }


}