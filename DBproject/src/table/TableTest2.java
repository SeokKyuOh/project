/*
	swing�� ������Ʈ �� �����ͺ��̽��� ��������� �ð�ȭ �ϱ⿡ ����ȭ�� ������Ʈ�� �ִµ�
	�װ� �ٷ� JTable�̴�.
	
	���ڵ��� ������ ���� �迭�� ũ�⸦ �����ؼ� �����غ���
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

public class TableTest2 extends JFrame{
	JTable table;
	JScrollPane scroll;
	
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="batman";
	String password="1234";
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;		//select���� ��츸 �ʿ��ϴ�. ��?? ����� ��ƾ� �ϹǷ�.
	
	
	String[][] data;	//data�� �߰��ϰų� ������ �� �ֱ� ������ ����.
	String[] column={"empno","ename","job","mgr","hiredate","sal","comm","deptno"};		//�÷��� �����̶� ����
	
	public TableTest2() {
		//setLayout(new FlowLayout());
		loadData();		//������ ����� ���� ����
			
		table = new JTable(data,column);
		scroll = new JScrollPane(table);
		
		add(scroll);
		setSize(800, 600);
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
				String sql = "select * from emp";			
				pstmt=con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = pstmt.executeQuery();		//���⿡ db�� ����ִ� . ��ĭ�� �������鼭 ������ �� ����
				
				//rs�� last()�� ������, ��ġ�� ����
				rs.last();
				int total=rs.getRow();
				
				//���� ���´� rs�� �ٽ� �ҷ�����
				rs.beforeFirst();		//�ƹ��͵� ����Ű�� �ʴ� ����  ù��° �������ΰ���. next�� �����̴ϱ� ù��° ���� ���� ù��°���� ����
				
				//������ �迭 ����. ������ �ؾ� ���� �� �ֱ� ������ while������ ���� ����
				data = new String[total][column.length];
				int index=0;	//�迭�� ������ ���Ѵ�.
				
				while(rs.next()){
					int empno = rs.getInt("empno");		//primary key ����
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					int mgr = rs.getInt("mgr");
					String hiredate = rs.getString("hiredate");
					int sal = rs.getInt("sal");
					String comm = rs.getString("comm");		//null�� ��κ��� �����ͺ��̽� ����� �ظ��ϸ� ���� �ʵ��� �����Ѵ�. null�� ������ String���� ����
					int deptno = rs.getInt("deptno");
					
					
					//���Ѱ� data�迭�� ���			
					data[index][0] = Integer.toString(empno);
					data[index][1] = ename;
					data[index][2] = job;
					data[index][3] = Integer.toString(mgr);
					data[index][4] = hiredate;
					data[index][5] = Integer.toString(sal);
					data[index][6] = comm;
					data[index][7] = Integer.toString(deptno);
					
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
		new TableTest2();
	}

}
