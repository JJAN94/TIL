package com.test02;

public class MTest03 {

	public static void main(String[] args) {
		
		Base b1 = new Pig(); // new Base() -> new Pig()
		b1.Start();
		b1.Stop();

		((Pig) b1).setA(100);
		System.out.println( ((Pig)b1).getA() );
	}

}
