package com.test;

// ����1. The String class represents character strings.�� ������ cnvr() �޼ҵ�� �����ؼ�
// �빮���� ������ �ҹ����� ������ ����ϰ�
// �빮�ڸ� �ҹ��ڷ�, �ҹ��ڸ� �빮�ڷ� ��ȯ �� ���Ϲ޴´�.
// String�� char[]�� �ٲٰ� // String.toCharArray()
// for -> Character���� is�ø��� �̿�
// character�� �ҹ�������, �빮������ �Ǻ��ϴ� �޼ҵ带 �̿��ؼ� ���ǹ��� ��� �� cnt�Ѵ�.
// character�� �빮�ڷ�, �ҹ��ڷ� �ٲپ��ִ� �޼ҵ带 ã�Ƽ� ��ȯ.
public class Exam01 {
	public static String cnvr(String res) { //res = str
		char[] ch_res = res.toCharArray();
		int cnt_u = 0; //�빮�� ����
		int cnt_L = 0; //�ҹ��� ����
		
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
		System.out.println("�빮�� ���� : " + cnt_u + "  �ҹ��� ���� : " + cnt_L);
		
		
		return new String(ch_res);
	}
	
	
	public static void main(String[] args) {
		
		String str = "The String class represents character strings.";
		String res = cnvr(str);
		System.out.println(res);
	}

}
