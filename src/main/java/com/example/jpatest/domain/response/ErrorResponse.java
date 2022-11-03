package com.example.jpatest.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {
    private int errorCode;
    private String errorMessage;
}
