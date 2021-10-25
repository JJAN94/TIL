# Java 기본



자바



```java
// test01.java
package com.test;
// 맨 상단부에 package를 명시해줘야한다.

public class Test01 {
// 접근 지정자, 클래스 이름은 파일이름 과 같아야 한다.
// 실행단위는 클래스 단위다.
	
	public static void main(String[] args) {
		System.out.println("핼로 월드~~~");
		// ;를 꼭 써준다.
	}
}
```





도움말 보는 방법

![java기본](C:\Users\JAY\Desktop\0626공부\java기본.PNG)

1. 맨 상단부 : 지금 도움말의 현재 위치, 위 보기는 CLASS
2. SUMMARY : NESTED / FIELD / CONSTR / METHOD
   - 이 클래스에 멤버로 가지고 있는 것들
   - CONSTR : 생성자
   - FIELD : 상수
3. System의 위는 Object
4. public final class System에서 final의 의미는 더이상 상속을 안하겠다는 뜻
   - CONSTR이 존재하지 않음. 자기 자신 System만 있을거니까. 
5. extends Object : Object를 상속했다는 의미