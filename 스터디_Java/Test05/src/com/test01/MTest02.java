package com.test01;
import java.util.Scanner;

public class MTest02 {
	public static void main(String[] args) {
		
		System.out.println("Input no : ");
		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();
		Base b1 = null; //null�̶� Ű����� ��ü�� null�� �ʱ�ȭ ���ִ� Ű�����̴�.
		
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
		// �������ε��� ����?
		// 1. �ڵ尡 �پ���.
		// 2. �ӵ��� ��������.
		// 3. �޸𸮰� ȿ�����̴�.
		
	}

}
