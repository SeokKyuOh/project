package com.ss.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyAdapter extends WindowAdapter{
	//WindowAdapter ��ü�� ���������� ���ξ���.
	//WindowTest���� �����ؾ��� WindowListener�� �޼������ �̸� ������ �ξ���. ������ ������ {}�� �ݾƼ�.
	//����Ͱ� �̹� 7���� ��� �������̵� �߱� ������ �츮�� ���������� ���� �ʴ� �����̴�. (����Ͱ� ��� ���� 7�� �¾���)
	//�� �߿��� ���ϴ� �޼��带 �� �������̵� ����.
	public void windowClosing(WindowEvent e) {
		System.exit(0);
		//System.out.println("push");		//windowListener ���� ����� �����쿡�� ���ѵȴ�. ���� �޼��嵵 windowClosing�̾ �������� ȣ��
	}
}
