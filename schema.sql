drop schema if exists day24;

create database day24;

use day24;

create table orders(
    order_id int auto_increment,
    order_date date,
    customer_name varchar(128),
    ship_address varchar(128),
    notes varchar(300),
    tax decimal (6,2) default 0.05,

    primary key (order_id)

)

create table order_details(
    id int auto_increment,
    product varchar(64),
    unit_price decimal (6,2),
    discount decimal (6,2) default 1.0,
    quantity int,
    order_id int,

    primary key (id)
    constraint foreign_id foreign key(order_id) references orders(order_id)
)

