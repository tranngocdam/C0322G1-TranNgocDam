create database products;
drop database products;
use products;
create table product(
id int primary key,
product_code varchar(50),
product_name varchar(50),
product_price double,
product_amount int,
product_description varchar(50),
product_status bit);

insert into product
value
(1, 'a32', 'kẹo', 23223.2, 34, 'ok', 1),
(2, null, 'bánh', 534.3, 12, 'không ok', 0),
(3, 'b21', 'rượu', 343.0, 2, 'đẹp', 0),
(4, 'bk', 'bia', 3211.0, 98, null, 1),
(5, 'k21', 'bia laure', 2323.1, 67, 'ok', 1),
(6, '92k', 'oshi', 938, 9, 'ngon', 0),
(7, '434h', 'nước ngọt', 8, 90, null, 0);

explain select * from product where product_code ='%92k%';
drop index pro_code on product;
create index pro_code on product(product_code);

create view product_view as select product.product_code, product.product_name
from product;
select * from product_view;
insert into product_view value('434h', 'nước muối');

DELIMITER //
create procedure delete_product_id(in number_id int(10))
begin 
select * from product;
delete from product where product.id=number_id;
end //
DELIMITER ;
call delete_product_id(5);

DELIMITER //
create procedure get_all_product()
begin
select * from product;
end //
DELIMITER ;
call get_all_product();

DELIMITER //
create procedure create_one_product()
begin
insert into product value(9, 'k9', 'coca', 212, 23, 'ok', 0);
end //
DELIMITER ;
call create_one_product();
select * from product;

DELIMITER //
create procedure edit_product( p_id int(45), p_code varchar(50), p_name varchar(50))
begin
	update product
    set product_code=p_code, product_name = p_name
    where id = p_id;
end //
DELIMITER ;
call edit_product(3, 'h22', 'nước tương');
select * from product;