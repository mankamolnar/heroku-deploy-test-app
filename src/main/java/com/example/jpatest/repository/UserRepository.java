package com.example.jpatest.repository;

import com.example.jpatest.domain.entity.User;
import com.example.jpatest.domain.projection.UserWithTodoSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select user.id as id, user.name as name, user.money as money, user.birthday as birthday, user.active as active, count(todo.id) as todoNumber " +
            "from User user " +
            "inner join user.todos as todo " +
            "where user.id = :id " +
            "group by user.id")
    UserWithTodoSize getUserWithTodoSize(@Param("id") long id);



    Optional<User> findByName(String kjaflskj);
    List<User> findAllByActiveTrue();
    Optional<User> findByNameIgnoreCase(String kjaflskj);
    Optional<User> findByNameIn(List<String> names);
    Optional<User> findByNameNotIn(List<String> names);

    Optional<User> findByNameStartingWith(String kjaflskj);
    Optional<User> findByNameEquals(String kjaflskj);
    List<User> findAllByBirthdayBetween(Date from, Date to);
    List<User> findAllByMoneyLessThan(int money);
    List<User> findAllByNameIsNull();
    List<User> findAllByBirthdayBetweenOrderByIdDesc(Date from, Date to);
    List<User> findAllByBirthdayBetweenOrderByBirthdayDescIdAsc(Date from, Date to);

}
