package homework2;

import javax.swing.JLabel;

public class CountThread extends Thread {
	JLabel la; // ����Ʈ�� null
	int interval; // ����Ʈ�� 0
	int count;

	public CountThread(JLabel la, int interval) {
		this.la = la;
		this.interval = interval;
		
		start();
	}

	public void run(){
		//Ư�� ���� ���� 1�� ������Ű��, ������ �ӵ����..
		while(true){
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
			la.setText(Integer.toString(count));
		}
	}
}
