/*
 	�÷��� �����ӿ��� ���� 2���� �� �������� ��ü���� ������ Set ������ �˾ƺ���
 */
package project0323;

import java.util.Iterator;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		//Set�� �ڽĵ� �� TreeSet�� ����غ���.
		TreeSet<String> set = new TreeSet<String>();
		
		set.add("���");
		set.add("����");
		set.add("������");
		
		/*�÷��� �����ӿ��� ��ü �� �������� ��ü�� ����ϴ� ����, �뷮�� ó�� �� �ݺ����� ���� ����� �� ���ٴ� ����� �ε�����.
		    �ذ�å) �������� ���� �����ְ� ������
					 Enumerartion, Iterator
					 
			�ݺ������� for, while���� �ִ�.
			for���� ���۰� ������ ��ġ�� �˰� ������ �����ϴ�. 1~256����
			
			While���� �Ұ�ȣ���� true ���� ���� �����Ѵ�.
			�����ڰ� ������ �� ���� ������ ������� �� �� �ַ� ���
			int i=0;
			
			while(true){
				i++;
				if(i>=256){
					break;		//break�� ������ ������ ��� �����ϴ� ���ѷ����� ������.
				}
			}		
			
		*/
		Iterator<String> it = set.iterator();	//��� �������� ����ȯ����� �ϴ� ���� ��������.
		
		/* �̷��� ����ϴ� ��� 4��° Ȯ���� �� ������ . �ڷᰡ ���
		String e1 = it.next();	//���� ��ҿ� ����
		String e2 = it.next();	
		String e3 = it.next();	
		String e4 = it.next();	
		*/
		
		while(it.hasNext()){
			String e1 = it.next();
			System.out.println(e1);
		}
		
		Iterator<String> it2= set.iterator();	//���� ���� �ι� �غ���. �������� ���� ���ʴ�� Ȯ���ϴ� ���ε�. ������� ������ ���� ���� �������� �˰��� ���� ������ ���ϴµ�
		while(it2.hasNext()){
			String e2 = it2.next();	
			System.out.println(e2);
		}
	}

}
