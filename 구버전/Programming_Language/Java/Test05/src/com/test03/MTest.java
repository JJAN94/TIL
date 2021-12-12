package com.test03;

public class MTest {

	public static void main(String[] args) {
		Car c1 = new Car("R8");
		Car c2 = new Car("R8");
		
		System.out.println("주소비교 : " + (c1 == c2)); // c1.toString() == c2.toString()
		
		System.out.println("주소비교 : " + (c1.equals(c2))); // c1.toString() == c2.toString()
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		
		if(c1.equals(c2)) {
			System.out.println("차 이름이 같다.");
		} else {
			System.out.println("차 이름이 달라.");
		}
	}

}