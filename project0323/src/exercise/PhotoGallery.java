package exercise;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PhotoGallery extends JFrame implements ActionListener{
	JPanel p;
	JButton bt_prev, bt_next;
	Canvas can;
	JLabel la;
	Image img;
	Toolkit kit;
	String[] route={
		"C:/html_workspace/images/nation/brazil.jpg",
		"C:/html_workspace/images/nation/canada.jpg",
		"C:/html_workspace/images/nation/china.jpg",
		"C:/html_workspace/images/nation/france.jpg",
		"C:/html_workspace/images/nation/germany.jpg",		
		"C:/html_workspace/images/nation/italy.jpg",		
		"C:/html_workspace/images/nation/jamaica.jpg",		
		"C:/html_workspace/images/nation/japan.jpg",		
		"C:/html_workspace/images/nation/mexico.jpg",		
		"C:/html_workspace/images/nation/usa.jpg"			
	};
	int count=0;
	
	public PhotoGallery() {
		p = new JPanel();
		bt_prev = new JButton("prev");
		bt_next = new JButton("next");
		la = new JLabel(route[0]);
		img = kit.getImage(route[0]);
		can = new Canvas(){
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, 500, 600, this);
			}
			
		};
		

		p.add(bt_prev);
		p.add(bt_next);
		
		p.setBackground(Color.red);
		can.setBackground(Color.WHITE);
		la.setBackground(Color.GREEN);
		
		add(p,BorderLayout.NORTH);
		add(can);
		add(la,BorderLayout.SOUTH);
		
		bt_prev.addActionListener(this);
		bt_next.addActionListener(this);
		
		setSize(500,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		JButton btm = (JButton)obj;
		
		if(btn == bt_prev){
			prev();
		}else if(btn == bt_next){
			next();
		}
	}
	public void prev(){
		count--;
		img=kit.getImage(route[count]);
		can.repaint();
		la.setText(route[count]);
		
	}
	public void next(){
		
		
	}
	
	public static void main(String[] args) {
		new PhotoGallery();
		
		

	}

}
