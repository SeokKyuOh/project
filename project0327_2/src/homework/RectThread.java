package homework;

import java.awt.Color;
import java.awt.Graphics;

public class RectThread extends ShapeThread{

	public RectThread(int x, int y, int width, int height, int interval, Graphics g) {
		super(x, y, width, height, interval, g);
	}
	
	public void render(){
		//화면 지우기
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 700, 600);
		
		//그리자
		x+=5;
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
	}
}
