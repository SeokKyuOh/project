package exercise;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		
		v.add("��");
		v.add("����");
		v.add("���");
		v.add("��");
		
		for(int i=0;i<v.size();i++){
			String o = v.get(i);
			System.out.println(o);
			
		}

	}

}
