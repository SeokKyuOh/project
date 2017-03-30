package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Bullet extends GameObject{
							/* is a 관계	*/
	public Bullet(ObjectManager objectManager, ObjectId id, int x, int y, int width, int height) {
		super(objectManager, id, x, y, width, height);		//굳이 나열할 필요 없이 부모에게서 받아오자
		velX=4;		//주인공이 2씩 움직이니까 좀 더 빠르게 만들자
		
	}
	public void tick(){
		x+=velX;
		rect.setBounds(x,y,width,height);
		
		//적군과 내가 교차하면, 둘 다 죽기
		for(int i=0;i<objectManager.list.size();i++){
			GameObject obj=objectManager.list.get(i);
			if(obj.id == ObjectId.Enemey){
				if(obj.rect.intersects(rect)){		//충돌하면.
					//너죽고 나죽자.
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
