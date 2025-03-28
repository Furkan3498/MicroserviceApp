package com.company.orders.entity.enums;

public enum ErrorMessage {

    ORDER_NOT_FOUND("Order not found with id: %s"),
    CLIENT_ERROR("Client error occurred while making the request"),
    SERVER_ERROR_DECODER("Server error occurred while making the request"),
    SERVER_ERROR("Unexpected error occured");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
