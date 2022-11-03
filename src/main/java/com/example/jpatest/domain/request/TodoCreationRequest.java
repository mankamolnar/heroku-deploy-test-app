package com.example.jpatest.domain.request;

import com.example.jpatest.domain.response.UserResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TodoCreationRequest {
    private int id;
    private String name;
    private boolean finished;
    private TodoCreationUserRequest user;
}
