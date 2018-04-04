package com.example.simpleJpa;

import com.example.simpleJpa.model.User;

import javax.persistence.*;
import java.util.List;


public class App {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void main(String[] args) {

        entityManagerFactory = Persistence.createEntityManagerFactory("example");
        entityManager = entityManagerFactory.createEntityManager();
        App app = new App();
        app.baseOperations();
        app.basicJPQL();

        app.nativeQuery();

        app.namedQuery();

        entityManager.close();
        entityManagerFactory.close();

    }


    private void namedQuery() {
        // transaction is already from JPQL

        //Query query=entityManager.createNamedQuery("user.getAll");

        TypedQuery<User> query = entityManager.createNamedQuery("user.getAll", User.class);

        //List<User> users=(List<User>)query.getResultList();
        List<User> users = query.getResultList();
        System.out.println("named Query  " + users);

    }


    private void nativeQuery() {

//        Query query=entityManager.createNativeQuery("SELECT  * FROM test_user where age<30",User.class);

        Query query = entityManager.createNativeQuery("SELECT  * FROM test_user where age between 16 and 25", User.class);

        List<User> users = (List<User>) query.getResultList();

        System.out.println("\nnative:  " + users);


    }


    private void basicJPQL() {

//        EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("example");
//
//        EntityManager entityManager=entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        //Query query=entityManager.createQuery("SELECT u from User u'");
        //Query query=entityManager.createQuery("SELECT u from User u where u.gender='female'");
        //Query query=entityManager.createQuery("SELECT u from User u order by u.age asc");

        Query query = entityManager.createQuery("SELECT u from User u where u.gender='male' order by u.age asc");
        List<User> users = query.getResultList();

        System.out.println(users);

//        for(User user: users){
//
//            System.out.println(user);
//
//        }

    }

    private void baseOperations() {

//        EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("example");
//
//        EntityManager  entityManager=entityManagerFactory.createEntityManager();

        /**
         * How to create user
         * */
        entityManager.getTransaction().begin();

        User user = new User("test@test.com", "male", 26);
        User user3 = new User("test1@test.com", "female", 18);
        User user4 = new User("test1@test.com", "female", 35);
        User user5 = new User("test2@test.com", "male", 40);
        User user6 = new User("test3@test.com", "male", 80);


        entityManager.persist(user);
        entityManager.persist(user3);
        entityManager.persist(user4);
        entityManager.persist(user5);
        entityManager.persist(user6);

        entityManager.getTransaction().commit();


        /*
         * Find user with the help of Id
         * */
        entityManager.getTransaction().begin();

        User user1 = entityManager.find(User.class, 1L);

        System.out.println("retrieved user  " + user1);

        /**
         * Update user
         * */

        user1.setGender("Female");

        entityManager.persist(user1);

        entityManager.getTransaction().commit();


        /*
         * find the updated entity
         * */
        User user2 = entityManager.find(User.class, 1L);

        System.out.println("updated user " + user2);

        /**
         * Remove user after this check the DB you will see that user is removed from DB
         * */

        entityManager.getTransaction().begin();

        entityManager.remove(user2);

        entityManager.getTransaction().commit();


        /*
         * Close the entityManager and entityManagerFactory
         * */
//        entityManager.close();
//
//        entityManagerFactory.close();

    }


}
