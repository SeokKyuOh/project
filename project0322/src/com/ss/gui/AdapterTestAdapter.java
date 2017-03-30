package com.ss.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AdapterTestAdapter extends KeyAdapter{
	JTextArea area;		//���⼭ new�� ��������. ���� �ʿ��� ���� ���ο���� �ƴ϶� ������ �ڷ��̱� �����̴�.
	JTextField txt;
	
	public AdapterTestAdapter(JTextArea area, JTextField txt) {			//�ڷ����� �տ� ���. ���� getter�� setter�� ��� ���� ���� ����.
		this.area=area;
		this.txt=txt;
	}
	//ctrl + space bar �ϸ� �ش� �޼��� ��� ����
	public void keyReleased(KeyEvent e) {
		//�����ƴ� area�� txt�� �Է��� ���ڿ� ���
		int key = e.getKeyCode();
		
		if(key==KeyEvent.VK_ENTER){
			String msg = txt.getText();
			area.append(msg + "\n");
			txt.setText("");		
		
		}
		
	
	}

}
