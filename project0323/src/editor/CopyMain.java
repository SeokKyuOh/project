package editor;

import java.awt.FlowLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;



public class CopyMain extends JFrame implements ActionListener{
	JButton bt_open, bt_save, bt_copy;
	JTextField t_open, t_save;
	FileInputStream fis;		//파일을 대상으로 한 입력스트림
	FileOutputStream fos;	//파일을 대상으로 한 출력스트림

	//파일 탐색기를 처리하는 객체
	JFileChooser chooser;
	
	public CopyMain() {
		bt_open = new JButton("원본경로");
		bt_save = new JButton("저장경로");
		bt_copy = new JButton("복사실행");
		
		t_open = new JTextField(30);
		t_save = new JTextField(30);
		
		setLayout(new FlowLayout());
		
		add(bt_open);
		add(t_open);
		add(bt_save);
		add(t_save);
		add(bt_copy);
		
		//버튼과 리스너와 연결
		bt_open.addActionListener(this);
		bt_save.addActionListener(this);
		bt_copy.addActionListener(this);

		//파일 추저를 미리 올려놓자
		//디폴트 디렉토리를 지정하면 편하다.
		chooser = new JFileChooser("C:/java_workspace2/project0323/");

		setSize(475,180);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//ㄴ 이 명령어를 수행하게 된다면. 스트림이 제거되기 전에도 꺼질 수 있는 여지가 있다.
		//	  그래서 윈도우 리스너를 이용하여 창이 꺼질때 스트림도 제거할 수 있는 코드를 작성하자
		
	}

	public void actionPerformed(ActionEvent e){//발생하는 이벤트는 얘만 알 수 있다.
		Object obj=e.getSource();	//이벤트 소스를 반환받는다. 소스는 모든 형태로부터 받을 수 있기 때문에 오브젝트임

		if(obj == bt_open){
			open();

		}else if(obj == bt_save){
			int state = chooser.showSaveDialog(this);
			//System.out.println(state);
			//상수는 인간에게 직관성을 부여해준다.
			//왜? 영어단어를 이용하니깐
			if(state == JFileChooser.APPROVE_OPTION){
				//저장 경로를 텍스트필드에 출력
				File file = chooser.getSelectedFile();		//파일은 범위가 더 큰 파일형
				
				//파일 클래스가 보유한 절대경로 메서드를 이용하여 경로반환
				String path = file.getAbsolutePath();
				
				t_save.setText(path);
				
			}
			
		}else if(obj == bt_copy){
			copy();
			
		}
	}
	
	//파일 열기
	public void open(){
		int state = chooser.showOpenDialog(this);//필요한 요소가 Component parent 여서 윈도우가 필요하다 그래서 this
		if(state == JFileChooser.APPROVE_OPTION){
			//유저가 선택한 파일에 대한 파일 클래스 인스턴스 얻기
			File file = chooser.getSelectedFile();
			//얻어진 인스턴스를 이용하여 절대경로 얻기
			String path = file.getAbsolutePath();
			
			//절대경로 텍스트 필드에 뿌리기
			t_open.setText(path);
			
			
		}

	}
	
	//복사하기 메서드를 따로만들자 활용성을 높이기 위해
	public void copy(){
		//원본파일에 스트림 생성하여 데이터를 들이마시자
		//들어오는 데이터를 목적 파일에 내려쓰자
		String oriPath = t_open.getText();	//오리지날 경로
		String destPath = t_save.getText();	//목적지 경로

		try{
			fis = new FileInputStream(oriPath);
			fos = new FileOutputStream(destPath);
			
			int data;		//값을 굳이 주자면 -1로 준다. 여기서 -1은 아무것도 없다는 뜻이니까. int data=-1;
			while(true){
				data = fis.read();	// 현재 실행중인 프로그램으로 1byte 읽어들임

				if(data == -1) break;
				fos.write(data);		//이걸 위에 적을경우 -1인지 확인 전에 쓰는 것이기 때문에 -1일때 파일이 망가짐
			}
			JOptionPane.showMessageDialog(this, "복사완료");

			//스트림을 닫자
			//try문안에서 닫을 경우 문제점
			//fis.close();		//fos에서 뻑나면 바로 FileNotFoundException으로 넘어가기 때문에 이부분이 실행 x
								//그래서 빨대가 남아있는다.
								//catch문에 넣어도 완료되었을 경우엔 catch문을 지나가버리기 때문에 finally에 넣어야한다.

		}catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(this, "파일을 찾을 수 없습니다.");	
			//ㄴ얘는 윈도우 창이 아니고 다이얼로그 창이다. 얘가 살아갈 곳은 this
		}catch(IOException e){
			JOptionPane.showMessageDialog(this, "IO작업 중 에러가 발생했습니다.");	
		}finally{		//실행되던 에러나던 무조건 실행
			try{		//finally에서도 try, catch문을 사용해야 한다.
				//객체가 메모리에 올라왔다면~
				if(fis!=null){
					fis.close();
				}
				if(fos!=null){
					fos.close();
				}
			}catch(IOException e){
			}
		}
	}



	public static void main(String[] args) {
		new CopyMain();

	}

}
