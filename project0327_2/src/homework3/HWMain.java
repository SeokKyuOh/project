/*
 	����ũ�� file.length

 	����ũ�� �ۼ�Ʈ ǥ�� 286 : 100% = 5 : x%
 	x=100*�����뷮/ �ѿ뷮
 	���� ����� ǥ�⸦ �����Ѵٸ� ���ν���ΰ� �Ѵ� �ϱ� ������
 	�����带 �������Ѵ�.
 	
 */

package homework3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class HWMain extends JFrame implements ActionListener{
	JProgressBar bar;
	JPanel p_open, p_save;
	JButton bt_open, bt_save, bt_copy;
	JTextField t_open, t_save;
	FileInputStream fis;
	FileOutputStream fos;
	JFileChooser chooser;
	
	HWMain hwMain;
	
	int count;
	
	public HWMain() {
		setLayout(new FlowLayout());
		bar = new JProgressBar(0,100);
		bt_open = new JButton("����");
		bt_save = new JButton("���");
		bt_copy = new JButton("�������");
		t_open = new JTextField(25);
		t_save = new JTextField(25);
		p_open = new JPanel();
		p_save = new JPanel();
		
		//bar ������ ����
		bar.setPreferredSize(new Dimension(380, 30));
		
		//���̱�
		add(bar);
		p_open.add(bt_open);
		p_open.add(t_open);
		p_save.add(bt_save);
		p_save.add(t_save);
		
		add(p_open);
		add(p_save);
		add(bt_copy);
		
		//��ư�� ������ ����
		bt_open.addActionListener(this);
		bt_save.addActionListener(this);
		bt_copy.addActionListener(this);	
		
		//���� ���� �̸� �÷�����
		chooser = new JFileChooser("C:/java_workspace2/project0323/");
		
		setSize(450, 250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
					
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == bt_open){
			open();
		}
		if(obj == bt_save){
			save();
		}
		if(obj == bt_copy){
			copy();
		}	
	}
	
	//���� ����
	public void open(){
		int state = chooser.showOpenDialog(this);
		if(state == JFileChooser.APPROVE_OPTION){
			File file = chooser.getSelectedFile();
			String path = file.getAbsolutePath();
			
			t_open.setText(path);		
		}
	}
	
	//���� ��μ���
	public void save(){
		int state = chooser.showOpenDialog(this);
		if(state == JFileChooser.APPROVE_OPTION){
			File file = chooser.getSelectedFile();
			String path = file.getAbsolutePath();
			
			t_save.setText(path);
		}
	}
	
	//���� ����
	public void copy(){
		hwMain=this;
		
		HWCopy hwc = new HWCopy(hwMain);
		hwc.start();
		
		//count+=((100*hwc.data)/hwc.data.length);
		//bar.setValue(count);
		
	
	}
	

	public static void main(String[] args) {
		new HWMain();
		

	}

}
;
