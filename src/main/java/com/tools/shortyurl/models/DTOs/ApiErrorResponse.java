package com.tools.shortyurl.models.DTOs;

public class ApiErrorResponse {
    private Integer status;
    private String message;

    public ApiErrorResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public ApiErrorResponse() {

    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
