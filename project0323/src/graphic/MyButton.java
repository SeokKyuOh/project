/*
	버튼 클래스는 final로 선언되어 있지 않으므로 당연히 상속이 가능하다.
*/
package graphic;

import java.awt.Graphics;

import javax.swing.JButton;

public class MyButton extends JButton{
	//상속관계시 부모의 생성자는 물려지지 않는다.
	public MyButton(String title){
		super(title);	//부모의 생성자 호출
	}
	
	//모든 컴포넌트는 스스로를 그리므로 이때 사용되는 메서드가 paint메서드이며
	//이 메서드를 개발자가 오버라이드 한다면 개발자가 버튼을 그리게 된다. (그리는 순간에 뺏는 형식)
	//SUN에서 제공하는 컴포넌트 중 개발자가 그대로 사용해야 할 것이 있고
	//개발자가 주도하여 그래픽 처리를 해야 할 것이 있다.
	//컴포넌트 중 개발자가 무언가를 그리는 용도의 컴포넌트는 JPanel, JFrame등 주로 컨테이너 류를 대상으로 하자
	//Canvas는 그림 그릴 대상의 목적으로 제공된다.
	
	/* 이와 같이 하게 되면 버튼의 그래픽을 개발자가 직접만드는 셈으로 
	 	아래와 같이만 코딩한다면 버튼은 보여지지 않고 consol창에 텍스트만 나오게 된다.
	public void paint(Graphics g) {
		System.out.println("그린다");
	}
	*/
}
