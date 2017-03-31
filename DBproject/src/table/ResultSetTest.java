/*
	레코드 결과를 배열로 받을 때의 단점
	레코드의 총 갯수를 알 수가 없다.
	
*/
package table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//jdbc = Java Data Base Connectivity=자바의 데이터 베이스 연동 기술
public class ResultSetTest {
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="batman";
	String password="1234";
	
	//아래의 삼총사는 모두 인터페이스, 구현 강제는 하되 내용은 각 개발사에서 채울 수 있게.
	Connection con;	//ms에서는 이게 접속시도 개체다. 그러나 다른 곳에서는 접속한 이후 그 결과를 담는 객체이다.
	PreparedStatement pstmt;
	ResultSet rs;
	
	//레코드셋 객체를 이용하여 총 레코드 수 알아맞춰 보기
	public ResultSetTest() {
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, user, password);
			if(con!=null){
				String sql="select * from company";
				
				//rs의 커서를 전방향, 후방향 등으로 자유롭게 움직이거나 함꺼번에 건너뛰게 하려면 스크롤 가능한 상수옵션을 부여해야한다.
				//select문의 결과집합을 대상으로 단지 보기만 할꺼면 READ_ONLY로. 수정을가할꺼면 UPDATABLE
				//하지만 선생님 경험상 SELECT문에 의한 코드는 대부분 읽기위함 이다.
				pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				rs=pstmt.executeQuery();
				
				rs.last();	//제일 마지막 레코드로 보내기
				int num = rs.getRow();	//현재 커서가 가리키는 레코드 번호. 즉 레코드 위치
				
				System.out.println(num);
				
			}
		} catch (ClassNotFoundException e) {		
			e.printStackTrace();
		} catch (SQLException e) {	
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ResultSetTest();

	}

}
