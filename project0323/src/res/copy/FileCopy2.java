/*
	★ 예외 처리의 목적
	- 비정상 종료의 방지(즉, 안정적인 시스템 운영을 위해)

	일반적으로 프로그램이 정상 수행될 수 없는 상황을 가리켜 "에러"라 한다.
	SUN에서는 에러에 대해 나름 분류했다... 클래스를 지원
	1. 프로그래머가 대처할 수 없는 불가항력적 에러
		Error (cpu파손, 네트워크선 단절 등 외부적 요인)

	2. 프로그래머가 대처할 수 있는 에러(이를 '예외'라고 한다.)
		자바의 관심사항은 바로 "예외"이다.
		SUN에서는 이 예외를 상황에 따라 체계적인 클래스로 지원하고 있다.

		이 예외 객체들은 다시 크게 2가지 유형으로 분류한다.
		(1) 컴파일 타임에 예외처리를 강요하는 경우
			 checked Exception(예. FileNotFoundException)

		(2) 컴파일 타임에 예외처리를 강요하지 않는 경우
			 Unchecked Exception = Runtime Exception
			 --> 이건 스프링 시간에 배워보자.
*/

package copy;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


class FileCopy2{
	FileInputStream fis;		//파일을 대상으로 한 입력스트링
	FileOutputStream fos;	//파일을 대상으로 한 출력스트링
	
	public FileCopy2(){
		//아래의 코드는 장차 에러가 발생할 수 있는 가능성이 다분한 코드이다. 
		//그래서 개발자가 문법을 잘 작성했음에도 자바는 특별한 안전장치를 마련하길 원한다.
		//안전장치를 마련하기를 요구한다. (try, catch)
		//이부분에 대한 오류를 확인하기 위해 지금 에딧플러스로 수업 중
		//이것에 대한 걱정 너무 하지 말자. 
		//try, catch문은 자바가 쓰라고 할때만 쓰면 된다.(남발하지 말것)
		try{
			//파일에 벌이 침을 꽂듯이 꽂는 코드
			fis = new FileInputStream("C:/java_orkspace2/project0323/src/res/pika.jpg");
			fos = new FileOutputStream("C:/java_workspace2/project0323/src/data/pika_copy.jpg");
			//아웃풋할때는 빈파일을 만들어준다.

			//System.out.println("파일에 스트림 생성했어요~!");
			/*
			int data;
			data=fis.read();	//1byte를 읽어들임
			System.out.println(data);//
			
			data=fis.read();	//1byte를 또 읽어들임
			System.out.println(data);
			*/
			int data;
			while(true){
				data=fis.read();	//1byte를 읽어들임
				fos.write(data);	//1byte 쓰기.
				if(data==-1)break;
				System.out.println(data);
			}

			/*스트림을 사용한 후엔 반드시 제거해야한다.
			제거하지 않으면 빨대가 제거되지 않아 사용하지 않는 빨대가 계속 누적된다.
			나중엔 이렇게 쌓인 빨대가 메모리를 크게 잡아먹는 원인이 되기도 한다.*/

		}catch(FileNotFoundException e){
			//에러가 발생하면 실행부가 이 영역으로 진입된다.
			//catch문을 수행하게되면 프로그램이 비정상종료가 되지않고 정상 수행하게된다.
			//복구의 용도가 아닌 개발자가 오류를 확인하고, 사용자에게는 안내하는 용도이다.
			System.out.println("파일을 찾을 수 없습니다.");//보통은 이런경우 개발자에게 메일오도록 작성. 빠른처리위해.
		}catch(IOException e){	//read와 대응하는 catch문
			System.out.println("파일을 읽을 수 없습니다.");
		}finally{
			//모든 업무가 끝나는 시점	에러가나도, 성공해도 들어온다.
			//finally를 선언하면 try문을 수행하던, catch문을 수행하던 실행부가 무조건 이 영역을 거치게 되어있다.
			//그렇기 때문에 마무리짓는 코드는 finally에서 수행되어야한다.
			//끝날때도 IOException해야한다..
		
			//finally 코드의 사용목적
			/*주로 database연동과 스트림 사용시 성공여부를 떠나서 무조건 자원을 닫거나 마무리하려면 
				try문이던 catch문을 수행하던 무조건 거쳐야 하는 영역을 두기 위함이다.*/
			try{
				fis.close();		//인풋스트림 연결해제	
				fos.close();	//아웃풋스트림 연결해제
			}catch(IOException e){

			}
		}
		
		/*
		try{
			if(fis!=null){fis.close();};		//인풋스트림 연결해제	
			if(fos!=null){fos.close();};	//아웃풋스트림 연결해제
				/*null이 아닐때만 실행해라
					if를 넣은 이유는 처음 생성부터 오류가 날경우 생성조차 안되었기 때문에 close 명령을 수행할 수 없다.
					이 때문에 새로운 에러가 발생하니 이부분을 null이 아닐경우라는 if문으로 작성하여 에러를 방지한다.*/
		/*
		}catch(IOException e){
		}*/
		
	}
	public static void main(String[] args){
		new FileCopy2();

	}

}
