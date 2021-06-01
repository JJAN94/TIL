# Day29

1. 제약 조건에 대해 살펴보고 컬럼 레벨과 테이블 레벨을 통해 구현할 수 있다.
2. 제약 조건을 수정하고 삭제할 수 있다.
3. 제약 조건의 정보를 확인 할 수 있다.

---

#### 제약조건

- 오라클에서 사용하는 제약 조건은 테이블의 특정 열에 지정한다. 
- 제약 조건을 지정한 열에는 제약 조건에 부합하지 않는 데이터를 저장 할 수 없다.  
- 제약 조건에 따라 기존 데이터의 수정이나 삭제 가능 여부도 영향을 받는다.



- not null
  - 해당 컬럼에 null을 포함하지 않도록 선언 (컬럼에만 지정 가능)
  - NULL을 제외한 데이터의 중복은 허용
- unique
  - 해당 컬럼 또는 컬럼 조합값이 유일하도록 함, 즉 중복이 불가 (컬럼, 테이블)
  - 단, NULL은 값의 중복에서 제외된다.
- primary key
  - 식별 값 (컬럼, 테이블)
  - 지정한 열이 유일한 값이면서 NULL을 허용하지 않는다. PK는 테이블에 하나만 지정가능
  - primary key = unique + not null
- references table(column)
  - 해달 컬럼이 참조하고 있는 (부모) 테이블의 특정 컬럼값들과 일치하거나 또는 null이 되도록 보장한다. (컬럼, 테이블)
- check
  - 해당 컬럼에 특정 조건에 만족 시키도록 한다. (컬럼, 테이블)
  - 설정한 조건식을 만족하는 데이터만 입력 가능
- Foreign key
  - 다른 테이블의 열을 참조하여 존재하는 값만 입력할 수 있다.



---

#### 제약조건 확인

```sql
-- 제약 조건 확인
DESC USER_CONSTRAINTS;
-- 제약조건들이 쫙 뜬다.

CONSTRAINT_NAME : 제약 조건 이름
CONSTRAINT_TYPE : 유형, P(primary key), u(unique), r(reference), c(check)

TABLE_NAME : 테이블 이름
SEARCH_CONDITION : check 제약조건 내용
R_CONSTRAINT_NAME : 참조 테이블의 primary key 이름
DELETE_RULE : 참조 테이블의 PRIMARY KEY 컬럼이 삭제 될 때 사용되는 규칙
			(NO ACTION, SET NULL, CASCADE 등)
```



```sql
-- 삭제 룰(DELETE_RULE)
-- 조건
ON DELETE CASCADE : 대상 데이터를 삭제하고, 해당 데이터를 참조하는 데이터도 삭제
ON DELETE SET NULL : 대상 데이터를 삭제하고, 해당 데이터를 참조하는 데이터는 NULL로 바꿈
ON DELETE RESTRICTED : 삭제 대상 데이터를 참조하는 데이터가 존재하면 삭제할 수 없다 (기본값)


-- 수정 룰
ON UPDATE CASCADE : 대상 데이터를 수정하면 해당 데이터를 참조하는 데이터도 수정
```





Q) EMP 테이블의 테이블 이름, 제약 조건, 타입을 확인해보자.

```sql
COLUMN TABLE_NAME FORMAT A15
COLUMN CONSTRAINT_NAME FORMAT A15
COLUMN CONSTRAINT_TYPE FORMAT A15

-- EMP
SELECT TABLE_NAME, CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'EMP';

-- 결과
TABLE_NAME      CONSTRAINT_NAME CONSTRAINT_TYPE
--------------- --------------- ---------------
EMP             PK_EMP          P
EMP             FK_DEPTNO       R

-- DEPT
SELECT TABLE_NAME, CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'DEPT';

-- 결과
TABLE_NAME      CONSTRAINT_NAME CONSTRAINT_TYPE
--------------- --------------- ---------------
DEPT            PK_DEPT         P
```



#### 테이블 생성

```sql
CREATE TABLE 테이블명(
컬럼명1 데이터 타입 [제약조건],,,
);
```



#### 테이블 수정

```sql
ALTER TABLE 테이블명
ADD 컬럼명 데이터타입[제약조건]
ADD CONSTRAINT 제약조건명 제약조건(컬럼명)
MODIFY 컬럼명 데이터타입

DROP COLUMN 컬럼명 [CASCADE CONSTRAINTS]
DROP PRIMARY KEY [CASCADE] | UNION(컬럼명...) [CASCADE]... | CONSTRAINT 제약조건명[CASCADE]...
```



#### 이름변경

