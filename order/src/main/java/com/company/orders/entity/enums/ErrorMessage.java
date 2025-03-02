package com.company.orders.entity.enums;

public enum ErrorMessage {

    ORDER_NOT_FOUND("Order not found with id: %s");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
