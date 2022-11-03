package com.example.jpatest.configartion;

import com.example.jpatest.domain.entity.Todo;
import com.example.jpatest.domain.entity.User;
import com.example.jpatest.repository.TodoRepository;
import com.example.jpatest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.util.Date;

@Configuration
public class DbSeedConfiguration {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoRepository todoRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void seedTest() {
        System.out.println("run seeding service.");

        User user = new User();
        user.setActive(true);
        user.setBirthday(new Date());
        user.setMoney(1000);
        user.setName("Sanyi");

        Todo todo = new Todo();
        todo.setName("Menj boltba");
        todo.setFinished(false);
        todo.setUser(user);

        todoRepository.save(todo);

    }
}

