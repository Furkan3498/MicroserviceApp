package com.company.payment.entity.enums;

public enum ErrorMessage {

    SERVER_ERROR("Unexpected Error Occurred"),
    PAYMENT_NOT_FOUND("Payment not found with order id: %s");

    private final  String message;

    ErrorMessage(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }
}
