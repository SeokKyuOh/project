package exercise;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import game.ObjectId;

public class Player extends GameObject{

	public Player(ObjectManager objectManager, ObjectId id, int x, int y, int width, int height) {
		super(objectManager, id, x, y, width, height);
	
	}
	
	public void fire(){
		Bullet bullet = new Bullet(objectManager, ObjectId.Bullet, x, y, 10, 10);
		objectManager.addObject(bullet);
	}
	
	public void tick(){
		x+=velX;
		y+=velY;
		rect.setBounds(x, y, width, height);
	}
	
	public void render(Graphics g){
		g.setColor(Color.WHITE);
		Graphics2D g2 = (Graphics2D)g;
		g2.draw(rect);
		
	}
}
