-- 자바연동 연습용 시퀀스, 테이블 생성
create sequence seq_test nocache;

create table person (
    pnum number(3) CONSTRAINT pk_pnum primary key,
    pname varchar2(20),
    pblood varchar2(5) default 'B',
    page number(3),
    ipsaday date        
);

-- 5개 정도 데이터 추가
insert into person values (seq_test.nextval,'이상순','A',34,'2010-12-20');
insert into person values (seq_test.nextval,'이효리','B',41,'2002-11-24');
insert into person values (seq_test.nextval,'강소연','A',37,'2011-06-11');
insert into person values (seq_test.nextval,'지우용','o',28,sysdate);
insert into person values (seq_test.nextval,'곽철용','AB',55,'1992-10-21');
commit;

select * from person;

delete from person where pnum>=6 and pnum<=9;

select pnum,pname,upper(pblood),page,to_char(ipsaday,'yyyy-mm-dd') ipsaday from person;
commit;

