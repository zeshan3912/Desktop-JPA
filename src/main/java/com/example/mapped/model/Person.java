package com.example.mapped.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Person extends AbstractPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String gender;

    public Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }
}
