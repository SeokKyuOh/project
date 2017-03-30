package exercise;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemoEditor extends JFrame{
	JPanel p;
	JButton bt_open, bt_save;
	JTextArea area;
	JScrollPane scroll;
	
	String ori="C:/java_workspace2/project0327_2/res/memo.txt";
	String dest="C:/java_workspace2/project0327_2/res/memo_ex_copy.txt";
	FileInputStream fis;
	FileOutputStream fos;
	
	InputStreamReader reader;
	BufferedReader buffr;
	
	OutputStreamWriter writer;
	PrintWriter writer2;
	
	public MemoEditor() {
		p = new JPanel();
		bt_open = new JButton("open");
		bt_save = new JButton("save");
		area = new JTextArea(40,30);
		scroll = new JScrollPane(area);
		
		p.add(bt_open);
		p.add(bt_save);
		
		add(p, BorderLayout.NORTH);
		add(scroll);
		
		bt_open.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});
		
		bt_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				save();
			}
		});
		
		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
		public void open(){
			try{
				fis = new FileInputStream(ori);
				
				reader = new InputStreamReader(fis, "utf-8");
				buffr = new BufferedReader(reader);
			
				
				String data;
				int count=0;
				
				while(true){
					data = buffr.readLine();
					count++;
					if(data==null)break;
					area.append(data+"\n");		
				}
				System.out.println("count="+count);
			} catch (FileNotFoundException e){
				e.printStackTrace();
				
			} catch (IOException e){
				e.printStackTrace();
			} finally{
				if(writer2 !=null){
					writer2.close();
				}
				if(fos !=null){
					try{
						fos.close();
					} catch(IOException e){
						e.printStackTrace();
					}
				}				
			}			
		}
	
		public void save(){
			try{
				fos = new FileOutputStream(dest);
				
				writer2 = new PrintWriter(fos);
				writer2.write(area.getText());
			} catch (FileNotFoundException e){
				e.printStackTrace();
			} catch (IOException e){
				e.printStackTrace();
			} finally{
				if(writer2 !=null){
					writer2.close();
				}
				if(fos !=null){
					try{
						fos.close();
					} catch(IOException e){
						e.printStackTrace();
					}
				}
			}
			
		}
	
	public static void main(String[] args) {
		new MemoEditor();

	}

}
