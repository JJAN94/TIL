# Day31

#### PL/SQL

```sql
CREATE TABLE test1(bunho number(3),
				irum varchar2(10));
```

Q1)

```sql
SET SERVEROUTPUT ON

BEGIN
	FOR i IN 1..10 LOOP
		INSERT INTO TEST1 VALUES(i, sysdate);
	end loop;
end;
/
SELECT * FROM TEST1;
```



Q2) 1~50까지 출력하자. [현재의 i값은? 00이다] -> FOR Loop

```sql
DECLARE
	i int := 0;

BEGIN
	FOR i IN 1..50 LOOP
		dbms_output.put_line('현재의 i값은? '||i||' 이다');
	END LOOP;
END;
/
-- FORTATOR : TO_CHAR써서 00이다 구현
```



Q3)  구구단에 홀수 단만 출력해보자. mod();

```sql
DECLARE
	total number :=0;
BEGIN
	for i in 2..9 loop
		if mod(i,2) <> 0 then
			dbms_output.put_line(i||' 단');
			dbms_output.put_line('===============');
			for j in 2..9 loop
				total := j*i;
				dbms_output.put_line(j||' * '||i||' = '||total||' ');
			end loop;
		end if;
	end loop;
END;
/
-- <>는 !=랑 같음
```



Q4) loop 무한 반복 명령 end loop;	 반복문 탈출 : exit;

- 무한루프 만들기와 조건을 줘서 무한루프 탈출하기.

```sql
-- 1~50까지 출력

DECLARE
	i int := 1;
BEGIN
	LOOP
		DBMS_OUTPUT.PUT_LINE('현재 값 i 값은 '||to_char(i,'0099')||' 이다.');
		i := i + 1;
		if i > 50 then
			exit;
		end if;
	END LOOP;
END;
/
```

```sql
-- 참고 TO_CHAR 변환
BEGIN
	DBMS_OUTPUT.PUT_LINE(TO_CHAR(100,'00999'));
END;
/
```



Q5) EMP 테이블에서 부서번호 10인 사원 평균 급여를 출력하는 익명의 블록을 완성해보자.

```sql
SELECT AVG(SAL)
FROM EMP
WHERE DEPTNO = 10
GROUP BY DEPTNO;


DECLARE
	avg01 number(7) := 0;
	deptno01 number(7) := 10;
BEGIN
	SELECT AVG(SAL) into avg01
	FROM EMP
	WHERE DEPTNO = deptno01
	GROUP BY DEPTNO; -- select문은 put_line으로 바로 호출 불가능. ;로 문장이 바로 끝나기때문.
	-- 임의 변수를 만들어서 담아줘야한다.
	dbms_output.put_line(deptno01||' 번 부서의 평균 급여는 ['||avg01||']원 입니다.');
END;
/

-- avg01 : select에서 나온 값을 저장하기 위한 변수
```



Q6) 20번 부서에 [5]명에 대한 평균 급여는 [2175]원이다. 익명으로 풀어보자.

EMP 테이블에서 20번 부서의 개수, 평균 급여를 구하자.

```sql
SELECT COUNT(DEPTNO), AVG(SAL)
FROM EMP
WHERE DEPTNO = 20
GROUP BY DEPTNO;


DECLARE
	DNO NUMBER(5) := 0;
	AVGSAL NUMBER(7) := 0;
BEGIN
	SELECT COUNT(DEPTNO), AVG(SAL) INTO DNO, AVGSAL
	FROM EMP
	WHERE DEPTNO = 20
	-- GROUP BY DEPTNO; 해도 같고 안해도 같고 결과가 같다잉
	DBMS_OUTPUT.PUT_LINE('20번 부서에 ['||DNO||']명에 대한 평균 급여는 ['||AVGSAL||']원이다.');
END;
/
```



---

 ACCEPT 변수 PROMPT '출력문장' -> 사용자 입력라인값을 읽어서 변수에 저장 %TYPE (% : 역참조 의미)

Q7)  사번을 입력해서 이름을 리턴받자. (7499)

```sql
ACCEPT INPUT_VAL PROMPT '사번 입력 : '

DECLARE
	my_name emp.ename%type; -- emp테이블의 ename에 있는 데이터타입과 같은걸 쓰고싶다. = varchar2(10)
	
BEGIN
	SELECT ENAME INTO MY_NAME 
	FROM EMP
	WHERE EMPNO = &INPUT_VAL; -- 역참조. 
	DBMS_OUTPUT.PUT_LINE('현재의 결과는 '||MY_NAME|| ' 이다.'); 
END;
/

```



