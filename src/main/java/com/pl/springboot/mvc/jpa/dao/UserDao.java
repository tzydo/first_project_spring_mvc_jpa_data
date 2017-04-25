package com.pl.springboot.mvc.jpa.dao;

import com.pl.springboot.mvc.jpa.model.Role;
import com.pl.springboot.mvc.jpa.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Native;


public interface UserDao extends CrudRepository<User,Integer> {
    User findByLoginAndPassword(String login, String password);

    @Modifying
    @Transactional
    @Query("update User u set u.name =?2 WHERE u.id_user =?1")
    void updateName(int id, String name);

    @Modifying
    @Transactional
    @Query("update User u set u.last_name =?2 WHERE u.id_user =?1")
    void updateLastName(int id_user, String LastName);

    @Modifying
    @Query("update User u set u.role =?2 WHERE u.id_user =?1")
    @Transactional
    void updateRole(int id_user, Role role);

    @Modifying
    @Transactional
    @Query("update User u set u.country =?2 WHERE u.id_user = ?1")
    void updateCountry(int id_user, String country);

    @Modifying
    @Transactional
    @Query("update User u set u.login =?2 WHERE u.id_user = ?1")
    void updateLogin(int id_user, String login);

    @Modifying
    @Transactional
    @Query("update User u set u.password =?2 WHERE u.id_user = ?1")
    void updatePassword(int id_user, String password);

}
