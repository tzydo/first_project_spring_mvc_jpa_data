package com.pl.springboot.mvc.jpa.dao;


import com.pl.springboot.mvc.jpa.model.Product;
import org.springframework.data.repository.CrudRepository;


public interface ProductDao extends CrudRepository<Product,Long>{

}
