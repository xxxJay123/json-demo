package com.example.jsondemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class JsonParsingException extends RuntimeException {
    public JsonParsingException(String message) {
        super(message);
    }
}