```sql
ALTER TABLE 기본테이블명 RENAME TO 새테이블명
RENAME 기존테이블명 TO 새테이블명

ALTER TABLE 테이블명 RENAME COLUMN 기본컬럼명 TO 새컬럼명
ALTER TABLE 테이블명 RENAME CONSTRAINT 기존제약조건명 TO 새제약조건명
```



#### 테이블 복사

- 서브 쿼리를 이용한 테이블 생성 및 행(레코드) 복사

- 서브 쿼리를 이용해서 복사한 경우 NOT NULL을 제외한 **제약조건은 복사 안됨**

  (not null 제약조건도 SYS_\****으로 복사된다.)

```sql
CREATE TABLE 테이블명[컬럼명,,, ] AS 서브쿼리

CREATE TABLE 테이블명 1 AS SELECT * FROM 테이블명 WHERE 1=0;
```

---

Q1) 테이블 생성해보자

```sql
CREATE TABLE TEST(
ID NUMBER(5),
NAME CHAR(10),
ADDRESS VARCHAR2(50));
```



Q2) ID컬럼을 USR 컬럼으로 변경해보자

```sql
ALTER TABLE TEST
RENAME COLUMN ID TO USR;
```



Q3) TEST 테이블의 이름을 EXAM_TEST 테이블로 변경해보자.

```sql
ALTER TABLE TEST
RENAME TO EXAM_TEST;
```



Q4) EXAM_TEST 테이블을 삭제하고 휴지통을 비우자

```sql
CREATE TABLE TEST AS SELECT * FROM EXAM_TEST;

CREATE TABLE TEST01 AS SELECT * FROM EXAM_TEST;

DROP TABLE EXAM_TEST;

SELECT * FROM RECYCLEBIN; -- 휴지통 / 캐시메모리 버퍼 2K, 4K, 6K...
DESC RECYCLEBIN; -- database buffer cache

PURGE RECYCLEBIN; -- 휴지통 삭제
```



```markdown
캐시메모리(cache memory)
캐시 메모리는 마이크로프로세서가 일반적인 램에 비해 더 빨리 액세스 할 수 있는 램이다. 마이크로프로세서가 데이터를 처리할 때 제일 먼저 캐시 메모리에 있는지를 찾아본 후, 만약 거기에서 원하는 데이터를 찾으면, (읽는데 더 많은 시간이 필요한) 메인 메모리로 갈 필요가 없게 된다.

캐시 메모리는 때로 마이크로프로세서에 얼마나 가깝고, 접근하기 쉬우냐에 따라 두 단계로 나뉘어진다. 레벨-1 (흔히 L1이라고도 표기한다) 캐시는 마이크로프로세서와 같은 칩 내에 있다 (예를 들면 PowerPC 601 프로세서는 자체 칩 내에 32 KB의 L1 캐시가 내장되어 있다). 레벨-2 캐시는 보통 별도로 분리된 SRAM 칩이며, 메인 메모리는 보통 DRAM 칩을 사용한다. SRAM은 DRAM과는 달리 전자기적으로 재생시킬 필요가 없기 때문에 값이 더 비싸다. 많이 사용되는 캐시 메모리 크기는 1 MB 이다.

캐시 메모리 외에도, 많은 사람들이 램 그 자체도 하드디스크에 대해 캐시 메모리의 역할을 수행한다고 생각하는데, 그 이유는 사용자가 컴퓨터를 켜고 운영체계를 적재하면 일단 램의 모든 내용은 하드디스크로부터 가져오기 때문이며, 이후 사용자가 새로운 응용프로그램을 시작하는 바에 따라 새로운 데이터를 액세스하게 된다. 램은 하드디스크로부터 가장 최근에 읽었던 데이터를 유지하기 위해 디스크 캐시라고 불리는 특별한 장소를 가질 수 있다.
```



Q5) 휴지통에 넣지 않고 바로삭제하는 방법

```sql
DROP TABLE TEST01 PURGE;
```

![rowid](C:\Users\JAY\Desktop\놋북백업\필요\플레이데이터\데일리파일\rowid.png)

```sql
INSERT INTO TEST VALUES(11,'111','111');

SELECT ROWID, USR, NAME, ADDRESS FROM TEST;
INSERT INTO TEST VALUES(112,'111','111');
INSERT INTO TEST VALUES(113,'111','111');

SELECT ROWID, USR, NAME, ADDRESS FROM TEST;
DELETE FROM TEST
WHERE USR = 113;

SELECT ROWID, USR, NAME, ADDRESS FROM TEST;
INSERT INTO TEST VALUES(111, '111', '111');
SELECT ROWID, USR, NAME, ADDRESS FROM TEST;

-- 통상 ROWID는 데이터 삭제 후에 테이블에 삭제 되기 전까지는 행의 식별자로 존재
-- 추가하면 다른 값으로 생성된다. C->D
```



