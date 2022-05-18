drop database if exists quan_ly_ban_hang;
create database quan_ly_ban_hang;
use quan_ly_ban_hang;

create table customer(
cID int,
cName varchar(50),
cAge int,
primary key(cID));

create table `order`(
oID int,
cID int,
oDate date,
oTotalPrime double,
primary key(oID),
foreign key (cID) references customer(cID));

create table product(
pID int,
pName varchar(50),
pPrime double,
primary key(pID));

create table orderDetail(
oID int,
pID int,
odQTy int,
primary key(oID, pID),
foreign key (oID) references `order`(oID),
foreign key (pID) references product(pID));

insert into customer
value(1, 'Minh Quan', 10), (2, 'Ngoc Anh', 20), (3, 'Hong Ha', 50);

insert into `order`
value(1, 1 , '2006-03-21', null), (2, 2, '2006-03-23', null), (3, 1, '2006-03-16', null);

insert into product
value(1, 'May Giac', 3), (2, 'Tu Lanh', 5), (3, 'Dieu Hoa', 7), (4, 'Quat', 1), (5, 'Bep Dien', 2);

insert into orderDetail
value(1, 1, 3), (1, 3, 7), (1, 4, 2), (2, 1, 1), (3, 1, 8), (2, 5, 4), (2, 3, 3);

select `order`.oID, `order`.oDate, product.pPrime from `order`
join  orderDetail on `order`.oID = orderDetail.oID
join product on product.pID = orderDetail.pID;

select customer.cID, customer.cName, product.pName from customer
join `order` on customer.cID = `order`.cID
join orderDetail on `order`.oID = orderDetail.oID
join product on product.pID = orderDetail.pID;

select cName from customer
where cName not in (
	select customer.cName from customer 
	join `order` on customer.cID = `order`.cID
	join orderDetail on `order`.oID = orderDetail.oID
	join product on product.pID = orderDetail.pID
	group by customer.cName
);

select `order`.oID, `order`.oDate, sum(orderDetail.odQTy*product.pPrime) as oTotalPrime from `order`
join orderDetail on `order`.oID = orderDetail.oID
join product on product.pID = orderDetail.pID
group by `order`.oID