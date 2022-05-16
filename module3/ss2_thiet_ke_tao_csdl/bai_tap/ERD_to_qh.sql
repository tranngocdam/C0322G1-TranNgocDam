drop database if exists ERD_to_quan_he;
create database ERD_to_quan_he;
use ERD_to_quan_he;

create table nhacc(
ma_ncc int auto_increment,
ten_ncc varchar(45),
dia_chi varchar(45),
sdt varchar(45),
primary key(ma_ncc));

create table phieu_xuat(
so_px int,
ngay_xuat date,
primary key(so_px));

create table vat_tu(
ma_vtu int,
ten_vtu varchar(50),
primary key(ma_vtu));

create table phieu_xuat_qh_vat_tu(
sl_xuat int,
dg_xuat double,
so_px int,
ma_vtu int,
primary key(so_px, ma_vtu),
foreign key (so_px) references phieu_xuat(so_px),
foreign key (ma_vtu) references vat_tu(ma_vtu));

create table phieu_nhap(
so_pn int,
ngay_nhap date,
primary key(so_pn));

create table vat_tu_qh_phieu_nhap(
sl_nhap int,
dg_nhap double,
ma_vtu int,
so_pn int,
primary key(ma_vtu,so_pn),
foreign key (ma_vtu) references vat_tu(ma_vtu),
foreign key (so_pn) references phieu_nhap(so_pn));

create table don_dh(
so_dh int,
ma_ncc int,
ngay_dh date,
primary key(so_dh),
foreign key (ma_ncc) references nhacc(ma_ncc));

create table don_dh_qh_vat_tu(
ma_vtu int,
so_dh int,
primary key(ma_vtu, so_dh),
foreign key (ma_vtu) references vat_tu(ma_vtu),
foreign key (so_dh) references don_dh(so_dh));
