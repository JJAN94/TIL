package com.test04;

import java.util.Vector;
import java.util.ArrayList;
import jumsu;
public class Test01 {


	
	public static void main(String[] args) {
		Vector v = new Vector(5, 4);
//		v.add("1");
//		v.add(new String("abcd"));
//		v.add(new Double(90.7));
//		System.out.println(v.get(0));
//		System.out.println(v.get(1));
//		System.out.println(v.get(2));
		
		for(int i=1;i<=21;i++) {
			v.add(i);
		}
		System.out.println(v.capacity());
		
		
		ArrayList<String> a = new ArrayList<String>();
		for(int i=1;i<=21;i++) {
			a.add(i+"");
		}
		System.out.println(a);
		
		ArrayList<Score> s = new ArrayList<Score>();
//		s.add(new Score(90, 80, 70));
		
		//s의 객체의 2번째에 값을 100, 100, 100을 입력해보자.
		s.add(1, new Score(100, 100, 100));
		System.out.println(s);
		
		for(Score res : s) {
			if(res.getKor() >= 90) {
				res.setKor(0);
			}
			System.out.println(res);
		}
		
		s.remove(4);
		
		System.out.println(s);
	}

}
