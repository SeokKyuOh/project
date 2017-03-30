package com.ss.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonCreate extends JFrame{
	JButton create_bt, color_bt;
	JPanel north_p, center_p;
	int count=0;
	ArrayList list = new ArrayList();		//�� ���� �迭!
															//ũ�⸦ ������� �ʾƵ� �ǰ�, ��ü���� �ٷ�
	//JButton[] bts = new JButton[];			//�̷��� �� ��� �迭�� ũ�⸦ ����ؾ� �ϱ� ������ ���ݰ� ���� ��Ȳ���� �������� �ʴ�.
	
	/*
	 	���ݱ��� ����ؿԴ� �迭�� �뷮�� �����͸� �����ְ� ó���Կ� �־ ��û�� �̵��� ��Դ�.
	 	������ C,C#,Java�� ���� �������α׷������� �迭 ������ �� ũ�⸦ �ݵ�� ����ؾ� �Ѵٴ� Ư¡�� 
	 	����� �ڷ����� �����Ǿ�� �Ѵٴ� �� ���� ������ �������� ��������.
	 	�ڹٿ����� �뷮�� ��ü(�ڡڡڡڡ�)�� ó���ϴµ� ������ ���̺귯���� �����ϴµ� 
	 	�̷��� ���̺귯���� ������ *�÷��� �����ӿ�*�̶� �ϰ�, java.util ��Ű���� ���ִ�.
	 	
	 	�ڹ��� collect framework���� �����ϴ� ��ü�� �� ���� ����ϱ� ������
	 	��� ����Ѵٴ� ���� ��û�� ���̴�.
	 	������ ���� �׶��׶� ������ ���� �����ϸ�ȴ�.
	 	
	 	����!!!!
	 	�迭���� �޸�, �÷��� �����ӿ��� ����� �Ǵ� ���� ���� �繰�� ��ü�� �����ȴ�.
	 	�迭�� ������, ��Ƽ� ó���ϴµ� �����ϴ�.
	 	
	 	���� ���� �� set ����
	 	���� �ִ� �� list ���� (ex.ä�ù� ���尡���� �ο���)
	 	��ü�� Ű�������� ������ �� �ִ� map ���� (ex.Ű���� ���ݸ� ������ ���� ��)
	 */
		
	
	public ButtonCreate() {
		//setLayout(new FlowLayout());
		create_bt = new JButton("�����");
		color_bt = new JButton("���󺯰�");
		north_p = new JPanel();
		center_p = new JPanel();
		
		north_p.add(create_bt);
		north_p.add(color_bt);
		
		add(north_p, BorderLayout.NORTH);
		add(center_p, BorderLayout.CENTER);
		
		//�̺�Ʈ ����
		//�ظ��ϸ� �̺�Ʈ �ȿ� ������ ¥�� �ʴ� ���� ����.(Ȱ�뼺�� ���̱� ����)
		create_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��ư����
				createButton();
			}
		});
		
		color_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��� ��ư�� ������� ���� ����
				setColor();
			}
		});
		
		setSize(500,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//��ư ���� �޼���
	//�ǰ��Կ��� ������ �� ������?
	//�̺�Ʈ�� �����Ͽ� ������ �ۼ��ϸ� �̺�Ʈ ����� ���濡 ���� ������ �ջ�ޱ� �����̴�.
	public void createButton(){
		count ++;
		JButton bt = new JButton(Integer.toString(count));		//Jbutton()�ȿ��� String�� �����ϱ� ������ count�� �ٲ��ش�.
		
		//javascript�� push()�� ���� ����� �޼��� ȣ������
		list.add(bt); //1�� �߰�!!
		System.out.println("������� ��������"+list.size());
		
		center_p.add(bt);
		center_p.updateUI();		//refresh ���ִ� �޼���
	}
	
	public void setColor(){
		for(int i=0;i<list.size();i++){
			//i��° ��ư�� setBackground()�ϸ� �ȴ�.
			JButton bt=(JButton)list.get(i);
			bt.setBackground(Color.YELLOW);
			
		}
		
	}
	
	public static void main(String[] args) {
		new ButtonCreate();
		
		
	}

}
