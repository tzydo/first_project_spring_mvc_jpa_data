package com.pl.springboot.mvc.jpa.dao;


import com.pl.springboot.mvc.jpa.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleDao extends CrudRepository<Role,Long>{
    public Role getRoleByIdRole(int id);
}
