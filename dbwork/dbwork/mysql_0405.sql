-- 문제: 아래의 결과를 자바파일로 실행해서 출력되도록 하세요
select buseo,count(*) inwon, max(score) maxscore, ceiling(avg(score)) avgscore
from sawon group by buseo;

-- shop과 cart join
select
	cartnum,username,sangpum,price,color,date_format(guipday,'%Y-%m-%d %H:%i') guipday
    from shop,cart
    where shop.shopnum=cart.shopnum;
    
-- 방법2
select
	cartnum,username,sangpum,price,color,date_format(guipday,'%Y-%m-%d %H:%i') guipday
    from shop 
    inner join cart
    on shop.shopnum = cart.shopnum;
    
select * from sawon;sawon

-- '홍' 입력시 홍이 포함된 이름을 가진 데이터 모두 출력
select * from sawon where name like '%강%';

-- 없을경우
select * from sawon where name like '%락%';
select * from sawon where name like concat('%','강','%');

insert into sawon (name,score,gender,buseo) values ('ㅇㅇ',56,'남자','인사부');
delete from sawon where num=11;

use bit701;
update sawon set score=98, buseo= '영업부' where name = '송하연';

create table student (
	num smallint auto_increment primary key,
    name varchar(20),
    java smallint,
    html smallint,
    spring smallint,
    testday datetime
);
insert into student values (null,'이효리',90,80,97,now());
select * from student;
select num,name,java,html,spring,
	java+html+spring tot, round((java+html+spring)/3,1) avg,
    date_format(testday,'%Y-%m-%d %H:%i') testday
    from student;
    select num,name,java,html,spring,
	java+html+spring tot, round((java+html+spring)/3,1) avg,
    date_format(testday,'%Y-%m-%d %H:%i') testday
    from student;