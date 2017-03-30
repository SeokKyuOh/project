package com.ss.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener{
	MyWin myWin;
	
	public void actionPerformed(ActionEvent e) {
		//System.out.println("¹öÆ° ´­·¶´Ï");
		String msg = myWin.txt.getText();
		System.out.println(msg);
		
	}
	public void setMyWin(MyWin myWin){
		this.myWin=myWin;
	}
	
}
