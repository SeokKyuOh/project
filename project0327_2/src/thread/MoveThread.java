//������ ������ ��� �� ������
package thread;

public class MoveThread extends Thread{
	AnyMain anyMain;
	
	public MoveThread(AnyMain anyMain) {
		this.anyMain = anyMain;
	}
	//�����ڴ� ���� ������ �ڵ带 run�� �����Ѵ�.
	//jvm�� run�� �˾Ƽ� ȣ�����ش�.
	public void run() {
		while(true){
			try{
				Thread.sleep(100);
				anyMain.move(); //�̸� �ҷ����� ���ؼ��� animain�� �ҷ��;� �Ѵ�.
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

}
