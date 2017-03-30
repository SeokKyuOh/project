package exercise;

import java.util.ArrayList;


public class ObjectManager {
	ArrayList<GameObject> list = new ArrayList<GameObject>();
	
	public void addObject(GameObject obj){
		list.add(obj);
	}

}
