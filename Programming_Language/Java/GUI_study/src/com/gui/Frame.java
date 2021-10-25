package com.gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame {
	public static void main(String[] args) {
		JFrame frame = new JFrame(); 
		JPanel panel = new JPanel();
		JLabel label = new JLabel("sth text");
		JButton btn1 = new JButton("Click this");
		JButton btn2 = new JButton("Exit Program");
		JTextArea txtArea = new JTextArea(); // ������ �ؽ�Ʈ�� ���� �� ����
//		JTextField txtField = new JTextField(200); //�ְ� ���� ���ڼ��� �� �־������.
		
		JPanel btnPanel = new JPanel();
		
		panel.setLayout(new BorderLayout());
				
		btnPanel.add(btn1);
		btnPanel.add(btn2);
//		panel.add(new JLabel("hello world"));
		panel.add(label, BorderLayout.NORTH);
//		panel.add(btn1, BorderLayout.WEST);
		panel.add(txtArea, BorderLayout.CENTER);
		panel.add(btnPanel, BorderLayout.WEST);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtArea.append("You are amazing\n");
				
			}
		});
		
		frame.add(panel); //panel�� add����߸� frame�� �߰��ȴ�.
		
		
		frame.setResizable(false); //false ������ ȭ�� ũ�� ���� �Ұ�
		//�׳� �����ϸ� frame�� �ȳ���, ���� �ʿ�
		frame.setVisible(true);
		// GUI â ũ�� ����
		frame.setPreferredSize(new Dimension(840, 840));
		frame.setSize(840, 840);
		frame.setLocationRelativeTo(null); //null�� �ָ� ȭ�� ��� GUIâ�� ���.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //GUIâ�� ���� ��Ŭ���� ���� ����
	}
}
