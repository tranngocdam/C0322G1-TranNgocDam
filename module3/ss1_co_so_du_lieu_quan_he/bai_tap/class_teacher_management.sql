CREATE DATABASE student_management;
USE student_management;
DROP DATABASE student_management;

CREATE TABLE class (
class_id int NOT NULL primary key,
class_name varchar(50) );

CREATE TABLE student (
id int NOT NULL primary key,
student_name varchar(50),
age int NULL,
country varchar(45) NULL,
class_id int,
FOREIGN KEY (class_id) REFERENCES class(class_id));
DROP TABLE student;

CREATE TABLE teacher (
teacher_id int NOT NULL primary key,
teacher_name varchar(50),
teacher_age int NULL,
teacher_country varchar(50),
class_id int,
FOREIGN KEY (class_id) REFERENCES class(class_id));
DROP TABLE teacher;