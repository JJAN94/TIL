package com.test02;

public class Pig implements Base {
	// ������ �ּ� ������ ���ؼ� �����ǰ� ���� ���� �ļ��� �޼ҵ带 ������ ��� Ȯ��
	private int a;
	// alt+shift+s = Generate Getters and Setters... �ڵ� ����
	public int getA() {
		return a;
	}
	
	public void setA(int a) {
		this.a = a;
	}
	
	@Override
	public void Start() {
		System.out.println("Pig 's Start() ");
	}
	
	@Override
	public void Stop() {
		System.out.println("Pig 's Stop() ");
	}
}
