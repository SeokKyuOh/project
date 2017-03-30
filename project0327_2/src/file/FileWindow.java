/*
  	Ŭ������ �ڵ��� ���뼺 ������ ź���� ����̴�.
  	�ڹٿ����� Ŭ�����н��� Ŭ���� �Ӹ��� �ƴ϶� �̹����� ��ϰ����ϴ�
 */
package file;

import java.awt.FlowLayout;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;

public class FileWindow extends JFrame{
	MyIcon folder_on, folder_off;
	
	
	public FileWindow() {
		setLayout(new FlowLayout());
		
		//�̹��� �������� �����ϵ�, ���ҽ� ������ ����
		//Uniformed Resouce Locater : ���յ� �ڿ��� ��ġ
		folder_on =  new MyIcon(this.getClass().getResource("/folder_open.png"),50,50);// res������ build path�� ����س��� ������ �ٷ� �̸� ���� �ȴ�.
		folder_off =  new MyIcon(this.getClass().getResource("/folder_close.png"),50,50);// res������ build path�� ����س��� ������ �ٷ� �̸� ���� �ȴ�.
		
		/* �̺κ��� ���뼺�� ���̱� ���� MyIcon Ŭ������ ���� �����
		//���������� ���� �̹����� ������.
		Image scaledImg = folder_on.getImage();
		//ũ�⸦ �� ������ �� ��������� �̹��� ��ü�� �ٽ� ��ȯ
		Image result = scaledImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		//������ �̹����� �ٽ� ����
		folder_on.setImage(result);
		*/
		
		//����� ������ �׽�Ʈ
		ArrayList<String> list = getDirlist();
		for(int i=0;i<list.size();i++){
			String dirName = list.get(i);
			MyPanel mp = new MyPanel(dirName, folder_off);
			add (mp);
		}
		setSize(600, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	//��ư �̹��� ��ȯ for������ ����
	//if������ Ŭ���� ���� open�̹����ϰ�, else�� ������ close�̹���
	
	
	
	
	//���ϴ� ����� ���� ���丮/���� ���ϱ�
	public ArrayList getDirlist(){
		File file = new File("C:/");
		
		File[] fileList = file.listFiles();
		ArrayList<String> dirList = new ArrayList<String>();
		
		//���丮�� �����
		for(int i=0;i<fileList.length;i++){
			if(fileList[i].isDirectory()){
				//���丮�� �߰ߵ� ������ ����Ʈ �߰�
				dirList.add(fileList[i].getName());	
			}
		}
		return dirList;
		
	}
	
	public static void main(String[] args) {
		new FileWindow();
	}

}
