# Java 변수

### 변수란?

- 값을 저장할 수 있는 메모리의 특정 주소에 붙이는 이름이다.
- 변수를 통해 메모리의 특정 주소에 값을 저장하고 로드할 수 있다.



#### 변수 선언 방법

- 변수를 어떤 데이터 타입(type)으로 저장할 지, 변수이름과 함께 선언한다.

```java
int score;
double height;
```



### 변수명 규칙

변수 이름은 그 변수가 의미하는 단어와 매칭 되는 이름으로 짓는게 좋다.

- 숫자로 시작할 수 없다.
- $, _ 외에 특수 문자를 사용할 수 없다.
- 영어 대소문자를 구분한다.
- 예약어 사용 불가능
- 길이 제한 없음
- 첫 문자는 영어 소문자로 시작하며, 추가 단어가 붙으면 대문자로 시작, ex) maxSpeed, firstName



### \*자바예약어

| 분류             | 예약어                                                       |
| ---------------- | ------------------------------------------------------------ |
| 기본 타입        | boolean, byte, char, short, int, long, float, double         |
| 접근 제한자      | private, protected, public                                   |
| 클래스와 관련    | class, abstract, interface, extends, implements, enum        |
| 객체와 관련      | new, instanceof, this, super, null                           |
| 메소드와 관련    | voide, return                                                |
| 제어문과 관련    | if, else, switch, case, default, for, do, while, break, continue |
| 논리값           | true, false                                                  |
| 예외 처리와 관련 | try, catch, finally, throw, throws                           |
| 기타             | package, import, synchronized, final, static                 |

Java language Keywords

| abstract  | continue | for        | new        | switch       |
| --------- | -------- | ---------- | ---------- | ------------ |
| assert*** | default  | goto*      | package    | synchronized |
| boolean   | do       | if         | private    | this         |
| break     | double   | implements | protected  | throw        |
| byte      | else     | import     | public     | throws       |
| case      | enum**** | instanceof | return     | transient    |
| catch     | extends  | int        | short      | try          |
| char      | final    | interface  | static     | void         |
| class     | finally  | long       | strictfp** | volatile     |
| const*    | float    | native     | super      | while        |

| *    |      | not used     |
| ---- | ---- | ------------ |
| **   |      | added in 1.2 |
| ***  |      | added in 1.4 |
| **** |      | added in 5.0 |



### 변수에 값 저장

대입연산자(=)를 이용해서 값을 할당한다.

```java
int score; //int score는 변수 선언부
score = 100; //score는 값 할당

// 또는
int score = 100; // 한번에 쓰는 것도 가능하다.
```

변수 선언부는 단순히 변수이름을 선언하는 것이고, 값을 할당할 때 변수가 생성된다. 이를 **변수 초기화**라고 하며, 이때 사용한 값을 **초기값**이라 한다.



### 변수 사용 예제1)

```java
package com.study;
// 변수 예제1
public class VariableStudy01 {
	public static void main(String[] args) {
		int hour = 1; // 변수 hour선언
		int minute = 12; // 변수 minute 선언
		
		System.out.println("현재시각은 오전 " + hour+":"+minute+"입니다.");
	}
}
```

```
현재시각은 오전 1:12입니다.
```



### 변수 사용 범위

- 자바 변수는 모두 {} 블록 내에서 선언되고 사용된다. 
- 메소드 안에서 선언된 변수를 로컬변수(local variable)이라고 한다.
- 로컬 변수는 메소드 안에서만 생성되었다가 메소드가 종료되면 메모리에서 자동으로 삭제된다.
- 즉, 선언된 블록에서만 사용되니 범위를 주의하자.
- 주의사항
  - 변수가 어떤 범위에서 사용되는지 선언 전 고민할 것 (선언 지점 고민)
  - 메소드 전체에서 사용하고 싶다면, 메소드 블록 맨 앞에서 선언할 것
  - 특정 블록에서만 쓰고싶다면 그 특정블록에서만 선언 할 것



다음 예제는 에러가 난다. 변수 범위를 읽지 못하기 때문이다.

```java
package com.study;

public class VariableStudy02 {
	
	public static void main(String[] args) {
		int a = 10;
		if(a>5) {
			int b = 20;
		}
		int c = a+b;
		System.out.println(c);

	}
}
```

```
Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
	b cannot be resolved to a variable
```

