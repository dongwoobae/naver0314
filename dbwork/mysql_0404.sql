-- 2024-04-04 mysql 공부
-- 현재 날짜 구하는 함수들
select now();
select sysdate() from dual;
select current_timestamp() from dual;
select current_date() from dual;
select current_time() from dual;
-- 날짜함수들
select year(now()) from dual;-- 2024
select month(now()) from dual;-- 4
select monthname(now()) from dual;-- April
select dayname(now()) from dual;
select dayofmonth(now()) from dual;-- 4일임을 표시
select date_format(now(),'%Y-%m-%d') from dual;
select date_format(now(),'%Y-%m-%d %H:%i') 현재시간 from dual;
select str_to_date(20240404,'%Y%m%d') from dual;-- 숫자를 날짜타입으로 변환
select str_to_date(date_format(now(),'%Y%m%d'),'%Y%m%d') from dual;

-- test01 테이블 생성
 create table test01 (num tinyint auto_increment primary key,
      name varchar(20), age smallint,
     height decimal(5,1),birthday datetime, ipsaday date);
     
-- insert: 일부만 추가할 경우 컬럼명기재, 전체 다 줄경우 컬럼명 생략
insert into test01(name,age,height) values('Lee',23,178.9);
insert into test01(name,birthday,ipsaday) values('Song','2021-12-25 12:30','2018-05-10');



select * from test01;
-- 컬럼 생략시 num도 값을 넣어야하는데 num은 auto이므로 그냥 null로 넣으면 됨
insert into test01 values(null,'Kim',29,156.9,now(),now());
insert into test01 values(null,'Son',31,181.799,now(),now());
insert into test01 values(null,'Park',26,178.5,now(),now());
insert into test01 values(null,'Bae',29,174.9,now(),now());
select * from test01;

select * from test01 where name = 'Son';
select * from test01 where name like 'S%';-- S로 시작
select * from test01 where name like '_i%';-- 2번째 글자가 i인 사람
select upper(name), height from test01;-- 이름은 대문자로
select ucase(name), height from test01;-- 이름은 대문자로 동일
select lower(name), height from test01;-- 소문자
select lcase(name), height from test01;-- 소문자 동일

-- 오라클의 nvl이 mysql에서는 ifnull -> null 일때 대체값 지정
select name, ifnull(age,10),ifnull(height,150.5) from test01;
select * from test01;-- 원본값을 바꾸진 않고 출력만 

-- 컬럼명 변경
select name "이름", ifnull(age,10) "나이",ifnull(height,150.5) "키" from test01;
select name , ifnull(age,10) age,ifnull(height,150.5) height from test01;

-- 테이블 구조 수정
-- column 추가
alter table test01 add hp varchar(20);
select * from test01 order by name;

-- 컬럼을 추가하는데 기본값을 지정해서 주고싶다
alter table test01 add blood varchar(4) default 'B';

-- 컬럼 타입 변경
desc test01;-- 구조확인
-- name의 길이를 20에서 30으로 변경
alter table test01 modify name varchar(30);
-- age 컬럼 제거
alter table test01 drop column age;

