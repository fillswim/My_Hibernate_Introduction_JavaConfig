CREATE TABLE my_db.employees
(
    id         int not null auto_increment,
    name       varchar(15),
    surname    varchar(25),
    department varchar(20),
    salary     int,
    constraint primary key (id)
);

