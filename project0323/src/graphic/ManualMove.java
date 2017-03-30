package graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ManualMove extends JFrame{
	JPanel p;
	JButton bt;
	int x;
	int y;
	
	public ManualMove() {
		p = new JPanel(){
			public void paint(Graphics g) {
				g.drawOval(x, y, 50, 50);
			}
		};
		p.setBackground(Color.YELLOW);
		bt = new JButton("move");
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x+=15;
				y+=15;
				
				repaint();	//p.repaint(); 하게되면..
				//프레임을 접근하는 방법
				test();	//여기서 this.을 넣게되면 프레임이 아니라 bt을 지칭하게 된다. 
			}
		});
		add(bt,BorderLayout.NORTH);
		add(p);
		
		
		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void test(){
		System.out.println("das");
		
	}
	
	public static void main(String[] args) {
		new ManualMove();
	
	}

}
