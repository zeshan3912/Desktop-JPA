package com.example.jpaInheritance.model;

import lombok.Data;

import javax.persistence.*;

@Entity
//these two are used in single table
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "type")

// use for JOin table
//@Inheritance(strategy = InheritanceType.JOINED)

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@Data
public class Vechical {

    protected String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Vechical() {
    }

    public Vechical(String name) {
        this.name = name;
    }
}
