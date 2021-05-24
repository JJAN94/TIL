조인(join)은 두 개 이상의 테이블을 연결하여 하나의 테이블처럼 출력할 때 사용하는 방식



집합연산자와의 차이점

- 집합 연산자를 사용한 결과는 두 개 이상 SELECT문의 결과 값을 세로로 연결한 것, 조인을 사용한 결과는 두 개 이상의 테이블 데이터를 가로로 연결한 것이라고 볼 수 있다.



FROM 절에 여러 개 테이블을 지정하는 것이 가능. 꼭 테이블이 아니더라고 테이블 형태, 즉 열과 행으로 구성된 데이터 집합이면 모두 FROM절에 지정 가능. (뷰view, 서브쿼리subquery등이 이에 해당)

```sql
SELECT 열1, 열2, ,,, ,열N
FROM EMP
WHERE 조건식
GROUP BY 그룹식
HAVING 그룹조건식
ORDER BY 정렬식
```

FROM절도 FROM 테이블1, 테이블2, ... , 테이블N이 가능 (WHERE, GROUP BY, ORDER BY절 등 다른절도 가능)



FROM 절에 여러 테이블 선언하기

```sql
SELECT *
FROM EMP, DEPT
ORDER BY EMPNO;
```





```
SELECT *
FROM EMP, DEPT
WHERE EMP.DEPTNO = DEPT.DEPTNO
ORDER BY EMPNO;
```





## 테이블의 별칭 설정

```sql
FROM 테이블 이름1 별칭1, 테이블 이름2 별칭2, ...
```

```sql
SELECT *
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
ORDER BY EMPNO;
```



모두를 띄울때도 *쓰는 것보다 하나하나 지정해주느게 좋다.

```sql
SELECT E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM, E.DEPTNO, D.DNAME, D.LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
ORDER BY EMPNO;
```



# 조인의 종류

#### EQUI JOIN (그냥 JOIN = INNER JOIN이라고도 함)

- 테이블을 연결한 후에 출력 행을 각 테이블의 특정 열에 일치한 데이터를 기준으로 선정하는 방식
- 두 개의 테이블간의 컬럼 값들이 정확하게 일치하는 경우 데이터를 리턴



-주의-

여러 테이블의 열 이름이 같을 때 유의점

```sql
SELECT EMPNO, ENAME, DEPTNO, DNAME, LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO;
```

위에서 DEPTNO는 EMP, DEPT에 다 있음. 일반 JOIN에서 어느 테이블의 열인지 명시를 안해주면 에러가 난다.

[ERROR] Execution (1: 22):ORA-00918 : 열의 정의가 애매합니다 (column ambiguously defined)

\>>이렇게 쓰자

```sql
SELECT E.EMPNO, E.ENAME, D.DEPTNO, D.DNAME, D.LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
ORDER BY D.DEPTNO, E.EMPNO;
```





WHERE절에 추가로 조건식 넣어 출력하기

```sql
SELECT E.EMPNO, E.ENAME, E.SAL, D.DEPTNO, D.DNAME, D.LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND SAL>= 3000;
```

대부분 SELECT 문이 그렇듯이 모든 데이터를 출력해야 하는 경우는 그리 흔치 않다. 구체적인 데이터를 출력하기 위해 WHERE 절에 조인 조건 외에도 다양한 조건식을 활용한다.



조인 테이블 개수와 조건식 개수의 관계

기본적으로 Cartesian product현상이 일어나지 않게 하는 데 필요한 조건식의 최소 개수는 조인 테이블 개수에서 하나를 뺀 값이다.

만약 A,B,C 테이블을 연결하려면 A,B를 연결하고 (A,B)와 C를 연결해줄 조건이 필요하다.

WHERE절의 조건식을 사용해 테이블을 조인할 때 반드시 각 테이블을 정확히 연결하는 조건식이 최소한 전체 테이블 수보다 하나 적은 수만큼 있어야 한다.



