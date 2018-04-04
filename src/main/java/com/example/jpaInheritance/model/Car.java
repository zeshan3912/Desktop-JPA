package com.example.jpaInheritance.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity

//used for single table
//@DiscriminatorValue(value = "car")

//used for join table
//@PrimaryKeyJoinColumn(referencedColumnName = "id")
@Data
public class Car extends Vechical {

    private Integer speed;


    public Car(Integer speed, String name) {
        super(name);
        this.speed = speed;
    }

    public Car() {
    }
}
