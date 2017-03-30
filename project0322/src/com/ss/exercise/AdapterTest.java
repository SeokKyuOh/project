package com.ss.exercise;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AdapterTest extends JFrame{
	JTextField txt;
	JTextArea area;
	JButton bt;
	
	public AdapterTest() {
		setLayout(new FlowLayout());
		
		txt = new JTextField(15);
		area = new JTextArea(15, 30);
		bt = new JButton("ENTER");
		
		add(txt);
		add(bt);
		add(area);
		
		txt.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e){
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					String msg = txt.getText();
					area.append(msg+"\n");
					txt.setText("");
				}
			}
		});
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = txt.getText();
				area.append(msg+"마우스로 눌렀네? \n");
				txt.setText("");
			}
		});
		
		setSize(350,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new AdapterTest();
		
	}

}
