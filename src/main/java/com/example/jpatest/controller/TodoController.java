package com.example.jpatest.controller;

import com.example.jpatest.domain.request.TodoCreationRequest;
import com.example.jpatest.domain.response.TodoResponse;
import com.example.jpatest.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/get-all-todos")
    public List<TodoResponse> getAllTodos() {
        return todoService.findAll();
    }

    @PostMapping("/save-todo")
    public TodoResponse saveTodo(@RequestBody TodoCreationRequest todoCreationRequest) {
        return todoService.save(todoCreationRequest);
    }
}
