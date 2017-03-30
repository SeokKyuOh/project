/*
	특정 디렉토리 안의 파일을 워하는 위치에 복사해본다.

	실행중인 프로그램으로 데이터가 들어가는 것은 inputStream이라고한다.
	반대로 나오는 것은 outputStream이라고 한다.
	이 두개를 합쳐서 IO라고 한다.

	1. 스트림이란? (Stream)
	- 흐름을 뜻한다.
	  현실에서의 스트림은 그 대상이 물이지만, 
	  전산에서의 스트림은 그 대상이 데이터이다.
	  결국 데이터가 흐르는 모습을 가리켜 스트림이라고 한다.
	2. 종류
	(1)방향에 따른 구분
	  입력 : 실행중인 프로그램으로 데이터가 들어가는 스트림
	  출력 : 실행중인 프로그램에서 테이터가 나오는 스트림
	컴파일했을 때 컴파일러가 무사히 컴파일을 마치면 이 프로그램은 정상 수행이 보장된 것이다??
	->아니다. ex)이미지 파일 경로 틀렸을때.
	------------------------------------------------------------------------------------------
	자바코드를 작성 후 컴파일했을때, 문법에 문제가 없다고하여 그 프로그램은 언제나 정상 수행을 보장해주진 않는다.
	예) 파일의 경로를 잘못 적은 경우(문법X, 데이터의 문제)
		-->컴파일은 제대로 되었으나, 실행 시 에러발생해서 비정상 종료.
	예) 방금 전까지는 파일이 존재해서 제대로 프로그램이 수행되고 있었으나, 누군가가 파일을 지워버린 경우
	이처럼 프로그램으로 감당할 수 없는 외부요인
		--> 실행 시 에러발생하여 비정상 종료
	비정상 종료는 개발자의 신뢰성에 큰 타격을 준다.

*/
package copy;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

class FileCopy extends JFrame{
	FileInputStream fis;
	String ori="C:/java_workspace2/project0323/src/res/mdrio.png";

	public FileCopy(){
		try{	//이 코드는 무조건 실행부에 의해 시도됨
			//SUN에서는 try문에서 에러가 발생한 경우 프로그램을 비정상 종료시키지 않기 위해
			//실행부가 catch문으로 진입하게 하여 정상수행을 할 수 있는 기회를 준다.
			fis = new FileInputStream(ori);	//지금 이 코드는 미래에 에러를 발생시킬 가능성이 있다. 
														//파일이 날아갈 수도 있는 가능성있다.

			//만일 이 try문 안에서 파일을 찾을 수 없는 에러가 발생할 경우
			//SUN에서는 FileNotFoundException객체를 메모리에 올리고,
			//이 인스턴스를 개발자에게 전달해준다.
			//왜?? 그래야 개발자가 에러정보를 이용하여 
			//사용자에게 알맞은 메세지를 보여줄 수 있기 때문에.
		}catch(FileNotFoundException e){	//catch문은 에러를 복구하는 것이 아니라 에러의 원인에 대한 확인용이다.
			JOptionPane.showMessageDialog(this, "파일을 찾을 수 없습니다.");	//파일경로가 틀릴경우
		}

		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args){
		new FileCopy();
	}

}
