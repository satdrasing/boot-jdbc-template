create table employee(
    id number primary key auto_increment,
    employee_name varchar(20)

);


create table department(
    id number primary key auto_increment,
    dept_name varchar(20)

);

--CREATE SEQUENCE EMPLOYEE_SEQ START WITH 1;

insert into department (id, dept_name) values(1,'oracle');
insert into department (id, dept_name) values (2, 'java');


insert into employee (id, employee_name) values(100,'satendra');
insert into employee (id, employee_name) values (2, 'rajan');