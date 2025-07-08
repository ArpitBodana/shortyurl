package com.tools.shortyurl.exceptions;

import com.tools.shortyurl.models.DTOs.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UrlNotFound.class)
    public ResponseEntity<ApiErrorResponse> handleUrlNotFound(UrlNotFound ex) {
        ApiErrorResponse res = new ApiErrorResponse();
        res.setStatus(404);
        res.setMessage(ex.getMessage());
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrorResponse> globalHandler(RuntimeException rex) {
        ApiErrorResponse res = new ApiErrorResponse();
        res.setStatus(500);
        res.setMessage(rex.getMessage());
        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
