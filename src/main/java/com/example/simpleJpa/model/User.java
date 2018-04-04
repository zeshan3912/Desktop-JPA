package com.example.simpleJpa.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "test_user")
@Data
@NamedQueries({@NamedQuery(name = "user.getAll", query = "SELECT u from User u"),
        @NamedQuery(name = "user.getUserById", query = "SELECT u from User u where u.id=:id")})

public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "gender", length = 6)
    private String gender;

    @Transient
    private String msg;

    private Integer age;

    public User() {
    }

    public User(String email, String gender, Integer age) {
        this.email = email;
        this.gender = gender;
        this.age = age;
    }
}
