package com.test02;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyFrame extends Frame implements WindowListener {
	Panel p1;
	Button bt;
	
	public MyFrame() {
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

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {

		System.out.println("windowClosing");
		System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {

		System.out.println("windowClosed");
		System.exit(0);
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {	
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {	
	}
}