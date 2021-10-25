package com.test;

public class Test03 {
	
	// 전역변수, 멤버 변수 : 생성자에서 초기화를 자동으로 대입한다.
	
	public static void Prn_int() {
		// 정수형 연습  
		
		Integer a = 100;
		Integer b = 200;
		System.out.println(a.longValue());
		System.out.println(a+a);
		System.out.println(a-a);
		
		System.out.println();
		
		System.out.printf("%5d %5d %5d \n", a, a, b);
		System.out.printf("%5o %5o %10o \n", a, a, b); //8진
		System.out.printf("%5x %5x %5x \n", a, a, b); //16진, x만 대소문자 다 가능
		// 나머진 소문자만 가능 (ex: D (x), d(o) )
		
		//public static String format(String format, Object... args)
		
		String res = String.format("%5x %5x %5x \n", a, a, b);
		System.out.println(res);
	}
	
	public static void Prn_float() {
		Double d = 98.7;
		Float f = 98.7f;
		
		System.out.println(d); //double
		System.out.println(f); //float , 메모리가 다름
		String str = String.format("%10.2f %-10.2f \n", 98.7, 98.7f); //-는 왼쪽정렬
		System.out.println(str);
	}
	
	public static void Prn_char() { //한글자 타입, 16비트(2바이트), ''로 쓴다
		
		Character A='A';
		System.out.println(A);
		System.out.printf("%5c \n", 'A');
		// 데이터 타입     변수 = 값;
		char ch = 'A';
		System.out.println("ch= "+ ch + " code = "  +(int)ch); //형변환은 (데이터타입)변수
		
		System.out.printf("%5d\n", (int)ch);
	}
	
	public static void Prn_String() {
		// 'A' 와 "A" 는 완전히 다르다.
		System.out.println("우리' 나라 대\'한\'민국");
		
		String str = "우리나라 대한민국";
		System.out.println(str);
		
	}
	
	public static void main(String[] args) {
		int a=100; // 변수를 선언할 때 지역변수는 반드시 초기값을 지정해야 한다.
		//int a; 라고만 하면 에러남. 변수를 호출하면 값을 리턴한다.
		Prn_int();
		Prn_float();
		Prn_char();
		
	}
}