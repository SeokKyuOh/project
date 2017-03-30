package exercise;

import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainApp extends JFrame{
	JButton[] menu = new JButton[3];
	JPanel p_north, p_center;
	JPanel[] page = new JPanel[3];
	URL[] url = new URL[3];
	String[] path = {"/login.png","/content.png","/etc.png"};
	
		
	public MainApp() {
		p_north = new JPanel();
		
	}
	
	public static void main(String[] args) {
		new MainApp();
		

	}

}
