package project0323;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<String, String>();
		
		map.put("soq0213","오석규");
		map.put("eksql821","동단비");
		map.put("qqkqqk23","오현규");
		
		//모든객체 출력
		Set set=map.keySet();		//map을 set으로 변환하여 사용한다.
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()){
			String id=it.next();
			String value=map.get(id);
			System.out.println(value);	
		}
		
		
		//String obj=map.get("eksql821");	//key값으로 객체 탐색		
		//System.out.println(obj);
		
	}

}
