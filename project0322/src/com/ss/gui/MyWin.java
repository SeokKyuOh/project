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
		bt = new JButton("�Է�");
		setLayout(new FlowLayout());
		MyActionListener my = new MyActionListener();
		
		add(txt);
		add(bt);
		
		my.setMyWin(this);
		
		bt.addActionListener(my);	//���� �����ϰ� ������ �ҷ��͵� �ǰ� �ٷ� �Ʒ�ó�� �ٷ� new�ص� �ǰ�
		txt.addKeyListener(new MyKeyListener());
			
		setBounds(100,100,250,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
		
	public static void main(String[] args) {
		new MyWin();
	}


}
