package com.ss.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AdapterTestAdapter extends KeyAdapter{
	JTextArea area;		//여기서 new를 하지말자. 지금 필요한 것은 새로운것이 아니라 기존의 자료이기 때문이다.
	JTextField txt;
	
	public AdapterTestAdapter(JTextArea area, JTextField txt) {			//자료형을 앞에 명시. 굳이 getter와 setter를 모든 곳에 쓰진 말자.
		this.area=area;
		this.txt=txt;
	}
	//ctrl + space bar 하면 해당 메서드 목록 나옴
	public void keyReleased(KeyEvent e) {
		//내꺼아닌 area에 txt의 입력한 문자열 출력
		int key = e.getKeyCode();
		
		if(key==KeyEvent.VK_ENTER){
			String msg = txt.getText();
			area.append(msg + "\n");
			txt.setText("");		
		
		}
		
	
	}

}
