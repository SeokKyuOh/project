/*
  	자바에서는 디렉토리를 제어하기 위한 클래스가 별도로 존재하지 않고, 디렉토리도 파일로 간주
  	결론 : java.io.File 클래스가 파일 + 디렉토리까지 처리한다.
 */

package file;

import java.io.File;

public class FileTest {

	public FileTest() {
		//C드라이브의 하위에 존재하는 모든 디렉토리 및 파일을 출력해보자
		File file = new File("C:/");
		
		//하위 디렉토리 및 파일의 목록 추출
		//String[] dir = file.list();
		File[] dir = file.listFiles();	//스트링배열이 아닌 더 넓은 범위의 파일 배열로 받기
		
		for(int i=0;i<dir.length;i++){
			if(dir[i].isDirectory()){		//디렉토리만 나오게 하기
				System.out.println(dir[i].getName());		//찾은 디렉토리 배열의 이름이 나오게 하기
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		new FileTest();
		

	}

}
