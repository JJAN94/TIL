package com.test03;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;


public class test01 extends JFrame  {
	Panel p1;
	Button bt;
	
	public void MyFrame() {
		super("내꺼");
		p1 = new Panel();
		bt = new Button("빙글 빙글 돌아도는 세상");
		
	}
	
	public void go() {
		///레이아웃
		setFont(new Font("Arial", Font.BOLD, 30));
		p1.add(bt);
		add(p1);
		
		/////이벤트 구현
			//1. 대상의 addxxxListener
		addWindowListener(this);
			//2. ()의 매개인자를 통해서 해당 이벤트에 맞는 메소드가 있는지 찾는다.
			//3. 구현한다.
		
		///프레임 실행 시점
		setSize(400, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame().go();
	}
	
}