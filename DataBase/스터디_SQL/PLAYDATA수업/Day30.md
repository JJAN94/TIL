# Day30

1. VIEW의 개념을 이해하고 기술 할 수 있다.
2. PLSQL의 문법을 이해하고 실행 할 수 있다.

오라클 책 338페이지 참고

---

#### VIEW

- 다른 테이블이나 뷰에 포함된 데이터의 맞춤 표현 Tailored Presentation

- STORED QUERY OR VIRTUAL TABLE로 간주되는 데이터 베이스 객체

- 하나 또는 하나 이상의 테이블 / 뷰에 포함된 데이터 부분 집합을 나타내는 논리적인 객체

  -> 선택적인 정보만 제공 가능

- 자체적인 데이터를 포함하지 않는다.

- 베이스 테이블 : 뷰를 통해 보여지는 데이터를 포함하고 있는 실제 테이블

---

#### VIEW 사용 목적 및 장점

1. Restricted data access
   - 뷰에 접근하는 사용자는 미리 정의된 결과만 볼 수 있다.
   - 데이터 접근을 제한함으로써 중요한 데이터를 보호할 수 있다.
2. Hide data complexity
   - 여러 테이블을 조인하는 등 복잡한 SQL구문을 사용하는 경우 자세한 SQL 구문의 내용을 숨길 수 있다.
3. Simplify statement for the user
   - 복잡한 SQL구문을 모르는 사용자라도 SELECT 구문 만으로 결과를 조회할 수 있다.
4. Present the data in different perspective
   - 뷰에 포함된 컬럼은 참조 대상 테이블에 영향을 주지 않고 다른 이름으로 참조가 가능하다.
5. Isolate applications from changes in definitions of base tables
   - 베이스 테이블에 포함된 여러개의 컬럼 중 일부만 사용하도록 뷰를 생성한 경우, 뷰가 참조하지 않는 나머지 컬럼이 변경되어도 뷰를 사용하는 다른 프로그램들은 영향을 받지 않는다.
6. Save complex queries
   - 복잡한 SQL구문을 뷰 형태로 저장해서 반복적으로 사용 가능하다.

---

#### VIEW 생성 구문

```sql
CREATE [OR REPLACE] [FORCE|NOFORCE] VIEW view_name[(alias,,,)]
AS 서브쿼리
[WITH CHECK OPTION [CONSTRAINT constraint_name] ] -- 옵션
[WITH READ ONLY [CONSTRAINT constraint_name] ]

-- |는 or뜻
```

- CREATE [OR REPLACE]

  - 지정한 뷰가 없으면 새로 생성, 동일 이름이 존재하면 수정

- FORCE

  - 베이스 테이블이 존재하지 않아도 뷰 생성 가능

- NOFORCE

  - 베이스 테이블이 존재 해야만이 뷰 생성 가능

- ALIAS

  - 뷰에서 사용되는 컬럼명, 생략시 SUBQUERY가 사용한 컬럼명을 사용한다. 
  - SUBQUERY가 사용한 SELECT LIST의 개수와 동일하다.

- 제약조건 (제약조건으로 간주되므로 이름 지정 가능)

  - WITH CHECK OPTION : 뷰를 통해 접근 가능한 데이터에 대해서만 DML 작업 허용

    ​										조건에 따라 INSERT/UPDATE 작업 제한 (DELETE는 제한이 없음)

  - WITH READ ONLY : 뷰를 통해 DML 작업을 허용 안함



```sql
CREATE OR REPLACE VIEW V_EMP
AS SELECT ENAME, DEPTNO FROM EMP WHERE DEPTNO=30;
```







#### VIEW - 데이터 조회 절차

뷰를 사용한 SQL 구문해석 -> 데이터 딕셔너리 "USER_VIEWS"에서 뷰 정의 검색

-> SQL 구문을 실행한 계정이 관련된 베이스 테이블에 접근하여 SELECT 할 수 있는 권한이 있는지 확인

-> 뷰 대신 데이터 베이스 기반으로 하는 동등한 작업으로 변환

-> 베이스 테이블을 대상으로 데이터 조회



Q19) 별칭에 ""을 구현하자.

```sql
CREATE OR REPLACE VIEW V_EMP_DEPT02("M_NAME", "M_DNAME", "M_JOB")
AS SELECT ENAME, DNAME, JOB
FROM EMP
LEFT JOIN DEPT USING(DEPTNO);

SELECT M_NAME, M_JOB
FROM V_EMP_DEPT02
WHERE M_JOB = 'CLEARK';

SELECT M_NAME, M_JOB
FROM V_EMP_DEPT02
WHERE M_JOB = 'CLEARK';

CREATE VIEW V_EMP_DEPT02("M_NAME", "M_DNAME", "M_JOB")
AS SELECT ENAME, DNAME, JOB
FROM EMP
LEFT JOIN DEPT USING(DEPTNO);
```







Q20) 뷰를 삭제해보자

```
DROP VIEW V_EMP_DEPT02;
```





Q21) VIEW를 이용해서 부서별 평균 월급보다 더 많은 월급을 받는 사원과 월급을 출력 해보자.

