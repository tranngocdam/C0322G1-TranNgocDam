drop database if exists quan_ly_ban_hang;
create database quan_ly_ban_hang;
use quan_ly_ban_hang;

-- drop table if exists customer;
create table customer(
cID int,
cName varchar(50),
cAge int,
primary key(cID));

-- drop table if exists `order`;
create table `order`(
oID int,
cID int,
oDate date,
oTotalPrime double,
primary key(oID),
foreign key (cID) references customer(cID));

-- drop table if exists product;
create table product(
pID int,
pName varchar(50),
pPrime double,
primary key(pID));

-- drop table if exists orderDetail;
create table orderDetail(
oID int,
pID int,
odQTy int,
primary key(oID, pID),
foreign key (oID) references `order`(oID),
foreign key (pID) references product(pID));