Q8) 30번 부서의 인원수는 [6]이고 평균급여는 [777]원 이다. [D] 등급이다.

조건 : 2100이상이면 'A' / 2000이상이면 'B' / 1500 'C' / 1000 'D' / 나머지 F이다.

```sql
DECLARE
	DCOUNT NUMBER(4) := 0;
	AVGSAL EMP.SAL%TYPE;
	GRADE_SAL VARCHAR2(6);
BEGIN 
	SELECT COUNT(DEPTNO), AVG(SAL) INTO DCOUNT, AVGSAL
	FROM EMP
	WHERE DEPTNO = 30
	GROUP BY DEPTNO;
	IF AVGSAL >= 2100 THEN
		GRADE_SAL := 'A';
	ELSIF AVGSAL >= 2000 THEN
		GRADE_SAL := 'B';
	ELSIF AVGSAL >= 1500 THEN
		GRADE_SAL := 'C';
	ELSIF AVGSAL >= 1000 THEN
		GRADE_SAL := 'D';
	ELSE 
		GRADE_SAL := 'F';
	END IF;
	DBMS_OUTPUT.PUT_LINE('30번 부서의 인원수는 ['||DCOUNT||']이고 평균급여는 ['||AVGSAL||']원 이다. ['||GRADE_SAL||'] 등급이다.');
	
END;
/
```

---



#### PROCEDURE 프로시져란?

특정 작업을 수행 할 수 있고 이름이 있는 PL/SQL 블록으로서 매개변수를 받을 수도 있고 반복적으로 사용할 수 있다.

보통 연속실행 또는 구현이 복잡한 트랜잭션을 수행하는 PL/SQL 블록을 데이터베이스에 저장하기 위해서 생성한다.

트랜잭션 : 작업의 단위, 일련의 작업등을 하나의 프로세서(exe)로 취하는 것



```sql
CREATE PROCEDURE p_name
	IN args -- 실행 환경에서 값을 전달
	OUT arg -- 값을 리턴
	IN OUT arg  -- 전달, 리턴한다.
is
	변수선언
BEGIN

END p_name;
```



Q9)

```sql
-- 프로시져 생성
CREATE PROCEDURE update_sal(v_empno in number)
is
BEGIN
	update emp set sal = sal + 100
	where empno = v_empno;
	commit;
END update_sal;
/

-- 프로시져로 적용하기 전
SELECT EMPNO, SAL FROM EMP WHERE EMPNO= 7369;

-- ---------------------------------------------------------------------
EMPNO        SAL
---------- ----------
      7369        800
-- ---------------------------------------------------------------------

-- 프로시져 적용       
EXECUTE UPDATE_SAL(7369); -- 오라클에선 EXEC UPDATE_SAL(7369); 라고 써도된다.

-- 프로시져 적용 후
SELECT EMPNO, SAL FROM EMP WHERE EMPNO= 7369;

-- ---------------------------------------------------------------------
 EMPNO        SAL
---------- ----------
      7369        900
-- ---------------------------------------------------------------------

-- SAL 이 100원 올랐다.
```



Q10) 부서번호를 입력받아 사원의 번호, 이름, 급여, 직업을 출력해보자. **rowtype**

```sql
create or replace PROCEDURE EX_PRO01_0601(P_EMPNO IN EMP.EMPNO%TYPE)
AS
 V_EMP EMP%rowtype; -- 한줄의 레코드 타입이 지정된다. 전체열 다 타입 복사

BEGIN
 SELECT EMPNO, ENAME, SAL, JOB INTO V_EMP.EMPNO, V_EMP.ENAME, V_EMP.SAL, V_EMP.JOB
 FROM EMP
 WHERE EMPNO = P_EMPNO;
    
 DBMS_OUTPUT.PUT_LINE('사원 번호 '|| V_EMP.EMPNO);
 DBMS_OUTPUT.PUT_LINE('사원 이름 '|| V_EMP.ENAME);
 DBMS_OUTPUT.PUT_LINE('사원 봉급 '|| V_EMP.SAL);
 DBMS_OUTPUT.PUT_LINE('사원 직업 '|| V_EMP.JOB);
    
END EX_PRO01_0601;

-- 디버그 후 실행할 때 EMPNO에 7902를 줘보자.
EXEC EX_PRO01_0601(7902);

-- 화면이 안뜨면 SET SERVEROUTPUT ON
```



