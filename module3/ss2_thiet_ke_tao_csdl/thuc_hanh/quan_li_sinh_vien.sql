CREATE DATABASE quan_ly_sinh_vien;
USE quan_ly_sinh_vien;
-- drop database quan_ly_sinh_vien;
CREATE TABLE class(
    class_id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    class_name VARCHAR(60) NOT NULL,
    startDate DATETIME    NOT NULL,
    status    BIT
);

CREATE TABLE student(
    student_id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    student_name VARCHAR(30) NOT NULL,
    student_address     VARCHAR(50),
    student_phone       VARCHAR(20),
    status      BIT,
    class_id     INT         NOT NULL,
    FOREIGN KEY (class_id) REFERENCES class(class_id)
);

CREATE TABLE subject(
    sub_id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sub_name VARCHAR(30) NOT NULL,
    credit  TINYINT     NOT NULL DEFAULT 1 CHECK ( Credit >= 1 ),
    status  BIT                  DEFAULT 1
);

CREATE TABLE mark(
    mark_id    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sub_id     INT NOT NULL,
    student_id INT NOT NULL,
    mark      FLOAT   DEFAULT 0 CHECK ( Mark BETWEEN 0 AND 100),
    ExamTimes TINYINT DEFAULT 1,
    UNIQUE (sub_id, student_id),
    FOREIGN KEY (sub_id) REFERENCES subject(sub_id),
    FOREIGN KEY (student_id) REFERENCES student(student_id)
);

insert into class
value 
(1, 'A1', '2008-12-08', 1), 
(2, 'A2', '2008-12-22', 1),
(3, 'B3', current_date(), 0);

insert into student(student_id, student_name, student_address, student_phone, status, class_id)
value
(1, 'Hung', 'Ha Noi', '0912113113', 1, 1), 
(2, 'Hoa', 'Hai phong', null, 1, 1),
(3, 'Manh', 'HCM', '0123123123', 0, 2);
-- insert into student(studen_id, student_name, student_address, student_phone, status, class_id)
-- value 

 
insert into subject
value
(1, 'CF', 5, 1), 
(2, 'C', 6, 1), 
(3, 'HDJ', 5, 1), 
(4, 'RDBMS', 10, 1);

insert into mark(mark_id, sub_id, student_id, mark, ExamTimes)
value
(1, 1, 1, 8, 1), 
(2, 1, 2, 10, 2), 
(3, 2, 1, 12, 1);

select * from student
where (student_name like 'h%');

select * from class
where (month(startDate)='12');

select subject.sub_name from subject
where credit between 3 and 5;

set sql_safe_updates=0;
update student
set class_id='2'
where (student.student_name='Hung');
set sql_safe_updates=1;

select student.student_name, mark.mark, subject.sub_name from student
join mark on student.student_id = mark.student_id
join subject on subject.sub_id = mark.sub_id
order by mark.mark desc, subject.sub_name
