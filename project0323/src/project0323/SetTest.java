/*
 	컬렉션 프레임웍의 유형 2가지 중 순서없는 객체들의 집합인 Set 유형을 알아보자
 */
package project0323;

import java.util.Iterator;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		//Set의 자식들 중 TreeSet을 사용해본다.
		TreeSet<String> set = new TreeSet<String>();
		
		set.add("사과");
		set.add("딸기");
		set.add("오렌지");
		
		/*컬렉션 프레임웍의 객체 중 순서없는 객체를 사용하다 보면, 대량의 처리 시 반복문을 직접 사용할 수 없다는 어려움에 부딪힌다.
		    해결책) 순서없는 것을 순서있게 만들자
					 Enumerartion, Iterator
					 
			반복문에는 for, while문이 있다.
			for문은 시작과 끝값을 수치로 알고 있을때 유용하다. 1~256까지
			
			While문은 소괄호안이 true 동안 동안 동작한다.
			개발자가 예측할 수 없는 범위를 대상으로 할 때 주로 사용
			int i=0;
			
			while(true){
				i++;
				if(i>=256){
					break;		//break를 해주지 않으면 계속 동작하는 무한루프에 빠진다.
				}
			}		
			
		*/
		Iterator<String> it = set.iterator();	//얘두 명시해줘야 형변환해줘야 하는 일이 없어진다.
		
		/* 이렇게 사용하는 경우 4번째 확인할 때 에러남 . 자료가 없어서
		String e1 = it.next();	//다음 요소에 접근
		String e2 = it.next();	
		String e3 = it.next();	
		String e4 = it.next();	
		*/
		
		while(it.hasNext()){
			String e1 = it.next();
			System.out.println(e1);
		}
		
		Iterator<String> it2= set.iterator();	//같은 것을 두번 해보자. 순서없는 것을 차례대로 확인하는 것인데. 결과값이 동일한 것을 보면 내부적인 알고리즘에 따라 순서를 정하는듯
		while(it2.hasNext()){
			String e2 = it2.next();	
			System.out.println(e2);
		}
	}

}
