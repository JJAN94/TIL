package com.test;
import java.util.Scanner;
import java.util.Arrays;

// 문제2. str을 받은 cnvr을 조작해보자.
// 1. 전체를 대문자로 출력 cnvr01()
//		toUpperCase
// 2. 전체를 소문자로 출력 cnvr02()
//		toLowerCase
// 3. 공백을 제거 후 출력 cnvr03() 
//		trim -> 앞뒤 공백제거
// 4. 공백을 찾아 하트로 출력
//		replace(char oldChar, char newChar)
// 5. 입력된 글자를 삭제 후 출력 = Scanner를 사용
// 6. 문자열을 하나씩 바이트로 변환 후 출력
//		getBytes
// 7. 문자열을 공백으로 분철 해서 분철 된 데이터를 출력

public class Exam02 {
	public static void cnvr01 (String res) {
		System.out.println(res.toUpperCase());
	}
	
	public static void cnvr02 (String res) {
		System.out.println(res.toLowerCase());
	}
	
	public static void cnvr03 (String res) {
		System.out.println(res.replace(" ",""));
	}
	
	public static void cnvr04 (String res) {
		System.out.println(res.replace(' ', '♥'));
	}
	
	public static void cnvr05() {
//		Scanner scan = new Scanner(System.in);
////		for(i=0; i<scan.nextLine().length(); i++) {
//		char ch[] = scan.next().toCharArray();
//		
//		String scan1;
//		scan1 = scan.nextLine();
//		
//		for(int i=0;i<scan1.length();i++) {
//			scan1.sub
//		}
//		System.out.println(scan1.);
	}
	
	public static void cnvr06 (String res) {
		byte[] bytes = res.getBytes();
		System.out.println(Arrays.toString(bytes));
	}
	
	public static void cnvr07 (String res) {
		String[] result = res.split("");
		System.out.println(Arrays.toString(result));
	}
	
	
	
		
	public static void main(String[] args) {
			
		String str = "The String class represents character strings.";
		cnvr01(str);
		cnvr02(str);
		cnvr03(str);
		cnvr04(str);
//		cnvr05();
		cnvr06(str);
		cnvr07(str);
		
		
		}	
	
}
