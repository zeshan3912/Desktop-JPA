**How to Work with JPA** 

First we will see how to fetch data using JDBC

and how to create database in sql, how to create table and also insert data into table

what is JPA and why we need JPA?

In simple word JPA is Java Persistence API, JPA is Specification that describe the management of relational Database
 
In JAP we map java objects on database object which we call Object Relational Mapping

for that we can use xml or annotation configuration I like annotation configuration

Most of the time we use these annotations

@Entity ==> Declares the class as entity

@Table ==> Declares the Table name if we did not put that on class by default class name will be table name  

@Id ==> specifies the property identify as primary key on the table

@Transient ==> the property marked as transient is not going to store in DB

for Relation ship b/w tables we use three annotations

@OneToONE
@ONETOMany and last one @ManyTOMany

with Entity class we can generate tables in DB





