/*
 	파일크기 file.length

 	파일크기 퍼센트 표기 286 : 100% = 5 : x%
 	x=100*읽은용량/ 총용량
 	파일 복사와 표기를 같이한다면 메인실행부가 둘다 하기 때문에
 	쓰레드를 나눠야한다.
 	
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
		bt_open = new JButton("열기");
		bt_save = new JButton("경로");
		bt_copy = new JButton("복사실행");
		t_open = new JTextField(25);
		t_save = new JTextField(25);
		p_open = new JPanel();
		p_save = new JPanel();
		
		//bar 사이즈 조절
		bar.setPreferredSize(new Dimension(380, 30));
		
		//붙이기
		add(bar);
		p_open.add(bt_open);
		p_open.add(t_open);
		p_save.add(bt_save);
		p_save.add(t_save);
		
		add(p_open);
		add(p_save);
		add(bt_copy);
		
		//버튼과 리스너 연결
		bt_open.addActionListener(this);
		bt_save.addActionListener(this);
		bt_copy.addActionListener(this);	
		
		//파일 추저 미리 올려놓기
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
	
	//파일 열기
	public void open(){
		int state = chooser.showOpenDialog(this);
		if(state == JFileChooser.APPROVE_OPTION){
			File file = chooser.getSelectedFile();
			String path = file.getAbsolutePath();
			
			t_open.setText(path);		
		}
	}
	
	//파일 경로설정
	public void save(){
		int state = chooser.showOpenDialog(this);
		if(state == JFileChooser.APPROVE_OPTION){
			File file = chooser.getSelectedFile();
			String path = file.getAbsolutePath();
			
			t_save.setText(path);
		}
	}
	
	//파일 복사
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
