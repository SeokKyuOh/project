package editor;

import java.awt.FlowLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;



public class CopyMain extends JFrame implements ActionListener{
	JButton bt_open, bt_save, bt_copy;
	JTextField t_open, t_save;
	FileInputStream fis;		//������ ������� �� �Է½�Ʈ��
	FileOutputStream fos;	//������ ������� �� ��½�Ʈ��

	//���� Ž���⸦ ó���ϴ� ��ü
	JFileChooser chooser;
	
	public CopyMain() {
		bt_open = new JButton("�������");
		bt_save = new JButton("������");
		bt_copy = new JButton("�������");
		
		t_open = new JTextField(30);
		t_save = new JTextField(30);
		
		setLayout(new FlowLayout());
		
		add(bt_open);
		add(t_open);
		add(bt_save);
		add(t_save);
		add(bt_copy);
		
		//��ư�� �����ʿ� ����
		bt_open.addActionListener(this);
		bt_save.addActionListener(this);
		bt_copy.addActionListener(this);

		//���� ������ �̸� �÷�����
		//����Ʈ ���丮�� �����ϸ� ���ϴ�.
		chooser = new JFileChooser("C:/java_workspace2/project0323/");

		setSize(475,180);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//�� �� ��ɾ �����ϰ� �ȴٸ�. ��Ʈ���� ���ŵǱ� ������ ���� �� �ִ� ������ �ִ�.
		//	  �׷��� ������ �����ʸ� �̿��Ͽ� â�� ������ ��Ʈ���� ������ �� �ִ� �ڵ带 �ۼ�����
		
	}

	public void actionPerformed(ActionEvent e){//�߻��ϴ� �̺�Ʈ�� �길 �� �� �ִ�.
		Object obj=e.getSource();	//�̺�Ʈ �ҽ��� ��ȯ�޴´�. �ҽ��� ��� ���·κ��� ���� �� �ֱ� ������ ������Ʈ��

		if(obj == bt_open){
			open();

		}else if(obj == bt_save){
			int state = chooser.showSaveDialog(this);
			//System.out.println(state);
			//����� �ΰ����� �������� �ο����ش�.
			//��? ����ܾ �̿��ϴϱ�
			if(state == JFileChooser.APPROVE_OPTION){
				//���� ��θ� �ؽ�Ʈ�ʵ忡 ���
				File file = chooser.getSelectedFile();		//������ ������ �� ū ������
				
				//���� Ŭ������ ������ ������ �޼��带 �̿��Ͽ� ��ι�ȯ
				String path = file.getAbsolutePath();
				
				t_save.setText(path);
				
			}
			
		}else if(obj == bt_copy){
			copy();
			
		}
	}
	
	//���� ����
	public void open(){
		int state = chooser.showOpenDialog(this);//�ʿ��� ��Ұ� Component parent ���� �����찡 �ʿ��ϴ� �׷��� this
		if(state == JFileChooser.APPROVE_OPTION){
			//������ ������ ���Ͽ� ���� ���� Ŭ���� �ν��Ͻ� ���
			File file = chooser.getSelectedFile();
			//����� �ν��Ͻ��� �̿��Ͽ� ������ ���
			String path = file.getAbsolutePath();
			
			//������ �ؽ�Ʈ �ʵ忡 �Ѹ���
			t_open.setText(path);
			
			
		}

	}
	
	//�����ϱ� �޼��带 ���θ����� Ȱ�뼺�� ���̱� ����
	public void copy(){
		//�������Ͽ� ��Ʈ�� �����Ͽ� �����͸� ���̸�����
		//������ �����͸� ���� ���Ͽ� ��������
		String oriPath = t_open.getText();	//�������� ���
		String destPath = t_save.getText();	//������ ���

		try{
			fis = new FileInputStream(oriPath);
			fos = new FileOutputStream(destPath);
			
			int data;		//���� ���� ���ڸ� -1�� �ش�. ���⼭ -1�� �ƹ��͵� ���ٴ� ���̴ϱ�. int data=-1;
			while(true){
				data = fis.read();	// ���� �������� ���α׷����� 1byte �о����

				if(data == -1) break;
				fos.write(data);		//�̰� ���� ������� -1���� Ȯ�� ���� ���� ���̱� ������ -1�϶� ������ ������
			}
			JOptionPane.showMessageDialog(this, "����Ϸ�");

			//��Ʈ���� ����
			//try���ȿ��� ���� ��� ������
			//fis.close();		//fos���� ������ �ٷ� FileNotFoundException���� �Ѿ�� ������ �̺κ��� ���� x
								//�׷��� ���밡 �����ִ´�.
								//catch���� �־ �Ϸ�Ǿ��� ��쿣 catch���� ������������ ������ finally�� �־���Ѵ�.

		}catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(this, "������ ã�� �� �����ϴ�.");	
			//����� ������ â�� �ƴϰ� ���̾�α� â�̴�. �갡 ��ư� ���� this
		}catch(IOException e){
			JOptionPane.showMessageDialog(this, "IO�۾� �� ������ �߻��߽��ϴ�.");	
		}finally{		//����Ǵ� �������� ������ ����
			try{		//finally������ try, catch���� ����ؾ� �Ѵ�.
				//��ü�� �޸𸮿� �ö�Դٸ�~
				if(fis!=null){
					fis.close();
				}
				if(fos!=null){
					fos.close();
				}
			}catch(IOException e){
			}
		}
	}



	public static void main(String[] args) {
		new CopyMain();

	}

}
