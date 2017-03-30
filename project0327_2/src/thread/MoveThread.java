//움직임 로직을 담게 될 쓰레드
package thread;

public class MoveThread extends Thread{
	AnyMain anyMain;
	
	public MoveThread(AnyMain anyMain) {
		this.anyMain = anyMain;
	}
	//개발자는 독립 실행할 코드를 run에 기재한다.
	//jvm이 run을 알아서 호출해준다.
	public void run() {
		while(true){
			try{
				Thread.sleep(100);
				anyMain.move(); //이를 불러오기 위해서는 animain을 불러와야 한다.
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

}
