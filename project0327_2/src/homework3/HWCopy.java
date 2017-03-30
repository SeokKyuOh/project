package homework3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class HWCopy extends Thread{
	HWMain hwMain;
	int data;
	int count;
	
	public HWCopy(HWMain hwMain) {
		this.hwMain = hwMain;
	}
	
	public void run(){
	
		String oriPath = hwMain.t_open.getText();
		String destPath = hwMain.t_save.getText();
		
		try{
			hwMain.fis = new FileInputStream(oriPath);
			hwMain.fos = new FileOutputStream(destPath);
			
			//int data;
			while(true){
				data = hwMain.fis.read();
				
				count++;
				//((100*hwc.data)/hwc.data.length);
				//bar.setValue((100*data)/data.length);
				
				if(data == -1) break;
				hwMain.fos.write(count);
			}
			JOptionPane.showMessageDialog(hwMain, "����Ϸ�");
		} catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(hwMain, "������ ã�� �� �����ϴ�.");
		} catch(IOException e){
			JOptionPane.showMessageDialog(hwMain, "�۾��� ������ �߻��߽��ϴ�.");
		} finally{
			try{
				if(hwMain.fis!=null){
					hwMain.fis.close();
				}
				if(hwMain.fos!=null){
					hwMain.fos.close();
				}
			} catch(IOException e){
				
			}
		}	
		
	}
}
