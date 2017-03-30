/*
 	모든 게임은 이 패널 안에서 그려질 예정이다.
 	아무리 게임의 장면이 다양하더라도, 패널은 오직 1개만 사용된다.
 	
 	모든 오브젝트는 결국 이 패널에 그려져야 하므로, 
 	이 패널의 paint메서드의 인수로 전달되는 graphics 객체를 게임에 등장할 모든 오브젝트가 전달받아야한다.(공유) 
 	그릴 수 있는 펜을 모두에게 빌려주는 느낌?
 	
 	게임패널이 보유한 그래픽스가 모든 사물에 들어가서 공유해야한다. 움직이는 곳은 하나니까
	심장은 하나만 둬야 서로 지우고 다시그려서 깜빡이기만 하는 것을 방지
	모든 애들은 tick과 render를 가져야한다.
	거기에 x,y,width,height를 각각 갖게되니까 중복되는 코드들이 많기 때문에 어버이가 될 거푸집을 만들어서 활용하자.
 */
package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{		
	//ㄴ내가 쓰레드가 된다! 내가 이미 누군가의 자식일 때 사용. 하지만 Runnable은 쓰레드는 아니다 run만가지고 있음
	
	public static final int WIDTH = 400;		//고정적이고 끝날때까지 공유한다. 모니터 크기니까 int
	public static final int HEIGHT = 300;
	public static final int SCALE = 2;			//유지보수를 쉽게하기 위해. 비율은 유지하면서 크기만 키울 수 있게 만듬. 유저가 직접 선택하게 할 경우 변수로 넣으면 된다.
	boolean flag = true;								//게임 가동 여부를 결정하는 변수
	Thread thread;										//게임 운영 쓰레드
	Player player;
	ObjectManager objectManager;				//객체 명단 관리자
	
	public GamePanel() {
		thread = new Thread(this);		//run을 가지고 있는 타겟이라 this
		thread.start();	
		
		init();
		
		//크기 지정
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));		//보통 사이즈를 직접 입력하진 않는다.
		
	}
	
	public void init(){
		//명단관리자 생성
		objectManager = new ObjectManager();
		
		//주인공 등장 시키기
		player = new Player(objectManager, ObjectId.Player, 100, 200, 50, 50);
		objectManager.addObject(player);		//1명추가
		
		//패널과 키보드 리스너 연결
		this.addKeyListener(new Keyboard(player));	//그냥 이렇게 했을경우 포커스는 패널이 아닌 윈도우에 가 있기 때문에 키 리스너가 먹지 않는다.
		
		//적군등장
		Random r = new Random();		//랜덤값 메서드
		
		for(int i=0;i<10;i++){
			int y = r.nextInt((HEIGHT*SCALE-50)-(50)+1)+50;		//max 값을 height*scale로 한다. min 값은 50으로
			int x = r.nextInt((WIDTH*SCALE+500)-(WIDTH*SCALE)+1)+WIDTH*SCALE;
			Enemy enemy = new Enemy(objectManager, ObjectId.Enemey, x, y, 30, 30);
			objectManager.addObject(enemy);
		}
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
		
		//오리지날 - player.render(g);			//g가 있는 이곳에서 render를 호출하자
		//개선안 아래
		for(int i=0;i<objectManager.list.size();i++){		//오브젝트 매니저에 있는 리스트에 들어있는 애들 만큼
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
			//오브젝트 매니져에 등록된 모~~~든 객체를 대상으로 tick()을 호출하자
			for(int i=0;i<objectManager.list.size();i++){		//오브젝트 매니저에 있는 리스트에 들어있는 애들 만큼
				GameObject obj = objectManager.list.get(i);
				obj.tick();
			}
			
			//player.tick();
			//player.render(g);			//여기서 render는 g가 없기 때문에 불가능
			repaint();						//paintComponet를 간접 호출한다.
			
			
		}
	}
	
}
