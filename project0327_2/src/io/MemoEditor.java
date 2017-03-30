package io;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemoEditor extends JFrame{
	JPanel p;
	JButton bt_open, bt_save;
	ImageIcon icon_open, icon_close;
	JTextArea area;
	JScrollPane scroll;
	
	String ori="C:/java_workspace2/project0327_2/res/memo.txt";//����
	String dest="C:/java_workspace2/project0327_2/res/memo_copy.txt";//�ٸ������� ������	
	FileInputStream fis;
	FileOutputStream fos;
	
	InputStreamReader reader;	//���ڱ�� �Է½�Ʈ��
	BufferedReader buffr;		//����ó���� ���ڱ�� �Է½�Ʈ��
	//���ӵ������ ���� ���پ� ó���ϴ� ���� BufferStream�̶�� �Ѵ�.
	
	//���ڱ���� ��½�Ʈ��
	OutputStreamWriter writer;
	PrintWriter writer2;	//���ڱ���� ��½�Ʈ��
	
	
	public MemoEditor() {
		p=new JPanel();
		icon_open = new ImageIcon("C:/java_workspace2/project0327_2/res/folder_open.png");
		icon_close = new ImageIcon("C:/java_workspace2/project0327_2/res/folder_close.png");
		bt_open=new JButton(icon_open);
		bt_save=new JButton(icon_close);
		area=new JTextArea(30, 20);
		scroll=new JScrollPane(area);
		
		p.add(bt_open);
		p.add(bt_save);
		
		add(p, BorderLayout.NORTH);
		add(scroll);
		
		/*
		bt_open.setBorderPainted(false);
		bt_open.setContentAreaFilled(false);
		bt_open.setFocusPainted(false);
		bt_open.setOpaque(false);
		*/
		

		//��ư 2�� �����͸����ΰ���
		bt_open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});
		
		bt_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		
		setSize(700, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}
	
	//�����ϱ�
	public void open() {
		try {
			fis=new FileInputStream(ori);
			//���ڱ�� ��Ʈ������ �������ڵ� �Ӽ��� ������ �� �ִ�.
			
			reader = new InputStreamReader(fis,"utf-8");	//fis�� utf-8�� �о���δ�.
			buffr = new BufferedReader(reader);		//reader �迭�� ���� �� �ִ�. InputStreamReader�� Reader�迭
			
			String data;	//���۴� ���پ� �а� string�� �ޱ� ������ int data���ƴ� string data�� �޴´�.
			int count=0;	//read Ƚ���� �˱�����
			
			while(true){
				data = buffr.readLine(); //1byte�� �о���δ�.
				count++;
				/*
				if(data==-1)break;
				area.append(Character.toString((char)data));
				*/
				if(data==null)break;		//string�� ��ü�̱� ������ ����Ʈ ���� null�� �Ǿ�� �Ѵ�.
				area.append(data+"\n");	//��ü�̱� ������ ���� ��ȯ�� �� �ʿ����. �� �ٱ� ������ "\n"�� �ٿ��ش�.
			}
			System.out.println("count="+count);
					
		} catch (FileNotFoundException e) {
			e.printStackTrace(); //�����ڸ� ���� ���� �α�����, ������ �ܼ�â�� ���ñ����� ���� �Ⱦ��� �����ڿ��� �Ⱥ��δ�.
			JOptionPane.showMessageDialog(this, "������ �������� �ʽ��ϴ�.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void save() {
		//������ ����� ������ �����Ѵ�.
		try{
			fos = new FileOutputStream(dest);
			//writer = new OutputStreamWriter(fos, "uft-8");
			
			writer2 = new PrintWriter(fos);
			writer2.write(area.getText());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {	//����½� ��������
			e.printStackTrace();	
		}finally{	//���� �ϳ��� �ݾƵ� �� �������� ��������� ���� �ݾ��ִ� ���� ����.
			//������� ��Ʈ���� ���� �ݴ� ó��
			if(writer2 !=null){//�����Ѵٸ� �ݴ´�
				writer2.close();
			}	
			if(fos !=null){
				try{
					fos.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}	
	}
	
	public static void main(String[] args) {
		new MemoEditor();
	}

}