package com.tools.shortyurl.controller;

import com.tools.shortyurl.models.UrlMappings;
import com.tools.shortyurl.service.ShortyUrlService;
import com.tools.shortyurl.utils.UrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class ShortyController {

    @Autowired
    private ShortyUrlService service;

    @Autowired
    private UrlUtils utils;


    @PostMapping("/shorty")
    public ResponseEntity<String> shortUrl(@RequestBody String url) {
        String shortyUrl = service.getShortyUrl(url);
        String newUrl =utils.getUpdatedUrl(shortyUrl);
        return new ResponseEntity<>(newUrl, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{shortyUrl}")
    public ResponseEntity<String> originalUrl(@PathVariable("shortyUrl") String shortyUrl) {
        UrlMappings urlMappings = service.getOriginalUrl(shortyUrl);
        String originalUrl = urlMappings.getOriginalUrl();
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(originalUrl)).build();
    }
}
