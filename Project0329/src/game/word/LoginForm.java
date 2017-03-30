/*로그인 화면을 담당할 클래스 정의*/
package game.word;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm extends JPanel implements ActionListener { // 패널은 윈도우가 있어야 존재 가능
	GameWindow gameWindow;
	JPanel container; // BorderLayout 적용예정
	JPanel p_center; // GridLayout 적용 예정
	JPanel p_south; // 남쪽에 버튼이 들어갈 예정
	JLabel la_id, la_pw;
	JTextField t_id;
	JPasswordField t_pw;
	JButton bt;

	public LoginForm(GameWindow gameWindow) {
		this.gameWindow = gameWindow;
		container = new JPanel();
		p_center = new JPanel();
		p_south = new JPanel();
		la_id = new JLabel("ID");
		la_pw = new JLabel("Password");
		t_id = new JTextField("batman",15);
		t_pw = new JPasswordField("1234",15);
		bt = new JButton("LOG IN");

		container.setLayout(new BorderLayout());

		p_center.setLayout(new GridLayout(2, 2));
		p_center.add(la_id);
		p_center.add(t_id);
		p_center.add(la_pw);
		p_center.add(t_pw);
		p_south.add(bt);

		GamePanel gamePanel;
		
		container.add(p_center);
		container.add(p_south, BorderLayout.SOUTH);

		add(container);
		
		bt.addActionListener(this);
		
		setPreferredSize(new Dimension(400, 100));
		setBackground(Color.YELLOW);
	}
	public void loginCheck(){
		String id = t_id.getText();
		String pw = new String(t_pw.getPassword());	//char[] 배열을 반환한다.	String중에 char[]을 받아 사용하는 것이 있다.
		if(id.equals("batman") && pw.equals("1234")){
			JOptionPane.showMessageDialog(this, "로그인 성공");
			gameWindow.setPage(1);
			
		}else{
			JOptionPane.showMessageDialog(this, "로그인 정보가 올바르지 않습니다.");
		}//정보통신 가이드.. 로그인 실패시 아이디가 틀렸는지 비번이 틀렸는지 콕찝어 말하지 말자. 정보보안의 경우의 수를 줄이는 이 같은 방법은 해킹의 단초가 된다.
	}
	public void actionPerformed(ActionEvent e) {
		loginCheck();
	}

}
