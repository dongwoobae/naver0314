create table myshop(
	shopidx smallint auto_increment primary key,
    sname varchar(30),
    sprice int,
    scount int,
    scolor varchar(20),
    sphoto varchar(100),
    writeday datetime
);
use bit701;
create table mysawon(
num smallint auto_increment primary key,
name varchar(20),
age smallint,
addr varchar(100),
buseo varchar(20),
photo varchar(100),
gender varchar(10),
birthday varchar(20));

drop table mysawon;

create table mystudent(
num smallint auto_increment primary key,
name varchar(20),
blood varchar(3),
license char(1),
java smallint,
spring smallint,
html smallint,
writeday datetime);

create table mymemo(
num smallint auto_increment primary key,
uploadphoto varchar(30),
title varchar(100),
content varchar(100),
writeday datetime);

use bit701;
create table userinformation(
num smallint auto_increment primary key,
userphoto varchar(30),
username varchar(20));

create table useractivity(
num smallint auto_increment primary key,
username varchar(20),
useryear int,
userdistance int);

drop table userinformation;
drop table useractivity;
use cycleproject;

alter table useractivity add column username varchar(20) first;
alter table useractivity modify column username varchar(20) after num;
alter table userinformation modify column userphoto varchar(30) after username;
alter table userinformation add constraint onlyname unique (username);
alter table useractivity add constraint onlyname foreign key (username) references userinformation(username);
alter table userinformation add column userage varchar(5);
alter table userinformation add column useraddr varchar(10);
alter table userinformation add column userclass varchar(10) after username;

create table bicyclecomponent(
num smallint auto_increment primary key,
username varchar(10),
frame varchar(20),
wheel varchar(20),
drivetrain varchar(20),
stem varchar(20),
saddle varchar(20),
writeday timestamp);

create table frame(
num smallint auto_increment primary key,
name varchar(10),
color varchar(10),
company varchar(10),
price int);

create table wheel(
num smallint auto_increment primary key,
name varchar(10),
company varchar(10),
price int);

create table drivetrain(
num smallint auto_increment primary key,
name varchar(10),
company varchar(10),
price int);

create table saddle(
num smallint auto_increment primary key,
name varchar(10),
company varchar(10),
price int);

create table stem(
num smallint auto_increment primary key,
name varchar(10),
company varchar(10),
price int);

alter table frame add column photo varchar(20);
alter table wheel add column photo varchar(20);
alter table drivetrain add column photo varchar(20);
alter table saddle add column photo varchar(20);