/*
 	단어를 표현할 클래스. 거푸집
 	게임에 등장할 대상 단어가 각각 y축의 값을 따로 갖고, 대량으로 만들어져야 하기 때문에 
 	결국 재사용성을 위한 코드집합인 클래스로 가자
 	
 	자바에서 게임이란. 데이타의 변화와 다시 그리기의 집합이다.
 */
package game.word;

import java.awt.Graphics;

public class Word {
	String name;		//이 객체가 담게될 단어
	int x;
	int y;
	//int interval;	//이를 여러개 단어에 각각 주게 되면 서로가 배경을 지우고 다시 그리기 때문에 깜빡거리기만 한다. 비동기화의 대표적인 예
						//이 때문에 게임을 만들땐 쓰레드를 한개만 두는 것이 좋다.
	int velX;
	int velY;	//단어가 움직일 속도
	
	//이 단어가 태어날 때 갖추어야할 초기값
	public Word(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	//이 객체에 반영될 데이터 변화코드
	public void tick(){
		y+=5;
	}
	
	//그 반영된 데이터를 이용하여 화면에 그리기
	public void render(Graphics g){
		g.drawString(name, x, y);
	}
}
