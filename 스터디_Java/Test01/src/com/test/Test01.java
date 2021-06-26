package com.test;

public class Test01 {
	
	public static void Ex01() {
		System.out.println("Ex01's method");
	}

	public static void main(String[] args) {
		Ex01();
		System.out.println(); //java.lang 내에 있는 멤버들은 import 하지 않고 호출할 수 있다.
		System.out.println();
		//class명.멤버
		MyClass.Disp();
	}
}


// 실행 = ctrl + F11