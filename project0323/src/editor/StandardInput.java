/*
	1. ��Ʈ���� ���⼺�� ���� �з�
		-�Է�, ���
		
	2. ��Ʈ���� ������ ó������� ���� �з�
		(1) ����Ʈ ��� ��Ʈ��
			(����½� 1byte�� ó��)
		(2) ���ڱ�� ��Ʈ��
			(����½� 2byte�� ��� ������ �� �ִ� ��Ʈ��)
			����! 2byte�� �аų�, ���°� �ƴϴ�. 
			       ������ 1byte�� ������ ���������� �ϼ��� ������� �� �� �ְ� ������.
			�� ���ڱ�ݽ�Ʈ���� ����Ģ
			�Է½�Ʈ�� - ~~~Reader�� ����
			��½�Ʈ�� - ~~~Writer�� ����
		(3) ���� ��Ʈ��
*/
package editor;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StandardInput {

	public static void main(String[] args) {
		//��Ʈ�� ���
		InputStream is = System.in;
		InputStreamReader reader=null;		//InputStreamReader�� ���� InputStream�� ���ʰ� �Ǿ���Ѵ�.
		reader = new InputStreamReader(is);	//�������� ���׷��̵� ���� �����̱�.
		
		int data;
		try {
			//while(true){		//while���� ���� ��� �ѱ��ڸ� �ԷµǴµ�, �̴� read()�޼��尡 �ѱ��ڸ� �о���̱� �����̴�.
				data = reader.read();	//1byte			���� ������ is��� ���� ������ reader�� ����Ѵ�. 
				//System.in;		//ǥ���Է�
				//System.out;	//ǥ�� ���   �ؼ�) �ý����̶�� Ŭ������ �ƿ� �������ִ� �ڷ����̴�. ���⼭ ������ ������ �� �𸥴�.
				//System.out.println();  �ؼ�) �ƿ��̶�� ������ �ڿ� �޼��尡 ����? �׷���?? �޼��尡 �ִ� 00 �� 
				
				System.out.print((char)data);		
				//��char�� �����ϸ� ���Ϳ� ����ִ� \n(�ٹٲ�)�� \r(�Ǿ����ΰ���)�� ���������� ��ȯ���� �ʱ� ������ ���x
				//�ѱ��� 2����Ʈ �̱� ������ �̶� �ٷ� �Է��ϸ� ������.
			//}
		} catch (IOException e) {
			e.printStackTrace();
		}	
		

	}

}
