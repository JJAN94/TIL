package com.test04;

public class MyExceptionTest {
	public static void main(String[] args) {
		int a = 10;
		
		try {
		if(a>0) {
			throw new MyException("0���� ũ�ݾ�");
		}
		} catch(MyException m) { // MyException m = new MyException("0���� ũ�ݾ�");
			System.out.println(m.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage()); // m�� �������� e�� ��ƶ�
		} finally {
			System.out.println("���ܰ� ������ ������ �ݵ�� ó������ ����Ŭ����, ���Ŭ����, �������� ��� �ø��� ");
		}
	}
}