```sql
CREATE OR REPLACE VIEW V_DEPT_SALAVG("Did", "Davg")
AS SELECT NVL(DEPTNO, 10),
ROUND(AVG(SAL),-1)
FROM EMP
GROUP BY DEPTNO;

SELECT * FROM V_DEPT_SALAVG;

SELECT ENAME, SAL
FROM EMP
JOIN V_DEPT_SALAVG ON (NVL(DEPTNO, 10)="Did")
WHERE SAL > "Davg"
ORDER BY 2 DESC;
```





Q22) 인라인 뷰(Inline View)를 사용해보자.

```sql
SELECT ENAME, SAL
FROM (SELECT NVL(DEPTNO, 10) AS "Did",
      ROUND(AVG(SAL),-1) AS "Davg"
      FROM EMP
      GROUP BY DEPTNO) V_DEPT_SALAVG
JOIN EMP ON (NVL(DEPTNO, 10)=V_DEPT_SALAVG."Did")
WHERE SAL > V_DEPT_SALVAG."Davg"
ORDER BY 2 DESC;
```







---

## PL/SQL

- Procedural Language / sql / Oracle's procedural Language Extension to SQL 의 약어
- 오라클 DB 환경에서 실행되는 절차적인 데이터 베이스 프로그래밍 언어
- PL/SQL에서는 프로그램단위를 block이라고 부르며 애플리케이션 로직들을 작성
- 변수정의, 조건처리, 반복문, Procedure Language 이다.
- 모듈화 PL/SQL 장점

SQL만으로 구현이 어렵거나 구현 불가능한 작업을 수행하기 위해 오라클에서 제공하는 프로그래밍 언어
변수, 조건처리, 반복 처리 등 다른 프로그래밍 언어에서도 제공하는 다양한 기능을 사용 할 수 있음

```sql
<< label >> (optional)
DECLARE    -- Declarative part (optional)
  -- Declarations of local types, variables, & subprograms

BEGIN      -- Executable part (required)
  -- Statements (which can use items declared in declarative part)

[EXCEPTION -- Exception-handling part (optional)
  -- Exception handlers for exceptions (errors) raised in executable part]
END;
```

#### 블록

데이터베이스 관련 특정 작업을 수행하는 명령어와 실행에 필요한 여러 요소를 정의하는 명령어 등으로 구성, 이러한 명령어를 모아둔 기본 단위를 블록(block)이라 한다.

| 구성 키워드            | 필수/선택 | 설명                                                         |
| ---------------------- | --------- | ------------------------------------------------------------ |
| DECLARE(선언부)        | 선택      | 실행에 사용될 변수, 상수, 커서 등을 선언                     |
| BEGIN(실행부)          | 필수      | 조건문, 반복문, SELECT, DML, 함수 등을 정의                  |
| EXCEPTION(예외 처리부) | 선택      | PL/SQL 실행 도중 발생하는 오류(예외상황)를 해결하는 문장 기술 |

```sql
DECLARE
[실행에 필요한 여러 요소 선언];
BEGIN
[작업을 위해 실제 실행하는 명령어];
EXCEPTION
[PL/SQL 수행 도중 발생하는 오류 처리];
END;
```

```sql
SET SERVEROUTPUT ON
-- 이걸 입력해야 커맨드창에 PRINT결과가 뜬다.
```



Oracle SQL Developer -> 프로시저 -> 새 프로시저 만들기(프로시저에서 실행해야 한다.)

**간단한 print문**

```sql
BEGIN
DBMS_OUTPUT.DISABLE;
DBMS_OUTPUT.PUT_LINE('111111111111111111');
DBMS_OUTPUT.ENABLE;
DBMS_OUTPUT.PUT_LINE('222222222222222222');
END;
/
```

**값 할당 후 print**

```sql
CREATE OR REPLACE PROCEDURE EX_PRO01 AS
    i NUMBER :=20;
BEGIN
    DBMS_OUTPUT.PUT_LINE('현재의 값은 ?'||i);

END EX_PRO01;
```

oracle에서 =은 := 이다. (할당연산자)

**사칙연산**

```sql
CREATE OR REPLACE PROCEDURE EX_PRO02 AS 
 i number := 100;
 j number := 200;
 k integer := 300;
 
BEGIN
 dbms_output.put_line(i || '+' || j || '=' || (i+j));
 dbms_output.put_line(i*j*k);
END EX_PRO02;
```

**조건문**

```sql
CREATE OR REPLACE PROCEDURE EX_PRO03 AS 
i int := 10;
BEGIN
 if i != 20 Then
    dbms_output.put_line('i='||i);
 end if;
END EX_PRO03;
```

```sql
CREATE OR REPLACE PROCEDURE EX_PRO04 AS 
score01 int := 85;
grade varchar2(3);

BEGIN
 if score01 >= 90 Then grade := 'A';
 elsif score01 >= 80 Then grade := 'B';
 elsif score01 >= 70 Then grade := 'C';
 elsif score01 >= 60 Then grade := 'D';
 else
    grade := 'f';
 end if;
 dbms_output.put_line('SCORE : '||score01 || '  Grade : '||grade);

END EX_PRO04;
```













