create table departments
(
    id   serial primary key,
    name varchar(255)
);

create table employee
(
    id             serial primary key,
    name           varchar(255),
    departments_id int references departments (id)
);

insert into departments(name)
values ('департамент внутренних дел');
insert into departments(name)
values ('департамент внешних дел');
insert into departments(name)
values ('департамент секретных дел');
insert into departments(name)
values ('департамент очень важных дел');

insert into employee(name, departments_id)
values ('петя', 1);
insert into employee(name, departments_id)
values ('вася', 1);
insert into employee(name, departments_id)
values ('лена', 2);
insert into employee(name, departments_id)
values ('ира', 3);
insert into employee(name, departments_id)
values ('настя', 2);
insert into employee(name, departments_id)
values ('денис', 1);
insert into employee(name)
values ('ваня');

select *
from employee
         left join departments on departments.id = employee.departments_id;
select *
from employee
         right join departments on departments.id = employee.departments_id;
select *
from employee
         full outer join departments on departments.id = employee.departments_id;
select *
from employee
         cross join departments;

select departments.id, departments.name
from departments
         left join employee on departments.id = employee.departments_id
where employee.id is null;

select employee.id, employee.name, departments.id, departments.name
from employee
         left join departments on departments.id = employee.departments_id;
select employee.id, employee.name, departments.id, departments.name
from departments
         right join employee on departments.id = employee.departments_id;

create table teens
(
    id     serial primary key,
    name   varchar(255),
    gender char
);

insert into teens(name, gender)
values ('петя', 'М');
insert into teens(name, gender)
values ('вася', 'М');
insert into teens(name, gender)
values ('лена', 'Ж');
insert into teens(name, gender)
values ('ира', 'Ж');
insert into teens(name, gender)
values ('настя', 'Ж');
insert into teens(name, gender)
values ('денис', 'М');

select *
from teens
         cross join teens t
where teens.gender != t.gender;