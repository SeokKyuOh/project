/*
 	이 클래스는 sun에서 자체 제작한 UI컴포넌트가 아니기 때문에 화면에 그려질 수 없다.
 	따라서 JPanel에 그려지려면 JPanel의 Graphics의 레퍼런스를 이 객체가 보유해야 한다.
 */

package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Player extends GameObject{
							/*	is a 관계*/
	public Player(ObjectManager objectManager, ObjectId id, int x, int y, int width, int height) {		//만드는 사람이 결정하게 하자 velX, velY는 키보드에 의해서 결정되기 때문에 미리 안줘도 된다
		super(objectManager, id, x, y, width, height);	//굳이 나열할 필요 없이 부모에게서 받아오자
		/* this.x=x;		이처럼 굳이 나열 x
		    this.y=y; */
	}
	
	//총알발사 행위를 정의한다.
	public void fire(){
		Bullet bullet = new Bullet(objectManager, ObjectId.Bullet, x, y, 10, 10);			//여기서 objectManager는 GameObject의 매니저다
		objectManager.addObject(bullet);
		
	}
	
	//x,y,width,height 등의 물리량 변화를 제어하기 위한 메서드 (사람으로 따지면 운동량변화?) 
	public void tick(){
		//System.out.println("tick()");
		x+=velX;
		y+=velY;
		//사각형이 나를 따라다니게 값의 동기화
		rect.setBounds(x, y, width, height);
		
	}
	
	//변화될 값을 화면에 보여지게 할 메서드
	public void render(Graphics g){		//보여지게 하려면 그래픽을 얻어와야하니까..
		//System.out.println("render()");
		g.setColor(Color.WHITE); //페인트 색 바꾸기. 배경색이랑 같으면 안보이니까
		//g.drawRect(x, y, 50, 50);
		Graphics2D g2 = (Graphics2D)g;		//업그레이드 된 그래픽스
		g2.draw(rect);
		
	}
}
