--카페에서 scott_table을 다운받아 git에 넣은 후 
--cmd창에서 git폴더로 이동 후 (cd git)
--@scott_table 엔터
--자동으로 안에 있는 sql명령어가 실행됩니다
--select * from tab;으로 확인
select * from tab;--생성된 테이블 확인
select * from emp;--emp 테이블의 연습용 데이터 확인
commit;

--emp 테이블의 구조 확인
desc emp;

--전체 컬럼으로 emp테이블 조회(* 가 전체컬럼을 뜻함)
select * from emp;
--ename,job 컬럼만 조회
select ename,job from emp;
--ename,job 컬럼만 조회, ename의 오름차순(asc) 내림차순(desc)으로 조회
select ename,job from emp order by ename asc;--오름차순일 경우 생략가능
select ename,job from emp order by ename desc;

--job 조회
select job from emp;

--job을 조회하는데 같은 직업은 한번만 나오게
select DISTINCT job from emp;

--오름차순
select DISTINCT job from emp order by job;
--내림차순
select DISTINCT job from emp order by job desc;

select DISTINCT job from emp order by 1;--컬럼번호는 1번부터, 

--ename이 smith 인 사람 조회
select * from emp where ename = 'SMITH';
select * from emp where ename = 'ward';--sql 명령어는 대소문자 상관없지만 데이터 값은 구분해줘야한다.

select * from emp where ename='SMITH' or ename='WARD';


--ename, sal을 조회
select ename, sal from emp;

--컬럼제목을 변경
select ename "사원명",sal "급여" from emp;--제목 변경시 공백이 포함되있을경우 반드시 ""로 묶어준다. 아니면 생략 가능
select ename 사원명,sal 급여 from emp;

--여러컬럼을 합해서 하나의 컬럼으로 출력할 경우
select '내이름은'||ename||'이고 직업은'||job||'입니다' from emp;
select '내이름은'||ename||'이고 직업은'||job||'입니다'  "사원"from emp;
select ename||'님의 연봉은'||sal||'만원입니다' "연봉" from emp;
--sal 연봉이 2000~3000 사이 조회(컬럼은 ename과 sal)
select  ename,sal from emp where sal>=2000 and sal<=3000;
--between 이용해서 조회
select ename,sal from emp where sal between 1000 and 2000;

--직업이 salesman이거나 manager,clerk 이면 조회
select ename,job from emp where job = 'SALESMAN' or job='MANAGER' or job = 'CLERK';

--IN(LIST)으로 OR을 간단히 할수있다.(조회할게 많을때)
select ename,job from emp where job IN ('SALESMAN','MANAGER','CLERK');

--MGR이 7902,7839,7788 조회(컬럼은 ename,job,mgr)
select ename,job,mgr from emp where mgr in ('7902','7839','7788');

--mgr이 null인 경우
select * from emp where mgr is null;

--comm이 null인 경우
select * from emp where comm is null;
select * from emp where comm is not null;

--문자 조회시 % 또는 _를 이용해서 조회
--ename이 a로 시작하는 사람 조회
select ename,sal from emp where ename like 'A%';
--n으로 끝나는 사람
select ename,sal from emp where ename like '%N';

--이름의 두번째 글자가 a인 사람
select ename,sal from emp where ename like '_A%';

--세번째가 a(언더바 한개가 한 글자를 뜻함)
select ename,sal from emp where ename like '__A%';

--컬럼은 ename과 sal, 이름이 s나 m으로 시작하는 사람
select ename,sal from emp where ename like 'S%' or ename like 'M%';
--이름이 s로 시작하는 사람 중에 연봉이 2000이상인 사람
select ename,sal from emp where ename like 'S%' and sal>=2000;
--mgr 이 7902,7788,7566이 아닌사람
select ename,sal,mgr from emp where mgr not in ('7902','7788','7566');

--comm,comm+1000 의 결과 출력
select comm,comm+1000 from emp;

--오라클 함수 중 NVL(컬럼명,null일 경우 초기값),mysql은 ifnull 
select NVL(comm,0),NVL(comm,0)+1000 from emp;
--컬럼제목 변경
select NVL(comm,0) COMM,NVL(comm,0)+1000 "COMM2" from emp;

--SAL이 2000~3000이 아닌 경우 조회
SELECT ENAME,SAL FROM EMP WHERE SAL<2000 OR SAL>3000;
SELECT ENAME,SAL FROM EMP WHERE SAL NOT BETWEEN 2000 AND 3000;

