package cookbook;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class ViewRecipe {
	
	private JFrame view_frame;
	private JPanel view_panel;
	private JButton close, save_and_close, edit;
	private JLabel allergy_filters, course_filters, ingredients, culture, name;
	private JTextArea notes;
	
	
	public ViewRecipe(int id, FoodItemList f)
	{
		setUpButtonListeners();
		Boolean can_edit = false;
		
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
		
		name = new JLabel();
		name.setText(f.getById(id).getName());
		name.setFont(new Font("Serif", Font.BOLD, 24));
		name.setBounds(30, 10, 840, 30);
		
		ingredients = new JLabel();
		ingredients.setText(f.getById(id).getIngredients());
		ingredients.setBounds(30, 45, 840, 200);
		
//		culture = new JLabel();
//		culture.setText(f.getById(id).getCulture());
//		culture.setBounds(30, 250, 840, 30);
		
		notes = new JTextArea();
		notes.setText(f.getById(id).getNotes());
		notes.setBounds(30, 290, 840, 300);
		notes.setEditable(can_edit);
		
//		allergy_filters = new JLabel();

//		course_filters = new JLabel();
	
		
		
		view_panel.add(name);
		view_panel.add(ingredients);
		view_panel.add(notes);
//		view_panel.add(culture);
//		view_panel.add(allergy_filters);
//		view_panel.add(course_filters);
		
		editable(can_edit);
		view_frame.setVisible(true);
	}
	
	public void editable(Boolean can_edit)
	{		
		if(can_edit)
		{
			
		}
		else
		{
			
		}
	}
	
	private void setUpButtonListeners()
	{
		
	}
}