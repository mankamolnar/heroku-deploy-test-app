package com.example.jpatest.domain.request.transformers;

import com.example.jpatest.domain.entity.User;
import com.example.jpatest.domain.request.TodoCreationUserRequest;
import org.springframework.stereotype.Service;

@Service
public class UserTransformer {

    public User transform(TodoCreationUserRequest userRequest) {
        User user = new User();

        user.setId(userRequest.getId());

        return user;
    }
}
