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
	
	String ori="C:/java_workspace2/project0327_2/res/memo.txt";//원본
	String dest="C:/java_workspace2/project0327_2/res/memo_copy.txt";//다른파일의 저장경로	
	FileInputStream fis;
	FileOutputStream fos;
	
	InputStreamReader reader;	//문자기반 입력스트림
	BufferedReader buffr;		//버퍼처리된 문자기반 입력스트림
	//ㄴ속도향상을 위해 한줄씩 처리하는 것을 BufferStream이라고 한다.
	
	//문자기반의 출력스트림
	OutputStreamWriter writer;
	PrintWriter writer2;	//문자기반의 출력스트림
	
	
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
		

		//버튼 2개 내부익명으로가자
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
	
	//저장하기
	public void open() {
		try {
			fis=new FileInputStream(ori);
			//문자기반 스트림에는 문자인코딩 속성을 지정할 수 있다.
			
			reader = new InputStreamReader(fis,"utf-8");	//fis를 utf-8로 읽어들인다.
			buffr = new BufferedReader(reader);		//reader 계열을 먹을 수 있다. InputStreamReader도 Reader계열
			
			String data;	//버퍼는 한줄씩 읽고 string을 받기 때문에 int data가아닌 string data로 받는다.
			int count=0;	//read 횟수를 알기위해
			
			while(true){
				data = buffr.readLine(); //1byte씩 읽어들인다.
				count++;
				/*
				if(data==-1)break;
				area.append(Character.toString((char)data));
				*/
				if(data==null)break;		//string은 객체이기 때문에 디폴트 값은 null이 되어야 한다.
				area.append(data+"\n");	//객체이기 때문에 따로 변환을 줄 필요없다. 쭉 붙기 때문에 "\n"을 붙여준다.
			}
			System.out.println("count="+count);
					
		} catch (FileNotFoundException e) {
			e.printStackTrace(); //개발자를 위한 에러 로그정보, 에러가 콘솔창에 스택구조로 쌓임 안쓰면 개발자에게 안보인다.
			JOptionPane.showMessageDialog(this, "파일이 존재하지 않습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void save() {
		//지정한 경로의 파일을 생성한다.
		try{
			fos = new FileOutputStream(dest);
			//writer = new OutputStreamWriter(fos, "uft-8");
			
			writer2 = new PrintWriter(fos);
			writer2.write(area.getText());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {	//입출력시 에러방지
			e.printStackTrace();	
		}finally{	//빨대 하나만 닫아도 다 닫히지만 명시적으로 각각 닫아주는 것이 좋다.
			//열어놓은 스트림은 전부 닫는 처리
			if(writer2 !=null){//존재한다면 닫는다
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