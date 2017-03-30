package count;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CountApp extends JFrame{
	JLabel la1, la2;
	JPanel p;
	
	
	public CountApp() {
		la1 = new JLabel(new CountFast());
		la2 = new JLabel("´À¸°°Å");
		p = new JPanel();
		
		p.add(la1);
		p.add(la2);
		
		add(p);
		
		setSize(500,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	
		
	}
	
	public static void main(String[] args) {
		new CountApp();

	}

}
