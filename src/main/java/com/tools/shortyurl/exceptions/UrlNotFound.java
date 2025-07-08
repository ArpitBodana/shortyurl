package com.tools.shortyurl.exceptions;

public class UrlNotFound extends RuntimeException{
    public UrlNotFound(String msg){
        super(msg);
    }
}
