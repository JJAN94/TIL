package com.test02;

public class Duck implements Base {
	@Override
	public void Start() {
		System.out.println("Duck 's Start() ");
	}

	@Override
	public void Stop() {
		System.out.println("Duck 's Stop() ");
	}
}
