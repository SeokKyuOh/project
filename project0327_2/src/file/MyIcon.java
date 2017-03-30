/*
  	������ ������ �� ũ�⸦ �����Ϸ��� �ڵ尡 �����ϹǷ�, ������ ���� ���ɼ��� �����صΰ� 
  	������ ������ �̹��� �������� ���� �����غ���.
 */
package file;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class MyIcon extends ImageIcon{
	
	public MyIcon(URL url, int width, int height) {
		//folder_on =  new ImageIcon(this.getClass().getResource("/folder_open.png"));// res������ build path�� ����س��� ������ �ٷ� �̸� ���� �ȴ�.
		//folder_off =  new ImageIcon(this.getClass().getResource("/folder_close.png"));// res������ build path�� ����س��� ������ �ٷ� �̸� ���� �ȴ�.
		super(url);	
		// ��ImageIcon ��ӹ��� ���¿��� new �ϴ� ���� �ȵǱ� ������ �θ��� super�� ���� ȣ��
		//		�θ� ���� ���� this�� �ҷ��� �� ������ ó������ url�� ������ �Է��ϴ� ������ ���� 
		
		//���������� ���� �̹����� ������.
		//Image scaledImg = folder_on.getImage();		����.
		Image scaledImg = this.getImage();		//���� ��ü�� �ڱ� �ڽ��̶� this
		
		//ũ�⸦ �� ������ �� ��������� �̹��� ��ü�� �ٽ� ��ȯ ���� ���ε� ������ ����.
		Image result = scaledImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		//������ �̹����� �ٽ� ����
		//folder_on.setImage(result);		����
		this.setImage(result);		//�ڱ� �ڽ��̴ϱ� this
	}
}
