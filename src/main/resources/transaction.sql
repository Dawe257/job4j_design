create table transaction
(
    id        serial primary key,
    card      varchar(255),
    amount    int,
    confirmed boolean
);

insert into transaction(card, amount, confirmed) values ('123', 100500, false);

update transaction set confirmed = true where id = 1;

delete from transaction where id = 1;
