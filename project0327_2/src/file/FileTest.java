/*
  	�ڹٿ����� ���丮�� �����ϱ� ���� Ŭ������ ������ �������� �ʰ�, ���丮�� ���Ϸ� ����
  	��� : java.io.File Ŭ������ ���� + ���丮���� ó���Ѵ�.
 */

package file;

import java.io.File;

public class FileTest {

	public FileTest() {
		//C����̺��� ������ �����ϴ� ��� ���丮 �� ������ ����غ���
		File file = new File("C:/");
		
		//���� ���丮 �� ������ ��� ����
		//String[] dir = file.list();
		File[] dir = file.listFiles();	//��Ʈ���迭�� �ƴ� �� ���� ������ ���� �迭�� �ޱ�
		
		for(int i=0;i<dir.length;i++){
			if(dir[i].isDirectory()){		//���丮�� ������ �ϱ�
				System.out.println(dir[i].getName());		//ã�� ���丮 �迭�� �̸��� ������ �ϱ�
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		new FileTest();
		

	}

}
