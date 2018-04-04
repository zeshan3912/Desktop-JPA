package com.example.composition;

import com.example.composition.model.Address;
import com.example.composition.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Employee employee = new Employee("Zeshan");

        Address address = new Address("Edmonton", "T5b3b5");

        employee.setAddress(address);
        address.setEmployee(employee);

        entityManager.persist(employee);
        entityManager.persist(address);

        entityManager.getTransaction().commit();

        entityManager.close();

        entityManagerFactory.close();
    }

}
