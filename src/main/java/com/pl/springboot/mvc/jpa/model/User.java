package com.pl.springboot.mvc.jpa.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "user")


@NamedQueries({
        @NamedQuery(name = "user.findIdByLoginAndPassword",
                query = "SELECT u FROM User u WHERE u.login = ?1 AND u.password = ?2"),
})


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_user;

    private String name;
    private String last_name;
    private String country;
    private String login;
    private String password;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_role")
    private Role role;
}
