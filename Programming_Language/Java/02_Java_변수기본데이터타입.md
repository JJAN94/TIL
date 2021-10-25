# 변수의 기본 데이터 타입

자바는 정수, 실수, 논리값을 저장할 수 있는 기본 타입을 제공한다. 이를 Primitive Data Types라고 한다. (기본 타입은 총 8개)

| 종류      | type                         |
| --------- | ---------------------------- |
| 정수 타입 | byte, char, short, int, long |
| 실수 타입 | float, double                |
| 논리 타입 | boolean                      |



### 정수 타입

- char는 음수 범위를 가질 수 없다.

- 기본 메모리 범위는 
  $$
  -2^{n-1} \ to\ 2^{n-1}-1
  $$
  

| 타입  | 메모리 사용 크기 | 저장되는 값의 허용 범위 |
| ----- | ---------------- | ----------------------- |
| byte  | 8bit (1byte)     | -2^7 ~ (2^7 -1)         |
| short | 16bit (2byte)    | -2^15 ~ (2^15 -1)       |
| char  | 16bit (2byte)    | 0 ~ (2^16 -1)           |
| int   | 32bit (4byte)    | -2^31 ~ (2^31 - 1)      |
| long  | 64bit (8byte)    | -2^63 ~ (2^63 -1)       |

참고) 개발자에 의해 직접 입력된 값을 리터럴(literal)이라고 한다.



### char 타입

- ' ' (single quotation mark)로 감싼 것을 **문자 리터럴**이라고 한다.
- 문자 리터럴은 유니코드로 변환되어 저장된다.
  - Unicode : 2byte로 표현할 수 있는 숫자(0~65535)로 mapping한 전세계 문자와 호환되는 국제 규약

```java
package com.study;
// char타입
public class VariableStudy03 {
	public static void main(String[] args) {
		int a1 = 'A'; //int타입에 문자를 입력하면 유니코드 자체가 출력된다.
		
		char a2 = 'A'; //문자 직접 입력
		char a3 = 65; //10진수 저장
		char a4 = '\u0041'; //16진수 저장
		
		char a5 = '가'; //문자 직업 입력
		char a6 =  44032; //10진수로 저장
		char a7 = '\uac00'; //16진수로 저장
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		System.out.println(a5);
		System.out.println(a6);
		System.out.println(a7);
	}
}
```

```
65
A
A
A
가
가
가
```



### String 타입

- " " (double quotation mark)로 감싼 문자 또는 여러 개의 문자들 (문자열)
- String타입은 유니코드로 변환해 저장하지 않는다
- String 타입은 기본 타입이 아니다. 클래스 타입이다.
- 이스케이프 문자를 적용할 수 있다.



### 실수 타입

- float : 32bit (4byte), 소수점 이하 7자리
- double : 64bit (8byte), 소수점 이하 15자리
  - double이 float보다 소수점 이하가 15자리에 7자리로 차이나니 더 정확한 데이터를 저장할 수 있다.
  - 특별한 이유가 없다면 double형을 쓰자.

```java
float pi = 3.14f; //3.14F;
double pi = 3.14;
```

float 타입은 뒤에 f 또는 F를 명시해줘야한다.



### 논리 타입

- true 또는 false값을 리턴한다.
- 조건문, 제어문 등에서 주로 사용된다.

```java
boolean startStudy = true;
boolean stopStudy = false;
```