Q) EMP 테이블 별칭을 E로, DEPT 테이블 별칭은 D로 하여 다음과 같이 EQUI JOIN을 했을 때 급여가 2500이하이고 사원 번호가 9999이하인 사원의 정보가 출력되도록 다음 SQL문 코드를 채워 보자.

```sql
SELECT E.EMPNO, E.ENAME, E.SAL, D.DEPTNO, D.DNAME, D.LOC
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND E.SAL<=2500 AND D.DEPTNO <= 9999; 
```



#### NON - EQUI JOIN

- EQUI JOIN 방식 외의 방식을 의미한다.
- 두 개의 테이블 간의 컬럼 값들이 정확하게 일치하지 않은 경우 사용

급여 범위를 지정하는 조건식으로 조인하기

```sql
SELECT *
FROM EMP E, SALGRADE S
WHERE E.SAL BETWEEN S.LOSAL AND S.HISAL;
```

NON EQUI JOIN은 EQUI JOIN에 비해 자주 쓰는 방식은 아니다. 하지만 조인 조건이 특정 열의 일치 여부를 검사하는 방식 외에 다른 방식도 사용할 수 있음을 기억하자.



#### SELF JOIN

- self join은 하나의 테이블을 여러 개의 테이블처럼 활용하여 조인하는 방식으로 물리적으로 동일한 테이블 여러 개를 사용할 때 발생할 수 있는 문제점을 해결한다.

- FROM 절에 같은 테이블을 여러 번 명시하되 테이블의 별칭만 다르게 지정하는 방식으로 사용한다.

- 같은 테이블에 있는 행들을 join하는데 사용

```sql
SELECT E1.EMPNO, E1.ENAME, E1.MGR, E2.EMPNO "MGR_EMPNO", E2.ENAME "MGR_ENAME"
FROM EMP E1, EMP E2
WHERE E1.MGR = E2.EMPNO;
--결과에 MGR=NULL인 KING은 제외되었음
```



#### OUTER JOIN

- 주종 관계를 만들어서 주테이블은 전체 출력, 종테이블은 TRUE만 출력 (종에 (+)를 주자)

- SELF JOIN에서 KING은 제외되었음. 최고상급자라 위에 누가 더 없어서. 그래서 총 11row만 표시됨.

  하지만 NULL이있어도 출력에 포함시켜야 한다면?

  이렇듯 두 테이블간 조인 수행에서 조인 기준 열의 어느 한쪽이 NULL이어도 강제로 출력하는 방식을 OUTER JOIN이라고 한다.

- OUTER JOIN은 좌우를 따로 나누어 지정하는데 WHERE 절에 조인 기준 열 중 한쪽에 (+) 기호를 붙여준다.

```sql
WHERE TABLE1.COL1 = TABLE2.COL1(+) --왼쪽 OUTER JOIN(LEFT OUTER JOIN)
WHERE TABLE1.COL1(+) = TABLE2.COL1 --오른쪽 OUTER JOIN(RIGHT OUTER JOIN)
```



```sql
SELECT E1.EMPNO, E1.ENAME, E1.MGR, E2.EMPNO "MGR_EMPNO", E2.ENAME "MGR_ENAME"
FROM EMP E1, EMP E2
WHERE E1.MGR = E2.EMPNO(+)
ORDER BY E1.EMPNO;
--LEFT OUTER JOIN
--왼쪽 열을 기준으로 오른쪽 열의 데이터 존재 여부에 상관없이 출력하라
```

```sql
SELECT E1.EMPNO, E1.ENAME, E1.MGR, E2.EMPNO "MGR_EMPNO", E2.ENAME "MGR_ENAME"
FROM EMP E1, EMP E2
WHERE E1.MGR(+) = E2.EMPNO
ORDER BY E1.EMPNO;
--RIGHT OUTER JOIN
--오른쪽 열을 기준으로 왼쪽 열 데이터의 존재와 상관없이 데이터를 출력하라
```















