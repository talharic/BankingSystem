package com.example.bankingsystem.exception;

import com.example.bankingsystem.enums.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFountException extends RuntimeException {

    public ItemNotFountException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}
