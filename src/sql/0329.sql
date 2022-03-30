show tables;

desc aaa;

drop table aaa;

create table aaa (
	name varchar(20) not null,
	age int default 20,
	gender char(2) default 'm',
	joinday datetime
);

insert into aaa values 
('홍길동',25,default,default);
insert into aaa values 
('홍길순',29,'f',default);
insert into aaa values 
('김말숙',35,'f','2020-1-5');
insert into aaa values 
('테스트',18,default,default);
