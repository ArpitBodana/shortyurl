package com.tools.shortyurl.Repository;

import com.tools.shortyurl.models.UrlMappings;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShortyUrlRepository extends MongoRepository<UrlMappings, Long> {

    Optional<UrlMappings> findByOriginalUrl(String originalUrl);

    Optional<UrlMappings> findByShortyUrl(String shortyUrl);
}
