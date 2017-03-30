package game.word;

import java.awt.Color;
import java.awt.FlowLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;

//이 윈도우는 크기가 결정되어있지 않아야 한다.
//왜? 윈도우 안에 들어오게 될 패널이 그 크기를 결정하기 때문이다.
//로그인 기능일 때는 작게, 게임 본 화면에서는 크게 만들어야하기 때문임
public class GameWindow extends JFrame {
	LoginForm loginForm; // 미리보유
	GamePanel gamePanel; // 미리보유

	JPanel[] page = new JPanel[2]; // 로그인 폼과 게임패널을 배열로 담을 패널을 생성하자

	public GameWindow() {
		setLayout(new FlowLayout());

		page[0] = new LoginForm(this);
		page[1] = new GamePanel(this);
		add(page[0]);
		add(page[1]);

		setPage(0);

		setVisible(true);
		setBackground(Color.YELLOW);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	// 윈도우안에 어떤 패널이 올지를 결정해주는 메서드 정의
	public void setPage(int index) {
		for (int i = 0; i < page.length; i++) {
			if (i == index) {
				page[i].setVisible(true);
			}else{
				page[i].setVisible(false);
			}
		}
		pack(	); // 내용물의 크기만큼 윈도우크기를 설정한다. 이걸 안하고 사이즈 설정 안할경우 확 쪼그라듬
		setLocationRelativeTo(null);//화면 중앙. 여기서 배치 하지 않으면 로그인 폼에서부터 위치 시작한다.
		
		
	}
	


	public static void main(String[] args) {
		new GameWindow();

	}

}
