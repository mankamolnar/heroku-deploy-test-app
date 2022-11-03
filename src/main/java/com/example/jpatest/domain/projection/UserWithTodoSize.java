package com.example.jpatest.domain.projection;

import java.util.Date;

public interface UserWithTodoSize {
    long getId();
    String getName();
    int getMoney();
    Date getBirthday();
    boolean isActive();
    int getTodoNumber();
}
