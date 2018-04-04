package com.example.composition.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String name;

    @OneToOne
    private Address address;

    public Employee(String name) {
        this.name = name;
    }
}
