package com.pl.springboot.mvc.jpa.dao;

import com.pl.springboot.mvc.jpa.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


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
    @Query("update User u set u.id_role =2 WHERE u.id_user =1")
    @Transactional
    void updateRole(int id_user, int id_role);
}
