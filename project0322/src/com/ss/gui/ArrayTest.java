package com.ss.gui;

import javax.swing.JButton;

public class ArrayTest {
	// var arr = new Array();			자바스크립트 스타일
	//자바를 포함한 대부분의 응용 프로그램에서는 배열 선언시, 반드시 그 크기를 명시해야한다.
		
	public static void main(String[] args) {
		JButton[] arr = new JButton[3];
		//Dog[] arr = new Dog[3];
		//int[] arr = new int[3];
		
		arr[0] = new JButton("버튼 1");
		arr[1] = new JButton("버튼 2");
		arr[2] = new JButton("버튼 3");
		
		for(int i=3;i<arr.length;i++){
				System.out.print(arr[i].getText());  			//(arr[i].getLabel()) 쓰면 줄이 나오는데 금방 사라진다는 예고 표시 
			
		}
	}
	
}
