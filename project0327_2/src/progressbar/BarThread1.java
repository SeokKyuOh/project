package progressbar;

import javax.swing.JProgressBar;

public class BarThread1 extends Thread {
	JProgressBar bar;
	int interval;
	int count;
	
	public BarThread1(JProgressBar bar, int interval) {
		this.bar = bar;
		this.interval = interval;
		
		//start();
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
			bar.setValue(count);
		}
	}
}
