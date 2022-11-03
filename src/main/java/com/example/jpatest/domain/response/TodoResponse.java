package com.example.jpatest.domain.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
public class TodoResponse {
    private int id;
    private String name;
    private boolean finished;
    private UserResponse user;
}
