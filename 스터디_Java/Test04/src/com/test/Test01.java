package com.test;

public class Test01 {
	public static void main(String[] args) {
		
		// == ���� : ��ü���� �ּҸ� ���ϴ� ������
		// new Car("bm7").toString == new Car("bm7").toString => ���� ���ϴ°� �ƴ϶� �ּҸ� ���Ѵ�.
		// toString ������
		// equals ������
		
		Integer i = new Integer(100);
		System.out.println(i + " : " + i.toString());
		
		Integer i2 = new Integer("100"); //"100"�� string�̳� parsing�ؼ� int�� ��Ÿ�� �� �ִ�.
		System.out.println(i2+50 + "\t" + (i2.toString() + 100)); // ����ȯ �� ����
		
		Double d1 = new Double ("92.9");
		System.out.println(d1 + " : " + d1.toString() + "\t" + (d1.toString() + 30));
		System.out.println(d1.doubleValue()+30); //�ڱ��ڽ��� �����ϴ°�. �⺻�����δ� �ڽ��� �ֱ⿡ ������ �����ϴ�.
		System.out.println(d1+30);
		System.out.println(d1.getClass().getName());
		System.out.println(d1.toString().getClass().getName());
		
		
		Integer i3 = 100; // =Integer i3=new Integer(100) �⺻�ڷ����� new�� �Ƚᵵ �ٷ� ���� �� �ִ�.
		System.out.println(i3);
		
		Double d3 = 97.9; //=Double d3 = new Double(97.9);
		System.out.println(d3);
		
		double d4 = new Double(98.9); //wrapperŬ������ �ڵ� ȣȯ (double�� �Ϲ� �ڷ���) 
		// �̷������δ� �Ϲ������δ»������ �ʴ´�.
		System.out.println(d4); //�Ϲ��ڷ������� ������⿡ d4.�� �ϸ� No Default Proposals��
		
		//��Ʈ��ũ�� �̿��� �� Ŭ������ ���� ����Ѵ�. Integer(o), int(x)
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
