insert into rules(name) values ('какое-то правило');

insert into role(name) values ('юзверь');

insert into role_rules(rules_id, role_id) VALUES (1, 1);

insert into "user"(name, role)values ('какой-то юзер', 1);

insert into category(name) values ('какая-то категория');

insert into state(name) values ('какой-то стейт');

insert into item("user", category, state) values (1, 1, 1);

insert into comments(content, item) values ('lorem ipsum', 1);

insert into attaches(item) values (1);