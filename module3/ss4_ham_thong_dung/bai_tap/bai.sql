use quan_ly_sinh_vien;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần

select * from subject
where credit=(select max(credit) from subject);

select subject.sub_id, subject.sub_name, subject.credit, subject.status, mark.mark from subject
join mark on subject.sub_id = mark.sub_id
where mark.mark=(select max(mark.mark) from mark);

select student.student_id, student.student_name, student.student_address, student.student_phone, student.status,
avg(mark.mark) as tb from student
join mark on student.student_id = mark.student_id
group by student.student_id, student.student_name, student.student_address, student.student_phone, student.status
order by mark.mark desc ;
select * from student;
select * from mark


