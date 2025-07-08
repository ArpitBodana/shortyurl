package com.tools.shortyurl.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document(collection = "urlmappings")
public class UrlMappings {
    @Id
    private String  id;
    private String originalUrl;
    private String shortyUrl;

    @CreatedDate
    private Date createdAt;

    public UrlMappings() {

    }

    public UrlMappings(String originalUrl, String shortyUrl) {
        this.originalUrl = originalUrl;
        this.shortyUrl = shortyUrl;
    }

    public UrlMappings(String  id, String originalUrl, String shortyUrl) {
        this.id = id;
        this.originalUrl = originalUrl;
        this.shortyUrl = shortyUrl;
    }

    public String  getId() {
        return id;
    }

    public void setId(String  id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortyUrl() {
        return shortyUrl;
    }

    public void setShortyUrl(String shortyUrl) {
        this.shortyUrl = shortyUrl;
    }


}