Q6) 다양한 제약 조건을 지정한 테이블을 만들어 보자. USER1

```sql
CREATE TABLE USER1(
IDX NUMBER RPIMARY KEY,
ID VARCHAR2(10) UNIQUE
NAME VARCHAR2(10) NOT NULL,
PHONE VARCHAR2(15),
ADDRESS VARCHAR2(50),
SCORE NUMBER(6,2) CHECK (SCORE >= 0 AND SCORE <=100),
SUBJECT_CODE NUMBER(5),
HIRE_DATE DATE DEFAULT SYSDATE,
MARRIAGE CHAR(1) DEFAULT 'N' CHECK(MARRIAGE IN ('Y', 'N')));
```





















---

#### 오라클 책 추가내용

데이터 무결성(data integrity)

- 데이터베이스에 저장되는 데이터의 정확성과 일관성을 보장한다는 의미
- 이를 위해 항상 유지해야 하는 기본 규칙이 존재, 제약 조건은 무결성을 지키기 위한 안전장치로 중요한 역할을 함
- insert(삽입), update(수정), 삭제(delete) 등 모든 과정에서 지켜야 함

| 종류                                 | 설명                                                         |
| ------------------------------------ | ------------------------------------------------------------ |
| 영역 무결성 <br />(domain integrity) | 열에 저장되는 값의 적정 여부를 확인. 자료형, 적절한 형식의 데이터, NULL 여부같은 정해 놓은 범위를 만족하는 데이터임을 규정 |
| 개체 무결성 <br />(entity integrity) | 테이블 데이터를 유일하게 식별할 수 있는 기본키는 반드시 값을 가지고 있어야 하며 NULL이 될 수 없고 중복될 수도 없음을 규정 |
| 참조 무결성 (referential integrity)  | 참조 테이블의 외래키 값은 참조 테이블의 기본키로서 존재해야 하며 NULL이 가능 |



#### NOT NULL (빈값을 허락하지 않는)

```sql
CREATE TABLE TABLE_NOTNULL(
LOGIN_ID VARCHAR2(20) NOT NULL,
LOGIN_PWD VARCHAR2(20) NOT NULL,
TEL VARCHAR2(20));

DESC TABLE_NOTNULL;

Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 LOGIN_ID                                  NOT NULL VARCHAR2(20)
 LOGIN_PWD                                 NOT NULL VARCHAR2(20)
 TEL                                                VARCHAR2(20)
```

```sql
INSERT INTO TABLE_NOTNULL (LOGIN_ID, LOGIN_PWD, TEL)
VALUES ('TEST_ID_01', NULL, '010-1234-5678');

ERROR at line 2:
ORA-01400: cannot insert NULL into ("SCOTT"."TABLE_NOTNULL"."LOGIN_PWD")
-- NOT NULL조건이라 NULL을 넣을 수 없다.
```

```sql
INSERT INTO TABLE_NOTNULL (LOGIN_ID, LOGIN_PWD)
VALUES ('TEST_ID_02', '1234');
-- TEL은 제약조건이 없어서 안넣어도 에러 안뜸
```

```sql
UPDATE TABLE_NOTNULL
SET LOGIN_PWD = NULL
WHERE LOGIN_ID = 'TEST_ID_02';

ERROR at line 2:
ORA-01407: cannot update ("SCOTT"."TABLE_NOTNULL"."LOGIN_PWD") to NULL
```



#### 제약 조건 확인하기

제약조건 확인 = USER_CONSTRAINTS 데이터 사전 활용

| 열 이름         | 설명                                                         |
| --------------- | ------------------------------------------------------------ |
| OWNER           | 제약 조건 소유 계정                                          |
| CONSTRAINT_NAME | 제약 조건 이름(직접 지정하지 않을 경우 오라클이 자동으로 지정함) |
| CONSTRAINT_TYPE | 제약 조건 종류, C=CHECK, NOT NULL / U=UNIQUE                 |
| TABLE_NAME      | 제약 조건을 지정한 테이블 이름                               |











CREATE TABLE job(id NUMBER(3) CONSTRAINT job_id_pk PRIMARY KEY, name VARCHAR(5) NOT NULL);







PK 드랍

ALTER TABLE JOB DROP CONSTRAINT JOB_ID_PK;







```
```



