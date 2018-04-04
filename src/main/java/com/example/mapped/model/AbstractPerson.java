package com.example.mapped.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public abstract class AbstractPerson {

    protected Boolean drivingLicense;


}
