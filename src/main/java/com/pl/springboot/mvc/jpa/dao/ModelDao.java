package com.pl.springboot.mvc.jpa.dao;

import com.pl.springboot.mvc.jpa.model.Modell;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ModelDao extends CrudRepository<Modell,Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Modell mo WHERE mo.name =?1")
    void removeByName(String name);
}
