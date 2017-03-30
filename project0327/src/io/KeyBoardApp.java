/*
	FileInpitStream ���� �����ڰ� ���ϴ� ������ ��Ʈ���� ������ �� ������,
	Ű����� ���� ǥ�� �Է� �ϵ������ ��쿣 �ڹٰ� ��Ʈ���� �������� ���ϰ�
	�ش� OS�� �����ϹǷ�, �ڹ� �����ڴ� OS�� ���� ǥ���Է� ��Ʈ���� ���;��Ѵ�.
	
	�ڹ��� Ŭ���� �� System Ŭ������ static ������� �� �� has a ����� ������ 
	InputStream�� in ��ü�� �ٷ� ǥ���Է� ��Ʈ���� �޾Ƴ��� Ŭ�����̴�.
	���� ���ÿ� �׳� System.in; �ϸ� �ȴ�.

	���ڱ�� ��Ʈ�� Ŭ������ �̸� ��Ģ
	�Է� : ~~Reader
	��� : ~~Writer
	���� �ΰ����� �ٴ� �͵��� ���ڰ� �ȱ�����. ������ ����

*/
package io;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;


class KeyBoardApp{

	public static void main(String[] args){
		InputStream is = System.in;

		//���ڱ�ٳ� ��Ʈ���� �ܵ����� �����ϴ� ���� �ƴ϶�,
		//�̹� ����Ʈ ��� ��Ʈ���� ������ �Ѵ�.
		//���� ������ �������� �μ��� ����Ʈ ��� ��Ʈ���� �ִ´�.
		InputStreamReader reader=null;
		reader = new InputStreamReader(is);		//���׷��̵� �� ���뿡 ���븦 �ִ´�.
		

		int data;
		try{
			while(true){
				/*
				data=is.read(); //1byte �о����. �׷��� ���� a ����ġ�� a�� ������ ���Ϳ� ���Ե� \n�� \R�� �ȳ��´�.
				//System.out.print(data);		//System�� �����ϴ� out ��ü��..
				System.out.print((char)data);	
				//�� ���ڷ� �ٲ���.. �ٸ� ���Ϳ� ���Ե� \n�� \r�� ��ɸ� ����ϱ� ������ ���ڷδ� ��µ��� �ʴ´�.
				*/

				data=reader.read(); //2byte �о����
				System.out.print((char)data);	

			}
		}catch(IOException e){

		}

	}

}
