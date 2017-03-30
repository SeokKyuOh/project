/*
 	패널이 라벨과 버튼을 가지고 있다.
 	JPanel has a Lable & JButton
 */
package file;

import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	JLabel la;
	JButton bt;
	
	//패널이 태어날 때, 그 부품도 같이 태어나야 하므로, 생성자에서 초기화 하자
	public MyPanel(String title, Icon icon) {
		la = new JLabel(title);		//여기에 들어갈 디렉토리명은 변하므로.. 메서드로 해도 된다.
		bt = new JButton(icon);
		
		bt.setBorderPainted(false);		//경계선 없애기
		bt.setContentAreaFilled(false);	//색 채우기 없음
		bt.setFocusPainted(false);		//포커스에 대한 경계 없애기
		bt.setOpaque(false);				//투명
		
		
		this.setLayout(new BorderLayout());
		add(la, BorderLayout.NORTH);
		add(bt);
		
	}
}
