drop database if exists quan_ly_ban_hang;
create database quan_ly_ban_hang;
use quan_ly_ban_hang;

create table customer(
c_id int,
c_name varchar(50),
c_age int,
primary key(c_id));

create table `order`(
o_id int,
c_id int,
o_date date,
o_total_prime double,
primary key(o_id),
foreign key (c_id) references customer(c_id));

create table product(
p_id int,
p_name varchar(50),
p_prime double,
primary key(p_id));

create table order_detail(
o_id int,
p_id int,
od_QTy int,
primary key(o_id, p_id),
foreign key (o_id) references `order`(o_id),
foreign key (p_id) references product(p_id));

insert into customer
value(1, 'Minh Quan', 10), (2, 'Ngoc Anh', 20), (3, 'Hong Ha', 50);

insert into `order`
value(1, 1 , '2006-03-21', null), (2, 2, '2006-03-23', null), (3, 1, '2006-03-16', null);

insert into product
value(1, 'May Giac', 3), (2, 'Tu Lanh', 5), (3, 'Dieu Hoa', 7), (4, 'Quat', 1), (5, 'Bep Dien', 2);

insert into order_detail
value(1, 1, 3), (1, 3, 7), (1, 4, 2), (2, 1, 1), (3, 1, 8), (2, 5, 4), (2, 3, 3);

select `order`.o_id, `order`.o_date, product.p_prime from `order`
join  order_detail on `order`.o_id = order_detail.o_id
join product on product.p_id = order_detail.p_id;

select customer.c_id, customer.c_name, product.p_name from customer
join `order` on customer.c_id = `order`.c_id
join order_detail on `order`.o_id = order_detail.o_id
join product on product.p_id = order_detail.p_id;

select c_name from customer
where c_name not in (
	select customer.c_name from customer 
	join `order` on customer.c_id = `order`.c_id
	join order_detail on `order`.o_id = order_detail.o_id
	join product on product.p_id = order_detail.p_id
	group by customer.c_name
);

select `order`.o_id, `order`.o_date, sum(order_detail.od_QTy*product.p_prime) as o_total_prime from `order`
join order_detail on `order`.o_id = order_detail.o_id
join product on product.p_id = order_detail.p_id
group by `order`.o_id