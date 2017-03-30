package file;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FileExplorer extends JFrame{
	JPanel p_north, p_center;
	JButton bt1, bt2, bt3, bt4, bt5;
	ImageIcon icon_open, icon_close;
	JLabel la1, la2, la3, la4, la5;
	int v=1;

	public FileExplorer() {
		setLayout(new FlowLayout());
		p_north = new JPanel();
		p_center = new JPanel();
		
		icon_open = new ImageIcon("C:/java_workspace2/project0327_2/res/folder_open.png");
		icon_close = new ImageIcon("C:/java_workspace2/project0327_2/res/folder_close.png");
		
		bt1 = new JButton(icon_open);
		bt2 = new JButton(icon_open);
		bt3 = new JButton(icon_open);
		bt4 = new JButton(icon_open);
		bt5 = new JButton(icon_open);
		
		la1 = new JLabel();
		la2 = new JLabel();
		la3 = new JLabel();
		la4 = new JLabel();
		la5 = new JLabel();

		
		File file = new File("C:/");
		File[] dir = file.listFiles();
		
		for(int i=5;i<10;i++){
			if(dir[i].isDirectory()){
				p_north.add(new JLabel(dir[i].getName()));
			}
			
		}
		
		p_north.add(bt1);
		//p_north.add(la1);		
		p_north.add(bt2);
		p_north.add(bt3);
		p_north.add(bt4);
		p_center.add(bt5);
		
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change();	
			}
		});
		
		setSize(700,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	

	public void change(){
		if(v==1){
			bt1 = new JButton(icon_close);
			v=v-1;
		}
		if(v==0){
			bt1 = new JButton(icon_open);
			v=v+1;
		}
		
	}
	
	
	
	public static void main(String[] args) {
		new FileExplorer();

	}

}
