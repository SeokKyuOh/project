/*
 	��� ������ �� �г� �ȿ��� �׷��� �����̴�.
 	�ƹ��� ������ ����� �پ��ϴ���, �г��� ���� 1���� ���ȴ�.
 	
 	��� ������Ʈ�� �ᱹ �� �гο� �׷����� �ϹǷ�, 
 	�� �г��� paint�޼����� �μ��� ���޵Ǵ� graphics ��ü�� ���ӿ� ������ ��� ������Ʈ�� ���޹޾ƾ��Ѵ�.(����) 
 	�׸� �� �ִ� ���� ��ο��� �����ִ� ����?
 	
 	�����г��� ������ �׷��Ƚ��� ��� �繰�� ���� �����ؾ��Ѵ�. �����̴� ���� �ϳ��ϱ�
	������ �ϳ��� �־� ���� ����� �ٽñ׷��� �����̱⸸ �ϴ� ���� ����
	��� �ֵ��� tick�� render�� �������Ѵ�.
	�ű⿡ x,y,width,height�� ���� ���ԵǴϱ� �ߺ��Ǵ� �ڵ���� ���� ������ ����̰� �� ��Ǫ���� ���� Ȱ������.
 */
package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{		
	//������ �����尡 �ȴ�! ���� �̹� �������� �ڽ��� �� ���. ������ Runnable�� ������� �ƴϴ� run�������� ����
	
	public static final int WIDTH = 400;		//�������̰� ���������� �����Ѵ�. ����� ũ��ϱ� int
	public static final int HEIGHT = 300;
	public static final int SCALE = 2;			//���������� �����ϱ� ����. ������ �����ϸ鼭 ũ�⸸ Ű�� �� �ְ� ����. ������ ���� �����ϰ� �� ��� ������ ������ �ȴ�.
	boolean flag = true;								//���� ���� ���θ� �����ϴ� ����
	Thread thread;										//���� � ������
	Player player;
	ObjectManager objectManager;				//��ü ��� ������
	
	public GamePanel() {
		thread = new Thread(this);		//run�� ������ �ִ� Ÿ���̶� this
		thread.start();	
		
		init();
		
		//ũ�� ����
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));		//���� ����� ���� �Է����� �ʴ´�.
		
	}
	
	public void init(){
		//��ܰ����� ����
		objectManager = new ObjectManager();
		
		//���ΰ� ���� ��Ű��
		player = new Player(objectManager, ObjectId.Player, 100, 200, 50, 50);
		objectManager.addObject(player);		//1���߰�
		
		//�гΰ� Ű���� ������ ����
		this.addKeyListener(new Keyboard(player));	//�׳� �̷��� ������� ��Ŀ���� �г��� �ƴ� �����쿡 �� �ֱ� ������ Ű �����ʰ� ���� �ʴ´�.
		
		//��������
		Random r = new Random();		//������ �޼���
		
		for(int i=0;i<10;i++){
			int y = r.nextInt((HEIGHT*SCALE-50)-(50)+1)+50;		//max ���� height*scale�� �Ѵ�. min ���� 50����
			int x = r.nextInt((WIDTH*SCALE+500)-(WIDTH*SCALE)+1)+WIDTH*SCALE;
			Enemy enemy = new Enemy(objectManager, ObjectId.Enemey, x, y, 30, 30);
			objectManager.addObject(enemy);
		}
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
		
		//�������� - player.render(g);			//g�� �ִ� �̰����� render�� ȣ������
		//������ �Ʒ�
		for(int i=0;i<objectManager.list.size();i++){		//������Ʈ �Ŵ����� �ִ� ����Ʈ�� ����ִ� �ֵ� ��ŭ
			GameObject obj = objectManager.list.get(i);
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
			//������Ʈ �Ŵ����� ��ϵ� ��~~~�� ��ü�� ������� tick()�� ȣ������
			for(int i=0;i<objectManager.list.size();i++){		//������Ʈ �Ŵ����� �ִ� ����Ʈ�� ����ִ� �ֵ� ��ŭ
				GameObject obj = objectManager.list.get(i);
				obj.tick();
			}
			
			//player.tick();
			//player.render(g);			//���⼭ render�� g�� ���� ������ �Ұ���
			repaint();						//paintComponet�� ���� ȣ���Ѵ�.
			
			
		}
	}
	
}
