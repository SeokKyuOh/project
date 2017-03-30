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
		bt = new JButton("����");
		t_input = new JTextField(15);

		this.add(scroll);
		p_south.add(t_input);
		p_south.add(bt);
		this.add(p_south, BorderLayout.SOUTH);

		// ������Ʈ�� ������ ����
		bt.addActionListener(this);
		t_input.addKeyListener(this);

		setBounds(100, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {
		//System.out.println(); // sysout ��Ʈ�� �����̽� ������ ��ɾ� ����
		// ChatB�� ChatC�� �����غ���
		chatB = new ChatB(); // �ҹ��ڷ� �� ������ �ϴ� ���� ��õ. ���߿� �˾ƺ��� ����
		chatC = new ChatC();
		
		//ChatB���� �ʿ��� ������ ���Խ�������
		chatB.setChatA(this);
		chatB.setChatC(chatC);
		
		//ChatC���� �ʿ��� ������ ���Խ�������
		chatC.setChatA(this);
		chatC.setChatB(chatB);
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		/* ���͸� ġ�� �޼����� �ٸ� â���� ������ */ // �ּ��� ������ �ϴ� ����Ű ctrl + shift + /   ���ִ°� /��� \�ִ´�.
		int key = e.getKeyCode(); // API ���� ���� �ʰ� Ȯ���ϴ� ��. ���콺 �ø��� ���̰� F2������ ��ũ�� �����鼭 Ȯ�� ����

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
