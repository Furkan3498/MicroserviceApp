package com.company.product.entity.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;




public enum ErrorMessage {
    PRODUCT_NOT_FOUND("Product not found with id: %s"),
    INSUFFICIENT_QUANTITY("Insufficient quantity for product with id: %s"),
    SERVER_ERROR("Unexpected error occurred"),
    CLIENT_ERROR("Client error occurred while making the request"),
    SERVER_ERROR_DECODER("Server error occurred while making the request");



    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}