/*
 	그림 그려질 목적으로 지원되는 객체인 Canvas에 그림을 그려보자

 	왜 캔버스에 그릴까?
 	캔버스는 컨테이너처럼 아무것도 없기 때문.
 	비어있다. 빈 도화지를 표현한 객체이므로..
 */
package graphic;

import java.awt.Canvas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CanvasTest extends JFrame{
	Canvas can;	//텅 빈 도화지!
	Toolkit kit;	//javaSE에서 이미지를 얻으려면 툴킷 객체를 이용해야 한다.
						//toolkit은 추상클래스 이지만 자기 자신을 올릴 수 있는 매서드가 스스로에게 존재한다.
	Image img;	//추상클래스여서 new 못함. 그래서 kit으로부터 얻어와야함
	
	public CanvasTest() {
		kit = Toolkit.getDefaultToolkit();	//인스턴스 얻기
		img = kit.getImage("C:/html_workspace/images/pika.jpg");		// 경로설정시 \사용하면 앞에 \를 또 넣어줘야 인식을 한다. 귀찮으니 /로 대체하자. 윈도우만 \그냥 사용
		can = new Canvas(){		//이름없는 클래스, 캔버스를 여기에 직접 오버라이드 한다. 내부 익명 클래스임.
			//paint 메서드는 사실상 행위에 불과하며 어떤 그림을 그릴지를 결정하는 객체는 Graphics 객체이다.
			public void paint(Graphics g){
				g.drawLine(0, 0, 300, 400);
				g.drawOval(50, 50, 60, 60);
				g.drawImage(img, 100, 100, 200, 200, this);		//여기서 observer는 캔버스로 주면된다. img는 추상클래스이기 때문에 new 안되고 toolkit이 필요하다.
																					//여기서의 this는 {}안이므로 canvas를 지칭한다.
			}
		};
		
		can.setBackground(Color.YELLOW);
		add(can);
		
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new CanvasTest();
	

	}

}