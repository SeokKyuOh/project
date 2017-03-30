package thread;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AnyMain extends JFrame{
	JButton bt;
	Canvas can;
	int x,y;
	AnyMain anyMain;
	
	public AnyMain() {
		anyMain=this; 		//자바스크립트에서 this를 피하기 위해 me를 쓰는 것처럼 위에 따로 선언한 후 붙인다.
		
		bt= new JButton("물체이동");
		add(bt, BorderLayout.NORTH);
			
		can = new Canvas(){
			public void paint(Graphics g) {
				g.drawOval(x, y, 50, 50);
			}
		};
		
		can.setBackground(Color.YELLOW);
		add(can);
		
		//버튼과 리스너 연결
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//이동 메서드 호출
				//동생 쓰레드를 만들어 일시키자
				MoveThread mt = new MoveThread(anyMain);	//기존 AnyMain 레퍼런스 접근해야한다 AnyMain.this라고 해도 된다.
				mt.start();
			}
		});
		
		setSize(700,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void move(){
		x+=5;
		can.repaint();
	}
	
	public static void main(String[] args) {
		new AnyMain();
	}

}
