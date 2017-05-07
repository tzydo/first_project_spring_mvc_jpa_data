package com.pl.springboot.mvc.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "model")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Modell implements Serializable {

    @Id
    @Column(name = "id_model")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_model;

    private String name;
}



