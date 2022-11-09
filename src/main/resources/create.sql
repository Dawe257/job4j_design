create table transaction (
    id serial primary key,
    card varchar(255),
    amount int,
    confirmed boolean
);
