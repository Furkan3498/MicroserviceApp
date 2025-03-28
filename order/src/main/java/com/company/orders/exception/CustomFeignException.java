package com.company.orders.exception;

public class CustomFeignException extends RuntimeException{

    private final Integer status;

    public CustomFeignException(Integer status,String message ) {
        super(message);
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
