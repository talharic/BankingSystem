package com.example.bankingsystem.enums;

public enum ErrorMessage {

    ITEM_ERROR_MESSAGE("Item Not Found"),
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
