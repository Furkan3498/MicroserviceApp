package com.company.product.exception;

public class InsufficientQuantityException extends RuntimeException{

    public InsufficientQuantityException(String message){
        super(message);

    }
}
