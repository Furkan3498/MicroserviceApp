package com.company.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.company.payment.entity.enums.ErrorMessage.SERVER_ERROR;

@RestControllerAdvice
public class ErrorHander {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handle(NotFoundException exception) {
        return new ErrorResponse(exception.getMessage());
    }



    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handle(Exception exception) {
        return new ErrorResponse(SERVER_ERROR.getMessage());
    }

}