```sql
-- 만들어진 stored procedure list 보기
SELECT * FROM user_procedure;

-- 프로시저의 내용까지 확인
SELECT * FROM user_source;

SELECT object_name, status
FROM user_objects
WHERE object_type = 'VIEW'; -- where object_type = 'PROCEDURE';

SELECT object_name, status
FROM user_objects
WHERE object_type = 'PROCEDURE';
```



#### Function

```sql
CREATE FUNCTION function_name RETURN 반환 데이터타입 AS

BEGIN

END; -- function_name;
```

Q) 사번을 입력받아서 월급에 100을 더한 결과를 리턴받자.

```sql
CREATE FUNCTION FUN0601 (V_EMPNO EMP.EMPNO%TYPE) RETURN NUMBER AS
V_SAL EMP.SAL%TYPE;
BEGIN
	UPDATE EMP SET SAL = SAL+100
	WHERE EMPNO = V_EMPNO;
	COMMIT;
	
    SELECT SAL INTO V_SAL
    FROM EMP
    WHERE EMPNO = V_EMPNO;
    
    RETURN V_SAL;
    
END;
/
```

```sql
-- 변수 만들기
var res_sal number;

-- 함수 호출시 리턴하는 값을 대입 후 실행, 변수 넣어줄때 앞에 :를 써주자.
EXECUTE :RES_SAL := FUN0601(7369);

-- 내용 출력
print res_sal;
```



```sql
CREATE OR REPLACE FUNCTION FUN20601 (V_ID emp.empno%type) RETURN NUMBER 
AS 
V_SAL EMP.SAL%TYPE := 0;

BEGIN
    SELECT SAL INTO V_SAL
    FROM EMP
    WHERE EMPNO = V_ID;
    
    RETURN V_SAL;
    
END FUN20601;
```



Q) 사번을 입력받아 연봉을 계산해서 리턴하는 함수 (연봉 = 봉급*12 + 커미션)

```sql
CREATE OR REPLACE FUNCTION FUN30601 (V_EMPNO EMP.EMPNO%TYPE) RETURN NUMBER AS
V_SAL EMP.SAL%TYPE := 0;
BEGIN
  SELECT SAL*12+NVL(COMM,0) INTO V_SAL
  FROM EMP
  WHERE EMPNO = V_EMPNO;
  
  RETURN V_SAL;
END FUN30601;

-- 실행
SELECT ENAME, EMPNO, SAL, COMM, FUN30601(EMPNO) FROM EMP;
```

```
ENAME  EMPNO     SAL     COMM  FUN30601(EMPNO)
SMITH	7369	1100	    	13200
ALLEN	7499	1600	300	    19500
WARD	7521	1250	500	    15500
JONES	7566	2975		    35700
MARTIN	7654	1250	1400	16400
BLAKE	7698	2850		    34200
CLARK	7782	2450		    29400
KING	7839	5000		    60000
TURNER	7844	1500	0		18000
JAMES	7900	1150			13800
FORD	7902	3000			36000
MILLER	7934	1300			15600

```



Q) 프로시저 만들기

```sql
CREATE OR REPLACE PROCEDURE EX3_0601 (V_EMPNO EMP.EMPNO%TYPE) AS
    VV_EMPNO EMP.EMPNO%TYPE;
    VV_ENAME EMP.ENAME%TYPE;
    VV_HIREDATE EMP.HIREDATE%TYPE;
BEGIN
    SELECT EMPNO, ENAME, HIREDATE INTO VV_EMPNO, VV_ENAME, VV_HIREDATE
    FROM EMP
    WHERE EMPNO = V_EMPNO;
    
    DBMS_OUTPUT.PUT_LINE('사원번호 : '||VV_EMPNO);
    DBMS_OUTPUT.PUT_LINE('사원이름 : '||VV_ENAME);
    DBMS_OUTPUT.PUT_LINE('입사일 : '||VV_HIREDATE);
END EX3_0601;

EXEC EX3_0601(7369);
```

```sql
-- 강사님
CREATE OR REPLACE PROCEDURE EX_PRO06 (p_empno in emp.empno%type)
AS
type MY_REC is record (v_empno number, v_ename varchar2(30), v_hiredate);
empr MY_REC;

BEGIN
	dbms_output.enable;
	select empno, ename, hiredate into empr.v_empno, empr.v_ename, empr.v_hiredate
	from emp
	where empno = p_empno;
	
	dbms_output.put_line('사원번호 : '||empr.v_empno);
	dbms_output.put_line('사원이름 : '||empr.v_ename);
	dbms_output.put_line('입사일 : '||empr.v_hiredate);
	
END EX_PRO06;
```

























---

https://pixabay.com/ko/videos/search/zoom/   줌 가상배경









