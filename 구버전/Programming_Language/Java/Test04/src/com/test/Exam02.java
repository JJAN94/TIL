package com.test;
import java.util.Scanner;
import java.util.Arrays;

// ����2. str�� ���� cnvr�� �����غ���.
// 1. ��ü�� �빮�ڷ� ��� cnvr01()
//		toUpperCase
// 2. ��ü�� �ҹ��ڷ� ��� cnvr02()
//		toLowerCase
// 3. ������ ���� �� ��� cnvr03() 
//		trim -> �յ� ��������
// 4. ������ ã�� ��Ʈ�� ���
//		replace(char oldChar, char newChar)
// 5. �Էµ� ���ڸ� ���� �� ��� = Scanner�� ���
// 6. ���ڿ��� �ϳ��� ����Ʈ�� ��ȯ �� ���
//		getBytes
// 7. ���ڿ��� �������� ��ö �ؼ� ��ö �� �����͸� ���

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
		System.out.println(res.replace(' ', '��'));
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
