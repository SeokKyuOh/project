/*
 	OS가 여러 프로세스들을 동시에 수행하면서 관리할 수 있듯(Multi-tasking), 
 	하나의 자바프로그램 내에서 세부적 실행단위를 만들어 동시에 수행시킬 수 있다.
 	이러한 세부적 실행 단위를 쓰레드라 한다.
 	
 	자바는 개발자가 정의하지 않아도 이미 기본적으로 제공되는 실행용 쓰레드가 있으며 
 	이러한 쓰레드를 가리켜 메인쓰레드라 한다.
 	결국 자바도 쓰레드 기반이다.
*/
package thread;

public class ThreadTest {
	//메인쓰레드 말고, 개발자가 원하는 사용자 정의 쓰레드 하나 만들어서 원하는 동시 작업을 시켜보자
	MyThread thread;
	
	public ThreadTest() {//생성자 메서드
		//메인쓰레드와는 별도로 독립적으로 실행될 수 있는 세부 실행단위를 생성함
		//쓰레드가 어떤 일을 할지는 개발자가 결정해야 하기 때문에..
		//쓰레드를 내 입맛대로 바꾸자.. 그냥 정의없이 new하면 단순히 불러오는 것이기 때문에 따로 클래스를 만들어 상속받자
		thread = new MyThread();
		thread.start();		
		//ㄴMyThread의 run을 실행시키자. 
		//하지만 그냥 run이라고 쓰고 실행하면 일반메서드가 되어 버려서 메인 실행부가 실행해버린다. 일을 맡겨버리는게 아니라서 따로 만드는 의미가 없어져버림  
		//start()라고 해야한다.
		
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("☆");
		}
	}
	
	public static void main(String[] args) {
		//int[] arr = new int[3];
		//System.out.println(arr[3]);		//배열의 크기를 벗어나서 에러남
		
		new ThreadTest();
		
	}

}