--GROUP 함수 (COUNT,MAX,MIN,AVG,SUM)
SELECT COUNT(*) FROM EMP;
SELECT MAX(SAL) FROM EMP;
SELECT MIN(SAL) FROM EMP;
SELECT SUM(SAL) FROM EMP;
SELECT AVG(SAL) FROM EMP;
--AVG는 소수점이하가 많이 나오는 경우가 잦아서 ROUND, CEIL, FLOOR등과 같이 많이 사용
SELECT ROUND(AVG(SAL),2) FROM EMP;--반올림
SELECT FLOOR(AVG(SAL)) FROM EMP;--내림 2073
SELECT CEIL(AVG(SAL)) FROM EMP;--올림 2074

--PPT 57페이지 GROUP BY 절
--JOB 을 그룹으로 직업별 각 인원수를 구해보자
SELECT JOB 직업,COUNT(*) 인원수 FROM EMP GROUP BY JOB;

--위의 결과에 직업의 오름차순
SELECT JOB 직업,COUNT(*) 인원수 FROM EMP GROUP BY JOB ORDER BY 1;
SELECT JOB 직업,COUNT(*) 인원수 FROM EMP GROUP BY JOB ORDER BY 직업;

--인원수의 오름차순
SELECT JOB 직업,COUNT(*) 인원수 FROM EMP GROUP BY JOB ORDER BY 인원수;
SELECT JOB 직업,COUNT(*) 인원수 FROM EMP GROUP BY JOB ORDER BY 2;

--직업별 인원수와 최고연봉, 최저연봉,평균연봉 (올림) 
SELECT JOB 직업 ,COUNT(*) 인원수 ,MAX(SAL) 최고연봉,MIN(SAL) 최저연봉 ,CEIL(AVG(SAL)) 평균연봉 FROM EMP GROUP BY JOB ORDER BY 2;

--HAVING은 GROUP절에서 그룹함수를 이용해 조건을 나타낼 경우
--직업별 인원수와 최고연봉, 직업별 인원수가 3명 이상일 경우 조회
SELECT JOB,COUNT(*),MAX(SAL) FROM EMP GROUP BY JOB HAVING COUNT(JOB)>=3;

--오라클에서는 현재날짜를 구할때 SYSDATE, MYSQL은 NOW()
SELECT SYSDATE FROM DUAL;
--3일 뒤는 몇일인가
SELECT SYSDATE + 3 FROM DUAL;
--30일 뒤 
SELECT SYSDATE +30 FROM DUAL;

--날짜타입을 문자열로 변환 TO_CHAR : 기호 Y,M,D,HH,HH24,MI,SS,AM/PM 
SELECT TO_CHAR (SYSDATE,'YYYY') FROM DUAL; --2024
SELECT TO_CHAR (SYSDATE,'YEAR') FROM DUAL;--언어로 나옴,타 프로그램에서 못받아서 잘안씀

SELECT TO_CHAR (SYSDATE,'MM') FROM DUAL;
SELECT TO_CHAR (SYSDATE,'MONTH') FROM DUAL;

--기호를 많이 쓰는데 다양한 기호로 날짜를 출력해보자
SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD') FROM DUAL;
SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD AM HH:MI') FROM DUAL;--AM이나 PM 둘중 아무거나 쓰면 오후 오전 표기
SELECT TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI') FROM DUAL;

--EMP에서 HIREDATE(날짜타입)을 이용해서 출력
SELECT ENAME,JOB,TO_CHAR(HIREDATE,'YYYY-MM-DD') HIREDATE FROM EMP;

--고용년도 1987년인 사람 출력
SELECT ENAME,JOB,TO_CHAR(HIREDATE,'YYYY-MM-DD') HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE,'YYYY')='1987';
SELECT ENAME,JOB,TO_CHAR(HIREDATE,'YYYY-MM-DD') HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE,'YYYY')=1987;

--고용월이 5월인 사람 출력
SELECT ENAME,JOB,TO_CHAR(HIREDATE,'YYYY-MM-DD') HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE,'MM')='05';
SELECT ENAME,JOB,TO_CHAR(HIREDATE,'YYYY-MM-DD') HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE,'MM')=5;

--SUBQUERY (SELECT문 안에 또 SELECT 문이 있는 경우)
--SCOTT의 연봉과 같은 연봉을 가진 사람을 구하시오
SELECT * FROM EMP WHERE SAL=(SELECT SAL FROM EMP WHERE ENAME='SCOTT');
--평균 연봉보다 많이 받는 사람의 정보 출력
SELECT * FROM EMP WHERE SAL>=(SELECT AVG(SAL) FROM EMP) ORDER BY SAL;








