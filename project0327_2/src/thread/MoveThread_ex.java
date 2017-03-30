package thread;

public class MoveThread_ex extends Thread{
	AniMain_ex aniMain;
	int x;
	
	public MoveThread_ex(AniMain_ex aniMain) {
		this.aniMain = aniMain;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				move();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void move(){
		x+=5;
		aniMain.can.repaint();		
	}
}
