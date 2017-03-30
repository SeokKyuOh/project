package progressbar;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressBarTest extends JFrame{
	JProgressBar bar1, bar2, bar3;
	//JProgressBar[] bar
	JButton bt;
	
	
	public ProgressBarTest() {
		setLayout(new FlowLayout());
		bar1 = new JProgressBar();
		bar2 = new JProgressBar();
		bar3 = new JProgressBar();
		
		bt = new JButton("작동");
		
		//바 사이즈 늘리기. 강제로 늘리기 위해서 setPreferredSize 사용해야 한다
		bar1.setPreferredSize(new Dimension(450, 40));
		bar2.setPreferredSize(new Dimension(450, 40));
		bar3.setPreferredSize(new Dimension(450, 40));
		
		add(bar1);
		add(bar2);
		add(bar3);
		add(bt);
		
		BarThread1 bt1 = new BarThread1(bar1, 100);
		BarThread1 bt2 = new BarThread1(bar2, 300);
		BarThread1 bt3 = new BarThread1(bar3, 500);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bt1.start();
				bt2.start();
				bt3.start();
				
			}
		});
		
		setSize(500, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
	}
	
	public static void main(String[] args) {
		new ProgressBarTest();

	}

}
