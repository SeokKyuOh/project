package com.ss.gui;

import javax.swing.JButton;

public class ArrayTest {
	// var arr = new Array();			�ڹٽ�ũ��Ʈ ��Ÿ��
	//�ڹٸ� ������ ��κ��� ���� ���α׷������� �迭 �����, �ݵ�� �� ũ�⸦ ����ؾ��Ѵ�.
		
	public static void main(String[] args) {
		JButton[] arr = new JButton[3];
		//Dog[] arr = new Dog[3];
		//int[] arr = new int[3];
		
		arr[0] = new JButton("��ư 1");
		arr[1] = new JButton("��ư 2");
		arr[2] = new JButton("��ư 3");
		
		for(int i=3;i<arr.length;i++){
				System.out.print(arr[i].getText());  			//(arr[i].getLabel()) ���� ���� �����µ� �ݹ� ������ٴ� ���� ǥ�� 
			
		}
	}
	
}
