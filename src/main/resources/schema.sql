CREATE SCHEMA netology;

create table netology.customers
(
    id           int NOT NULL PRIMARY KEY,
    name         varchar(255),
    surname      varchar(255),
    age          int,
    phone_number int
);

create table netology.customer_orders
(
    id           int NOT NULL PRIMARY KEY,
    date         varchar(255),
    customer_id  int NOT NULL,
    product_name varchar(255),
    amount       double precision,
    foreign key (customer_id)  references netology.customers(id)
);

insert into netology.customers
values (1, 'Peter', 'Parker', 19, 5557896),
       (2, 'Bruce', 'Wayne', 40, 666999);

insert into netology.customer_orders
values (1, '20.01.2009', 1, 'stew', 299.99),
       (2, '02.08.2021', 2, 'beer', 100.99);