package count;

public class CountFast extends Thread{
	int count=0;
	CountApp countApp;
	
	public CountFast(CountApp countApp) {	
		this.countApp = countApp;
		
		start();
	}
	
	public void print(){
		count++;
		countApp.la1.setText(Integer.toBinaryString(count));
		
	}
	
	public void run() {
		while (true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			print();
		}
	}
	
	
}
