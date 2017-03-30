/*
 	서로 다른 그래픽, 속도, 기타 값을 갖는 물체를 움직이게 하자
 */
package homework;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MultiAni extends JFrame {
	JButton bt;
	Canvas can;
	Graphics gp; // 다른 곳에서 참조 위해 밖으로 뺌



	public MultiAni() {
		bt = new JButton("각자움직이기");
		can = new Canvas() { // paint매서드 재정의
			public void paint(Graphics g) {
				// gp=g;
			}
		};

		// ct = new CircleThread(gp, 0, 0, 50, 50); //gp가 생기기 전에 불러내서 에러남.
		// ct.start();

		can.setBackground(Color.YELLOW);
		add(bt, BorderLayout.NORTH);
		add(can);

		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g = can.getGraphics(); // 캔버스가 보유하고 있는 그래픽을 넘긴다.
				
				CircleThread ct = new CircleThread(0, 0, 50, 50, 100, g);
				RectThread rt = new RectThread(0, 60, 50, 50, 100, g);
				
			}
		});

		setSize(700, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MultiAni();

	}

}
