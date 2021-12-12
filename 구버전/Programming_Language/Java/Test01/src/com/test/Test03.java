package com.test;

public class Test03 {
	
	// ��������, ��� ���� : �����ڿ��� �ʱ�ȭ�� �ڵ����� �����Ѵ�.
	
	public static void Prn_int() {
		// ������ ����  
		
		Integer a = 100;
		Integer b = 200;
		System.out.println(a.longValue());
		System.out.println(a+a);
		System.out.println(a-a);
		
		System.out.println();
		
		System.out.printf("%5d %5d %5d \n", a, a, b);
		System.out.printf("%5o %5o %10o \n", a, a, b); //8��
		System.out.printf("%5x %5x %5x \n", a, a, b); //16��, x�� ��ҹ��� �� ����
		// ������ �ҹ��ڸ� ���� (ex: D (x), d(o) )
		
		//public static String format(String format, Object... args)
		
		String res = String.format("%5x %5x %5x \n", a, a, b);
		System.out.println(res);
	}
	
	public static void Prn_float() {
		Double d = 98.7;
		Float f = 98.7f;
		
		System.out.println(d); //double
		System.out.println(f); //float , �޸𸮰� �ٸ�
		String str = String.format("%10.2f %-10.2f \n", 98.7, 98.7f); //-�� ��������
		System.out.println(str);
	}
	
	public static void Prn_char() { //�ѱ��� Ÿ��, 16��Ʈ(2����Ʈ), ''�� ����
		
		Character A='A';
		System.out.println(A);
		System.out.printf("%5c \n", 'A');
		// ������ Ÿ��     ���� = ��;
		char ch = 'A';
		System.out.println("ch= "+ ch + " code = "  +(int)ch); //����ȯ�� (������Ÿ��)����
		
		System.out.printf("%5d\n", (int)ch);
	}
	
	public static void Prn_String() {
		// 'A' �� "A" �� ������ �ٸ���.
		System.out.println("�츮' ���� ��\'��\'�α�");
		
		String str = "�츮���� ���ѹα�";
		System.out.println(str);
		
	}
	
	public static void main(String[] args) {
		int a=100; // ������ ������ �� ���������� �ݵ�� �ʱⰪ�� �����ؾ� �Ѵ�.
		//int a; ��� �ϸ� ������. ������ ȣ���ϸ� ���� �����Ѵ�.
		Prn_int();
		Prn_float();
		Prn_char();
		
	}
}