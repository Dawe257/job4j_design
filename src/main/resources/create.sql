create table rules
(
    id   serial primary key,
    name varchar(255)
);

create table role
(
    id   serial primary key,
    name varchar(255)
);

create table role_rules
(
    id       serial primary key,
    rules_id int references rules (id),
    role_id  int references role (id)
);

create table "user"
(
    id   serial primary key,
    name varchar(255),
    role int references role (id)
);

create table category
(
    id serial primary key,
    name varchar(255)
);

create table state
(
    id serial primary key,
    name varchar(255)
);

create table item
(
    id       serial primary key,
    "user"   int references "user" (id),
    category int references category (id),
    state    int references state (id)
);

create table comments
(
    id      serial primary key,
    content varchar(255),
    item    int references item (id)
);

create table attaches
(
    id   serial primary key,
    item int references item (id)
);
