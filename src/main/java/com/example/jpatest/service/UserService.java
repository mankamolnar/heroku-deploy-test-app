package com.example.jpatest.service;

import com.example.jpatest.domain.entity.User;
import com.example.jpatest.domain.exception.UserNotFoundException;
import com.example.jpatest.domain.projection.UserWithTodoSize;
import com.example.jpatest.domain.response.UserResponse;
import com.example.jpatest.domain.response.transformers.UserResponseTransformer;
import com.example.jpatest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserResponseTransformer userResponseTransformer;

    public Optional<User> userByName(String name) {
        return userRepository.findByName(name);
    }

    public void save(User users) {
        userRepository.save(users);
    }

    public void saveAll(List<User> users) {
        userRepository.saveAll(users);
    }

    public UserResponse findById(long id) throws UserNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("user not found!"));

        return userResponseTransformer.transform(user);
    }

    public UserWithTodoSize findUserWithTodoSizeById(long id) {
        return userRepository.getUserWithTodoSize(id);
    }
}
