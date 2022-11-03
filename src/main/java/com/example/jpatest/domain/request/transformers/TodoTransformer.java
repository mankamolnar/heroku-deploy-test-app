package com.example.jpatest.domain.request.transformers;

import com.example.jpatest.domain.entity.Todo;
import com.example.jpatest.domain.request.TodoCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoTransformer {

    @Autowired
    private UserTransformer userTransformer;

    public Todo transform(TodoCreationRequest todoRequest) {
        Todo todo = new Todo();

        todo.setFinished(todoRequest.isFinished());
        todo.setName(todoRequest.getName());
        todo.setUser(userTransformer.transform(todoRequest.getUser()));

        return todo;
    }
}
