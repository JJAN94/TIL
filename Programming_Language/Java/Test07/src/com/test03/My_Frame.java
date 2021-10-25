package com.test03;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import com.mytest.Calc;

//case 1:  인터페이스를 implements 하는 이벤트 적용 방법
public class My_Frame extends Frame {
	Panel p1, p2, p3, p4;
	Label lbl_a, lbl_b;
	TextField txt_a, txt_b, txt_result;
	CheckboxGroup cbg;
	Checkbox op01, op02, op03, op04;
	Button bt ;
	public My_Frame() {
		super("내꺼 ");
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		p4 = new Panel();
		lbl_a = new Label("A:");
		lbl_b = new Label("B:");
		txt_a = new TextField(20);
		txt_b = new TextField(20);
		txt_result = new TextField(20);
		cbg = new CheckboxGroup();
		op01 = new Checkbox("+", cbg, false);
		op02 = new Checkbox("-", cbg, false);
		op03 = new Checkbox("*", cbg, false);
		op04 = new Checkbox("/", cbg, false);
        bt = new Button ("Ok");
	}
	public void go() {
		// 레이아웃
		setFont(new Font("궁서", 1, 30));
		setLayout(new GridLayout(4, 1));
		////// p1
		p1.add(lbl_a);
		p1.add(txt_a);
		/// p2
		p2.add(lbl_b);
		p2.add(txt_b);
		/// p3
		p3.add(op01);
		p3.add(op02);
		p3.add(op03);
		p3.add(op04);
		p3.add(bt);
		// p4
		
		p4.add(txt_result);	
		// 이벤트 구현
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		bt.addActionListener(new MyEvent());
		// 프레임 실행 시점
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		setSize(600, 400);
		setVisible(true);
	}
	
	class MyEvent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
//			System.out.println(e.toString());
//			System.out.println(e.getActionCommand()+":");
//			System.out.println(e.paramString());
//			if(e.getActionCommand().equals(e))
			
			int a = Integer.parseInt(txt_a.getText());
			int b = Integer.parseInt(txt_b.getText());
			
			my_calc.setA(a);
			my_calc.setB(b);
			
			if(op01.getState()) {
				String res = String.valueOf(my_calc.getHap());
				txt_result.setText(res);
			}
			
			System.out.println(op01.getState());
		}
	}
	
	public static void main(String[] args) {
		new My_Frame().go();
	}

}