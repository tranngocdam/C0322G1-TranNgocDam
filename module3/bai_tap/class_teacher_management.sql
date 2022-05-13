CREATE DATABASE student_management;
USE student_management;
DROP DATABASE student_management;

CREATE TABLE class (
class_id int NOT NULL primary key,
class_name varchar(50) );

CREATE TABLE student (
student_id int NOT NULL,
student_name varchar(50),
student_age int NULL,
student_country varchar(45) NULL,
class_id int,
FOREIGN KEY (class_id) REFERENCES class(class_id));
DROP TABLE student;

CREATE TABLE teacher (
teacher_id int NOT NULL,
teacher_name varchar(50),
teacher_age int NULL,
teacher_country varchar(50),
class_id int,
FOREIGN KEY (class_id) REFERENCES class(class_id));
DROP TABLE teacher;