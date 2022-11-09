create table color
(
    id serial primary key,
    name varchar(255)
);

create table person
(
    id serial primary key,
    name varchar(255),
    hair_color int references color(id)
);