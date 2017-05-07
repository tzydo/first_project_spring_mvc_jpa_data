package com.pl.springboot.mvc.jpa.dao;

import com.pl.springboot.mvc.jpa.model.ProductType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ProductTypeDao extends CrudRepository<ProductType, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM ProductType pt WHERE pt.name =?1")
    void removeByName(String name);

}
