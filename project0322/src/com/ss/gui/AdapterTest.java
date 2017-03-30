package com.ss.gui;

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
	
	public AdapterTest(){
		setLayout(new FlowLayout());	//������ ���
		
		txt = new JTextField(15);
		area = new JTextArea(15,30);
		bt = new JButton("������");
		
		add(txt);
		add(bt);
		add(area);
		
		
		//txt�� �����ʿ��� ����
		//txt.addKeyListener(new AdapterTestAdapter(area, txt));		//������ ���
		
		//.java ������ ����� ���� ���, Ŭ���� �ڵ� ��ü�� �޼����� �μ��� Ŭ������ ������� � �ٷ� ������ ���� �ִ�.
		//�����͸�Ŭ���� (Anonymous inner class)�� ����ϴ� ����?
		//.java vs �����͸�
		//**���� Ŭ���������� ����� �� �ִ� ���뼺�� �������� �͵鿡 ���� �����͸�Ŭ������ ���� ����Ѵ�.**
		//.java�� ���������� �����ҽ����� �ۼ��ϴ� ������ �ڵ��� ���뼺�� �ִ�.
		//������ GUI���α׷��� ��� Ư�� �̺�Ʈ �����ڵ�� Ư�� Ŭ������ �������̱� ������ ���뼺�� ����� ��������.
		//�� ��� �����ڰ� .java���� ������, �μ��� ���� ��ü�� �Ѱܹ޴� ���� �ؾ��ұ�?
		//�ش�) ��ȸ�� �ڵ�� ����. �� ���� Ŭ������ �Ϻη� Ŭ������ ������� �������.
		txt.addKeyListener(new KeyAdapter(){		//���⼭ KeyAdapter�� new �� ���ϻ�. {}�� ���� �̸� ���� �͸� Ŭ���� ���� ����
			public void keyReleased(KeyEvent e){		//�̸� ���� �������̵尡 �����ϰ�, �̸� �����͸�Ŭ������� �Ѵ�.
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					String msg = txt.getText();
					area.append(msg + "\n");
					txt.setText("");	
				}
			}
		});
		//KeyAdapter �� �߻�Ŭ�����ӿ��� �ұ��ϰ� new�� ���� �� �ִ� ������ �ڿ� {}���� ���ǰ� �̷������ �����̴�.																
		
		
		//�����͸� Ŭ������ ����
		//�����͸� �޼��� �ڵ� �ȿ��� �ڽ��� ������ �ܺ�Ŭ������ ��������� ����ó�� �� �� �ִ�.
		//�ڰ��� ���� ����
		//�����͸�Ŭ������ ������� ��� �̵��� �������� ������ �� �ִٴ� ���ε�
		//���� �����ڰ� ���������� �����͸����� ����ϰ��� �Ҷ��� �� ���������� final�� ����Ǿ� �־���Ѵ�.
		//final int a=9;
		
		bt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("������?");
				//a=8;  �̺κ��� �������� ������ final�� �����Ͽ� ������ �� �� ���� ����
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
