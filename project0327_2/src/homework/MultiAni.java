/*
 	���� �ٸ� �׷���, �ӵ�, ��Ÿ ���� ���� ��ü�� �����̰� ����
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
	Graphics gp; // �ٸ� ������ ���� ���� ������ ��



	public MultiAni() {
		bt = new JButton("���ڿ����̱�");
		can = new Canvas() { // paint�ż��� ������
			public void paint(Graphics g) {
				// gp=g;
			}
		};

		// ct = new CircleThread(gp, 0, 0, 50, 50); //gp�� ����� ���� �ҷ����� ������.
		// ct.start();

		can.setBackground(Color.YELLOW);
		add(bt, BorderLayout.NORTH);
		add(can);

		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graphics g = can.getGraphics(); // ĵ������ �����ϰ� �ִ� �׷����� �ѱ��.
				
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
