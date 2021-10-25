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
