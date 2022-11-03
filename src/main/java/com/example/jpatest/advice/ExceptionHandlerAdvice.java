package com.example.jpatest.advice;

import com.example.jpatest.domain.exception.UserNotFoundException;
import com.example.jpatest.domain.response.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public ErrorResponse handleException(Exception e, WebRequest request) {
        ErrorResponse response = new ErrorResponse(100, e.getMessage());

        return response;
    }
}
