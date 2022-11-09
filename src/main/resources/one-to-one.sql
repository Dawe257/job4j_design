create table transaction
(
    id        serial primary key,
    card      varchar(255),
    confirmed boolean,
    amount    int references amount (id) unique
);

create table amount
(
    id       serial primary key,
    count    int,
    currency varchar(255)
);