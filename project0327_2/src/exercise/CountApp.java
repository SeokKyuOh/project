package exercise;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountApp extends JFrame{
	JLabel la1, la2;
	
	
	public CountApp() {
		la1 = new JLabel("0");
		la2 = new JLabel("0");
		
		setLayout(new FlowLayout());
		
		la1.setFont(new Font("Dotum", Font.BOLD, 70));
		la2.setFont(new Font("Dotum", Font.BOLD, 70));
		
		add(la1);
		add(la2);
		
		setSize(700,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
	}

	public static void main(String[] args) {
		new CountApp();

	}

}
