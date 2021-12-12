package com.test04;

//예외발생시킬 때 
//throws : 예외를 위임하는 것, 메소드 뒤에 선언하는 키워드
//throw : 예외를 실행하는 키워드, 예) throw MyException();

/*
try {

} catch(후손Exception) { 
	//catch는 여러개 가능
} catch(Exception e){

} finally { 
	//finally는 필수
}
*/

public class MTest {

	public static void main(String[] args) {
		//메인 실행시 두개의 정수를 받아서 합을 구하자.
		int a = 0;
		int b = 0;
		
		try {
		a = Integer.parseInt(args[0]);
		b = Integer.parseInt(args[1]);
		} catch (NumberFormatException t) {
			System.out.println("예외났다");
		}
		
		System.out.println((a+b));
		
		

	}

}
