package com.example.mapped;

import com.example.mapped.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Person person = new Person("zeshna", "male");
        person.setDrivingLicense(Boolean.TRUE);

        entityManager.persist(person);

        entityManager.getTransaction().commit();

        entityManager.close();

        entityManagerFactory.close();


    }

}
