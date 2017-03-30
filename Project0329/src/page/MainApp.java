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
	
	//만든 페이지들을 보유한다.
	JPanel p_center;	//페이지들이 붙을 곳
	LoginForm loginForm;
	Content content;
	Etc etc;
	JPanel[] page = new JPanel[3];		//폼들은 모두 패널이기 때문에 배열로 담아서 순서대로 관리하자
	
	public MainApp() {
		p_north = new JPanel();
		
		//for문으로 배열화된 재료들 합쳐 버튼 만들기
		for(int i=0;i<path.length;i++){
			url[i]=this.getClass().getResource(path[i]);
			menu[i] = new JButton(new ImageIcon(url[i]));
			p_north.add(menu[i]);
			menu[i].addActionListener(this);	//버튼과 리스너 연결
		}
		
		add(p_north, BorderLayout.NORTH);

		p_center = new JPanel();
		page[0] = new LoginForm();//로그인폼 생성
		page[1] = new Content();//컨텐트생성
		page[2] = new Etc();
		
		p_center.add(page[0]);		//얘두 패널이기 때문에 붙여야한다.
		p_center.add(page[1]);		//BorderLayout이면 생성시 새로운것이 위에 덮어버린다. 함께 공존하게 만들려면 FlowLayout써야함. 
		p_center.add(page[2]);		//그러기 위해 또 패널필요
		
		add(p_center);
		
		setSize(700,600);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		//아래의 코드의 for문 버전
		for(int i=0;i<page.length;i++){
			if(obj == menu[i]){
				page[i].setVisible(true);
			}else{
				page[i].setVisible(false);
			}
		}
		
		/* 속상한 코드, 유지보수성이 떨어지는 코드
		if(obj == menu[0]){
			page[0].setVisible(true); //로그인폼 o
			page[1].setVisible(false);//컨텐츠 x
			page[2].setVisible(false);//기타 x
			
		} else if(obj == menu[1]){
			page[0].setVisible(false);//로그인폼 x
			page[1].setVisible(true);//컨텐츠 o
			page[2].setVisible(false);//기타 x
			
		} else if(obj == menu[2]){
			page[0].setVisible(false);//로그인폼 x
			page[1].setVisible(false);//컨텐츠 x
			page[2].setVisible(true);//기타 o
		}
		*/
	}
	
	
	public static void main(String[] args) {
		new MainApp();

	}

}
