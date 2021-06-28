package com.test;

public class Test01 {
	public static void main(String[] args) {
		
		// == 같다 : 객체간의 주소를 비교하는 연산자
		// new Car("bm7").toString == new Car("bm7").toString => 값을 비교하는게 아니라 주소를 비교한다.
		// toString 재정의
		// equals 재정의
		
		Integer i = new Integer(100);
		System.out.println(i + " : " + i.toString());
		
		Integer i2 = new Integer("100"); //"100"은 string이나 parsing해서 int로 나타낼 수 있다.
		System.out.println(i2+50 + "\t" + (i2.toString() + 100)); // 형변환 후 연산
		
		Double d1 = new Double ("92.9");
		System.out.println(d1 + " : " + d1.toString() + "\t" + (d1.toString() + 30));
		System.out.println(d1.doubleValue()+30); //자기자신을 리턴하는것. 기본적으로는 자신을 주기에 연산이 가능하다.
		System.out.println(d1+30);
		System.out.println(d1.getClass().getName());
		System.out.println(d1.toString().getClass().getName());
		
		
		Integer i3 = 100; // =Integer i3=new Integer(100) 기본자료형은 new를 안써도 바로 넣을 수 있다.
		System.out.println(i3);
		
		Double d3 = 97.9; //=Double d3 = new Double(97.9);
		System.out.println(d3);
		
		double d4 = new Double(98.9); //wrapper클래스는 자동 호환 (double은 일반 자료형) 
		// 이런식으로는 일반적으로는사용하지 않는다.
		System.out.println(d4); //일반자료형으로 만들었기에 d4.을 하면 No Default Proposals뜸
		
		//네트워크를 이용할 땐 클래스로 만들어서 써야한다. Integer(o), int(x)
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
