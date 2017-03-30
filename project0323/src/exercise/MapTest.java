package exercise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<String,String>(); 
		
		map.put("abc@gmail.com", "oh");
		map.put("def@naver.com","kim");
		map.put("ghi@daum.net","son");
		
		Set set = map.keySet();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()){
			String id=it.next();
			String value = map.get(id);
			String full = id +" "+value;
			System.out.println(full);
		}
	}

}
