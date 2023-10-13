package com.example.bankingsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFountException extends RuntimeException {

    public ItemNotFountException(String message) {
        super(message);
    }
}
