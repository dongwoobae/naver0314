create table memberdb(
num smallint auto_increment primary key,
name varchar(20),
myid varchar(20),
passwd varchar(20),
addr varchar(200),
hp varchar(20),
email varchar(30),
photo varchar(20),
birthday varchar(20),
gaipday datetime);

drop table memberdb;

select count(*) from memberdb where myid='dfsda';

create table comment(
id smallint auto_increment primary key,
userid varchar(20),
passwd varchar(20),
content varchar(400),
writeday datetime
);
select count(*) from comment;

alter table comment add column myid varchar(20) after userid;
alter table memberdb modify column photo varchar(100);
SET GLOBAL max_allowed_packet = 256*1024*1024;
alter table comment drop column myid;
alter table comment add column mynum smallint;

create table reboard (
num smallint auto_increment primary key,
writer varchar(20),
myid varchar(20),
subject varchar(300),
uploadphoto varchar(100),
content varchar(2000),
readcount smallint default 0,
regroup smallint,
restep smallint, 
relevel smallint,
writeday datetime);

create table boardanswer(
aidx smallint auto_increment primary key,
num smallint,
writer varchar(20),
myid varchar(20),
content varchar(1000),
writeday datetime,
foreign key(num) references reboard(num) on delete cascade);