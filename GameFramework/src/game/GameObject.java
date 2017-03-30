/*
	게임에 등장할 모든 객체의 최상위 클래스를 정의한다
 	왜??
 	상속을 이용하면 코드 중복을 방지할 수 있고, 최상위 클래스 자료형으로 자식들을 가리킬 수 있으므로
 	코드가 유연해진다.
*/
package game;

import java.awt.Graphics;
import java.awt.Rectangle;

abstract public class GameObject {	//아래에 추상메서드가 있으므로 추상클래스화
	ObjectManager objectManager;
	ObjectId id;		//모든 게임 객체에 할당될 아이디
	
	int x;
	int y;
	int width;
	int height;
	int velX;
	int velY;
	Rectangle rect;		//교차테스트에 써먹을 사각형 객체. 모두가 필요하니까 넣어주자.
	
	public GameObject(ObjectManager objectManager, ObjectId id, int x, int y, int width, int height) {
		this.objectManager=objectManager;
		this.id=id;		//어떤 종류인지 구분하기 위함.(enemy인지 bullet인지 등)
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		rect = new Rectangle(x,y,width,height);
	
	}
	
	abstract public void tick();		//자식들이 어떤것을 할지 모르기 때문에 추상 메서드화
	
	abstract public void render(Graphics g); //자식들이 어떤것을 할지 모르기 때문에 추상 메서드화
	
}
