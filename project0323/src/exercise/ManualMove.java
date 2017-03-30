package exercise;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ManualMove extends JFrame{
	Canvas can;
	JPanel p;
	JButton bt;
	int a=50;
	int b=50;
	int x;
	int y;
	
	
	public ManualMove() {
		can = new Canvas(){
			public void paint(Graphics g) {
				g.drawRect(x, y, a, b);
			}
			
		};
		p = new JPanel();
		bt = new JButton("¿Ãµø");
		
		can.setBackground(Color.RED);
		
		
		bt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("¥≠∑∂¥œ?");
				x+=15;
				y+=15;
				a+=5;
				b+=5;
				can.repaint();
			}
			
		});
		
		p.add(bt);
		add(p, BorderLayout.NORTH);
		add(can);
		
		setSize(400,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ManualMove();
		

	}

}
