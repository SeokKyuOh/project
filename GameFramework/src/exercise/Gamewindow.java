package exercise;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Gamewindow extends JFrame{
	GamePanel gamePanel;
	
	public Gamewindow() {
		gamePanel = new GamePanel();
		add(gamePanel);
		
		gamePanel.setFocusable(true);
		
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new Gamewindow();

	}

}
