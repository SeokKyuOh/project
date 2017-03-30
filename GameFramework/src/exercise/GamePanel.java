package exercise;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;



public class GamePanel extends JPanel implements Runnable{
	
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;
	public static final int SCALE = 2;
	boolean flag = true;
	Thread thread;
	Player player;
	ObjectManager objectManager;
	
	public GamePanel() {
		thread = new Thread(this);
		thread.start();
		
		init();
		
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
	}
	
	public void init(){
		objectManager = new ObjectManager();
		
		player = new Player(objectManager, ObjectId.Player, 100, 200, 50, 50);
		objectManager.addObject(player);
		
		this.addKeyListener(new Keyboard(player));
		
		Random r = new Random();
		
		for(int i=0; i<10; i++){
			int y = r.nextInt((HEIGHT*SCALE)-50+1)+50;
			int x = r.nextInt((WIDTH*SCALE+500)-(WIDTH*SCALE)+1)+WIDTH*SCALE;
			Enemy enemy = new Enemy(objectManager, ObjectId.Enemey, x, y, 30, 30);
			objectManager.addObject(enemy);
		}
	}
	
	public void painComponent(Graphics g){
		g.setColor(Color.BLACK);
		g.fill3DRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
		
		for(int i=0;i<objectManager.list.size();i++){
			GamgeObject obj = objectManager.list.get(i);
			obj.render(g);
		}
	}
	
	public void run(){
		while(true){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(int i=0; i<objectManager.list.size();i++){
				GameObject obj = objectManager.list.get(i);
				obj.tick();
			}
			repaint();
		}
	}
}
