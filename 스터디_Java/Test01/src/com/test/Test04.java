package com.test;

public class Test04 {
	
	public static void Exam() {
		// 1. ������ ������ �ϳ�(a) �����ؼ� 10�� ��������. �Ʒ��� Integer Ŭ������ �޼���� �����غ���.
		Integer a = 10;
		
		
		// 2. a�� 2������ ��ȯ �� ���
		// public static String toBinaryString(int i)
		String str1 = Integer.toBinaryString(a);
		System.out.println(str1);
				
		// 3. a�� 8������ ��ȯ �� ���
		// public static String toHexString(int i)
		String str2 = Integer.toHexString(a);
		System.out.println(str2);
		
		// 4. a�� 16������ ��ȯ �� ��� �غ���.
		// public static String toOctalString(int i)
		String str3 = Integer.toOctalString(a);
		System.out.println(str3);
		
	}
	
	
	public static void Exam02() {
		System.out.println("char�� ���� : "+ (int)Character.MIN_VALUE + "~"+ (int)Character.MAX_VALUE);
		
		// ���� A�� �ҹ��ڷ� �����غ���.
		char ch = Character.toLowerCase('A');
		System.out.println(ch + " : " + Character.isLowerCase(ch));
		
		// ���� a�� �빮�ڷ� �����غ���.
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
