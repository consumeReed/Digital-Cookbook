import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ImageFilter extends FileFilter {
	   public final static String JPEG = "jpeg";
	   public final static String JPG = "jpg";
	   public final static String GIF = "gif";
	   public final static String BMP = "bmp";
	   public final static String PNG = "png";
	   
	   @Override
	   public boolean accept(File f) {
	      if (f.isDirectory()) {
	         return true;
	      }

	      String extension = getExtension(f);
	      if (extension != null) {
	         if (extension.equals(BMP) ||
	            extension.equals(GIF) ||
	            extension.equals(JPEG) ||
	            extension.equals(JPG) ||
	            extension.equals(PNG)) {
	            return true;
	         } else {
	            return false;
	         }
	      }
	      return false;
	   }

	   @Override
	   public String getDescription() {
	      return ".bmp, .gif, .jpeg, .jpg, or .png";
	   }

	   String getExtension(File f) {
	      String ext = null;
	      String s = f.getName();
	      int i = s.lastIndexOf('.');
	   
	      if (i > 0 &&  i < s.length() - 1) {
	         ext = s.substring(i+1).toLowerCase();
	      }
	      return ext;
	   } 
	}