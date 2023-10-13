package com.example.bankingsystem.enums;

public enum ErrorMessage {

    CUSTOMER_ERROR_MESSAGE("Customer Not Found"),
    ;

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
