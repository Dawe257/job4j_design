create table car
(
    id serial primary key,
    name varchar(255)
);

create table person
(
    id serial primary key,
    name varchar(255)
);

create table person_car
(
    id serial primary key,
    car_id int references car(id),
    person_id int references person(id)
)

