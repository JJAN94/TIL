# CRUD

CRUD는 대부분의 소프트웨어서 기본적으로 쓰는 데이터 처리 기능이다.
CREATE / READ / UPDATE / DELETE를 말한다.

기능의 상세한 내용은 다음과 같다.

| 이름              | 기능         | SQL    |
| ----------------- | ------------ | ------ |
| Create            | 생성         | INSERT |
| Read or Retrieve  | 읽기 or 인출 | SELECT |
| Update            | 갱신         | UPDATE |
| Delete or Destroy | 삭제 or 파괴 | DELETE |



## CRUD에 대한 SQL 문법(MySQL)

### 1. SELECT

데이터베이스 내의 테이블에서 원하는 정보를 추출 하는 명령

* 기본 Form

```mysql
SELECT 컬럼 이름
FROM 테이블 이름
[WHERE 조건절]
```



원래 테이블의 전체 이름은 '데이터베이스이름.테이블이름' 형태이다.
USE를 사용해서 데이터베이스를 선택하면 데이터베이스 이름을 생략하도 된다.
\*는 '모든 것'을 의미한다.

```mysql
SELECT *
FROM employees.titles;

>>
SELECT *
FROM titles;
```



특정열을 가져오고 싶으면 특정 열 이름을 ,로 나열하면 된다.

```mysql
SELECT first_name, last_name, gender
FROM employess;
```



Q) employees 테이블의 first_name, gender열을 찾아보자.

```mysql
SELECT first_name, gender
FROM employees;
```

```
| Niranjan       | M      |
| Youpyo         | M      |
| Kwangsub       | F      |
| Dekang         | F      |
| Francoise      | M      |
| Alain          | M      |
...
```



#### 별칭(alias)

열 이름을 별도의 원하는 이름으로 지정해서 조회할 수 있다. 열 이름 뒤 AS 별칭으로 하면된다.

```mysql
SELECT first_name AS 이름, gender 성별, hire_date '회사 입사일'
FROM employees;
```

```
+----------------+------+-------------+
| 이름           | 성별 | 회사 입사일 |
+----------------+------+-------------+
| Georgi         | M    | 1986-06-26  |
| Bezalel        | F    | 1985-11-21  |
| Parto          | M    | 1986-08-28  |
| Chirstian      | M    | 1986-12-01  |
| Kyoichi        | M    | 1989-09-12  |
| Anneke         | F    | 1989-06-02  |
...
```



AS는 생략해도 된다.

**단**, 별칭에 공백이 있다면 반드시 ' '로 씌어줘야 한다.



#### 조건의 WHERE

수백개, 수천개, 수백만, 수억개... 에 해당하는 데이터에서 특정 조건에 해당하는 데이터만 조회하고 싶을 때 조건절 WHERE를 써주자.

이름이 '김경호'인 사람만을 조회해보자.

```mysql
SELECT *
FROM usertbl
WHERE name = '김경호';
```

```
+--------+--------+-----------+------+---------+---------+--------+------------+
| userID | name   | birthYear | addr | mobile1 | mobile2 | height | mDate      |
+--------+--------+-----------+------+---------+---------+--------+------------+
| KKH    | 김경호 |      1971 | 전남 | 019     | 3333333 |    177 | 2007-07-07 |
+--------+--------+-----------+------+---------+---------+--------+------------+
1 row in set (0.00 sec)
```



#### WHERE와 관계연산자

Q) 1970년 이후 출생하고 키가 182 이상인 사람의 아이디와 이름을 조회해보자.

```mysql
SELECT userID, Name
FROM usertbl
WHERE birthYear >= 1970 AND height >= 182;
```

```
+--------+--------+
| userID | Name   |
+--------+--------+
| LSG    | 이승기 |
| SSK    | 성시경 |
+--------+--------+
2 rows in set (0.00 sec)
```



Q) 1970년 이후 출생하거나 키가 182 이상인 사람의 아이디와 이름을 조회해보자.

```mysql
SELECT userID, Name
FROM usertbl
WHERE birthYear >= 1970 OR height >= 182;
```

```
+--------+--------+
| userID | Name   |
+--------+--------+
| BBK    | 바비킴 |
| EJW    | 은지원 |
| KBS    | 김범수 |
| KKH    | 김경호 |
| LJB    | 임재범 |
| LSG    | 이승기 |
| SSK    | 성시경 |
+--------+--------+
7 rows in set (0.00 sec)
```



#### WHERE와 BETWEEN-AND, IN(), LIKE

- WHERE 절에 들어갈 조건이 연속형 변수인 경우(예:키, 몸무게 등등)
  - BETWEEN ~ AND 구문을 써서 해당하는 범위에 속하는 데이터를 조회할 수 있다.

Q) 키가 180에서 183에 해당하는 사람의 이름과 키를 출력해보자.

```mysql
SELECT name, height
FROM usertbl
WHERE height BETWEEN 180 AND 183;
```

```
+--------+--------+
| name   | height |
+--------+--------+
| 임재범 |    182 |
| 이승기 |    182 |
+--------+--------+
2 rows in set (0.00 sec)
```



- WHERE 절에 들어갈 조건이 이산형인 경우(예: 혈액형, 학점 등등)

  - 이산형인 경우 BETWEEN절을 쓸 수 없다.

  - 이런 경우 IN()을 써서 IN에 해당하는 데이터를 조회 할 수 있다.

Q) 주소가 경남, 전남, 경북인 사람의 이름과 주소를 조회해보자.

```mysql
SELECT name, addr
FROM usertbl
WHERE addr IN ('경남', '전남', '경북');
```

```
+--------+------+
| name   | addr |
+--------+------+
| 은지원 | 경북 |
| 김범수 | 전남 |
| 김경호 | 전남 |
| 윤종신 | 경남 |
+--------+------+
4 rows in set (0.00 sec)
```



- 특정 문자열이 들어간 데이터를 조회하고 싶을 때
  - 만약 조회하고 싶은게 김씨 성을 가진 사람이라면?
  - mDate가 2007년으로 시작하는 사람만을 조회하고 싶을때는?
  - 이런 경우는 LIKE를 쓰면된다. `_`와 `%`를 조합해서 조회가능
    - `김%`는 김으로 시작하고 뒤에는 무엇이든 와도 된다는 의미
    - `_종신`의 경우 앞에 한글자만 허락하고 이름이 종신인 사람만을 찾겠다는 의미
    - `_용%`이면 용 앞에 한글자만 오고 용 뒤에는 뭐든 와도 상관없다는 의미.
      - 예로 조용필, 사용한 사람, 이용해 줘서 감사합니다 등등...

Q) 김씨 성을 가진 사람의 이름과 키를 조회해보자.

```mysql
SELECT name, height
FROM usertbl
WHERE name LIKE '김%';
```

```
+--------+--------+
| name   | height |
+--------+--------+
| 김범수 |    173 |
| 김경호 |    177 |
+--------+--------+
2 rows in set (0.00 sec)
```



Q) 이름이 종신인 사람의 이름과 키를 출력해보자.

```mysql
SELECT name, height
FROM usertbl
WHERE name LIKE '_종신';
```

```
+--------+--------+
| name   | height |
+--------+--------+
| 윤종신 |    170 |
+--------+--------+
1 row in set (0.00 sec)
```











