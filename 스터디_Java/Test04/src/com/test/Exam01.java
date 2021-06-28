package com.test;

// 문제1. The String class represents character strings.의 내용을 cnvr() 메소드로 대입해서
// 대문자의 개수와 소문자의 개수를 출력하고
// 대문자를 소문자로, 소문자를 대문자로 변환 후 리턴받는다.
// String을 char[]로 바꾸고 // String.toCharArray()
// for -> Character에서 is시리즈 이용
// character의 소문자인지, 대문자인지 판별하는 메소드를 이용해서 조건문을 사용 후 cnt한다.
// character의 대문자로, 소문자로 바꾸어주는 메소드를 찾아서 변환.
public class Exam01 {
	public static String cnvr(String res) { //res = str
		char[] ch_res = res.toCharArray();
		int cnt_u = 0; //대문자 개수
		int cnt_L = 0; //소문자 개수
		
		for(int i=0;i<ch_res.length;i++) {
			if(Character.isUpperCase(ch_res[i])) {
				ch_res[i] = Character.toLowerCase(ch_res[i]);
				cnt_u++;
			}
			else if(Character.isLowerCase(ch_res[i])) {
				ch_res[i] = Character.toUpperCase(ch_res[i]);
				cnt_L++;
			}
			
//			System.out.println(ch_res[i]);
			
		}
		System.out.println("대문자 개수 : " + cnt_u + "  소문자 개수 : " + cnt_L);
		
		
		return new String(ch_res);
	}
	
	
	public static void main(String[] args) {
		
		String str = "The String class represents character strings.";
		String res = cnvr(str);
		System.out.println(res);
	}

}
