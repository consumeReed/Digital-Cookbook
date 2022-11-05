import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.io.*;
import java.nio.file.*;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class DeletePicture extends JFrame implements ActionListener{
		/**File file = new File("userdata\\pictureName.whateverExtension");
		
		if (file.delete()) {
            System.out.println("File deleted successfully");
        }
        else {
            System.out.println("Failed to delete the file");
        }**/
		
	JButton button;
	DeletePicture() {
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
			fileChooser.addChoosableFileFilter(new ImageFilter());
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.setCurrentDirectory(new File(".")); //sets directory
            int response = fileChooser.showOpenDialog(null); //select file to open
            if(response == JFileChooser.APPROVE_OPTION) {
            	File src = new File(fileChooser.getSelectedFile().getAbsolutePath());
            	Path a = Paths.get(src.getPath());
            	try {
            		Files.delete(a);
            	} catch (Exception e2) {
            		e2.printStackTrace();
            	}
            	}
			}
	}
	
	public static void Main(String[] args) {
		//full method test.
		new DeletePicture();
	}
}
