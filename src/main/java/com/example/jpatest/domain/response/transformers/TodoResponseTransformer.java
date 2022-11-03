package com.example.jpatest.domain.response.transformers;

import com.example.jpatest.domain.entity.Todo;
import com.example.jpatest.domain.response.TodoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoResponseTransformer {

    @Autowired
    private UserResponseTransformer userResponseTransformer;

    public TodoResponse transform(Todo todo) {
        TodoResponse response = new TodoResponse();

        response.setId(todo.getId());
        response.setFinished(todo.isFinished());
        response.setName(todo.getName());
        response.setUser(userResponseTransformer.transform(todo.getUser()));

        return response;
    }

    public List<TodoResponse> transform(List<Todo> todos) {
        List<TodoResponse> responses = new ArrayList<>();

        for (Todo todo : todos) {
            responses.add(transform(todo));
        }

        return responses;
    }
}
