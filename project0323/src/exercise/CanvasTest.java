package exercise;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CanvasTest extends JFrame{
	Canvas can;
	Image img;
	Toolkit kit;
	
	
	public CanvasTest() {
		kit = Toolkit.getDefaultToolkit();
		img = kit.getImage("C:/html_workspace/images/pika.jpg");
		can = new Canvas(){
			public void paint(Graphics a){
				a.drawLine(10, 10, 150, 150);
				a.drawRect(20, 20, 40, 40);
				a.drawImage(img, 50, 50, this);
				
			}
			
		};
		
		can.setBackground(Color.GREEN);
		add(can);
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new CanvasTest();
	

	}

}
