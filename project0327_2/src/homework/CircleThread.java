//���� ǥ���� ��ü �� �� ������
package homework;

import java.awt.Color;
import java.awt.Graphics;

public class CircleThread extends ShapeThread{

	public CircleThread(int x, int y, int width, int height, int interval, Graphics g) {		//�ʱ�ȭ �ϸ鼭 ���� �Ѱܹ���
		super(x, y, width, height, interval, g);
	}
	
	public void render(){
		//System.out.println("g��"+g);
		//�����
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, 700, 600);	//�׸� �׸��� ����Ʈ�� �ξ� ���������.
		
		//�׸���
		x+=5;
		g.setColor(Color.BLACK);
		g.drawOval(x, y, width, height);
		
	}
	
}
