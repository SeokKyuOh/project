/*
 	�׸� �׷��� �������� �����Ǵ� ��ü�� Canvas�� �׸��� �׷�����

 	�� ĵ������ �׸���?
 	ĵ������ �����̳�ó�� �ƹ��͵� ���� ����.
 	����ִ�. �� ��ȭ���� ǥ���� ��ü�̹Ƿ�..
 */
package graphic;

import java.awt.Canvas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CanvasTest extends JFrame{
	Canvas can;	//�� �� ��ȭ��!
	Toolkit kit;	//javaSE���� �̹����� �������� ��Ŷ ��ü�� �̿��ؾ� �Ѵ�.
						//toolkit�� �߻�Ŭ���� ������ �ڱ� �ڽ��� �ø� �� �ִ� �ż��尡 �����ο��� �����Ѵ�.
	Image img;	//�߻�Ŭ�������� new ����. �׷��� kit���κ��� ���;���
	
	public CanvasTest() {
		kit = Toolkit.getDefaultToolkit();	//�ν��Ͻ� ���
		img = kit.getImage("C:/html_workspace/images/pika.jpg");		// ��μ����� \����ϸ� �տ� \�� �� �־���� �ν��� �Ѵ�. �������� /�� ��ü����. �����츸 \�׳� ���
		can = new Canvas(){		//�̸����� Ŭ����, ĵ������ ���⿡ ���� �������̵� �Ѵ�. ���� �͸� Ŭ������.
			//paint �޼���� ��ǻ� ������ �Ұ��ϸ� � �׸��� �׸����� �����ϴ� ��ü�� Graphics ��ü�̴�.
			public void paint(Graphics g){
				g.drawLine(0, 0, 300, 400);
				g.drawOval(50, 50, 60, 60);
				g.drawImage(img, 100, 100, 200, 200, this);		//���⼭ observer�� ĵ������ �ָ�ȴ�. img�� �߻�Ŭ�����̱� ������ new �ȵǰ� toolkit�� �ʿ��ϴ�.
																					//���⼭�� this�� {}���̹Ƿ� canvas�� ��Ī�Ѵ�.
			}
		};
		
		can.setBackground(Color.YELLOW);
		add(can);
		
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new CanvasTest();
	

	}

}