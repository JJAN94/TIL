package com.test;

public class Test03 {

	public static void for_test() {
		System.out.println("case 1 : 1~10 ���");
		
		for(int i=1; i<=10;i++) {
			System.out.printf("%5d", i);
			
		}
	}
	
	public static void for_test02() {
		System.out.println("case 2 : 10~1 ���");
		int i =0;
		for(i=10; i>=1;i--) {
			System.out.printf("%5d", i);
			
		}
		System.out.println("\n ===> i="+i);
	}
	
	public static void for_test03() {
		System.out.println("\n case 3 : 1~100 2�� ���, ������ ���");
		int i =0;
		int cnt=0;
		for(i=1; i<=100;i++) {
			if (i%2==0) {
				System.out.printf("%5d", i);
				cnt++;
			}
		}
		System.out.println("\n ===> cnt="+cnt);
	}
	
	public static void for_test04() {
		System.out.println("\n case 4 : ��ø for ���");
		for(int i=1; i<=21; i+=5) {
			for (int j=i; j<=i+4; j++) {
				System.out.printf("%5d", j);
			}
			System.out.println();
		}
	}
	
	public static void for_test05() {
		System.out.println("\n case 4 : ��ø for ���");
		for(int i=1; i<=5; i++) {
			for (int j=i; j<=i+20; j+=5) {
				System.out.printf("%5d", j);
			}
			System.out.println();
		}
	}
	
	public static void for_test06() {
		System.out.println("\n case 4 : ��ø for ���");
		for(int i=25; i>=5; i-=5) {
			for (int j=i; j>=i-4; j--) {
				System.out.printf("%5d", j);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		for_test06();
//		int a =10;
//		int k =300;
//		{
//			System.out.println("a="+a);
//			k =100;
//			System.out.println("k="+k);
//		}
//		System.out.println("k="+k); 
//		//�� �ȿ� ������ �����ϸ� �� ���ȿ����� ������ �� �ִ�.
		
	}
}
