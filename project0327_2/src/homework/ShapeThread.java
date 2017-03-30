/*
 	원이던 사각형이던 어떤 도형을 표현한 객체이건, 이 클래스의 자식으로 두자
 	왜?? 공통적 특징이 있으므로.
 */
package homework;

import java.awt.Color;
import java.awt.Graphics;

abstract public class ShapeThread extends Thread {
	int x;
	int y;
	int width;
	int height;
	int interval;
	Graphics g;
	
	public ShapeThread(int x, int y, int width, int height, int interval, Graphics g){
		this.x=x;
		this.y=y;
		this.width = width;
		this.height = height;
		this.interval = interval;
		this.g = g;
		
		start();		//자바스크립트의 move처럼 태어나자마자 움직이겠다.
	}
	
	abstract public void render(); 	//자식은 이부분만 오버라이드 하여 사용한다.
			

	public void run() {
		while (true) {
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			render();
		}

	}
}
