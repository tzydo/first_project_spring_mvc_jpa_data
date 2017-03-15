package com.pl.springboot.mvc.jpa.dao;

import com.pl.springboot.mvc.jpa.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Integer> {
    User findByLoginAndPassword(String login, String password);
}
