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
	ArrayList list = new ArrayList();		//얘 완전 배열!
															//크기를 명시하지 않아도 되고, 객체만을 다룸
	//JButton[] bts = new JButton[];			//이렇게 할 경우 배열의 크기를 명시해야 하기 때문에 지금과 같은 상황에선 적절하지 않다.
	
	/*
	 	지금까지 사용해왔던 배열은 대량의 데이터를 순서있게 처리함에 있어서 엄청난 이득을 줘왔다.
	 	하지만 C,C#,Java와 같은 응용프로그램에서는 배열 생성시 그 크기를 반드시 명시해야 한다는 특징과 
	 	선언시 자료형이 결정되어야 한다는 점 등이 오히려 유연성이 떨어진다.
	 	자바에서는 대량의 객체(★★★★★)를 처리하는데 유용한 라이브러리를 제공하는데 
	 	이러한 라이브러리를 가리켜 *컬렉션 프레임웍*이라 하고, java.util 패키지에 모여있다.
	 	
	 	자바의 collect framework에서 제공하는 객체는 그 수가 상당하기 때문에
	 	모두 사용한다는 것은 멍청한 짓이다.
	 	업무에 따라 그때그때 적절한 것을 선택하면된다.
	 	
	 	주의!!!!
	 	배열과는 달리, 컬렉션 프레임웍의 대상이 되는 것은 오직 사물인 객체에 한정된다.
	 	배열과 공통점, 모아서 처리하는데 유용하다.
	 	
	 	순서 없는 것 set 유형
	 	순서 있는 것 list 유형 (ex.채팅방 입장가능한 인원수)
	 	물체를 키값만으로 추출할 수 있는 map 유형 (ex.키세스 초콜릿 끈으로 집는 것)
	 */
		
	
	public ButtonCreate() {
		//setLayout(new FlowLayout());
		create_bt = new JButton("만들기");
		color_bt = new JButton("색상변경");
		north_p = new JPanel();
		center_p = new JPanel();
		
		north_p.add(create_bt);
		north_p.add(color_bt);
		
		add(north_p, BorderLayout.NORTH);
		add(center_p, BorderLayout.CENTER);
		
		//이벤트 구현
		//왠만하면 이벤트 안에 로직을 짜지 않는 것이 좋다.(활용성을 높이기 위해)
		create_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//버튼생성
				createButton();
			}
		});
		
		color_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//모든 버튼을 대상으로 배경색 변경
				setColor();
			}
		});
		
		setSize(500,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//버튼 생성 메서드
	//피곤함에도 별도로 뺀 이유는?
	//이벤트에 의존하여 로직을 작성하면 이벤트 방식의 변경에 의해 로직도 손상받기 때문이다.
	public void createButton(){
		count ++;
		JButton bt = new JButton(Integer.toString(count));		//Jbutton()안에는 String이 들어가야하기 때문에 count를 바꿔준다.
		
		//javascript의 push()와 완전 비슷한 메서드 호출하자
		list.add(bt); //1건 추가!!
		System.out.println("현재까지 누적수는"+list.size());
		
		center_p.add(bt);
		center_p.updateUI();		//refresh 해주는 메서드
	}
	
	public void setColor(){
		for(int i=0;i<list.size();i++){
			//i번째 버튼의 setBackground()하면 된다.
			JButton bt=(JButton)list.get(i);
			bt.setBackground(Color.YELLOW);
			
		}
		
	}
	
	public static void main(String[] args) {
		new ButtonCreate();
		
		
	}

}
