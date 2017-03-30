package com.ss.gui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatB extends JFrame implements KeyListener{
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	//필요한 객체, 즉 사용할 객체가 있다면 has a 관계로 보유하자
	ChatA chatA; 		//현재 chatA의 값은 null
	ChatC chatC;
	
	public ChatB(){
		area = new JTextArea();
		scroll = new JScrollPane(area);
		p_south = new JPanel();
		t_input=new JTextField(15);
		//chatA = new ChatA();		
		//ㄴ 여기서 new 하면 안되는 이유? 우리가 원하는 건 새로운 ChatA가 아닌 나를 태어나게 했던 그 ChatA의 주소값을 원한다.
		
		this.add(scroll);
		p_south.add(t_input);
		this.add(p_south, BorderLayout.SOUTH);
		
		t_input.addKeyListener(this);
		
		setBounds(400,100,300,400);
		setVisible(true);
				
	}

	
	public void keyPressed(KeyEvent e) {		
	}

	public void keyReleased(KeyEvent e) {
		//ChatA, ChatC에게 메세지 보내기
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			String msg=t_input.getText();
			this.area.append(msg+"\n");
			chatA.area.append(msg+"\n");
			chatC.area.append(msg+"\n");
			t_input.setText("");;
		}
	}

	public void keyTyped(KeyEvent e) {
	
	}

	//외부의 어떤 객체가, 나에게 데이터를 주입시켜줄 수 있는 setter를 준비하자
	public void setChatA(ChatA chatA){
		this.chatA=chatA;		//this를 뺄경우 {}안에 있는 매개변수를 지칭하기 때문에 this를 명시
	}
	
	public void setChatC(ChatC chatC){
		this.chatC=chatC;
	}
}
