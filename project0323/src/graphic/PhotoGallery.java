package graphic;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PhotoGallery extends JFrame implements ActionListener{
	JLabel l;
	Canvas can;
	JPanel p;
	JButton bt_prev, bt_next;
	Toolkit kit=Toolkit.getDefaultToolkit();
	Image img;
	String[] path={
		"C:/html_workspace/images/nation/brazil.jpg",
		"C:/html_workspace/images/nation/canada.jpg",
		"C:/html_workspace/images/nation/china.jpg",
		"C:/html_workspace/images/nation/france.jpg",
		"C:/html_workspace/images/nation/germany.jpg",		
		"C:/html_workspace/images/nation/italy.jpg",		
		"C:/html_workspace/images/nation/jamaica.jpg",		
		"C:/html_workspace/images/nation/japan.jpg",		
		"C:/html_workspace/images/nation/mexico.jpg",		
		"C:/html_workspace/images/nation/usa.jpg"	
	};
	int count=0;		//�迭�� index		ó�� ���� ������ �����Ϸ��� ���⸦ ����
	
	public PhotoGallery() {
		l = new JLabel(path[0]);
		img=kit.getImage(path[0]);
		
		can = new Canvas(){
			public void paint(Graphics g){
				g.drawImage(img, 0,0,600,600, this);	//�˹����� �̹����� �Ȱ� �����ϱ�~this
				//System.out.println("paint ȣ��");
			}	
		};
			
		p = new JPanel();
		bt_prev = new JButton("��");
		bt_next = new JButton("��");
				
		p.add(bt_prev);
		p.add(bt_next);
		
		can.setBackground(Color.YELLOW);
		
		add(l, BorderLayout.NORTH);
		add(can, BorderLayout.CENTER);
		add(p, BorderLayout.SOUTH);
		
		//��ư���� ����
		bt_prev.addActionListener(this);
		bt_next.addActionListener(this);
		
		setSize(600,650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent e){	//���⼭ e�� ������ �߻��� �̺�Ʈ ��θ� ���Ѵ�. ���� ��������� �����ȵǾ��ִ�
		//System.out.println(e);
		//���â�� ���� ��
		//JOptionPane.showMessageDialog(this, "����?");
		
		//ActionEvent�� Ŭ���Ӹ� �ƴ϶�, ���������� �ƿ츣�� �̺�Ʈ ��ü�̴�.
		//���� ��ư�� ActionEvent�� ����Ű�� �� �ƴϴ�.
		//�׷��� e.getSource() ȣ���ϸ�, � ������Ʈ�� �̺�Ʈ�� �����״��� ������ �� �����Ƿ�
		//Object������ ��ȯ���ش�.
		Object obj = e.getSource();		//�̺�Ʈ�� ����Ų ������Ʈ
		JButton btn = (JButton)obj;		//����ȯ�� �����ϴ�. ū�ڷ������� �����ڷ��� ��ȯ�� �ս��� ����� ������ �ý����� �׻� �����.
		
		if(btn == bt_prev){//�ּҰ��� �����̶��..
			//JOptionPane.showMessageDialog(this, "����");		//this �ڸ����� �����츦 �־���ϴµ� ���� ������ �� �ڽ��� �������� ������ this��� ��Ī�Ѵ�.
			prev();
		}else if(btn == bt_next){
			//JOptionPane.showMessageDialog(this, "����");
			next();
		}
		
	}
	//�������� �����ֱ�
	public void prev(){
		count--;
		img=kit.getImage(path[count]);
		can.repaint();
		l.setText(path[count]);
	}
	
	//�������� �����ֱ�
	public void next(){
		//�̹����� ��κ��� + ���� ���� ����
		count++;
		img=kit.getImage(path[count]);
		
		//�����ڴ� paint �޼��带 ȣ���� �� ����.
		//paint�� ���� ȣ��ǳ�?
		//������ �ش� ������Ʈ�� ������ ���Ҷ� ������ ȣ��ȴ�.
		//���� ��ư�� ������ �Ǹ�, �˹����� ������ �������� ���� ������ paint�޼���� ȣ����� �ʴ´�.
		//�ذ�å) �˹����� paint�޼��带 ���� ȣ���ؾ�������, ȣ�� �Ұ��̱� ������ '����' ȣ���ؾ��Ѵ�.
		//�ý������� paint ȣ���ش޶�� ��û�ؾ��Ѵ�.
		//repaint() -->update() -->paint()
		//update�޼���� ���� ȭ���� �������.
		//paint�޼��尡 �׸��� �ٽ� �׸���
		//���� �̹��� �뷮�� ū ��쿣 �츮 ���� �����Ÿ��� ȿ���� ���� ���̴�.
		
		/////â�� �ø��ų� ���϶����� ���Ӱ� �ٽ� ����� �ٽ� �׸���. -> �޸𸮸� ���� �Դ´�.
		/////�̿��ڰ� â�� �����ϴ� Ÿ�̹��� �����ڰ� �� �� ���� ������ ����ȣ���� �Ұ�. �ý����� ������ �Ǵ��Ѵ�.
		can.repaint();
		//���� ������ ������
		l.setText(path[count]);
		
	}
	
	
	public static void main(String[] args) {
		new PhotoGallery();
	
	}

}
