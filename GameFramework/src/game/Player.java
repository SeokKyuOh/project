/*
 	�� Ŭ������ sun���� ��ü ������ UI������Ʈ�� �ƴϱ� ������ ȭ�鿡 �׷��� �� ����.
 	���� JPanel�� �׷������� JPanel�� Graphics�� ���۷����� �� ��ü�� �����ؾ� �Ѵ�.
 */

package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Player extends GameObject{
							/*	is a ����*/
	public Player(ObjectManager objectManager, ObjectId id, int x, int y, int width, int height) {		//����� ����� �����ϰ� ���� velX, velY�� Ű���忡 ���ؼ� �����Ǳ� ������ �̸� ���൵ �ȴ�
		super(objectManager, id, x, y, width, height);	//���� ������ �ʿ� ���� �θ𿡰Լ� �޾ƿ���
		/* this.x=x;		��ó�� ���� ���� x
		    this.y=y; */
	}
	
	//�Ѿ˹߻� ������ �����Ѵ�.
	public void fire(){
		Bullet bullet = new Bullet(objectManager, ObjectId.Bullet, x, y, 10, 10);			//���⼭ objectManager�� GameObject�� �Ŵ�����
		objectManager.addObject(bullet);
		
	}
	
	//x,y,width,height ���� ������ ��ȭ�� �����ϱ� ���� �޼��� (������� ������ �����ȭ?) 
	public void tick(){
		//System.out.println("tick()");
		x+=velX;
		y+=velY;
		//�簢���� ���� ����ٴϰ� ���� ����ȭ
		rect.setBounds(x, y, width, height);
		
	}
	
	//��ȭ�� ���� ȭ�鿡 �������� �� �޼���
	public void render(Graphics g){		//�������� �Ϸ��� �׷����� ���;��ϴϱ�..
		//System.out.println("render()");
		g.setColor(Color.WHITE); //����Ʈ �� �ٲٱ�. �����̶� ������ �Ⱥ��̴ϱ�
		//g.drawRect(x, y, 50, 50);
		Graphics2D g2 = (Graphics2D)g;		//���׷��̵� �� �׷��Ƚ�
		g2.draw(rect);
		
	}
}