---

## 책 내용 추가

#### 뷰의 사용목적

1. 편리성
   - 실무에서는 SQL문이 A4몇장씩 될 정도 많은 분량으로 이루어진 경우도 있다.
   - SQL문에서 자주 활용하는 SELECT문을 뷰로 저장해 놓은 후 다른 SQL문에서 활용하면 전체 SQL문의 복잡도를 완화하고 본래 목적의 메인 쿼리에 집중할 수 있어 편리하다.
2. 보안성
   - 일부 데이터 또는 조인이나 여러 함수등으로 가공을 거친 데이터만 SELECT하는 뷰 열람 권한을 제공하는 것이 가능.
   - 예민한 데이터나, 불필요한 데이터 노출을 막을 수 있다.



#### 뷰 생성

SCOTT계정은 뷰 생성 권한이 없으므로 SYSTEM계정에서 권한 부여를 해줘야한다.

```sql
SQLPLUS SYSTEM/(내가 설정한 비밀번호)
GRANT CREATE VIEW TO SCOTT;
```

#### 참고 (MYDB 계정생성)

```sql
SQLPLUS SYSYEM/(내가 설정한 비밀번호) 접속 후

create user MYDB identified by 비밀번호;
grant CREATE SESSION, ALTER SESSION, CREATE DATABASE LINK, -
  CREATE MATERIALIZED VIEW, CREATE PROCEDURE, CREATE PUBLIC SYNONYM, -
  CREATE ROLE, CREATE SEQUENCE, CREATE SYNONYM, CREATE TABLE, - 
  CREATE TRIGGER, CREATE TYPE, CREATE VIEW, UNLIMITED TABLESPACE -
  to MYDB;
-- 생성완료, exit하고 MYDB로 접속

@"c:\Test\myscott.sql"
-- sql파일과 계정 연동시키는 작업
```



FORMAT

```sql
CREATE [OR REPLACE] [FORCE|NOFORCE] VIEW 뷰이름 (열이름1, 열이름2,,,)
AS (저장할 SELECT문(서브쿼리))

[WITH CHECK OPTION [CONSTRAINT 제약 조건]]
[WITH READ ONLY [CONSTRAINT 제약 조건]]
```

| 요소              | 설명                                                         |
| ----------------- | ------------------------------------------------------------ |
| OR REPLACE        | 같은 이름의 뷰가 이미 존재할 경우에 현재 생성할 뷰로 대체하여 생성(선택) |
| FORCE             | 뷰가 저장할 SELECT문의 기반 테이블이 존재하지 않아도 강제로 생성(선택) |
| NOFORCE           | 뷰가 저장할 SELECT문의 기반 테이블이 존재할 경우에만 생성(default) (선택) |
| 뷰 이름           | 생성할 뷰 이름 지정**(필수)**                                |
| 열 이름           | SELECT문에 명시된 이름 대신 사용할 열 이름 지정(생략가능)(선택) |
| 저장할 SELECT문   | 생성할 뷰에 저장할 SELECT문 지정**(필수)**                   |
| WITH CHECK OPTION | 지정한 제약 조건을 만족하는 데이터에 한해 DML 작업이 가능하도록 뷰 생성(선택) |
| WITH READ ONLY    | 뷰의 열람, 즉 SELECT만 가능하도록 뷰 생성(선택)              |

생성 예시

```sql
CREATE VIEW VW_EMP20
AS (SELECT EMPNO, ENAME, JOB, DEPTNO
    FROM EMP
    WHERE DEPTNO=20);
    
-- 생성한 뷰 확인(USER_VIEWS 데이터 사전 조회)
SELECT *
FROM USER_VIEWS;
```



Q3) VIEW를 생성한다.

```sql
CREATE OR REPLACE VIEW V_EMP
AS SELECT ENAME, DEPTNO FROM EMP WHERE DEPTNO=30;
```



Q4) VIEW 생성 정보를 확인 해보자. USER_TAB_COLS

```sql
SELECT COLUMN_NAME, DATA_TYPE, NULLABLE
FROM USER_TAB_COLS
WHERE TABLE_NAME = 'V_EMP';

COLUMN COLUMN_NAME FORMAT A20
COLUMN DATA_TYPE FORMAT A20
COLUMN NULLABLE FORMAT A10

COLUMN_NAME          DATA_TYPE            NULLABLE
-------------------- -------------------- ----------
ENAME                VARCHAR2             Y
DEPTNO               NUMBER               Y
```

```sql
-- 모든 정보를 표현해줌
SELECT *
FROM USER_TAB_COLS;
```

```sql
SELECT *
FROM USER_TAB_COLS
WHERE TABLE_NAME = 'V_EMP';
```



Q5) 조인한 결과로 테이블을 생성해보고 내용 확인하기

```sql
CREATE OR REPLACE VIEW V_EMP_DEPT
AS SELECT ENAME, DNAME, JOB
FROM EMP
LEFT JOIN DEPT USING(DEPTNO);
```



Q6) 확인

````sql

````



Q7) ALIAS를 써보자

```sql
```











GRANT/REVOKE 설명

https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=heartflow89&logNo=221002112762





