/*
 	플레이어의 움직임을 제어하자
 */
package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyboard extends KeyAdapter{
	Player player;		//플레이어를 넘겨 받기 위해 선언하자
	
	public Keyboard(Player player) {
		this.player = player;
	}

	//키보드 누르면
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch(key){		//소괄호 안에 값에 대해 조건을 따져보겠다
			case KeyEvent.VK_LEFT:
				player.velX=-2;break;
			case KeyEvent.VK_RIGHT:
				player.velX=2;break;
			case KeyEvent.VK_UP:
				player.velY=-2;break;
			case KeyEvent.VK_DOWN:
				player.velY=2;break;
			case KeyEvent.VK_SPACE:
				//총알 생성
				player.fire();break;
		}
	}
	
	//키보드 떼면
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch(key){	
		case KeyEvent.VK_LEFT:
			player.velX=0;break;
		case KeyEvent.VK_RIGHT:
			player.velX=0;break;
		case KeyEvent.VK_UP:
			player.velY=0;break;
		case KeyEvent.VK_DOWN:
			player.velY=0;break;
		}
	}
	
	
}
