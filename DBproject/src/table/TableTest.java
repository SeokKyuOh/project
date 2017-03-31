/*
	swing�� ������Ʈ �� �����ͺ��̽��� ��������� �ð�ȭ �ϱ⿡ ����ȭ�� ������Ʈ�� �ִµ�
	�װ� �ٷ� JTable�̴�.
*/
package table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableTest extends JFrame{
	JTable table;
	JScrollPane scroll;
	
	String driver="org.mariadb.jdbc.Driver";
	String url="jdbc:mariadb://localhost:3306/db0331";
	String user="root";
	String password="";
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;		//select���� ��츸 �ʿ��ϴ�. ��?? ����� ��ƾ� �ϹǷ�.
	
	
	String[][] data;	//data�� �߰��ϰų� ������ �� �ֱ� ������ ����.
	String[] column={"member_id","name","age"};		//�÷��� �����̶� ����
	
	public TableTest() {
		//setLayout(new FlowLayout());
		loadData();		//������ ����� ���� ����
			
		table = new JTable(data,column);
		scroll = new JScrollPane(table);
		
		add(scroll);
		setSize(500, 150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//���ڵ� ä���ֱ� �޼���
	//���̺��� �����ϱ� ����, mariaDB �����Ͽ� member ���̺��� ���ڵ带 ������ �迭�� ��Ƴ���
	//��? JTable�� �������� �μ��� ������ �迭�� ���Ǵϱ�
	public void loadData(){
		/*
		1�ܰ� - ����̹��� �ε�
		2�ܰ� - ����
		3�ܰ� - ���ϴ� ������ ����
		4�ܰ� - db ���õ� �ڿ� �ݱ�
	*/
		try {
			Class.forName(driver);
			//System.out.println("�ε强��");
			con = DriverManager.getConnection(url, user, password);
			if(con!=null){
				//System.out.println("���Ӽ���");
				String sql = "select * from member";			
				pstmt=con.prepareStatement(sql);
				rs = pstmt.executeQuery();		//���⿡ db�� ����ִ� . ��ĭ�� �������鼭 ������ �� ����
				
				//������ �迭 ����. ������ �ؾ� ���� �� �ֱ� ������ while������ ���� ����
				data = new String[3][3];
				int index=0;	//�迭�� ������ ���Ѵ�.
				
				while(rs.next()){
					int member_id = rs.getInt("member_id");		//primary key ����
					String name = rs.getString("name");
					int age = rs.getInt("age");
					
					//���Ѱ� data�迭�� ���			
					data[index][0] = Integer.toString(member_id);
					data[index][1] = name;
					data[index][2] = Integer.toString(age);
					
					index++;
					
				}
			}else{
				//System.out.println("���ӽ���");
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
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
			
	}
	
	public static void main(String[] args) {
		new TableTest();
	}

}
