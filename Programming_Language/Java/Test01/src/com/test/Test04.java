package com.test;

public class Test04 {
	
	public static void Exam() {
		// 1. 정수형 변수를 하나(a) 선언해서 10을 대입하자. 아래를 Integer 클래스의 메서드로 구현해보자.
		Integer a = 10;
		
		
		// 2. a를 2진수로 변환 후 출력
		// public static String toBinaryString(int i)
		String str1 = Integer.toBinaryString(a);
		System.out.println(str1);
				
		// 3. a를 8진수로 변환 후 출력
		// public static String toHexString(int i)
		String str2 = Integer.toHexString(a);
		System.out.println(str2);
		
		// 4. a를 16진수로 변환 후 출력 해보자.
		// public static String toOctalString(int i)
		String str3 = Integer.toOctalString(a);
		System.out.println(str3);
		
	}
	
	
	public static void Exam02() {
		System.out.println("char의 범위 : "+ (int)Character.MIN_VALUE + "~"+ (int)Character.MAX_VALUE);
		
		// 문자 A를 소문자로 변경해보자.
		char ch = Character.toLowerCase('A');
		System.out.println(ch + " : " + Character.isLowerCase(ch));
		
		// 문자 a를 대문자로 변경해보자.
		System.out.println(Character.toUpperCase('a') + " : " + Character.isUpperCase(Character.toUpperCase('a')));
		
		boolean fw = true;
		System.out.println(fw + " : " + !fw);
		
		String str = "abcdefghijklmn"; //String str = new String("abcdefghijklmn");
		System.out.println(str.toLowerCase() + " : " + str.toUpperCase());
	}
	
	
	public static void main(String[] args) {
		Exam02();
	}
	

}
