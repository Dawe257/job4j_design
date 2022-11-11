create table devices
(
    id    serial primary key,
    name  varchar(255),
    price float
);

create table people
(
    id   serial primary key,
    name varchar(255)
);

create table devices_people
(
    id        serial primary key,
    device_id int references devices (id),
    people_id int references people (id)
);

insert into devices(name, price) values ('iphon', 10000);
insert into devices(name, price) values ('sasung', 8000);
insert into devices(name, price) values ('ximi', 4000);

insert into people(name) values ('петя');
insert into people(name) values ('ваня');
insert into people(name) values ('степа');

insert into devices_people(device_id, people_id) values (1, 1);
insert into devices_people(device_id, people_id) values (2, 2);
insert into devices_people(device_id, people_id) values (3, 3);
insert into devices_people(device_id, people_id) values (1, 3);

select avg(price)
from devices;

select p.name, avg(d.price)
from devices_people as dp
         join devices d on dp.device_id = d.id
         join people p on dp.people_id = p.id
group by p.name;

select p.name, avg(d.price)
from devices_people as dp
         join devices d on dp.device_id = d.id
         join people p on dp.people_id = p.id
group by p.name
having avg(d.price) > 5000;