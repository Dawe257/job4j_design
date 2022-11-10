select e.name, d.sit_num from employee e join desk d on e.desk = d.id;

select e.name as Имя, d.sit_num from employee e join desk d on e.desk = d.id;

select e.name as Имя, d.sit_num as "Рабочее место" from employee e join desk d on e.desk = d.id;