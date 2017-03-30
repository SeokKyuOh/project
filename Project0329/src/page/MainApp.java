package page;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainApp extends JFrame implements ActionListener{
	JButton[] menu = new JButton[3];
	JPanel p_north;
	URL[] url = new URL[3];
	String[] path ={"/login.png","/content.png","/etc.png"};
	
	//���� ���������� �����Ѵ�.
	JPanel p_center;	//���������� ���� ��
	LoginForm loginForm;
	Content content;
	Etc etc;
	JPanel[] page = new JPanel[3];		//������ ��� �г��̱� ������ �迭�� ��Ƽ� ������� ��������
	
	public MainApp() {
		p_north = new JPanel();
		
		//for������ �迭ȭ�� ���� ���� ��ư �����
		for(int i=0;i<path.length;i++){
			url[i]=this.getClass().getResource(path[i]);
			menu[i] = new JButton(new ImageIcon(url[i]));
			p_north.add(menu[i]);
			menu[i].addActionListener(this);	//��ư�� ������ ����
		}
		
		add(p_north, BorderLayout.NORTH);

		p_center = new JPanel();
		page[0] = new LoginForm();//�α����� ����
		page[1] = new Content();//����Ʈ����
		page[2] = new Etc();
		
		p_center.add(page[0]);		//��� �г��̱� ������ �ٿ����Ѵ�.
		p_center.add(page[1]);		//BorderLayout�̸� ������ ���ο���� ���� ���������. �Բ� �����ϰ� ������� FlowLayout�����. 
		p_center.add(page[2]);		//�׷��� ���� �� �г��ʿ�
		
		add(p_center);
		
		setSize(700,600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		//�Ʒ��� �ڵ��� for�� ����
		for(int i=0;i<page.length;i++){
			if(obj == menu[i]){
				page[i].setVisible(true);
			}else{
				page[i].setVisible(false);
			}
		}
		
		/* �ӻ��� �ڵ�, ������������ �������� �ڵ�
		if(obj == menu[0]){
			page[0].setVisible(true); //�α����� o
			page[1].setVisible(false);//������ x
			page[2].setVisible(false);//��Ÿ x
			
		} else if(obj == menu[1]){
			page[0].setVisible(false);//�α����� x
			page[1].setVisible(true);//������ o
			page[2].setVisible(false);//��Ÿ x
			
		} else if(obj == menu[2]){
			page[0].setVisible(false);//�α����� x
			page[1].setVisible(false);//������ x
			page[2].setVisible(true);//��Ÿ o
		}
		*/
	}
	
	
	public static void main(String[] args) {
		new MainApp();

	}

}
