/*
 	������ = 100%*���系�� �о���� ����Ÿ/��üũ��
 	 	
 */
package homework;

import java.awt.Color;
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
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class CopyMain extends JFrame implements ActionListener, Runnable{
	JProgressBar bar;
	JButton bt_open, bt_save, bt_copy;
	JTextField t_open, t_save;
	JFileChooser chooser; // �Ź� new�ϴ°��� �ƴ϶� �޸𸮿� �÷��ΰ� ���ø��� �ҷ����� ��
	File file; // �о���� ����. copy���� ���������� ����ϱ� ���� ����
	Thread thread; //���縦 ������ ���뾲����
							//���� �޼���� �츮�� �˰� �ִ� �� ����ζ� �Ҹ��� ���ø����̼��� ��� ����ϴ� ������ �����Ѵ�.
							//���� ���� ���ѷ����� �����¿� �������ؼ��� �ȵȴ�.
	long total;	// ���������� ��ü �뷮
	
	public CopyMain() {
		bar = new JProgressBar();
		bt_open = new JButton("����");
		bt_save = new JButton("����");
		bt_copy = new JButton("�������");

		t_open = new JTextField(35);
		t_save = new JTextField(35);
		chooser = new JFileChooser("C:/html_workspace/images");

		bar.setPreferredSize(new Dimension(450, 50));
		//bar.setBackground(Color.YELLOW);
		bar.setString("0%");
		bar.setStringPainted(true);

		setLayout(new FlowLayout());

		add(bar);
		add(bt_open);
		add(t_open);
		add(bt_save);
		add(t_save);
		add(bt_copy);

		// ��ư�� ������ ����
		bt_open.addActionListener(this);
		bt_save.addActionListener(this);
		bt_copy.addActionListener(this);

		setSize(500, 200);
		setVisible(true);
		setLocationRelativeTo(null); // ������ ȭ���� ��ġ ����. ����� ��ġ�� ���Ͽ� �����ϴ� ��������
										// �񱳴���� ���� �ܵ� ������� ������ null�� �ش�.
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {
		// �̺�Ʈ�� ����Ų �̺�Ʈ�ҽ�(�̺�Ʈ��ü)
		Object obj = e.getSource();
		// switch(obj){} //else if ���� ����� ���

		if (obj == bt_open) {
			open();
		} else if (obj == bt_save) {
			save();
		} else if (obj == bt_copy) {
			//������ ���� ���縦 �������� ���� �����忡�� ��Ű��
			//������ �������� Runnable ������ü�� �μ��� ������ Runnable ��ü���� �������� run()�޼��带 �����Ѵ�.
			thread = new Thread(this);
			thread.start();		//�츮�� run ����
			
		}
	}

	public void open() {
		int result = chooser.showOpenDialog(this);

		if (result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			t_open.setText(file.getAbsolutePath());
			total = file.length();	//length�� long���� ����ؾ� �ϱ� ������ ���� total�� long���� ����

		}
	}

	public void save() {
		int result = chooser.showOpenDialog(this);

		if (result == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();		
			//�����⼭�� file�� �� �����ϴ� ���̱� ������ ���� ���κ����� ����� file�� �״�� �� ��� �ٽ� ������ġ�� �Ǿ� ������.
			//   �׷��� ���������� �ٽ� �� �� �����ؾ��Ѵ�.
			t_save.setText(file.getAbsolutePath());
		}
	}

	public void copy() {		//���ξ������ ���ѷ����� ���� �ȵȴ�.
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file);
			fos = new FileOutputStream(t_save.getText());
			// ������ ��Ʈ���� ���� ������ �б�
			int data;
			int count=0;
			
			while (true) {
				data = fis.read();// 1byte �б�
				if (data == -1)break;
				count++;
				fos.write(data);// 1byte ���
				int v = (int)getPercent(count);		//long�������� int�� ���� ����ȯ �Ʒ��� setValue�� int���� ���ϱ� ������	
				//���α׷����ٿ� ����
				bar.setValue(v);		//v�ڸ��� int���� �����Ѵ�.
				bar.setString(v+"%");
			}
			JOptionPane.showMessageDialog(this, "����Ϸ�");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void run(){	//copy�� ������ ���� ������
		copy();
	}
	
	//���� ������ ���ϱ� ����
	//������ = 100%*���系�� �о���� ����Ÿ/��üũ��
	public long getPercent(int currentRead){		//���⼭ long�ڸ��� void�� ���� �ʴ´�.
		return (100*currentRead)/total;				//������ ���� currentRead�� int�� �̰� total�� long���̱� ������ �ս��� �����ϱ� ���� long���� ����
	}
	
	
	public static void main(String[] args) {
		new CopyMain();

	}

}
