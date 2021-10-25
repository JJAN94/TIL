package com.test;

public class Test02 {
	public static void prn() {
		// String은 일반자료형이 없어서 그냥 써도 클래스로 인식
		// String cde = "cde"; 주소를 받아 cde변수를 참조한다.
		
		
		//다음은 String(String original) 과 같다.
		String original = "The String class represents character strings";
		String str02 = new String(original);
		
		String str03 = new String(new String("The String class represents character strings"));
		
		String str04 = new String("The String class represents character strings");
		
		System.out.println(original);
		System.out.println(str02);
		System.out.println(str03);
		System.out.println(str04);
		
		String res = original.toUpperCase(); //res는 대문자로 나오지만 original은 아무 변화가 없다.
		//스스로는 변화없이 변경해서 다른 애한테 주는 것.
		// StringBuffer, StringBuilder는 다르다. 얘네는 변화가능
		System.out.println(res);
		}

	public static void prn02() {
		// String = C ( String() )
		// StringBuffer = C : StringBuffer(), append / R : U : D : delete
		// StringBuilder = CRUD
		// typora 참고
		
		StringBuffer sb = new StringBuffer();
//		sb.append("abc");
//		System.out.println(sb);
		for(int i =65; i<=80; i++) {
			sb.append((char)i); //34나옴
		}
//	방법1 : 	sb.delete(3, 6);
		for(int j=1;j<=3;j++) { //방법2
			sb.deleteCharAt(3);
		}
		System.out.println(sb.capacity()); //capacity는 바이트단위로 용량을 잡는다.
		System.out.println(sb);
		
		StringBuilder sb1 = new StringBuilder();
		for(int i=0;i<=16;i++) {
			sb1.append(i);
		}
		System.out.println(sb1.capacity());
	
	}
	
	
	public static void main(String[] args) {
		prn02();
	}
}
