package com.test01;
import java.util.Scanner;

public class MTest02 {
	public static void main(String[] args) {
		
		System.out.println("Input no : ");
		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();
		Base b1 = null; //null이란 키워드는 객체를 null로 초기화 해주는 키워드이다.
		
		switch (no) {
		case 1:
			b1 = new Duck();
			break;
			
		case 2:
			b1 = new Puppy();
			break;
		
		case 3:
			b1 = new Pig();
			break;
		}
		b1.Start();
		b1.Stop();
		// 동적바인딩을 쓰면?
		// 1. 코드가 줄어든다.
		// 2. 속도가 빨라진다.
		// 3. 메모리가 효율적이다.
		
	}

}
