package project0323;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<String, String>();
		
		map.put("soq0213","������");
		map.put("eksql821","���ܺ�");
		map.put("qqkqqk23","������");
		
		//��簴ü ���
		Set set=map.keySet();		//map�� set���� ��ȯ�Ͽ� ����Ѵ�.
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()){
			String id=it.next();
			String value=map.get(id);
			System.out.println(value);	
		}
		
		
		//String obj=map.get("eksql821");	//key������ ��ü Ž��		
		//System.out.println(obj);
		
	}

}
