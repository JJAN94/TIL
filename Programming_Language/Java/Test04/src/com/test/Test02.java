package com.test;

public class Test02 {
	public static void prn() {
		// String�� �Ϲ��ڷ����� ��� �׳� �ᵵ Ŭ������ �ν�
		// String cde = "cde"; �ּҸ� �޾� cde������ �����Ѵ�.
		
		
		//������ String(String original) �� ����.
		String original = "The String class represents character strings";
		String str02 = new String(original);
		
		String str03 = new String(new String("The String class represents character strings"));
		
		String str04 = new String("The String class represents character strings");
		
		System.out.println(original);
		System.out.println(str02);
		System.out.println(str03);
		System.out.println(str04);
		
		String res = original.toUpperCase(); //res�� �빮�ڷ� �������� original�� �ƹ� ��ȭ�� ����.
		//�����δ� ��ȭ���� �����ؼ� �ٸ� ������ �ִ� ��.
		// StringBuffer, StringBuilder�� �ٸ���. ��״� ��ȭ����
		System.out.println(res);
		}

	public static void prn02() {
		// String = C ( String() )
		// StringBuffer = C : StringBuffer(), append / R : U : D : delete
		// StringBuilder = CRUD
		// typora ����
		
		StringBuffer sb = new StringBuffer();
//		sb.append("abc");
//		System.out.println(sb);
		for(int i =65; i<=80; i++) {
			sb.append((char)i); //34����
		}
//	���1 : 	sb.delete(3, 6);
		for(int j=1;j<=3;j++) { //���2
			sb.deleteCharAt(3);
		}
		System.out.println(sb.capacity()); //capacity�� ����Ʈ������ �뷮�� ��´�.
		System.out.println(sb);
		
		StringBuilder sb1 = new StringBuilder();
		for(int i=0;i<=16;i++) {
			sb1.append(i);
		}
		System.out.println(sb1.capacity());
	
	}
	
	
	public static void main(String[] args) {
		prn02();
	}
}
