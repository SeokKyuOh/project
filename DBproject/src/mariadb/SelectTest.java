/*
	mariadb�� �����Ͽ� ���ڵ带 �ֿܼ� ��� ����
	
	����) dbms�����簡 �����ϴ� ����̹��� �̸� �غ�����
*/
package mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {
	String driver = "org.mariadb.jdbc.Driver";
	String url = "jdbc:mariadb://localhost:3306/db0331";	//�̺κ��� �ʿ��Ҷ����� �˻�����
	String user = "root";
	String password = "";		//�����̽��ٷ� ���� ���� �� ��
	Connection con = null;	//���������� ���� �������̽�
	PreparedStatement pstmt;	//���� ���� ��ü �׷��� ���ӿ� �������̴�. �����Ŀ� �����ؾ���
	ResultSet rs;		//�������� select���� ��� �������� �����ͺ��̽��� ���̺�� ������ ��������� ��Ƴ��� ��ü(=ǥ�� ����)
							//������ ���ֱ⸸ �ϴ� �ڷḦ �� ��ǻ�ͷ� �����´�
		
	public SelectTest() {
		/*
			1. ����̹��� �ε�
			2. ����
			3. ���ϴ� ������ ����
			4. db ���õ� �ڿ� �ݱ�
		*/

		try {
			Class.forName(driver);
			System.out.println("�ε强��");
			
			con = DriverManager.getConnection(url, user, password);
			if(con !=null){
				System.out.println("���Ӽ���");
				String sql="select * from member";		//�ܼ�â�� �ƴϱ⶧���� ;���� �ʴ´�.
				
				pstmt=con.prepareStatement(sql);
				
				//���� ���� �� ��ȯ�Ǵ� ��������� ����.
				//��? select���̴ϱ�
				rs = pstmt.executeQuery();
				
				//Ŀ�� ��ĭ ����
				while(rs.next()){		//while�� �ȿ� �ִ� ���� Ʈ���� ����.
					int member_id = rs.getInt("member_id");
					String name = rs.getString("name");;			//�÷��� �ش��ϴ� �� ��ȯ.		name�̾ getString�̾�� �Ѵ�.
					int age = rs.getInt("age");							//���� ��ȯ 		���̴� ���ڷ� ���صξ getint�̾�� �Ѵ�.
					System.out.println(member_id+","+name+","+age);
				}	
				
			}else{
				System.out.println("���ӽ���");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		new SelectTest();
	}

}
