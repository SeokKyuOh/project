/*
 	키보드를 대상으로
 	
 	키보드와 관련된 스트림은 개발자가 만드는 것이 아니라 이미 OS가 만들어놓고 있다.
 	키보드건 파일이건 스트림은 OS가 이미 만들어놓은 걸 우리가 쓸 수 있게 부탁하는 것이다.
 */
package editor;

import java.io.IOException;
import java.io.InputStream;

public class KeyBoardTest {

	public static void main(String[] args) {
		/*
		 	keyboard는 개발자가 원할 때 생성할 수 있는 스트림이 아니라
		 	이미 시스템에서 컴퓨터를 킬 때 얻어두기 때문에 
		 	개발자는 이미 존재하는 스트림을 얻어와 사용하면 된다.
		 	자바에서는 os로 부터 스트림을 이미 얻어와서 System클래스의 멤버변수인 in 변수에 받아놓았다.
		 	
		 	자바는 하드웨어를 직접 제어하지 않고 또한 하드웨어 자체는 현 시스템을 운영하는 OS가 제어하므로
		 	하드웨어에 대한 입력 스트림은 자바가 아닌 OS가 이미 제어해놓고 있다.
		 	따라서 자바언어를 이용하여 키보드, 스캐너 등등의 입력 하드웨어의 값을 얻기 위해서는
		 	각 하드웨어에 알맞는 스트림 클래스가 지원되는 게 아니라 
		 	오직 표준 입력스트림인 InputStream을 쓰면 된다.
		*/
		InputStream is = System.in;//윈도우에 의존적인 입력방식은 모두 이것으로 받을 수 있다.(키보드, 포스 스캐너 등 모든것)
		
		int data;
		try {	//shift + alt + z 하면 해야하는 기능 나옴
			//read() 메서드는 사용자의 입력이 있을 때까지 블럭 상태에 빠진다.
			//블럭상태란 대기상태를 말한다.
			while(true){
				data = is.read();	//1byte읽기 	
				System.out.print(data); //char를 선언하면 문자만 나오지만 
													//int형일 경우 입력한 문자에 해당하는 숫자값과 엔터에 대한 값, 
													//그리고 줄바꾸고 앞으로 가는 기능에 대한 값이 함께 출력된다.
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
