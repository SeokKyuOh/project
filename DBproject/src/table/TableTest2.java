/*
	swing의 컴포넌트 중 데이터베이스의 결과집합을 시각화 하기에 최적화된 컴포넌트가 있는데
	그게 바로 JTable이다.
	
	레코드의 갯수에 따라 배열의 크기를 지정해서 개발해보자
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
	ResultSet rs;		//select문일 경우만 필요하다. 왜?? 결과를 담아야 하므로.
	
	
	String[][] data;	//data는 추가하거나 변경할 수 있기 때문에 선언만.
	String[] column={"empno","ename","job","mgr","hiredate","sal","comm","deptno"};		//컬럼은 고정이라 냅둠
	
	public TableTest2() {
		//setLayout(new FlowLayout());
		loadData();		//데이터 만들기 전에 접속
			
		table = new JTable(data,column);
		scroll = new JScrollPane(table);
		
		add(scroll);
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//레코드 채워넣기 메서드
	//테이블을 생성하기 전에, mariaDB 연동하여 member 테이블의 레코드를 이차원 배열에 담아놓자
	//왜? JTable의 생성자의 인수로 이차원 배열이 사용되니까
	public void loadData(){
		/*
		1단계 - 드라이버를 로드
		2단계 - 접속
		3단계 - 원하는 쿼리문 실행
		4단계 - db 관련된 자원 닫기
	*/
		try {
			Class.forName(driver);
			//System.out.println("로드성공");
			con = DriverManager.getConnection(url, user, password);
			if(con!=null){
				//System.out.println("접속성공");
				String sql = "select * from emp";			
				pstmt=con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = pstmt.executeQuery();		//여기에 db가 들어있다 . 한칸씩 내려가면서 접근할 수 있음
				
				//rs를 last()로 보내고, 위치를 묻자
				rs.last();
				int total=rs.getRow();
				
				//정찰 보냈던 rs를 다시 불러오자
				rs.beforeFirst();		//아무것도 가리키지 않는 상태  첫번째 이전으로간다. next로 움직이니까 첫번째 위로 가야 첫번째부터 나옴
				
				//이차원 배열 생성. 생성을 해야 담을 수 있기 때문에 while문보다 먼저 생성
				data = new String[total][column.length];
				int index=0;	//배열의 층수를 뜻한다.
				
				while(rs.next()){
					int empno = rs.getInt("empno");		//primary key 접근
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					int mgr = rs.getInt("mgr");
					String hiredate = rs.getString("hiredate");
					int sal = rs.getInt("sal");
					String comm = rs.getString("comm");		//null은 대부분의 데이터베이스 설계시 왠만하면 들어가지 않도록 설계한다. null이 있으니 String으로 받자
					int deptno = rs.getInt("deptno");
					
					
					//구한값 data배열에 담기			
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
				//System.out.println("접속실패");
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
