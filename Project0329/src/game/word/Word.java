/*
 	�ܾ ǥ���� Ŭ����. ��Ǫ��
 	���ӿ� ������ ��� �ܾ ���� y���� ���� ���� ����, �뷮���� ��������� �ϱ� ������ 
 	�ᱹ ���뼺�� ���� �ڵ������� Ŭ������ ����
 	
 	�ڹٿ��� �����̶�. ����Ÿ�� ��ȭ�� �ٽ� �׸����� �����̴�.
 */
package game.word;

import java.awt.Graphics;

public class Word {
	String name;		//�� ��ü�� ��Ե� �ܾ�
	int x;
	int y;
	//int interval;	//�̸� ������ �ܾ ���� �ְ� �Ǹ� ���ΰ� ����� ����� �ٽ� �׸��� ������ �����Ÿ��⸸ �Ѵ�. �񵿱�ȭ�� ��ǥ���� ��
						//�� ������ ������ ���鶩 �����带 �Ѱ��� �δ� ���� ����.
	int velX;
	int velY;	//�ܾ ������ �ӵ�
	
	//�� �ܾ �¾ �� ���߾���� �ʱⰪ
	public Word(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	//�� ��ü�� �ݿ��� ������ ��ȭ�ڵ�
	public void tick(){
		y+=5;
	}
	
	//�� �ݿ��� �����͸� �̿��Ͽ� ȭ�鿡 �׸���
	public void render(Graphics g){
		g.drawString(name, x, y);
	}
}
