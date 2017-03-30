package game.word;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GamePanel extends JPanel implements ItemListener, Runnable, ActionListener {
	GameWindow gameWindow;

	JPanel p_west; // 왼쪽 컨트롤 영역
	JPanel p_center; // 단어 그래픽 처리 영역

	JLabel la_user; // 게임 로그인 유저명
	JLabel la_score; // 게임 점수
	Choice choice; // 단어 선택 드랍박스
	JTextField t_input; // 게임 입력창
	JButton bt_start, bt_pause, bt_stop; // 게임 시작버튼
	String res = "C:/java_workspace2/Project0329/res/";

	FileInputStream fis;
	InputStreamReader reader;
	BufferedReader buffr; // 문자기반 버퍼 스트림
	
	//조사한 단어를 담아놓자! 게임에 써먹기 위해~!
	ArrayList<String> wordList = new ArrayList<String>();
	Thread thread;					//단어게임을 진행할 쓰레드
	boolean flag = true;			//run실행부의 while 문을 제어할 논리값
	boolean isDown = true;		//run 실행부 중 내려오는 값을 제어할 논리값
	
	ArrayList<Word> words = new ArrayList<Word>();
	

	public GamePanel(GameWindow gameWindow) {
		this.gameWindow = gameWindow;
		setLayout(new BorderLayout());
		p_west = new JPanel();
		
		//이 영역은 지금부터 그림을 그릴 영역 (글씨 쓰는 것도 그림그리는 것으로 처리)
		p_center = new JPanel(){
			public void paintComponent(Graphics g) {
				//기존 그림 지우기
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, 750, 700);
				
				//다시 그리기
				g.setColor(Color.BLUE);
				//모든 워드들에 대한 render()호출
				for(int i=0;i<words.size();i++){
					words.get(i).render(g);
				}
			}
		};

		la_user = new JLabel("오석규 님");
		la_score = new JLabel("0점");
		choice = new Choice();
		t_input = new JTextField(10);
		bt_start = new JButton("Start");
		bt_pause = new JButton("Pause");
		bt_stop = new JButton("종료");

		p_west.setPreferredSize(new Dimension(150, 700));
		p_west.setBackground(Color.YELLOW);

		choice.add("▼ 주제 선택");
		choice.setPreferredSize(new Dimension(125, 40));
		choice.addItemListener(this);

		p_west.add(la_user);
		p_west.add(choice);
		p_west.add(t_input);
		p_west.add(bt_start);
		p_west.add(bt_pause);
		p_west.add(bt_stop);
		p_west.add(la_score);
		

		add(p_west, BorderLayout.WEST);
		add(p_center);
		
		//버튼과 리스너 연결
		bt_start.addActionListener(this);
		bt_pause.addActionListener(this);
		bt_stop.addActionListener(this);
		
		//텍스트 필드와 리스너 연결
		t_input.addKeyListener(new KeyAdapter() {		//위에서 이미 액션리스너를 implements했으니 내부입력으로 가자
			
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					//화면에 존재하는 words와 입력값 비교하여 맞으면 words에서 객체 삭제
					String value = t_input.getText();
					for(int i=0;i<words.size();i++){		//wordList는 데이타베이스를 뽑아온 것에 불과하기 때문에 객체인 words를 비교해야한다.
						if(words.get(i).name.equals(value)){//값비교는 ==보다 equals을 쓰는 것이 더 정확하다.
							words.remove(i);
						};
						
					}
				}
			}
		});

		setVisible(false); // 최초엔 안보이게 하기 위해
		setPreferredSize(new Dimension(900, 700));

		getCategory();
		
	}

	// 초이스 컴포넌트에 채워질 파일명 조사하기
	public void getCategory() {
		File file = new File(res);
		// 파일 + 디렉토리 섞여있는 배열반환
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile()) {
				String name = files[i].getName(); // memo.txt
				String[] arr = name.split("\\.");
				if (arr[1].equals("txt")) { // 메모장이라면
					choice.add(name);
				}
			}
		}
	}

	// 단어 읽어오기
	public void getWord() {
		int index = choice.getSelectedIndex();
		if (index != 0) {// 첫번째 요소는 빼고..
			String name = choice.getSelectedItem();
			System.out.println(res + name);

			try {
				fis = new FileInputStream(res + name);
				reader = new InputStreamReader(fis, "utf-8"); // utf-8로 선언해야 한글이 안깨진다.
				// 스트림을 버퍼 처리 수준까지 업그레이드
				buffr = new BufferedReader(reader);
				String data; // readLine의 반환형이 String 형이라 String으로 선언
				
				//기존에 wordList를 비운다.
				wordList.removeAll(wordList);	//언제나 10개만 유지되도록
				
				while (true) {
					data = buffr.readLine();
					if (data == null)
						break;
					System.out.println(data);
					
					wordList.add(data);		//단어 조사한 것 담아주기
				}
				//준비된 단어를 화면에 보여주기	
				createWord();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (buffr != null) {
					try {
						buffr.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (reader != null) {
					try {
						reader.close();
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
	}
	
	public void createWord(){
		for(int i=0;i<wordList.size();i++){
			String name = wordList.get(i);		//반환형 string
			Word word = new Word(name, ((i*75)+10), 100);
			
			words.add(word);	//word 객체 명단 만들기
		}
	}
	
	//게임시작
	public void startGame(){
		if(thread == null){		//처음 start 버튼 눌렀을때만 실행되게
			flag=true;		//stop버튼 눌렀을때 false로 돌아간 while문을 다시 ture로 바꿔준다.
			thread = new Thread(this);	//Runnable을 구현자인 this를 넣어줘야 아래의 run실행부가 실행된다.
			thread.start();
		}
		
	}
	
	//게임중지
	public void pauseGame(){
		isDown = !isDown;
		
	}
	
	//게임종료
	/* --처음으로 돌아가자
		1.wordList(단어들이 들어있는) 지우기
		2.words(Word 인스턴스들이 들어있는) 지우기
		3.choice 초기화 (index = 0)
		4.flag=false
		5.thread를 null로 다시 초기화
	*/
	public void stopGame(){
		wordList.removeAll(wordList);		//반환값에 컬렉션프레임웍이 들어가야한다. wordList 자기자신을 넣는다.
		words.removeAll(words);
		choice.select(0);		//첫번째 요소 강제 선택
		flag=false;	//while문 중지 목적
		thread=null;	//thread를 null로 넣어줘야 다음에 다시 스타트했을때 시작할 수 있다.
	}

		
	public void itemStateChanged(ItemEvent e) {
		// system.out.println("눌렀니?");
		getWord();

	}
		
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == bt_start){
			startGame();
		}else if(obj == bt_pause){
			pauseGame();
		}else if(obj == bt_stop){
			stopGame();
		}
	}
	
	public void run() {		//게임의 심장부
		while(flag){		//항상 true 일경우 멈출 수 없으니 멈출수도 있게 변수로 놓자
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(isDown == true){
				//모든 단어들에 대해서 tick()
				for(int i=0;i<words.size();i++){
					words.get(i).tick();
				}
				//모든 단어들에 대해서 repaint()	
				p_center.repaint();
			}
		}
	}
}
