/*
	FileInpitStream 등은 개발자가 원하는 시점에 스트림을 생성할 수 있지만,
	키보드와 같은 표준 입력 하드웨어의 경우엔 자바가 스트림을 생성하지 못하고
	해당 OS가 관리하므로, 자바 개발자는 OS로 부터 표준입력 스트림을 얻어와야한다.
	
	자바의 클래스 중 System 클래스의 static 멤버변수 중 즉 has a 관계로 보유한 
	InputStream형 in 객체가 바로 표준입력 스트림을 받아놓은 클래스이다.
	따라서 사용시엔 그냥 System.in; 하면 된다.

	문자기반 스트림 클래스의 이름 규칙
	입력 : ~~Reader
	출력 : ~~Writer
	위의 두가지가 붙는 것들은 문자가 안깨진다. 나머진 깨짐

*/
package io;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;


class KeyBoardApp{

	public static void main(String[] args){
		InputStream is = System.in;

		//문자기바나 스트림은 단독으로 존재하는 것이 아니라,
		//이미 바이트 기반 스트림을 전제로 한다.
		//따라서 생성시 생성자의 인수에 바이트 기반 스트림을 넣는다.
		InputStreamReader reader=null;
		reader = new InputStreamReader(is);		//업그레이드 된 빨대에 빨대를 넣는다.
		

		int data;
		try{
			while(true){
				/*
				data=is.read(); //1byte 읽어들임. 그래서 영어 a 엔터치면 a만 나오고 엔터에 포함된 \n과 \R은 안나온다.
				//System.out.print(data);		//System이 보유하는 out 객체에..
				System.out.print((char)data);	
				//ㄴ 문자로 바꾸자.. 다만 엔터에 포함된 \n과 \r은 기능만 담당하기 때문에 문자로는 출력되지 않는다.
				*/

				data=reader.read(); //2byte 읽어들임
				System.out.print((char)data);	

			}
		}catch(IOException e){

		}

	}

}
