/*
	1. 스트림의 방향성에 따른 분류
		-입력, 출력
		
	2. 스트림의 데이터 처리방법에 따른 분류
		(1) 바이트 기반 스트림
			(입출력시 1byte씩 처리)
		(2) 문자기반 스트림
			(입출력시 2byte씩 묶어서 이해할 수 있는 스트림)
			주의! 2byte씩 읽거나, 쓰는게 아니다. 
			       여전히 1byte씩 깨져서 지나가지만 완성된 모양으로 볼 수 있게 도와줌.
			★ 문자기반스트림의 명명규칙
			입력스트림 - ~~~Reader로 끝남
			출력스트림 - ~~~Writer로 끝남
		(3) 버퍼 스트림
*/
package editor;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StandardInput {

	public static void main(String[] args) {
		//스트림 얻기
		InputStream is = System.in;
		InputStreamReader reader=null;		//InputStreamReader는 기존 InputStream이 기초가 되어야한다.
		reader = new InputStreamReader(is);	//빨대위에 업그레이드 빨대 덧붙이기.
		
		int data;
		try {
			//while(true){		//while문이 없을 경우 한글자만 입력되는데, 이는 read()메서드가 한글자만 읽어들이기 때문이다.
				data = reader.read();	//1byte			기존 빨대인 is대신 업글 빨대인 reader를 사용한다. 
				//System.in;		//표준입력
				//System.out;	//표준 출력   해석) 시스템이라는 클래스에 아웃 변수가있는 자료형이다. 여기서 변수가 뭔지는 잘 모른다.
				//System.out.println();  해석) 아웃이라는 변수는 뒤에 메서드가 오네? 그러면?? 메서드가 있는 00 다 
				
				System.out.print((char)data);		
				//ㄴchar로 선언하면 엔터에 들어있는 \n(줄바꿈)과 \r(맨앞으로가기)는 문자형으로 변환되지 않기 때문에 출력x
				//한글은 2바이트 이기 때문에 이때 바로 입력하면 깨진다.
			//}
		} catch (IOException e) {
			e.printStackTrace();
		}	
		

	}

}
