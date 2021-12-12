# SQL정리1
## 예제 테이블 정리

### 1. EMP 테이블

* 사원 정보가 들어 있는 EMP 테이블
* employee, DESC 명령어를 써서 EMP테이블의 구성을 보자.

```sql
DESC EMP;
```

```sql
Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 EMPNO                                     NOT NULL NUMBER(4)
 ENAME                                              VARCHAR2(10)
 JOB                                                VARCHAR2(9)
 MGR                                                NUMBER(4)
 HIREDATE                                           DATE
 SAL                                                NUMBER(7,2)
 COMM                                               NUMBER(7,2)
 DEPTNO                                             NUMBER(2)
```

- 10byte = 한글(한글자당 2byte) 5글자, 영어(한글자당 1byte) 10글자



### 2. DEPT 테이블

- department, 회사를 구성하는 부서 데이터를 관리하는 테이블

```sql
DESC DEPT;
```

```sql
Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 DEPTNO                                    NOT NULL NUMBER(2)
 DNAME                                              VARCHAR2(14)
 LOC                                                VARCHAR2(13)
```



### 3. SALGRADE

- EMP테이블에서 관리하는 사원들의 급여와 관련된 테이블

```sql
DESC SALGRADE;
```

```sql
Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 GRADE                                              NUMBER
 LOSAL                                              NUMBER
 HISAL                                              NUMBER
```



----

SQL문에서 **테이블 이름**, **열 이름**은 **대문자**로 쓰자

SQL은 대, 소문자를 가리지 않지만 가독성을 위해서 대문자를 사용하자

---



## 데이터를 조회하는 방법

- 셀렉션(selection)
  - 행 단위로 조회
- 프로젝션(projection)
  - 열 단위로 조회
- 셀렉션(selection) + 프로젝션(projection)
  - 행과 열을 지정해서 조회
- 조인(join)
  - 두 개 이상의 테이블을 양옆에 연결해 하나의 테이블처럼 만들어 데이터를 조회

---

## SELECT절과 FROM 문

<양식>

```sql
SELECT [조회할 컬럼1], [조회할 컬럼2], ...
FROM [조회할 테이블 이름];
```

- SELECT에 컬럼을 지정하거나 \*(애스터리스크)로 전체 열을 지정
- column들을 attribute라 부른다.
- table들을 entity라고 부른다.



#### 생성된 모든 테이블 조회

```sql
SELECT *
FROM TAB;
```

```sql
TNAME           TABTYPE        CLUSTERID
--------------- -------------- ---------
BONUS           TABLE
DEPT            TABLE
EMP             TABLE
SALGRADE        TABLE
```



#### EMP 테이블 전체 조회

```sql
SELECT *
FROM EMP;
```

```sql
EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7369 SMITH                CLERK               7902 80/12/17   800           20
 7499 ALLEN                SALESMAN            7698 81/02/20  1600   300     30
 7521 WARD                 SALESMAN            7698 81/02/22  1250   500     30
 7566 JONES                MANAGER             7839 81/04/02  2975           20
 7654 MARTIN               SALESMAN            7698 81/09/28  1250  1400     30
 7698 BLAKE                MANAGER             7839 81/05/01  2850           30
 7782 CLARK                MANAGER             7839 81/06/09  2450           10
 7839 KING                 PRESIDENT                81/11/17  5000           10
 7844 TURNER               SALESMAN            7698 81/09/08  1500     0     30
 7900 JAMES                CLERK               7698 81/12/03   950           30
 7902 FORD                 ANALYST             7566 81/12/03  3000           20

EMPNO ENAME                JOB                  MGR HIREDATE   SAL  COMM DEPTNO
----- -------------------- ------------------ ----- -------- ----- ----- ------
 7934 MILLER               CLERK               7782 82/01/23  1300           10

12 rows selected.
```



#### EMP 테이블의 부분 추출

```sql
SELECT ENAME, SAL, DEPTNO
FROM EMP;
```

```sql
ENAME                  SAL DEPTNO
-------------------- ----- ------
SMITH                  800     20
ALLEN                 1600     30
WARD                  1250     30
JONES                 2975     20
MARTIN                1250     30
BLAKE                 2850     30
CLARK                 2450     10
KING                  5000     10
TURNER                1500     30
JAMES                  950     30
FORD                  3000     20

ENAME                  SAL DEPTNO
-------------------- ----- ------
MILLER                1300     10

12 rows selected.
```



#### 사원테이블과 부서테이블의 전체 내용을 조회

```sql
SELECT *
FROM EMP, DEPT; -- EMP의 12행과 DEPT의 4행이 하나하나 결합되어 총 48 rows를 갖게 됨
```

---

## Alias (별칭)

```sql
SELECT 컬럼1 AS 별칭1, 컬럼2 AS 별칭2, ...
FROM 테이블 별칭,...
```

- Oracle은 AS를 안써줘도 됨
- 별칭에 띄어쓰기가 들어가면 " "로 묶어줘야하며 그냥 단어가 들어갈시 single quotation marks(따옴표를) 쓰지않는다

#### 사원 이름과 부서번호, 부서이름을 출력하되 테이블에 각각 사원, 부서로 별칭을 주자 (테이블 별칭)

```sql
SELECT 사원.ENAME, 부서.DEPTNO, 부서.DNAME
FROM EMP 사원, DEPT 부서;
```



#### 사원테이블에서 사원의 이름, 부서번호, 봉급이라고 타이틀을 주고 출력하자.

```sql
SELECT ENAME "사원의 이름", EMPNO 부서번호, SAL 봉급
FROM EMP;
```

```sql
사원의 이름          부서번호  봉급
-------------------- -------- -----
SMITH                    7369   800
ALLEN                    7499  1600
WARD                     7521  1250
JONES                    7566  2975
MARTIN                   7654  1250
BLAKE                    7698  2850
CLARK                    7782  2450
KING                     7839  5000
TURNER                   7844  1500
JAMES                    7900   950
FORD                     7902  3000

사원의 이름          부서번호  봉급
-------------------- -------- -----
MILLER                   7934  1300

12 rows selected.
```

```sql
SELECT ENAME AS "사원의 이름", DEPTNO AS 부서번호, SAL AS 봉급
FROM EMP; -- 위와 동일하다.
```



문자열 연결 연산자



