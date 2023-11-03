package com.example.gasolineraspring.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseDTO {
    @JsonProperty("success")
    private boolean success;
    @JsonProperty("message")
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
