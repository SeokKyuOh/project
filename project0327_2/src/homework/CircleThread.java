//원을 표현한 객체 및 그 움직임
package homework;

import java.awt.Color;
import java.awt.Graphics;

public class CircleThread extends ShapeThread{

	public CircleThread(int x, int y, int width, int height, int interval, Graphics g) {		//초기화 하면서 값을 넘겨받자
		super(x, y, width, height, interval, g);
	}
	
	public void render(){
		//System.out.println("g는"+g);
		//지우고
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 700, 600);	//그린 그림에 페인트를 부어 덮어버린다.
		
		//그리자
		x+=5;
		g.setColor(Color.BLACK);
		g.drawOval(x, y, width, height);
		
	}
	
}
