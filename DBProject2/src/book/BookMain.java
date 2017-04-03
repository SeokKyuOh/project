package book;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BookMain extends JFrame implements ItemListener, ActionListener{
	DBManager manager = DBManager.getInstance();
	Connection con;
	
	JPanel p_west;		//���� �����
	JPanel p_content;	//���� ���� ��ü
	JPanel p_north;		//���� ���� ��� ����
	JPanel p_table;		//JTable�� �ٿ��� �г�
	JPanel p_grid;		//�׸��� ������� ������ �г�
	Choice ch_top;
	Choice ch_sub;
	JTextField t_name;
	JTextField t_price;
	Canvas can;
	JButton bt_regist;
	CheckboxGroup group;
	Checkbox ch_table, ch_grid;
	Toolkit kit = Toolkit.getDefaultToolkit();		//��Ŷ�� �߻�Ŭ�������� new �ȵȴ�. ��� static���� �ø� �� �ִ�.
	Image img;
	JFileChooser chooser;
	
	
	public BookMain() {
		//setLayout(new FlowLayout());
		p_west = new JPanel();	
		p_content = new JPanel();
		p_north = new JPanel();
		p_table = new JPanel();
		p_grid = new JPanel();
		ch_top = new Choice();
		ch_sub = new Choice();
		t_name = new JTextField(12);
		t_price = new JTextField(12);
		URL url = this.getClass().getResource("/default.png");		//���ϴ� �̹����� �ִ� �������� bulid path�� use at source�� �����ΰ� ���
		
		try {
			img = ImageIO.read(url);
			System.out.println(img);
		} catch (IOException e) {	
			e.printStackTrace();
		}
		
		can = new Canvas(){
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, 140, 140, this);
			}
		};
		can.setPreferredSize(new Dimension(150, 150));
		
		bt_regist = new JButton("���");
		group = new CheckboxGroup();
		ch_table = new Checkbox("���̺�", true, group);
		ch_grid = new Checkbox("�׸���", false, group);
		
		//���� ���� �ø���
		chooser = new JFileChooser("C:/html_workspace/images");
		
		
		//ch_top.add("����");
		ch_top.setPreferredSize(new Dimension(130, 45));
		//ch_sub.add("����");
		ch_sub.setPreferredSize(new Dimension(130, 45));
		
		p_west.setPreferredSize(new Dimension(150, 600));
		p_west.setBackground(Color.WHITE);
		p_west.add(ch_top);
		p_west.add(ch_sub);
		p_west.add(t_name);
		p_west.add(t_price);
		p_west.add(can);
		p_west.add(bt_regist);

		p_north.add(ch_table);
		p_north.add(ch_grid);

		//p_content.setBackground(Color.RED);
		p_content.add(p_north);
		
		add(p_west, BorderLayout.WEST);
		add(p_content);
		
		init();
		
		ch_top.addItemListener(this);
		can.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				openFile();
				
			}
		});
		
		
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void init(){
		//���̽� ������Ʈ�� �ֻ��� ��� ���̱�
		con = manager.getConnection();
		String sql = "select * from topcategory";
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		try{
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				ch_top.add(rs.getString("category_name"));
			}
		} catch (SQLException e){
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
	
	//���� ī�װ� ��������
	public void getSub(String v){
		//������ �̹� ä���� �������� �ִٸ�, ���� ��~~�����.
		ch_sub.removeAll(); //���� ī�װ��� �����
		
		StringBuffer sb = new StringBuffer();
		sb.append("select * from subcategory");
		sb.append(" where topcategory_id=(");	//where ���� ��ĭ ����.. �ձ۰� �پ�����ϱ�
		sb.append(" select topcategory_id from");
		sb.append(" topcategory where category_name='"+v+"')");
		
		System.out.println(sb.toString());
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt=con.prepareStatement(sb.toString());		//sb�� stringbuffer ���̾ ����ȯ
			rs=pstmt.executeQuery();
			while(rs.next()){
				ch_sub.add(rs.getString("category_name"));
			}	
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
		
		//String sql="select * from subcategory";
		//sql+=" where topcategory_id=��������id";
		
	}
	
	public void itemStateChanged(ItemEvent e) {
		Choice ch = (Choice)e.getSource();
		getSub(ch.getSelectedItem());	//�ѱ��� �Ѿ���� ���ؼ� index�� �ƴ� item���� �Ѵ�.
	}
	
	//�׸����� �ҷ�����
	public void openFile(){
		int result = chooser.showOpenDialog(this);		//����ڰ� ��Ҵ������� Ȯ�� �������� �˱����� ���� �޴´�
		
		if(result == JFileChooser.APPROVE_OPTION){//����������
			//������ �̹����� canvas�� �׸� ���̴�.
			File file = chooser.getSelectedFile();		//��ȯ���� file�̴�.
			img = kit.getImage(file.getAbsolutePath());
			can.repaint();
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		e.getSource();	//object�� ��ȯ�޴� ����. ��ư�ϼ��� �����ϼ��� �ֱ� ����
		System.out.println("����?");
	}
	
	public static void main(String[] args) {
		new BookMain();
	 

	}

}
