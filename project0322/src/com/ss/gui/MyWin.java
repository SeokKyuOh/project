package com.ss.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyWin extends JFrame {
	JTextField txt;
	JButton bt;
	
	
	public MyWin(){
		
		txt = new JTextField(15);
		bt = new JButton("입력");
		setLayout(new FlowLayout());
		MyActionListener my = new MyActionListener();
		
		add(txt);
		add(bt);
		
		my.setMyWin(this);
		
		bt.addActionListener(my);	//위에 선언하고 변수를 불러와도 되고 바로 아래처럼 바로 new해도 되고
		txt.addKeyListener(new MyKeyListener());
			
		setBounds(100,100,250,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
		
	public static void main(String[] args) {
		new MyWin();
	}


}
