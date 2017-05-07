package com.pl.springboot.mvc.jpa.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "mark")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "Mark.getMarkById",
        query = "Select ma From Mark ma Where ma.id_mark = ?1")
public class Mark implements Serializable{

    @Id
    @Column(name = "id_mark")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_mark;

    private String name;
}
