create table type
(
    id   serial primary key,
    name varchar(255)
);

create table product
(
    id           serial primary key,
    name         varchar(255),
    type_id      int references type (id),
    expired_date date,
    price        int
);

insert into type(name)
values ('СЫР');
insert into type(name)
values ('МОЛОКО');
insert into type(name)
values ('МЯСО');
insert into type(name)
values ('РЫБА');
insert into type(name)
values ('ДЕСЕРТ');

insert into product(name, type_id, expired_date, price)
values ('сыр моцарела', 1, '2023-05-05', 350);
insert into product(name, type_id, expired_date, price)
values ('сыр адыгейский', 1, '2023-05-05', 450);
insert into product(name, type_id, expired_date, price)
values ('сыр гауда', 1, '2021-05-05', 250);
insert into product(name, type_id, expired_date, price)
values ('говядина', 3, '2023-05-05', 350);
insert into product(name, type_id, expired_date, price)
values ('баранина', 3, '2023-05-05', 350);
insert into product(name, type_id, expired_date, price)
values ('свинина', 3, '2023-05-05', 350);
insert into product(name, type_id, expired_date, price)
values ('творог', 2, '2023-05-05', 350);
insert into product(name, type_id, expired_date, price)
values ('кефир', 2, '2022-05-05', 350);
insert into product(name, type_id, expired_date, price)
values ('селедка', 4, '2023-05-05', 754);
insert into product(name, type_id, expired_date, price)
values ('лосось', 4, '2023-05-05', 1000);
insert into product(name, type_id, expired_date, price)
values ('лосось', 4, '2023-05-05', 1000);
insert into product(name, type_id, expired_date, price)
values ('лосось', 4, '2023-05-05', 1000);
insert into product(name, type_id, expired_date, price)
values ('Шоколадное мороженое', 5, '2023-05-05', 1000);


select *
from product
         join type on type.id = product.type_id
where type.name = 'СЫР';

select *
from product
where name like '%мороженое%';

select *
from product
where expired_date < current_date;

select *
from product
where price = (select max(price) from product);

select t.name, count(*)
from product
         join type t on t.id = product.type_id
group by t.name;

select *
from product
         join type on type.id = product.type_id
where type.name = 'СЫР'
   or type.name = 'МОЛОКО';

select t.name, count(*)
from product
         join type t on t.id = product.type_id
group by t.name
having count(*) < 10;

select *
from product
         join type t on t.id = product.type_id;