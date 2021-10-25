package com.test;

// static : class명.멤버  <-> non-static : class변수를 만들어 멤버로 접근
// static은 선언과 동시에 주소가 생성되어 바로 호출이 가능
// non-static은 주소가 생성되지 않기때문에 객체로 주소를 만들고 그것을 불러온다.
public class MyClass {
	
	public static void Disp() {
		System.out.println("MyClass.Disp()");
		// static메서드 => MyClass.Disp()로 호출해야 명령을 수행한다.
	}

}

// 자바는 우선 static인지 아닌지를 먼저 확인한다. (호출하기 위해서)
