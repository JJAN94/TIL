package com.test04;

//���ܹ߻���ų �� 
//throws : ���ܸ� �����ϴ� ��, �޼ҵ� �ڿ� �����ϴ� Ű����
//throw : ���ܸ� �����ϴ� Ű����, ��) throw MyException();

/*
try {

} catch(�ļ�Exception) { 
	//catch�� ������ ����
} catch(Exception e){

} finally { 
	//finally�� �ʼ�
}
*/

public class MTest {

	public static void main(String[] args) {
		//���� ����� �ΰ��� ������ �޾Ƽ� ���� ������.
		int a = 0;
		int b = 0;
		
		try {
		a = Integer.parseInt(args[0]);
		b = Integer.parseInt(args[1]);
		} catch (NumberFormatException t) {
			System.out.println("���ܳ���");
		}
		
		System.out.println((a+b));
		
		

	}

}
