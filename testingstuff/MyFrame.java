import java.awt.FlowLayout;


import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.*;

import org.apache.commons.io.FileUtils;

public class MyFrame extends JFrame implements ActionListener{

	JButton button;
	
	MyFrame(){		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		button = new JButton("Select File");
		button.addActionListener(this);
		
		this.add(button);
		this.pack();
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==button) {
			
			JFileChooser fileChooser = new JFileChooser();
			
			fileChooser.setCurrentDirectory(new File(".")); //sets current directory
			
			int response = fileChooser.showOpenDialog(null); //select file to open
			//int response = fileChooser.showSaveDialog(null); //select file to save
			
			if(response == JFileChooser.APPROVE_OPTION) {
				File src = new File(fileChooser.getSelectedFile().getAbsolutePath());
				System.out.println(src);
				String tmp = "userdata\\" + src.getName();
				/*File dest = new File(tmp);
				try
				{
					if(!dest.exists())
						dest.createNewFile();
					FileUtils.copyFile(src, dest);
				}catch(Exception f)
				{
					f.printStackTrace();
				}*/
				File dest = new File(tmp);
				try {
					FileInputStream fileInputStream = new FileInputStream(src);
					FileOutputStream fileOutputStream = new FileOutputStream(dest);
					
					int bufferSize;
					byte[] buffer = new byte[512];
					while((bufferSize = fileInputStream.read(buffer))>0)
						fileOutputStream.write(buffer, 0, bufferSize);
					fileInputStream.close();
					fileOutputStream.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		
		// JFileChooser = A GUI mechanism that let's a user choose a file (helpful for opening or saving files)
		
		new MyFrame();
	}
}
