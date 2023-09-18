package com.example.jsondemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MissingApiException extends RuntimeException {
    public MissingApiException(String message) {
        super(message);
    }
}