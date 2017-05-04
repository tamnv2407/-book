drop table if exists `book`;
CREATE TABLE book(
   id INT NOT NULL AUTO_INCREMENT,
   title VARCHAR(100) NOT NULL,
   author VARCHAR(40) NOT NULL,
   description VARCHAR(200),
   date_create DATE,
   date_update DATE,
   PRIMARY KEY ( id )
);
drop table if exists `role`;
CREATE TABLE role(
   role_key INT NOT NULL AUTO_INCREMENT,
   role_type VARCHAR(50) NOT NULL,
   PRIMARY KEY ( role_key )
);
drop table if exists `user`;
CREATE TABLE user(
   id INT NOT NULL AUTO_INCREMENT,
   email VARCHAR(100) NOT NULL,
   password VARCHAR(100) NOT NULL,
   firstName VARCHAR(50),
   lastName VARCHAR(50),
   role_key int,
   PRIMARY KEY ( id )
);