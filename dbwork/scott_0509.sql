use bit701;
create table guest(
num smallint auto_increment primary key,
nickname varchar(20),
avatar varchar(50),
content varchar(1000),
writeday datetime);
drop table guest;