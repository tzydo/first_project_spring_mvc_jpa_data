package com.pl.springboot.mvc.jpa.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Data

@NamedQuery(name = "Product.getProductById",
            query = "SELECT p FROM Product p where p.id_product =?1")
public class Product implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_product;

    private String product_type;
    private String mark;
    private String model;
    private int count;
    private int price;
    private String description;

}
