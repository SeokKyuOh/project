/*
 	현실에서의 그래픽 요소는..
 	그리는 주체 = 사람
 	그림도구 = 붓, 팔레트
 	그려질 대상 = 켄버스
 	
 	전산에서는 위의 그래픽 요소를 그대로 반영하고 있다.
 	주체 = 컴포넌트 스스로
 	도구 = 붓(paint() 메서드)
 			팔레트(Graphics 객체)
 			참고) 현실의 팔레트보다 훨씬 더 기능이 막강하다.
 	대상 = 컴포넌트
 	
 */

package graphic;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

//버튼도 컴포넌트이므로, 분명히 스스로 그릴 것이다.

public class ButtonTest extends JFrame{
	MyButton bt;
	
	public ButtonTest() {
		bt = new MyButton("버튼");		//이때 MyButton은 JButton의 자식일 뿐이기 때문에 생성자를 따로 만들지 않으면 에러난다.
			
		setLayout(new FlowLayout());
		add(bt);
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new ButtonTest();
		

	}

}
