create table car_bodies
(
    id   serial primary key,
    name varchar(255)
);

create table car_engines
(
    id   serial primary key,
    name varchar(255)
);

create table car_transmission
(
    id   serial primary key,
    name varchar(255)
);

create table cars
(
    id              serial primary key,
    name            varchar(255),
    body_id         int references car_bodies (id),
    engine_id       int references car_engines (id),
    transmission_id int references car_transmission (id)
);

insert into car_bodies(name)
values ('седан');
insert into car_bodies(name)
values ('хэтчбэк');
insert into car_bodies(name)
values ('пикап');
insert into car_bodies(name)
values ('лимузин');

insert into car_engines(name)
values ('v4');
insert into car_engines(name)
values ('v6');
insert into car_engines(name)
values ('v8');

insert into car_transmission(name)
values ('робот');
insert into car_transmission(name)
values ('автомат');
insert into car_transmission(name)
values ('ручная');
insert into car_transmission(name)
values ('вариатор');

insert into cars(name, body_id, engine_id, transmission_id)
values ('форд фокус', 2, 1, 1);
insert into cars(name, body_id, transmission_id)
values ('опель астра', 2, 1);
insert into cars(name, body_id, engine_id, transmission_id)
values ('тоета камри', 1, 3, 2);
insert into cars(name, body_id, engine_id)
values ('амарок', 3, 3);
insert into cars(name, body_id, engine_id)
values ('киа рио', 1, 1);

select cars.id, cars.name, car_bodies.name, car_transmission.name, car_engines.name
from cars
         left join car_bodies on cars.body_id = car_bodies.id
         left join car_engines on cars.engine_id = car_engines.id
         left join car_transmission on cars.transmission_id = car_transmission.id;

select car_bodies.id, car_bodies.name
from car_bodies
         left join cars on car_bodies.id = cars.body_id
where cars.body_id is null;

select car_engines.id, car_engines.name
from car_engines
         left join cars on car_engines.id = cars.engine_id
where cars.engine_id is null;

select car_transmission.id, car_transmission.name
from car_transmission
         left join cars on car_transmission.id = cars.transmission_id
where cars.transmission_id is null;