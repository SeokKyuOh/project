/*
  	클래스는 코드의 재사용성 때문에 탄생한 기술이다.
  	자바에서는 클래스패스에 클래스 뿐만이 아니라 이미지도 등록가능하다
 */
package file;

import java.awt.FlowLayout;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;

public class FileWindow extends JFrame{
	MyIcon folder_on, folder_off;
	
	
	public FileWindow() {
		setLayout(new FlowLayout());
		
		//이미지 아이콘을 생성하되, 리소스 폴더로 부터
		//Uniformed Resouce Locater : 통합된 자원의 위치
		folder_on =  new MyIcon(this.getClass().getResource("/folder_open.png"),50,50);// res폴더를 build path로 등록해놨기 때문에 바로 이름 쓰면 된다.
		folder_off =  new MyIcon(this.getClass().getResource("/folder_close.png"),50,50);// res폴더를 build path로 등록해놨기 때문에 바로 이름 쓰면 된다.
		
		/* 이부분은 재사용성을 높이기 위해 MyIcon 클래스로 따로 만들기
		//아이콘으로 부터 이미지만 얻어오기.
		Image scaledImg = folder_on.getImage();
		//크기를 재 조정한 후 결과적으로 이미지 객체를 다시 반환
		Image result = scaledImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		//조정된 이미지를 다시 부착
		folder_on.setImage(result);
		*/
		
		//제대로 붙을지 테스트
		ArrayList<String> list = getDirlist();
		for(int i=0;i<list.size();i++){
			String dirName = list.get(i);
			MyPanel mp = new MyPanel(dirName, folder_off);
			add (mp);
		}
		setSize(600, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	//버튼 이미지 전환 for문으로 구현
	//if문으로 클릭한 것은 open이미지하고, else로 나머진 close이미지
	
	
	
	
	//원하는 경로의 하위 디렉토리/파일 구하기
	public ArrayList getDirlist(){
		File file = new File("C:/");
		
		File[] fileList = file.listFiles();
		ArrayList<String> dirList = new ArrayList<String>();
		
		//디렉토리만 골라내자
		for(int i=0;i<fileList.length;i++){
			if(fileList[i].isDirectory()){
				//디렉토리가 발견될 때마다 리스트 추가
				dirList.add(fileList[i].getName());	
			}
		}
		return dirList;
		
	}
	
	public static void main(String[] args) {
		new FileWindow();
	}

}
