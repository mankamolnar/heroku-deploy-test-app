package com.example.jpatest.controller;

import com.example.jpatest.domain.entity.User;
import com.example.jpatest.domain.exception.UserNotFoundException;
import com.example.jpatest.domain.projection.UserWithTodoSize;
import com.example.jpatest.domain.response.UserResponse;
import com.example.jpatest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/add-user")
    public boolean addUser(@RequestBody User user) {
        userService.saveAll(List.of(user));

        return true;
    }

    @GetMapping("/get-user-by-id/{id}")
    public UserResponse findById(@PathVariable long id) throws UserNotFoundException {
        return userService.findById(id);
    }

    @GetMapping("/get-user/{id}")
    public UserWithTodoSize getUser(@PathVariable long id) {
        return userService.findUserWithTodoSizeById(id);
    }

    @GetMapping("/get-user-failing")
    public UserResponse getFailingUser() throws Exception {
        throw new UserNotFoundException("Failed request! Try again later.");
    }
}
