package com.test01;

import java.awt.*;

public class MyFrame extends Frame {
	
	Button bt;
	Button bt01;
	
	public MyFrame() {
		super("³»²¨"); // Frame(String title);
		bt = new Button("1");
		bt01 = new Button("22");
	}
	
	public void go() {
		add(bt, BorderLayout.NORTH);
		add(bt01, BorderLayout.SOUTH);
		add(new Button("È£¿À"), BorderLayout.CENTER);
		add(new Button("123"), BorderLayout.WEST);
		add(new Button("456"), BorderLayout.EAST);
		
		setBackground(new Color(200,175,175));
		setSize(new Dimension(400,200));
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MyFrame m = new MyFrame();
		m.go();
		System.out.println(m.getTitle());
	}

}