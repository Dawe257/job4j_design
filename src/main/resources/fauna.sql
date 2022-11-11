create table fauna
(
    id             serial primary key,
    name           varchar(255),
    avg_age        int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date)
values ('fish', 10000, '1000-01-01');
insert into fauna(name, avg_age, discovery_date)
values ('cow', 15000, '2000-01-01');
insert into fauna(name, avg_age, discovery_date)
values ('dog', 25000, '3000-01-01');
insert into fauna(name, avg_age)
values ('cat', 20000);

select *
from fauna
where name like '%fish%';

select *
from fauna
where avg_age >= 10000
  and avg_age <= 21000;

select *
from fauna
where discovery_date IS NULL;

select *
from fauna
where discovery_date < '1950-01-01';