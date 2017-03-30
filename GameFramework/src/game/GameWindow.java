package game;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class GameWindow extends JFrame{
	GamePanel gamePanel;
	
	public GameWindow() {
		//setLayout(new FlowLayout());		이게 있을경우 약간의 여백이 보인다.
		
		gamePanel = new GamePanel();
		add(gamePanel);
		
		//패널에 프로그래밍 적으로 포커스 올리기
		gamePanel.setFocusable(true);
		
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new GameWindow();

	}

}
