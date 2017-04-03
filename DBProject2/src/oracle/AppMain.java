package oracle;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class AppMain extends JFrame implements ItemListener{
	ConnectionManager manager;//��� ��ü�� �����ϱ� ���� ���� �����Ҷ� �ҷ��´�.
	Connection con;		//��� ��ü�� �����ϱ� ���� ���� �����Ҷ� �ҷ��´�.
	
	JTable table;
	JScrollPane scroll;
	JPanel p_west, p_center;
	Choice choice;
	String[][] item = {
		{"�����̺��� �����ϼ���",""},
		{"������̺�","emp"},
		{"�μ����̺�","dept"}
	};
	
	TableModel[] model = new TableModel[item.length];
	
	public AppMain() {
		//�����ΰ� ������ �и���Ű�� ���� �߰���(Controller)�� ���簡 �ʿ��ϴ�. 
		//JTable������ �� ��Ʈ�ѷ��� ������ TableModel�� ���ش�.
		//TableModel�� ����� ���, JTable�� �ڽ��� ������� �� �����͸� TableModel�� ���� ������ ���� ����Ѵ�.
		//getColumnCount()
		//getRowCount()
		//getValueAt()
		
		manager = ConnectionManager.getInstance();
		con = manager.getConnection();
		
		table = new JTable();
		scroll = new JScrollPane(table);
		p_west = new JPanel();
		p_center = new JPanel();
		choice = new Choice();
		
		//���̺� �𵨵��� �÷�����
		model[0] = new DefaultTableModel();
		model[1] = new EmpModel(con);
		model[2] = new DeptModel(con);		//�޸𸮿� �ö��״� �ּ����� ����
		//�ϳ��� �����ϸ� �ӵ��� ������.
		
		//���̽� ����
		for(int i=0;i<item.length;i++){
			choice.add(item[i][0]);
		}
		
		p_west.add(choice);	//west ������ �гο� ���̽� ����
		p_center.add(scroll);	//center ������ �гο� ��ũ�� ����
		
		add(p_west, BorderLayout.WEST);
		add(p_center);
			
		//���̺��� ������ �ֱ�
		//�Ʒ��� ���� �ڷᰡ �����Ǿ� �ִ� �ڵ��� ������������ �ſ� �������� ������ �ڵ��̴�.	
		/*table.setValueAt("���", 0, 0);
		table.setValueAt("��", 0, 1);		
		table.setValueAt("���", 1, 0);
		table.setValueAt("ƫ��", 1, 1);*/
				
		pack();
		
		//���̽��� ������ ����
		choice.addItemListener(this);
		
		//������ â ���� �� ����Ŭ ���� ����
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				//Ŀ�ؼ� �ݱ�
				manager.disConnect(con);
				
				//���α׷� ����
				System.exit(0);
			}
		});
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	//�ش�Ǵ� ���̺� �����ֱ�
	public void showData(int index){
		System.out.println("����� ���Ե� ���̺���"+item[index][1]);
		table.setModel(model[index]);
		
		//�ش�Ǵ� ���̺� ���� ����ϸ� �ȴ�
		//emp -> EmpModel
		//dept -> DeptModel
		//�ƹ��͵� �ƴϸ� -> DefaultTableModel
	}
	
	public void itemStateChanged(ItemEvent e) {
		Choice ch = (Choice)e.getSource();

		int index = ch.getSelectedIndex();		//���� ������ choice
		showData(index);
		
		
		
	}

	public static void main(String[] args) {
		new AppMain();

	}

}