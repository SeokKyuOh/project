package com.ss.gui;
/*
 	�̺�Ʈ ���α׷��� �� �����ʰ� �������̽��̱� ������ �� �ϳ��� �޼��带 �������̵� ���� ������ 
 	���������� ����� ���� �Ǿ� ������ ������ �߻��Ѵ�.
 	�� ��Ģ�� Ư���� �߻�޼��带 ���� ������ �������̽��� ��� �ʹ� ��ȿ�����̰� �ǰ��ϴ�.
 	
 	�ذ�å) �����ڸ� ����Ͽ� �̹� �������� �޼������ ������ �س��� ��ü���� ������ ����Ͷ� �Ѵ�.
 	 BUT! ����ʹ� ������ �����Ǵ� ���� �ƴ϶�, ������ ����� ���� 3�� �̻��� �߻�޼��带 ������ �����ʶ��
 	 ����� ������ �ϴ� �ǽ��غ����Ѵ�.
 */
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/*������ �̺�Ʈ�� �����غ���*/
public class WindowTest extends JFrame {
	JButton bt;
	
	public WindowTest(){
		bt = new JButton("��ư");
		setLayout(new FlowLayout());
		
		add(bt);
		
		addWindowListener(new MyAdapter());	//this ��� MyAdapter�� �������μ� ������������ ���Ѵ�.
		//bt.addWindowListener(new MyAdapter()); �� �Ұ����� ����. windowListener���� ��ư�� �ٴ� ���� �Ұ���. actionListener�� ����
		
		setBounds(100,100,200,250);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new WindowTest();
	}
}
