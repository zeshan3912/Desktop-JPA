package com.example.composition.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cityName;


    private String postalCode;

    @OneToOne
    private Employee employee;

    public Address() {
    }

    public Address(String cityName, String postalCode) {
        this.cityName = cityName;
        this.postalCode = postalCode;
    }
}
