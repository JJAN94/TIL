package com.test04;

public class MTest03 {
	public static void main(String[] args) {
		for(int i=0;i<20;i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("%3c", '¢¾');
		}
	}
}
