# 형변환



### 자동 타입 변환(promotion)

- 자동으로 형변환이 일어나는 것

- 자동타입 변환은 값의 허용 범위가 작은 타입이 허용 범위가 큰 타입으로 저장될 때 일어난다.

```markdown
byte < short < int < long < float < double
// double로 갈수록 커진다.
```

```java
byte byteValue = 10;
int intValue = byteValue;
// byte보다 int가 더 크므로 자동으로 형변환이 일어난다.

// 정수는 실수로 저장될 때 자동으로 무조건 형변환이 일어난다.
// char경우 int로 자동 변환되며 유니코드 값이 int로 저장된다.
// ex) 'A' -> 65
// byte에서 char로 변경시 에러난다. char는 음수범위를 포함하지 않기 때문이다.
```



### 강제 타입 변환(casting)

- 값의 허용범위를 넘어서는 변환을 가능하게 해주는 기능
- 범위를 축소시켜서 넣는다.
- 변환할 변수 앞에 (타입)을 명시해줘서 쓴다.

```java
double pi =3.14;
int intPi = (int)pi;
```

```markdown
intPi = 3 이 저장된다.
```





### 연산에서 자동 타입 변환

- 연산과정 중 허용범위가 더 큰 피연사자 쪽으로 타입이 변환되어 연산이 수행되는 케이스
- 예를 들어 long타입 + int타입 하면 결과는 long으로 형변환되어 나온다. (long이 더 크다)

```java
byte x = 10;
byte y = 20;
byte res = x+y; // 컴파일 에러
// Type mismatch: cannot convert from int to byte
int res = x+y; //이렇게 써야한다.
```

- 실수인 경우에도 float보다 double이 크므로 1.2f + 3.4라 해도 1.2 + 3.4 로 변환되어 수행되고 변수에 저장된다.



예제1

```java
int x = 1;
int y = 2;
// x/y를 하면 어떻게 출력될까? 0.5가 나올까?

// 1번
double res = x/y; 

// 2번
double xx = (double)x;
double yy = (double)y;
double res = xx/yy;
```

- 1번의 경우
  - 0.0이 나온다. 정수연산은 정수로 나온다. 그러면 0.5에서 정수로 변환하여 0이 나오는걸 double형으로 다시 변환하니 0.0이 나오는 것이다.
- 2번의 경우
  - 1.0 / 2.0이 되므로 0.5가 나온다.



예제2

```java
int a = 2;
String b = "3"
// 두개를 연산하면? a+b
// int a가 문자열 "2"로 변환되어 결합된다. (파이썬 문자열 더하기와 같다)
// "23"이 나오는 것
```



### 문자열을 기본 타입으로 강제 변환

- String str = "sth"
- 문자열의 형태가 강제 변환할 기본타입의 모양을 가지고 있어야한다.
  - String str = "a1"를 int로 강제변환은 불가능하다.

| 변환              | 예시                                       |
| ----------------- | ------------------------------------------ |
| String -> byte    | byte value = Byte.parseByte(str);          |
| String -> short   | short value = Short.parseShort(str);       |
| String -> int     | int value = Integer.parseInt(str);         |
| String -> long    | long value = Long.parseLong(str);          |
| String -> float   | float value = Float.parseFloat(str);       |
| String -> double  | double value = Double.parseDouble(str);    |
| String -> boolean | boolean value = Boolean.parseBoolean(str); |







