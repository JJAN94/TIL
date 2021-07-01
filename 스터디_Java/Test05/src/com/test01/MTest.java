package com.test01;
import java.util.Scanner;

public class MTest {
	public static void main(String[] args) {
		
		System.out.println("Input no : ");
		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();
		
		switch (no) {
		case 1:
			Duck d1 = new Duck();
			d1.Start();
			d1.Stop();
			break;
			
		case 2:
			Puppy p1 = new Puppy();
			p1.Start();
			p1.Stop();
			break;
		
		case 3:
			Pig pig = new Pig();
			pig.Start();
			pig.Stop();
			break;
		}
		
	}

}
