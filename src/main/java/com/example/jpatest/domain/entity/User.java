package com.example.jpatest.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private int money;

    private Date birthday;

    private boolean active;

    @OneToMany(mappedBy = "user")
    private List<Todo> todos;
}

/**
 *
 * {
 *     nev: sanyi
 *     todos: [
 *          {
 *              nev: menj el a bankba
 *              user: {
 *                  nev: sanyi
 *                  todos: [
 *                      {
 *                          nev: menj el a bankba
 *                          ....
 *                      }
 *                  ]
 *              }
 *          }
 *     ]
 * }
 *
 *
 */