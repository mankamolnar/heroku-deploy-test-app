package com.example.jpatest.service;

import com.example.jpatest.domain.entity.Todo;
import com.example.jpatest.domain.request.TodoCreationRequest;
import com.example.jpatest.domain.request.transformers.TodoTransformer;
import com.example.jpatest.domain.response.TodoResponse;
import com.example.jpatest.domain.response.transformers.TodoResponseTransformer;
import com.example.jpatest.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    @Autowired
    private TodoTransformer todoTransformer;

    @Autowired
    private TodoResponseTransformer todoResponseTransformer;

    public List<TodoResponse> findAll() {
        return todoResponseTransformer.transform(repository.findAll());
    }

    public TodoResponse save(TodoCreationRequest todoCreationRequest) {
        Todo todo = repository.save(todoTransformer.transform(todoCreationRequest));

        return todoResponseTransformer.transform(todo);
    }
}
