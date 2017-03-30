package project0323;

import java.util.Vector;


import javax.swing.JButton;

/*
 	컬렉션 프레임 웍의 API 객체 중 List 계열의 하위 객체인 Vector를 학습해보자
 	
 	참고) List 계열은 사실 우리가 흔히 써왔던 배열과 거의 같다.
 	
 						배열												List
 	크기:			반드시 명시									선택사항, 유연함
 	대상:	자바기본자료형 + 객체자료형							오직 객체형
 	Vector는 크기를 명시할 수 있지만 그 수를 넘어가는 경우 추가로 계속 늘어난다.
 	예) Vector(5) 면 5칸이지만 6개 만들경우 추가로 5개 더 만들어짐
 	
*/
public class VectorTest {
	
	public static void main(String[] args) {
		//컬렉션 프레임웍 객체에 Generic Type을 명시하면
		//객체가 섞이는 것을 컴파일 타임에 방지해준다.
		Vector<String> v = new Vector<String>();		//클래스 명에 클릭 후 shift + F2를 누르면 API문서 바로 열린다.
		//Vector<String> 이것 자체가 하나의 자료형이기 때문에 뒤에 new 다음에도 똑같이 붙는다.
		//제너릭으로 선언하게 되면 더이상 오브젝트가 들어가는 것이 아니기 때문에 
		
		v.add("사과");
		v.add("딸기");
		//v.add(new JButton("나 버튼"));		//얘도 가능하다. 오브젝트 자체를 담을 수 있으니까. 하지만 쓰고자 할때 형변환관련해서 에러가 날 경우가 다분하다.
		v.add("바나나");
		v.add("오렌지");
		
		for(int i=0;i<v.size();i++){
			String obj=v.get(i);		//Object obj=v.get(2); 이렇게해도 값은 나오지만 정확하게 하자면 반환되는 오브젝트형을 처음 선언한 String으로 변환해줘야한다.
			System.out.println(obj);
		}										//String obj=(String)v.get(i); 제너릭으로 선언하게 되면 더이상 오브젝트가 들어가는 것이 아니기 때문에 String으로 형변환 하지 않아도 된다.
		
		
		
		
	}

}
