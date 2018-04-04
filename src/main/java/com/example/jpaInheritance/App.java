package com.example.jpaInheritance;


import com.example.jpaInheritance.model.Bus;
import com.example.jpaInheritance.model.Car;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();


        Bus bus = new Bus("N bus", 54);

        Car car = new Car(200, "Nissan");

        entityManager.persist(bus);
        entityManager.persist(car);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();


    }


}