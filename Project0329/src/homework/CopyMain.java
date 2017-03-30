/*
 	진행율 = 100%*현재내가 읽어들인 데이타/전체크기
 	 	
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
	JFileChooser chooser; // 매번 new하는것이 아니라 메모리에 올려두고 사용시마다 불러내는 것
	File file; // 읽어들일 파일. copy에서 파일형으로 사용하기 위해 꺼냄
	Thread thread; //복사를 실행할 전용쓰레드
							//메인 메서드는 우리가 알고 있는 그 실행부라 불리는 어플리케이션의 운영을 담당하는 역할을 수행한다.
							//따라서 절대 무한루프나 대기상태에 빠지게해서는 안된다.
	long total;	// 원본파일의 전체 용량
	
	public CopyMain() {
		bar = new JProgressBar();
		bt_open = new JButton("열기");
		bt_save = new JButton("저장");
		bt_copy = new JButton("복사실행");

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

		// 버튼과 리스너 연결
		bt_open.addActionListener(this);
		bt_save.addActionListener(this);
		bt_copy.addActionListener(this);

		setSize(500, 200);
		setVisible(true);
		setLocationRelativeTo(null); // 윈도우 화면의 위치 지정. 어떤것의 위치와 비교하여 생성하는 것이지만
										// 비교대상이 없는 단독 윈도우기 때문에 null을 준다.
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {
		// 이벤트를 일으킨 이벤트소스(이벤트주체)
		Object obj = e.getSource();
		// switch(obj){} //else if 문과 비슷한 기능

		if (obj == bt_open) {
			open();
		} else if (obj == bt_save) {
			save();
		} else if (obj == bt_copy) {
			//메인이 직접 복사를 수행하지 말고 쓰레드에게 시키자
			//쓰레드 생성자의 Runnable 구현객체를 인수로 넣으면 Runnable 객체에서 재정의한 run()메서드를 수행한다.
			thread = new Thread(this);
			thread.start();		//우리꺼 run 수행
			
		}
	}

	public void open() {
		int result = chooser.showOpenDialog(this);

		if (result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			t_open.setText(file.getAbsolutePath());
			total = file.length();	//length가 long형을 사용해야 하기 때문에 위에 total을 long으로 선언

		}
	}

	public void save() {
		int result = chooser.showOpenDialog(this);

		if (result == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();		
			//ㄴ여기서는 file을 재 생성하는 것이기 때문에 위에 메인변수로 선언된 file을 그대로 쓸 경우 다시 원본위치가 되어 버린다.
			//   그래서 지역변수로 다시 한 번 선언해야한다.
			t_save.setText(file.getAbsolutePath());
		}
	}

	public void copy() {		//메인쓰레드는 무한루프에 들어가면 안된다.
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file);
			fos = new FileOutputStream(t_save.getText());
			// 생성된 스트림을 통해 데이터 읽기
			int data;
			int count=0;
			
			while (true) {
				data = fis.read();// 1byte 읽기
				if (data == -1)break;
				count++;
				fos.write(data);// 1byte 출력
				int v = (int)getPercent(count);		//long형이지만 int로 강제 형변환 아래쪽 setValue가 int값만 원하기 때문에	
				//프로그래스바에 적용
				bar.setValue(v);		//v자리엔 int값만 들어가야한다.
				bar.setString(v+"%");
			}
			JOptionPane.showMessageDialog(this, "복사완료");
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

	public void run(){	//copy를 수행할 동생 쓰레드
		copy();
	}
	
	//현재 진행율 구하기 공식
	//진행율 = 100%*현재내가 읽어들인 데이타/전체크기
	public long getPercent(int currentRead){		//여기서 long자리에 void를 쓰지 않는다.
		return (100*currentRead)/total;				//파일이 현재 currentRead는 int형 이고 total은 long형이기 때문에 손실을 방지하기 위해 long으로 선언
	}
	
	
	public static void main(String[] args) {
		new CopyMain();

	}

}
