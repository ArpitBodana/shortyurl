package com.tools.shortyurl.service;

import com.tools.shortyurl.Repository.ShortyUrlRepository;
import com.tools.shortyurl.exceptions.UrlNotFound;
import com.tools.shortyurl.models.UrlMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ShortyUrlService {

    @Autowired
    private ShortyUrlRepository shortyUrlRepository;

    private String generateShortyUrl() {
        return UUID.randomUUID().toString().substring(0, 6);
    }

    public String getShortyUrl(String url) {
        Optional<UrlMappings> exist = shortyUrlRepository.findByOriginalUrl(url);
        if (exist.isPresent()) {
            return exist.get().getShortyUrl();
        }

        String shortyUrl = generateShortyUrl();
        UrlMappings urlMappings = new UrlMappings();
        urlMappings.setShortyUrl(shortyUrl);
        urlMappings.setOriginalUrl(url);
        UrlMappings saved = shortyUrlRepository.save(urlMappings);
        return saved.getShortyUrl();
    }

    public UrlMappings getOriginalUrl(String url) {
        return shortyUrlRepository.findByShortyUrl(url).orElseThrow(() -> new UrlNotFound("Url not found."));
    }
}
