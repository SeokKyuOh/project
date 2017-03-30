package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Bullet extends GameObject{
							/* is a ����	*/
	public Bullet(ObjectManager objectManager, ObjectId id, int x, int y, int width, int height) {
		super(objectManager, id, x, y, width, height);		//���� ������ �ʿ� ���� �θ𿡰Լ� �޾ƿ���
		velX=4;		//���ΰ��� 2�� �����̴ϱ� �� �� ������ ������
		
	}
	public void tick(){
		x+=velX;
		rect.setBounds(x,y,width,height);
		
		//������ ���� �����ϸ�, �� �� �ױ�
		for(int i=0;i<objectManager.list.size();i++){
			GameObject obj=objectManager.list.get(i);
			if(obj.id == ObjectId.Enemey){
				if(obj.rect.intersects(rect)){		//�浹�ϸ�.
					//���װ� ������.
					objectManager.list.remove(obj);
					objectManager.list.remove(this);
				}
			}
		}
	}
	
	public void render(Graphics g){
		g.setColor(Color.YELLOW);
		Graphics2D g2 =(Graphics2D)g;
		g2.fillOval(x, y, width, height);
		
	}
}
