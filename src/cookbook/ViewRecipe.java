package cookbook;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class ViewRecipe {
	
	private JFrame view_frame;
	private JPanel view_panel;
	
	public ViewRecipe(int id, FoodItemList f)
	{
		view_frame = new JFrame();
		view_frame.setTitle(f.getById(id).getName());
		view_frame.setSize(900, 930);
		view_frame.setLocationRelativeTo(null);
		view_frame.setResizable(false);
		
		view_frame.setUndecorated(true);
		view_frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		MetalLookAndFeel.setCurrentTheme(new MyDefaultMetalTheme());
		try {
			UIManager.setLookAndFeel(new MetalLookAndFeel());
		} catch (Exception e) {
			e.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(view_frame);
		
		view_panel = new JPanel();
		view_frame.getContentPane().add(view_panel);
		
		view_frame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
		view_panel.setLayout(null);
		
		
		view_frame.setVisible(true);
	}
	
}