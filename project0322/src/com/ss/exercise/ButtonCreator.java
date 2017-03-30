package com.ss.exercise;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonCreator extends JFrame{
	JButton bt_create, bt_color;
	JPanel p_north, p_center;
	int i=0;
	ArrayList list = new ArrayList();
	
	public ButtonCreator() {
		bt_create = new JButton("버튼생성");
		bt_color = new JButton("색상변경");
		p_north = new JPanel();
		p_center = new JPanel();
		
		p_north.add(bt_create);
		p_north.add(bt_color);
		
		add(p_north, BorderLayout.NORTH);
		add(p_center, BorderLayout.CENTER);
		
		bt_create.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				createButton();	
			}
		});
		
		bt_color.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setColor();
			}
		});
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public void createButton(){
		i++;
		JButton bt = new JButton(Integer.toString(i));
		list.add(bt);
		p_center.add(bt);
		p_center.updateUI();
	}
	
	public void setColor(){
		for(int i=0;i<list.size();i++){
			JButton bt = (JButton)list.get(i);
			bt.setBackground(Color.BLUE);

		}
		
	}
	
	public static void main(String[] args) {
		new ButtonCreator();
		

	}

}
