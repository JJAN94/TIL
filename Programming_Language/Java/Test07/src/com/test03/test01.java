package com.test03;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;


public class test01 extends JFrame  {
	Panel p1;
	Button bt;
	
	public void MyFrame() {
		super("����");
		p1 = new Panel();
		bt = new Button("���� ���� ���Ƶ��� ����");
		
	}
	
	public void go() {
		///���̾ƿ�
		setFont(new Font("Arial", Font.BOLD, 30));
		p1.add(bt);
		add(p1);
		
		/////�̺�Ʈ ����
			//1. ����� addxxxListener
		addWindowListener(this);
			//2. ()�� �Ű����ڸ� ���ؼ� �ش� �̺�Ʈ�� �´� �޼ҵ尡 �ִ��� ã�´�.
			//3. �����Ѵ�.
		
		///������ ���� ����
		setSize(400, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame().go();
	}
	
}