-- 컬렴명 변경(5 버젼에서는 change, 8은 rename column (오라클하고 같다)
-- hp->phone으로 변경해보자
alter table test01 rename column hp to phone;

-- 삭제
delete from test01 where num=5;
-- 수정
update test01 set birthday = '1990-12-12',ipsaday=now(),phone='010-2222-3333'
	where num=1;

-- 조회
select * from test01 order by name;
select * from test01 order by 1;-- 첫 컬럼이 1번 

-- 부분 조회
select * from test01 limit 0,3;-- 첫 데이터가 0번, 0번부터 3개 조회
select * from test01 limit 3,2;

 create table sawon (
              num smallint auto_increment,
              name varchar(20),
              score smallint,
              gender varchar(10),
              buseo varchar(10),
              constraint pk_sawon_num primary key(num),
  		constraint ck_sawon_score check (score between 0 and 100),
 		constraint ck_sawon_gender check (gender in ('여자','남자')));

-- 제약조건 확인
select * from information_schema.table_constraints where table_name='sawon';
select * from sawon;

-- check에 안맞는 값을 insert 할 경우 오류메세지 확인
insert into sawon values (null,'이민정',110,'여자','홍보부');-- 점수가 100점 이상이어서 에러

-- check에 맞는 값
insert into sawon values (null,'이민정',90,'여자','홍보부');

insert into sawon values (null,'홍길동',90,'남','교육부');-- 에러발생
insert into sawon values (null,'홍길동',90,'남자','교육부');

select * from sawon;

-- group by 연습용 데이터 10개 추가
insert into sawon values (null,'이진',87,'여자','인사부');
insert into sawon values (null,'송강',95,'남자','홍보부');
insert into sawon values (null,'서강준',100,'남자','홍보부');
insert into sawon values (null,'고강석',60,'남자','교육부');
insert into sawon values (null,'황정음',90,'여자','인사부');
insert into sawon values (null,'배수지',70,'여자','교육부');
insert into sawon values (null,'하연수',80,'여자','교육부');
insert into sawon values (null,'전소민',76,'여자','인사부');

-- group 함수
select count(*) from sawon;-- 총 인원수
select sum(score),round(avg(score),1) from sawon;

-- 성별로 인원수 최고점수 최저점수 평균점수 구하기
select 
	gender 성별,count(*) 인원수,max(score) 최고점수,
    min(score) 최저점수,round(avg(score),1) 평균점수
from sawon
group by gender;

-- 부서별 인원수와 최고점수
select buseo 부서, count(*) 인원수, max(score) 최고점수 
from sawon group by buseo;

-- 오라클의 decode와 비슷한 if문
select name, score, if(score>=90,'통과','재시험') 평가
from sawon;

-- test01 은 연습용이므로 삭제
select * from test01;
drop table test01;

-- mysql 파일의 함수부분 복사해서 실행시켜 결과를 보세요
select concat('happy','day') from dual; /*문자열더함*/
select concat('apple','kiwi','mango') from dual;
select replace('have a nice day','a','*') from dual;
select instr('happy','a') from dual;
select instr('happy','x') from dual;
select left('have a nice day',4) from dual;
select right('have a nice day',5) from dual;
select right('have a nice day',7) from dual;
select mid('have a nice day',8,4) from dual;
select substring('have a nice day',8,4) from dual;-- 8번째에서 4글자 추출
select left('가나다라마바사',3) from dual; /*한글도3글자 나옴*/
select substring('가나다라마바사',4,2) from dual;
select concat(ltrim('   abc    '),'*') from dual;
select concat(rtrim('   abc    '),'*') from dual;
select concat(trim('   abc    '),'*') from dual;
select lcase('Happy'),lower('Happy') from dual;
select ucase('Happy'),upper('Happy') from dual;
select reverse('Happy') from dual;
select abs(-10) from dual;/*무조건 양수값 반환*/
select ceiling(2.1) from dual; /*무조건올림  3 */
select floor(2.9) from dual; /*무조건내림  2 */
select truncate(2.345,2) from dual; /*소숫점2자리까지 출력되고 3자리에서 내림*/
select mod(5,3) from dual;/*5를 3으로 나눈나머지=2*/
select greatest(12,23,34,11,4) from dual;/*가장 큰숫자*/
select least(12,23,34,11,4) from dual;/*가장 작은숫자*/
select trim('have a nice day');-- trim은 양쪽 공백을 지우는거지 가운데 공백을 지우지는 못함
select replace('have a nice day',' ','');-- 공백을 replace로 없앨 수 있음
select right(replace('have a nice day',' ',''),7);-- niceday로 뽑아낼 수 있음
select concat('have a',' ','nice day');
select concat('vamilo ','lower sound ','redclick keyboard') 키보드;

create table bitclass (
   idx smallint primary key,
   class varchar(30),
   price int,
   gigan smallint);

insert into bitclass values (100,'Java',110000,10);
insert into bitclass values (200,'HTML5',90000,8);
insert into bitclass values (300,'jQuery',130000,12);
insert into bitclass values (400,'Oracle',180000,20);
select * from bitclass;

create table stu (
   num smallint auto_increment primary key,
   name varchar(20),
   idx smallint,
   sugangday date,
   constraint stu_fk_idx foreign key(idx) references bitclass(idx));

insert into stu (name,idx,sugangday) values ('kim',200,now());
insert into stu (name,idx,sugangday) values ('lee',100,now());
insert into stu (name,idx,sugangday) values ('son',300,now());
insert into stu (name,idx,sugangday) values ('min',400,now());
select * from stu;

select * from bitclass bc,stu where bc.idx=stu.idx;-- 그냥 값을 다 깡으로 넣어버리기
select name,class,price,gigan,sugangday from bitclass bc,stu
  where bc.idx=stu.idx;

select name,class,price,gigan,sugangday from bitclass bc 
	inner join stu on bc.idx=stu.idx;
    
    create table shop (
idx smallint auto_increment primary key,
sang varchar(20));
insert into shop (sang) values ('블라우스');
insert into shop (sang) values ('티셔츠');
select * from shop;

create table cart (
 num smallint auto_increment primary key,
 name varchar(20),
 idx smallint,
 foreign key(idx) references shop(idx));

 insert into cart (name,idx) values ('lee',1);
 insert into cart (name,idx) values ('kim',2);
 
 select * from cart;
 
select * from shop,cart where shop.idx=cart.idx;

SELECT *
FROM shop
INNER JOIN cart
ON shop.idx=cart.idx;

commit;

-- 연습용 테이블은 삭제
drop table stu;
drop table bitclass;

show tables;

drop table cart;
drop table shop;

-- join 연습용 테이블 2개 생성 : on delete cascade
create table shop(
	shopnum smallint auto_increment primary key, 
    sangpum varchar(30),
    price int,
    color varchar(20) default 'black'
    );
    show tables;
    select * from shop;
    
create table cart(
	cartnum smallint auto_increment primary key,
    username varchar(20),
    shopnum smallint,
    guipday datetime,
    constraint fk_shopnum foreign key(shopnum)
    references shop(shopnum) on delete cascade
);

select * from cart;

-- shop에 상품 5개 등록해보자
insert into shop(sangpum,price) values ('블라우스',12000);
insert into shop values (null,'청바지',29000,'blue');
insert into shop values (null,'레이스조끼',31000,'yellow');
insert into shop values (null,'주름스커트',43000,'green');
insert into shop values (null,'체크남방',32000,'pink');

select * from shop;

-- cart에도 데이터 추가하기
select * from cart;
insert into cart values (null,'이진',3,now());
insert into cart values (null,'강철순',1,now());
insert into cart values (null,'유재석',4,now());
insert into cart values (null,'한예슬',5,now());
insert into cart values (null,'강호동',1,now());

-- join 1
select * from shop,cart where shop.shopnum=cart.shopnum;-- 전체 가져오기

-- join 2 
select 
	username,sangpum,price,color,guipday
from shop s, cart c where s.shopnum=c.shopnum;

-- join 3
select 
	username,sangpum,price,color,guipday
from shop
inner join cart
on shop.shopnum=cart.shopnum;

-- shop에서 1번 블라우스를 삭제 
delete from shop where shopnum=1;

-- 다시 join
select 
	username,sangpum,price,color,guipday
from shop
inner join cart
on shop.shopnum=cart.shopnum;

select * from sawon order by num;

-- 문제 : 아래의 결과를 자바 파일로 실행해서 출력되도록 하세요
select buseo,count(*) inwon, max(score) maxscore, ceiling(avg(score)) avgscore
from sawon group by buseo;
show tables;
select * from cart;
select * from shop;

select gender,count(*) inwon, max(score) maxscore, round(avg(score)) avgscore 
from sawon group by gender;
drop database opentutorials;
use bit701;