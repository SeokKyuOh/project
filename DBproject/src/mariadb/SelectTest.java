/*
	mariadb를 연동하여 레코드를 콘솔에 찍어 보자
	
	주의) dbms제조사가 제공하는 드라이버를 미리 준비하자
*/
package mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {
	String driver = "org.mariadb.jdbc.Driver";
	String url = "jdbc:mariadb://localhost:3306/db0331";	//이부분은 필요할때마다 검색가능
	String user = "root";
	String password = "";		//스페이스바로 공간 띄지 말 것
	Connection con = null;	//접속정보를 가진 인터페이스
	PreparedStatement pstmt;	//쿼리 수행 객체 그래서 접속에 의존적이다. 접속후에 수행해야함
	ResultSet rs;		//쿼리문이 select문일 경우 원격지의 데이터베이스의 테이블과 동일한 결과집합을 담아놓는 객체(=표와 같다)
							//서버에 떠있기만 하는 자료를 내 컴퓨터로 가져온다
		
	public SelectTest() {
		/*
			1. 드라이버를 로드
			2. 접속
			3. 원하는 쿼리문 실행
			4. db 관련된 자원 닫기
		*/

		try {
			Class.forName(driver);
			System.out.println("로드성공");
			
			con = DriverManager.getConnection(url, user, password);
			if(con !=null){
				System.out.println("접속성공");
				String sql="select * from member";		//콘솔창이 아니기때문에 ;찍지 않는다.
				
				pstmt=con.prepareStatement(sql);
				
				//쿼리 수행 후 반환되는 결과집합을 받자.
				//왜? select문이니까
				rs = pstmt.executeQuery();
				
				//커서 한칸 전진
				while(rs.next()){		//while문 안에 있는 것이 트루인 동안.
					int member_id = rs.getInt("member_id");
					String name = rs.getString("name");;			//컬럼에 해당하는 값 반환.		name이어서 getString이어야 한다.
					int age = rs.getInt("age");							//나이 반환 		나이는 숫자로 정해두어서 getint이어야 한다.
					System.out.println(member_id+","+name+","+age);
				}	
				
			}else{
				System.out.println("접속실패");
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
