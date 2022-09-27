create database mat_bang;
use mat_bang;
-- drop database mat_bang;
create table trang_thai(
trang_thai_id int primary key,
trang_thai_name varchar(45));

create table loai_mat_bang(
loai_mat_bang_id int primary key,
loai_mat_bang_name varchar(45));

create table mat_bang(
ma_mb varchar(45) primary key,
dien_tich double,
trang_thai_id int,
tang int,
loai_mat_bang_id int,
gia_cho_thue double,
ngay_bd date,
ngay_kt date,
foreign key (trang_thai_id) references trang_thai(trang_thai_id)ON DELETE CASCADE,
foreign key (loai_mat_bang_id) references loai_mat_bang(loai_mat_bang_id)ON DELETE CASCADE);

insert into trang_thai 
value
(1,"trống"), (2,"hạ tầng"), (3,"đầy đủ");

insert into loai_mat_bang 
value
(1, "văn phòng chia sẻ"),
(2, "văn phòng trọn gói");
select mb.ma_mb, mb.dien_tich, tt.trang_thai_name, mb.tang,lmb.loai_mat_bang_name, mb.gia_cho_thue, mb.ngay_bd, mb.ngay_kt from mat_bang mb
join trang_thai tt on mb.trang_thai_id=tt.trang_thai_id
join loai_mat_bang lmb on mb.loai_mat_bang_id=lmb.loai_mat_bang_id;


insert into mat_bang 
value
("mb001", 100, 1, 2, 1, 2099000, '2020-11-20', '2021-11-25'),
("mb002", 2402, 3, 5, 2, 5000000, '2020-04-03', '2020-10-03'),
("mb003", 240, 1, 15, 1, 5000000, '2020-04-03', '2020-10-03'),
("mb004", 250, 2, 5, 2, 5000000, '2020-04-03', '2020-10-03'),
("mb005", 240, 1, 6, 1, 5000000, '2020-04-03', '2020-10-03'),
("mb006", 330, 3, 5, 2, 7000000, '2020-04-03', '2020-10-03'),
("mb007", 240, 1, 2, 2, 5000000, '2020-04-03', '2020-10-03'),
("mb008", 660, 3, 5, 2, 2023200, '2020-04-03', '2020-10-03'),
("mb009", 240, 3, 8, 1, 5003300, '2020-04-03', '2020-10-03'),
("mb0010", 240, 1, 10, 2, 5000000, '2020-04-03', '2020-10-03'),
("mb0011", 340, 3, 3, 1, 5043400, '2020-04-03', '2020-10-03'),
("mb0012", 2320, 1, 9, 2, 7003430, '2020-04-03', '2020-10-03'),
("mb0013", 240, 3, 5, 2, 330000, '2020-04-03', '2020-10-03'),
("mb0014", 4340, 1, 5, 1, 1000000, '2020-04-03', '2020-10-03'),
("mb0015", 240, 2, 5, 2, 5000000, '2020-04-03', '2020-10-03'),
("mb0016", 230, 1, 8, 1, 1023200, '2020-04-03', '2020-10-03'),
("mb0017", 240, 3, 5, 1, 5000000, '2020-04-03', '2020-10-03'),
("mb0018", 5650, 3, 7, 1, 5034300, '2020-04-03', '2020-10-03'),
("mb0019", 240, 1, 5, 2, 5000000, '2020-04-03', '2020-10-03'),
("mb0020", 240, 2, 2, 1, 5004340, '2020-04-03', '2020-10-03'),
("mb0021", 450, 1, 5, 2, 2000000, '2020-04-03', '2020-10-03'),
("mb0022", 240, 1, 4, 1, 6008800, '2020-04-03', '2020-10-03'),
("mb0023", 2343, 2, 5, 1, 5420000, '2020-04-03', '2020-10-03'),
("mb0024", 240, 1, 9, 2, 5000000, '2020-04-03', '2020-10-03'),
("mb0025", 240, 3, 5, 2, 5023000, '2020-04-03', '2020-10-03'),
("mb0026", 3430, 1, 12, 1, 5004300, '2020-04-03', '2020-10-03'),
("mb0027", 240, 3, 4, 2, 5000000, '2020-04-03', '2020-10-03'),
("mb0028", 231, 1, 5, 1, 53440000, '2020-04-03', '2020-10-03'),
("mb0029", 240, 2, 2, 1, 5000000, '2020-04-03', '2020-10-03'),
("mb0030", 430, 1, 22, 2, 5440000, '2020-04-03', '2020-10-03');

select * from mat_bang 
where tang='3';
