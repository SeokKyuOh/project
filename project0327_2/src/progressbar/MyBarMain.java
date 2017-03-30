package progressbar;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class MyBarMain extends JFrame{
	JProgressBar[] bar = new JProgressBar[3];
	Mybar[] mb = new Mybar[3];
	int[] interval={100,500,100};
	
	JButton bt;
	int count;
	
	public MyBarMain() {
		setLayout(new FlowLayout());
		
		for(int i=0;i<bar.length;i++){
			bar[i] = new JProgressBar();
			mb[i] = new Mybar(bar[i], interval[i]);
			bar[i].setPreferredSize(new Dimension(450, 40));
			add(bar[i]);
		}
		
		
		bt = new JButton("ÀÛµ¿");
		
		add(bt);
		
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
			}
		});
		
		setSize(500, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
	}
	
	public static void main(String[] args) {
		new MyBarMain();

	}

}
