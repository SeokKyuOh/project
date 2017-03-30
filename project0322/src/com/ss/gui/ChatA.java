package com.ss.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatA extends JFrame implements ActionListener, KeyListener {
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JButton bt;
	JTextField t_input;
	ChatB chatB;
	ChatC chatC;

	public ChatA() {
		area = new JTextArea();
		scroll = new JScrollPane(area);
		p_south = new JPanel();
		bt = new JButton("열기");
		t_input = new JTextField(15);

		this.add(scroll);
		p_south.add(t_input);
		p_south.add(bt);
		this.add(p_south, BorderLayout.SOUTH);

		// 컴포넌트와 리스너 연결
		bt.addActionListener(this);
		t_input.addKeyListener(this);

		setBounds(100, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {
		//System.out.println(); // sysout 컨트롤 스페이스 누르면 명령어 나옴
		// ChatB와 ChatC를 생성해보자
		chatB = new ChatB(); // 소문자로 된 것으로 하는 것을 추천. 나중에 알아보기 쉽게
		chatC = new ChatC();
		
		//ChatB에게 필요한 정보를 주입시켜주자
		chatB.setChatA(this);
		chatB.setChatC(chatC);
		
		//ChatC에게 필요한 정보를 주입시켜주자
		chatC.setChatA(this);
		chatC.setChatB(chatB);
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		/* 엔터를 치면 메세지를 다른 창으로 보내자 */ // 주석을 나오게 하는 단축키 ctrl + shift + /   없애는건 /대신 \넣는다.
		int key = e.getKeyCode(); // API 문서 열지 않고 확인하는 법. 마우스 올리면 보이고 F2누르면 스크롤 나오면서 확인 가능

		if (key == KeyEvent.VK_ENTER) {
			String msg = t_input.getText();
			area.append(msg + "\n");
			chatB.area.append(msg + "\n");
			chatC.area.append(msg + "\n");
			t_input.setText("");

		}

	}

	public void keyTyped(KeyEvent e) {
	}

	public static void main(String[] args) {
		new ChatA();

	}
}
