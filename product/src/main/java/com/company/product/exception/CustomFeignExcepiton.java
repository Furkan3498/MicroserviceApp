package com.company.product.exception;

public class CustomFeignExcepiton extends RuntimeException{

    public CustomFeignExcepiton(String message) {
        super(message);
    }
}
