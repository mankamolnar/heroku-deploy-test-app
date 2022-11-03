package com.example.jpatest.domain.response.transformers;

import com.example.jpatest.domain.entity.User;
import com.example.jpatest.domain.response.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserResponseTransformer {

    public UserResponse transform(User user) {
        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setActive(user.isActive());
        response.setBirthday(user.getBirthday());
        response.setMoney(user.getMoney());
        response.setName(user.getName());

        return response;
    }
}
