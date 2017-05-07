package com.pl.springboot.mvc.jpa.dao;

import com.pl.springboot.mvc.jpa.model.Mark;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface MarkDao extends CrudRepository<Mark,Long>{

    @Modifying
    @Transactional
    @Query("DELETE FROM Mark ma WHERE ma.name =?1")
    void removeByName(String name);

}
