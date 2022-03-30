show tables;

create table dbtest (
	idx 		int not null auto_increment primary key,
	name 		varchar(20) not null,
	age 		int default 20,
	gender 	varchar(2) default '남',
	joinday datetime default now()
);

insert into dbtest values (default, '홍길동', 25, default, default);
--update dbtest set  age=28, joinday = date_format('2022-03-08', '%Y-%m-%d') where idx=5;

select * from dbtest where date_format(joinday, '%Y-%m-%d') = '2022-03-30';
select * from dbtest;





