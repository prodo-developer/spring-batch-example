create table person (
    id bigint primary key auto_increment,
    name varchar(255),
    age varchar(255),
    address varchar(255)
);

insert into person(name, age, address)
values('prodo','32','원주');
insert into person(name, age, address)
values('홍길동','30','서울');
insert into person(name, age, address)
values('아무개','25','부산');

