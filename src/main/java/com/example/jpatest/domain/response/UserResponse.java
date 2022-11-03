package com.example.jpatest.domain.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class UserResponse {
    private long id;
    private String name;
    private int money;
    private Date birthday;
    private boolean active;
}
