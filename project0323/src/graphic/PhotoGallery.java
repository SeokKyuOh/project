package graphic;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PhotoGallery extends JFrame implements ActionListener{
	JLabel l;
	Canvas can;
	JPanel p;
	JButton bt_prev, bt_next;
	Toolkit kit=Toolkit.getDefaultToolkit();
	Image img;
	String[] path={
		"C:/html_workspace/images/nation/brazil.jpg",
		"C:/html_workspace/images/nation/canada.jpg",
		"C:/html_workspace/images/nation/china.jpg",
		"C:/html_workspace/images/nation/france.jpg",
		"C:/html_workspace/images/nation/germany.jpg",		
		"C:/html_workspace/images/nation/italy.jpg",		
		"C:/html_workspace/images/nation/jamaica.jpg",		
		"C:/html_workspace/images/nation/japan.jpg",		
		"C:/html_workspace/images/nation/mexico.jpg",		
		"C:/html_workspace/images/nation/usa.jpg"	
	};
	int count=0;		//배열의 index		처음 시작 사진을 변경하려면 여기를 변경
	
	public PhotoGallery() {
		l = new JLabel(path[0]);
		img=kit.getImage(path[0]);
		
		can = new Canvas(){
			public void paint(Graphics g){
				g.drawImage(img, 0,0,600,600, this);	//켄버스가 이미지를 안고 있으니까~this
				//System.out.println("paint 호출");
			}	
		};
			
		p = new JPanel();
		bt_prev = new JButton("◀");
		bt_next = new JButton("▶");
				
		p.add(bt_prev);
		p.add(bt_next);
		
		can.setBackground(Color.YELLOW);
		
		add(l, BorderLayout.NORTH);
		add(can, BorderLayout.CENTER);
		add(p, BorderLayout.SOUTH);
		
		//버튼마다 연결
		bt_prev.addActionListener(this);
		bt_next.addActionListener(this);
		
		setSize(600,650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent e){	//여기서 e는 눌러서 발생한 이벤트 모두를 말한다. 현재 어떤것인지는 지정안되어있다
		//System.out.println(e);
		//경고창을 띄우는 법
		//JOptionPane.showMessageDialog(this, "누름?");
		
		//ActionEvent는 클릭뿐만 아니라, 여러행위를 아우르는 이벤트 객체이다.
		//따라서 버튼만 ActionEvent를 일으키는 게 아니다.
		//그래서 e.getSource() 호출하면, 어떤 컴포넌트가 이벤트를 일으켰는지 예측할 수 없으므로
		//Object형으로 반환해준다.
		Object obj = e.getSource();		//이벤트를 일으킨 컴포넌트
		JButton btn = (JButton)obj;		//형변환이 가능하다. 큰자료형에서 작은자료의 변환은 손실이 생기기 때문에 시스템은 항상 물어본다.
		
		if(btn == bt_prev){//주소값이 왼쪽이라면..
			//JOptionPane.showMessageDialog(this, "이전");		//this 자리에는 윈도우를 넣어야하는데 현재 지금은 나 자신이 프레임이 때문에 this라고 지칭한다.
			prev();
		}else if(btn == bt_next){
			//JOptionPane.showMessageDialog(this, "다음");
			next();
		}
		
	}
	//이전사진 보여주기
	public void prev(){
		count--;
		img=kit.getImage(path[count]);
		can.repaint();
		l.setText(path[count]);
	}
	
	//다음사진 보여주기
	public void next(){
		//이미지의 경로변경 + 라벨의 값도 변경
		count++;
		img=kit.getImage(path[count]);
		
		//개발자는 paint 메서드를 호출할 수 없다.
		//paint는 언제 호출되나?
		//유저가 해당 컴포넌트의 변경을 가할때 스스로 호출된다.
		//따라서 버튼을 누르게 되면, 켄버스의 변경을 가한적이 없기 때문에 paint메서드는 호출되지 않는다.
		//해결책) 켄버스의 paint메서드를 강제 호출해야하지만, 호출 불가이기 때문에 '간접' 호출해야한다.
		//시스템한테 paint 호출해달라고 요청해야한다.
		//repaint() -->update() -->paint()
		//update메서드는 기존 화면을 싹지운다.
		//paint메서드가 그림을 다시 그린다
		//따라서 이미지 용량이 큰 경우엔 우리 눈엔 깜빡거리는 효과가 나는 것이다.
		
		/////창을 늘리거나 줄일때마다 새롭게 다시 지우고 다시 그린다. -> 메모리를 많이 먹는다.
		/////이용자가 창을 변경하는 타이밍을 개발자가 알 수 없기 때문에 직접호출이 불가. 시스템이 스스로 판단한다.
		can.repaint();
		//라벤의 변경을 가하자
		l.setText(path[count]);
		
	}
	
	
	public static void main(String[] args) {
		new PhotoGallery();
	
	}

}
