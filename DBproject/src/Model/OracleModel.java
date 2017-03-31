/*
 	이 객체는 JTable의 생성자에서 요구하는 컨트롤러 객체이다.
	이 객체의 역할은 디자인과 로직을 분리시켜주는 중간자 역할을 한다.
	JTable이 계속 나 뭐넣어야해?? 물어봄.
	JTable이 주체임
	JTable은 TableModel에 의존적임. 철썩같이 믿는다.
*/
package Model;

import javax.swing.table.AbstractTableModel;

public class OracleModel extends AbstractTableModel{
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="batman";
	String password="1234";
	
	String[][] data = new String[3][2];
	
	public OracleModel() {
		data[0][0]="짜장면";
		data[0][1]="북경반점";
		data[1][0]="샌드위치";
		data[1][1]="서브웨이";
		data[2][0]="핫크리스피 치킨";
		data[2][1]="KFC";
	}
	
	
	//컬럼의 갯수를 반환
	public int getColumnCount() {		
		return 2;
	}

	//레코드의 갯수를 반환
	public int getRowCount() {
		return 3;
	}

	//특정위치의 값을 반환
	public Object getValueAt(int row, int col) {
		//System.out.println("row="+row+",col"+col+"에 뭘 넣을까?");
		return data[row][col];
	}

}
