package com.ss.gui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatC extends JFrame implements KeyListener{
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	private ChatA chatA;
	private ChatB chatB;
	
	public ChatC(){
		area = new JTextArea();
		scroll = new JScrollPane(area);
		p_south = new JPanel();
		t_input=new JTextField(15);
		
		this.add(scroll);
		p_south.add(t_input);
		this.add(p_south, BorderLayout.SOUTH);
		
		t_input.addKeyListener(this);
		
		setBounds(400,500,300,400);
		setVisible(true);

	}

	public ChatA getChatA() {
		return chatA;
	}

	public void setChatA(ChatA chatA) {
		this.chatA = chatA;
	}

	public ChatB getChatB() {
		return chatB;
	}

	public void setChatB(ChatB chatB) {
		this.chatB = chatB;
	}

	public void keyPressed(KeyEvent e) {	
	}


	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			String msg=t_input.getText();
			this.area.append(msg+"\n");
			chatA.area.append(msg+"\n");
			chatB.area.append(msg+"\n");
			t_input.setText("");
		}
	}

	public void keyTyped(KeyEvent e) {
		
	}

	
}
