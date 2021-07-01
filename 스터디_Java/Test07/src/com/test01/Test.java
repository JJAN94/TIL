package com.test01;
import java.awt.*;

public class Test {

	public static void main(String[] args) {
		Frame f1 = new Frame();
		f1.setBackground(Color.pink);
		f1.setVisible(true);
//		f1.setSize(200,300);
		f1.setSize(new Dimension(400,200));
		System.out.println(f1.getBackground());
		System.out.println(f1.getSize());
		
	}

}
