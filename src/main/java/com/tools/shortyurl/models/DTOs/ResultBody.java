package com.tools.shortyurl.models.DTOs;

public class ResultBody {

    private String originalLink;
    private String shortyLink;

    public ResultBody(String originalLink, String shortyLink) {
        this.originalLink = originalLink;
        this.shortyLink = shortyLink;
    }

    public ResultBody() {
    }

    public String getOriginalLink() {
        return originalLink;
    }

    public void setOriginalLink(String originalLink) {
        this.originalLink = originalLink;
    }

    public String getShortyLink() {
        return shortyLink;
    }

    public void setShortyLink(String shortyLink) {
        this.shortyLink = shortyLink;
    }
}
