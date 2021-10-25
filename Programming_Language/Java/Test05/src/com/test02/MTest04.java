package com.test02;

public class MTest04 {
	public void Prn(Base b) { // Base b = new Pig()
		b.Start();
		b.Stop();
	}
	public static void main(String[] args) {
		
		new MTest04().Prn(new Pig());
		
		//¿Õ∏Ì
		new MTest04().Prn(new Base() {

			@Override
			public void Start() {
				System.out.println("111111111");
				
			}

			@Override
			public void Stop() {
				System.out.println("2222222222222");
			}
			});
	}
}
