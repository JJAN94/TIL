package com.test02;

public class Pig implements Base {
	// 선조의 주소 번지를 통해서 재정의가 되지 않은 후손의 메소드를 제어할 경우 확인
	private int a;
	// alt+shift+s = Generate Getters and Setters... 자동 생성
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
