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
		JTextArea txtArea = new JTextArea(); // 여러줄 텍스트를 넣을 수 있음
//		JTextField txtField = new JTextField(200); //넣고 싶은 글자수를 꼭 넣어줘야함.
		
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
		
		frame.add(panel); //panel을 add해줘야만 frame에 추가된다.
		
		
		frame.setResizable(false); //false 지정시 화면 크기 조절 불가
		//그냥 실행하면 frame이 안나옴, 설정 필요
		frame.setVisible(true);
		// GUI 창 크기 설정
		frame.setPreferredSize(new Dimension(840, 840));
		frame.setSize(840, 840);
		frame.setLocationRelativeTo(null); //null을 주면 화면 가운데 GUI창이 뜬다.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //GUI창을 끄면 이클립스 실행 종료
	}
}
