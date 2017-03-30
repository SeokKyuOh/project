package thread;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AniMain_ex extends JFrame{
	JButton bt;
	Canvas can;
	int x;
	AniMain_ex aniMain;
	
	public AniMain_ex() {
		aniMain=this;
		
		bt = new JButton("move");
		can = new Canvas(){
			public void paint(Graphics g) {
				g.drawOval(x, 0, 50, 50);
				g.drawOval(x, 100, 50, 50);
				g.drawOval(x, 200, 50, 50);
				
			}
		};
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MoveThread_ex mt = new MoveThread_ex(aniMain);
				mt.start();
			}
		});
		
		can.setBackground(Color.YELLOW);
		
		add(bt, BorderLayout.NORTH);
		add(can);
		
		
		setSize(600,700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new AniMain_ex();
		

	}

}
