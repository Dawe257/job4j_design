create table desk
(
    id      serial primary key,
    sit_num int unique
);

create table employee
(
    id   serial primary key,
    name varchar(255),
    desk int references desk (id) unique
);

insert into desk(sit_num)
values (1);
insert into desk(sit_num)
values (2);
insert into desk(sit_num)
values (3);

insert into employee(name, desk)
values ('петя', 1);
insert into employee(name, desk)
values ('ваня', 2);
insert into employee(name, desk)
values ('степа', 3);

select e.name, d.sit_num
from employee e
         join desk d on e.desk = d.id;

select e.name as Имя, d.sit_num
from employee e
         join desk d on e.desk = d.id;

select e.name as Имя, d.sit_num as "Рабочее место"
from employee e
         join desk d on e.desk = d.id;