package com.test;
import java.util.Scanner;
// import java.util.* 라 하면 util 패키지 안에 다 불러옴
// 패키지 안에 10개정도를 쓸거면 *를 쓰고 그 이하는 하나하나 명시해서 부르자.

// import는 package 하단에만 쓰자. 다른곳은 못씀

// 자바에서 표준 입출력을 구현하는 클래스
/* 표준입력을 할 때 3가지
 * 		
 * 		1. java.io 의 클래스 사용방법
 * 				java.io.Class BufferedInputStream
 * 
 *  	2. main() 매개인자로 입력 받는 방법
 * 				main(String[] args)
 * 
 * 		3. Scanner로 입력 받는 방법
 * 				java.util.Scanner
 * 
 * 
 */


public class Test01 {
	
	public static String Prn(int jumsu) {
		 	int testscore = jumsu;
	        char grade;

	        if (testscore >= 90) {
	            grade = 'A';
	        } else if (testscore >= 80) {
	            grade = 'B';
	        } else if (testscore >= 70) {
	            grade = 'C';
	        } else if (testscore >= 60) {
	            grade = 'D';
	        } else {
	            grade = 'F';
	        }
	        return ("Grade = "+grade);
//	        System.out.println("Grade = " + grade);
	}
	
	public static void main(String[] args) {
//		Prn();
		Scanner sc = new Scanner(System.in); //InputStream의 객체를 in으로 필드화 후 멤버로 가짐 = 표준입력장치
		System.out.println("input jumsu : ");
		int i = sc.nextInt();
		String res = Prn(i);
		System.out.println("res = " + res);
//		System.out.println(" i = " + i);
//		
//		String str = sc.next();
//		System.out.println("str = " + str);
	}

}
