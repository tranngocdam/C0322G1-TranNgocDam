use quan_ly_sinh_vien;
SELECT student.student_address, COUNT(student.student_id) AS 'Số lượng học viên'
FROM student
GROUP BY student_address;

SELECT S.student_id, S.student_name, AVG(mark)
FROM student S join mark m on S.student_id = m.student_id
GROUP BY S.student_id, S.student_name;

SELECT S.student_id,S.student_name, AVG(mark)
FROM student S join mark M on S.student_id = M.student_id
GROUP BY S.student_id, S.student_name