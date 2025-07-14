package com.tools.shortyurl.controller;

import com.tools.shortyurl.models.DTOs.ResultBody;
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
    public ResponseEntity<ResultBody> shortUrl(@RequestBody String url) {
        String shortyUrl = service.getShortyUrl(url);
        String newUrl =utils.getUpdatedUrl(shortyUrl);
        ResultBody resultBody = new ResultBody();
        resultBody.setShortyLink(newUrl);
        resultBody.setOriginalLink(url);
        return new ResponseEntity<>(resultBody, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{shortyUrl}")
    public ResponseEntity<String> originalUrl(@PathVariable("shortyUrl") String shortyUrl) {
        String originalUrl = service.getOriginalUrl(shortyUrl);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(originalUrl)).build();
    }
}
