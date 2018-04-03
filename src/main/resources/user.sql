/*
create database
*/
CREATE database test2;

/*
use that database
*/

use test2;

/*
create user table
*/

CREATE table test_user (
  id     int not null AUTO_INCREMENT,
  email  varchar(255),
  gender varchar(6),
  primary key (id)
);

/***
*
* insert data into table
*/

insert into test_user (email, gender)
VALUES ("don.leffler@parisian.net", "male"),
  ("weston92@hotmail.com", "female"),
  ("celia17@hotmail.com", "male"),
  ("mozell.effertz@yahoo.com", "female"),
  ("mtromp@hotmail.com", "female"),
  ("elmer08@green.com", "male");


/**
  check all the data is inserted into table
*/

select *
from test_user;