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
		setLayout(new FlowLayout());	//선생님 방법
		
		txt = new JTextField(15);
		area = new JTextArea(15,30);
		bt = new JButton("눌러요");
		
		add(txt);
		add(bt);
		add(area);
		
		
		//txt와 리스너와의 연결
		//txt.addKeyListener(new AdapterTestAdapter(area, txt));		//기존의 방법
		
		//.java 파일을 만들기 싫은 경우, 클래스 코드 자체를 메서드의 인수나 클래스의 멤버변수 등에 바로 대입할 수도 있다.
		//내부익명클래스 (Anonymous inner class)를 사용하는 이유?
		//.java vs 내부익명
		//**현재 클래스에서만 사용할 수 있는 재사용성이 떨어지는 것들에 대해 내부익명클래스를 통해 사용한다.**
		//.java를 물리적으로 원본소스까지 작성하는 이유는 코드의 재사용성에 있다.
		//하지만 GUI프로그래밍 등에서 특히 이벤트 구현코드는 특정 클래스에 종속적이기 때문에 재사용성이 상당히 떨어진다.
		//이 경우 개발자가 .java까지 만들어가며, 인수를 통해 객체를 넘겨받는 수고를 해야할까?
		//해답) 일회성 코드로 가자. 즉 현재 클래스에 일부로 클래스를 존재시켜 사용하자.
		txt.addKeyListener(new KeyAdapter(){		//여기서 KeyAdapter는 new 한 것일뿐. {}를 통해 이름 없는 익명 클래스 생성 가능
			public void keyReleased(KeyEvent e){		//이를 통해 오버라이드가 가능하고, 이를 내부익명클래스라고 한다.
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					String msg = txt.getText();
					area.append(msg + "\n");
					txt.setText("");	
				}
			}
		});
		//KeyAdapter 가 추상클래스임에도 불구하고 new를 받을 수 있는 이유는 뒤에 {}통해 정의가 이루어지기 때문이다.																
		
		
		//내부익명 클래스의 장점
		//내부익명 메서드 코드 안에서 자신을 포함한 외부클래스의 멤버변수를 내것처럼 쓸 수 있다.
		//자격증 시험 문제
		//내부익명클래스의 사용으로 얻는 이득은 멤버면수를 공유할 수 있다는 것인데
		//만일 개발자가 지역변수를 내부익명내에서 사용하고자 할때는 그 지역변수는 final로 선언되어 있어야한다.
		//final int a=9;
		
		bt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("눌렀니?");
				//a=8;  이부분이 에러나는 이유는 final로 선언하여 변경이 될 수 없기 때문
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
