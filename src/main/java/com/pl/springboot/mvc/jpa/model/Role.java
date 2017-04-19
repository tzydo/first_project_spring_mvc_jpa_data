package com.pl.springboot.mvc.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "role")

@NamedQueries({
        @NamedQuery(name = "Role.getRoleByIdRole",
                query = "select r FROM Role r where r.id_role = ?1 "),

        @NamedQuery(name = "Role.getRoleByRoleName",
                query = "select r From Role r where r.name = ?1 "),
})

public class Role implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_role;

    private String name;
}
