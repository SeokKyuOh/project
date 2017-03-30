/*
	�� ���� ó���� ����
	- ������ ������ ����(��, �������� �ý��� ��� ����)

	�Ϲ������� ���α׷��� ���� ����� �� ���� ��Ȳ�� ������ "����"�� �Ѵ�.
	SUN������ ������ ���� ���� �з��ߴ�... Ŭ������ ����
	1. ���α׷��Ӱ� ��ó�� �� ���� �Ұ��׷��� ����
		Error (cpu�ļ�, ��Ʈ��ũ�� ���� �� �ܺ��� ����)

	2. ���α׷��Ӱ� ��ó�� �� �ִ� ����(�̸� '����'��� �Ѵ�.)
		�ڹ��� ���ɻ����� �ٷ� "����"�̴�.
		SUN������ �� ���ܸ� ��Ȳ�� ���� ü������ Ŭ������ �����ϰ� �ִ�.

		�� ���� ��ü���� �ٽ� ũ�� 2���� �������� �з��Ѵ�.
		(1) ������ Ÿ�ӿ� ����ó���� �����ϴ� ���
			 checked Exception(��. FileNotFoundException)

		(2) ������ Ÿ�ӿ� ����ó���� �������� �ʴ� ���
			 Unchecked Exception = Runtime Exception
			 --> �̰� ������ �ð��� �������.
*/

package copy;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


class FileCopy2{
	FileInputStream fis;		//������ ������� �� �Է½�Ʈ��
	FileOutputStream fos;	//������ ������� �� ��½�Ʈ��
	
	public FileCopy2(){
		//�Ʒ��� �ڵ�� ���� ������ �߻��� �� �ִ� ���ɼ��� �ٺ��� �ڵ��̴�. 
		//�׷��� �����ڰ� ������ �� �ۼ��������� �ڹٴ� Ư���� ������ġ�� �����ϱ� ���Ѵ�.
		//������ġ�� �����ϱ⸦ �䱸�Ѵ�. (try, catch)
		//�̺κп� ���� ������ Ȯ���ϱ� ���� ���� �����÷����� ���� ��
		//�̰Ϳ� ���� ���� �ʹ� ���� ����. 
		//try, catch���� �ڹٰ� ����� �Ҷ��� ���� �ȴ�.(�������� ����)
		try{
			//���Ͽ� ���� ħ�� �ȵ��� �ȴ� �ڵ�
			fis = new FileInputStream("C:/java_orkspace2/project0323/src/res/pika.jpg");
			fos = new FileOutputStream("C:/java_workspace2/project0323/src/data/pika_copy.jpg");
			//�ƿ�ǲ�Ҷ��� �������� ������ش�.

			//System.out.println("���Ͽ� ��Ʈ�� �����߾��~!");
			/*
			int data;
			data=fis.read();	//1byte�� �о����
			System.out.println(data);//
			
			data=fis.read();	//1byte�� �� �о����
			System.out.println(data);
			*/
			int data;
			while(true){
				data=fis.read();	//1byte�� �о����
				fos.write(data);	//1byte ����.
				if(data==-1)break;
				System.out.println(data);
			}

			/*��Ʈ���� ����� �Ŀ� �ݵ�� �����ؾ��Ѵ�.
			�������� ������ ���밡 ���ŵ��� �ʾ� ������� �ʴ� ���밡 ��� �����ȴ�.
			���߿� �̷��� ���� ���밡 �޸𸮸� ũ�� ��ƸԴ� ������ �Ǳ⵵ �Ѵ�.*/

		}catch(FileNotFoundException e){
			//������ �߻��ϸ� ����ΰ� �� �������� ���Եȴ�.
			//catch���� �����ϰԵǸ� ���α׷��� ���������ᰡ �����ʰ� ���� �����ϰԵȴ�.
			//������ �뵵�� �ƴ� �����ڰ� ������ Ȯ���ϰ�, ����ڿ��Դ� �ȳ��ϴ� �뵵�̴�.
			System.out.println("������ ã�� �� �����ϴ�.");//������ �̷���� �����ڿ��� ���Ͽ����� �ۼ�. ����ó������.
		}catch(IOException e){	//read�� �����ϴ� catch��
			System.out.println("������ ���� �� �����ϴ�.");
		}finally{
			//��� ������ ������ ����	����������, �����ص� ���´�.
			//finally�� �����ϸ� try���� �����ϴ�, catch���� �����ϴ� ����ΰ� ������ �� ������ ��ġ�� �Ǿ��ִ�.
			//�׷��� ������ ���������� �ڵ�� finally���� ����Ǿ���Ѵ�.
			//�������� IOException�ؾ��Ѵ�..
		
			//finally �ڵ��� ������
			/*�ַ� database������ ��Ʈ�� ���� �������θ� ������ ������ �ڿ��� �ݰų� �������Ϸ��� 
				try���̴� catch���� �����ϴ� ������ ���ľ� �ϴ� ������ �α� �����̴�.*/
			try{
				fis.close();		//��ǲ��Ʈ�� ��������	
				fos.close();	//�ƿ�ǲ��Ʈ�� ��������
			}catch(IOException e){

			}
		}
		
		/*
		try{
			if(fis!=null){fis.close();};		//��ǲ��Ʈ�� ��������	
			if(fos!=null){fos.close();};	//�ƿ�ǲ��Ʈ�� ��������
				/*null�� �ƴҶ��� �����ض�
					if�� ���� ������ ó�� �������� ������ ����� �������� �ȵǾ��� ������ close ����� ������ �� ����.
					�� ������ ���ο� ������ �߻��ϴ� �̺κ��� null�� �ƴҰ���� if������ �ۼ��Ͽ� ������ �����Ѵ�.*/
		/*
		}catch(IOException e){
		}*/
		
	}
	public static void main(String[] args){
		new FileCopy2();

	}

}
