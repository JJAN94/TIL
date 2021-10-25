package com.test;

public class Test {
	
	public static void Prn(Abstract_aa a2) {
		a2.test();
	}
	public static void main(String[] args) {
		//case1
		My m1 = new My();
		m1.test();
		
		//case2
		Abstract_aa a1 = new My();
		a1.test();
		
		//case3
		Prn(new My());
		
		//case4
		Prn(new Abstract_aa() {
			@Override
			public void test() {
				System.out.println("나 재정의야~~");
			}
		});
	}
}
