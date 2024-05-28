create table simpleboard (
num smallint auto_increment primary key,
writer varchar(20),
avatar varchar(10),
subject varchar(20),
content varchar(20),
readcount smallint default 0,
chu smallint default 0,
writeday datetime
);
alter table simpleboard modify column content varchar(200);