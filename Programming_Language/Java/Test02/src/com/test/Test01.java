package com.test;
import java.util.Scanner;
// import java.util.* �� �ϸ� util ��Ű�� �ȿ� �� �ҷ���
// ��Ű�� �ȿ� 10�������� ���Ÿ� *�� ���� �� ���ϴ� �ϳ��ϳ� ����ؼ� �θ���.

// import�� package �ϴܿ��� ����. �ٸ����� ����

// �ڹٿ��� ǥ�� ������� �����ϴ� Ŭ����
/* ǥ���Է��� �� �� 3����
 * 		
 * 		1. java.io �� Ŭ���� �����
 * 				java.io.Class BufferedInputStream
 * 
 *  	2. main() �Ű����ڷ� �Է� �޴� ���
 * 				main(String[] args)
 * 
 * 		3. Scanner�� �Է� �޴� ���
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
		Scanner sc = new Scanner(System.in); //InputStream�� ��ü�� in���� �ʵ�ȭ �� ����� ���� = ǥ���Է���ġ
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
