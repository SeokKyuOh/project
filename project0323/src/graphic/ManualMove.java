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
				
				repaint();	//p.repaint(); �ϰԵǸ�..
				//�������� �����ϴ� ���
				test();	//���⼭ this.�� �ְԵǸ� �������� �ƴ϶� bt�� ��Ī�ϰ� �ȴ�. 
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
