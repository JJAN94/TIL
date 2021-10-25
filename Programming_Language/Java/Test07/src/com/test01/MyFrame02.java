package com.test01;

import java.awt.*;

public class MyFrame02 extends Frame {

	Panel p1, p2;
	Button bt1, bt2;
	
	public MyFrame02() {
		p1 = new Panel();
		p2 = new Panel();
		
		bt1 = new Button("111");
		bt2 = new Button("222");
		
	}
	
	public void go() {
		///p1
		p1.add(bt1);
		
		///p2
		p2.add(bt2);
		
		////frame
		setLayout(new GridLayout(2,1));
		add(p1);
		add(p2);
		setSize(500,500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame02().go();
	}
	
}
