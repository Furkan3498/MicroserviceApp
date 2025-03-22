package com.company.payment.entity.enums;

public enum ErrorMessage {

    SERVER_ERROR("Unexpected Error Occurred");

    private final  String message;

    ErrorMessage(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }
}
