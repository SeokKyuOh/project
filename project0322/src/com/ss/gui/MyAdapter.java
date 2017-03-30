package com.ss.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyAdapter extends WindowAdapter{
	//WindowAdapter 자체는 구현강제가 따로없다.
	//WindowTest에서 구현해야할 WindowListener의 메서드들을 미리 구현해 두었다. 내용은 없지만 {}로 닫아서.
	//어댑터가 이미 7개를 모두 오버라이드 했기 때문에 우리가 구현강제를 받지 않는 상태이다. (어댑터가 대신 가시 7개 맞아줌)
	//이 중에서 원하는 메서드를 또 오버라이드 하자.
	public void windowClosing(WindowEvent e) {
		System.exit(0);
		//System.out.println("push");		//windowListener 여서 기능이 윈도우에만 국한된다. 현재 메서드도 windowClosing이어서 닫을때만 호출
	}
}
