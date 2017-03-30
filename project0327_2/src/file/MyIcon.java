/*
  	아이콘 생성시 그 크기를 조정하려면 코드가 복잡하므로, 앞으로 재사용 가능성을 염두해두고 
  	나만의 재조정 이미지 아이콘을 새로 정의해본다.
 */
package file;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class MyIcon extends ImageIcon{
	
	public MyIcon(URL url, int width, int height) {
		//folder_on =  new ImageIcon(this.getClass().getResource("/folder_open.png"));// res폴더를 build path로 등록해놨기 때문에 바로 이름 쓰면 된다.
		//folder_off =  new ImageIcon(this.getClass().getResource("/folder_close.png"));// res폴더를 build path로 등록해놨기 때문에 바로 이름 쓰면 된다.
		super(url);	
		// ㄴImageIcon 상속받을 상태에서 new 하는 것이 안되기 때문에 부모인 super를 통해 호출
		//		부모 생성 전에 this를 불러낼 수 없으니 처음부터 url을 변수로 입력하는 것으로 변경 
		
		//아이콘으로 부터 이미지만 얻어오기.
		//Image scaledImg = folder_on.getImage();		기존.
		Image scaledImg = this.getImage();		//얻어올 주체가 자기 자신이라 this
		
		//크기를 재 조정한 후 결과적으로 이미지 객체를 다시 반환 가로 세로도 변수로 넣자.
		Image result = scaledImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		//조정된 이미지를 다시 부착
		//folder_on.setImage(result);		기존
		this.setImage(result);		//자기 자신이니까 this
	}
}
