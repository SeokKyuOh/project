/*
 	�츮�� ������� �����ͺ��̽� ��ǰ�� ��� DBMS�̴�.
 	DB(�����) MS(�����ý���) - ��Ʈ��ũ����̶� ���������� �����ϴ�
 	
 	���� ������� ��Ʈ��ũ ���������� TCP/IP����̹Ƿ� 
 	�������� ȣ��Ʈ�� �����Ϸ��� �� ȣ��Ʈ�� �ּҸ� �˾ƾ��ϴµ�
 	����� TCP/IP������ IP�ּҸ� �˾ƾ��Ѵ�.
 	�׸��� user ������������ �˾ƾ��Ѵ�.
 */
package oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestMain {

	public static void main(String[] args) {
		
		/*1�ܰ� - ����Ŭ�� �ڹٰ� ������ �� �ִ� �ڵ尡 ����ִ� jar������ �޸𸮿� �ε��ؾ��Ѵ�.
					�̷� �����ͺ��̽� ���� jar������ �ڹٿ����� ����̹��� �Ѵ�.
					����̹��� DB�����翡�� �����Ѵ�.
					Oracle --> ����Ŭ��
					MySQL --> ����Ŭ��
					MSSQL --> MS
		   2�ܰ� - ����Ŭ�� ��������		*/
		
		//����̹� Ŭ���� �ε�. �����Ѱ� ��Ʈ�������� ������ �ȴ�.
		Connection con = null;						//try catch���� ���� �ֱ� ������ finally���� �ݱ� ���ؼ� ���⿡ ���� ����
		PreparedStatement pstmt = null;		//try catch���� ���� �ֱ� ������ finally���� �ݱ� ���ؼ� ���⿡ ���� ����
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	//��Ŭ�������� Ŭ������ ���絵 ���� ��
			System.out.println("����̹� �ε� ����");
			con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "batman", "1234");
																	/*   jdbc������� oracle ���α׷��� thin������� �Ѵ�.@localhost ���ڽ���*/
			if(con!=null){
				System.out.println("���Ӽ���");
				
				//���� ������ ������ ���̺� insert �õ�����
				String sql ="insert into company(company_id, brand) values(seq_company.nextval, '����Ű')";	//���ڷ� ������ ����Ŭ�� �˾Ƽ� ó���Ѵ�.
				//������ ������ ���ؼ��� �������� �����ϴ� ��ü�� �̿��ؾ� �ϴµ�, 
				//�� ��ü�� �ٷ� PreparedStatement �������̽� �̴�.
				pstmt = con.prepareStatement(sql);
				int result = pstmt.executeUpdate();		//������ ���� �޼���
				//�� ������ ���࿡ ���� �ݿ��� ���ڵ��� ���� ��ȯ���ش�.
				//insert���� ������ 1�Ǿ��� �ԷµǱ� ������ ������� ������ 1 ���н� 0 �̴�.
				if(result==1){
					System.out.println("�Է¼���");
				}else{
					System.out.println("�Է½���");
				}
			}else{
				System.out.println("���ӽ���");
			}
								
		} catch (ClassNotFoundException e) {
			System.out.println("����̹��� ã�� �� �����ϴ�.");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//��Ʈ���� DB�����۾� �Ŀ� �ݵ�� �ݴ� ó���� �ؾ��Ѵ�.
			//pstmt �湮, con �빮 �̴ϱ� �湮�� ���� �ݴ´�
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
