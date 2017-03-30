package game.word;

import java.awt.Color;
import java.awt.FlowLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;

//�� ������� ũ�Ⱑ �����Ǿ����� �ʾƾ� �Ѵ�.
//��? ������ �ȿ� ������ �� �г��� �� ũ�⸦ �����ϱ� �����̴�.
//�α��� ����� ���� �۰�, ���� �� ȭ�鿡���� ũ�� �������ϱ� ������
public class GameWindow extends JFrame {
	LoginForm loginForm; // �̸�����
	GamePanel gamePanel; // �̸�����

	JPanel[] page = new JPanel[2]; // �α��� ���� �����г��� �迭�� ���� �г��� ��������

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

	// ������ȿ� � �г��� ������ �������ִ� �޼��� ����
	public void setPage(int index) {
		for (int i = 0; i < page.length; i++) {
			if (i == index) {
				page[i].setVisible(true);
			}else{
				page[i].setVisible(false);
			}
		}
		pack(	); // ���빰�� ũ�⸸ŭ ������ũ�⸦ �����Ѵ�. �̰� ���ϰ� ������ ���� ���Ұ�� Ȯ �ɱ׶��
		setLocationRelativeTo(null);//ȭ�� �߾�. ���⼭ ��ġ ���� ������ �α��� ���������� ��ġ �����Ѵ�.
		
		
	}
	


	public static void main(String[] args) {
		new GameWindow();

	}

}
