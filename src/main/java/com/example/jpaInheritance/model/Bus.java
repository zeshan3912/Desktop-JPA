package com.example.jpaInheritance.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity

//used for single table
//@DiscriminatorValue(value = "bus")

//used for join table
//@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Bus extends Vechical {

    @Getter
    @Setter
    private Integer numberofPassangers;

    public Bus(String name, Integer numberofPassangers) {
        super(name);
        this.numberofPassangers = numberofPassangers;
    }

    public Bus() {

    }
}
