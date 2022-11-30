package cookbook;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JLabel allergy_filters, allergy_filters_header, course_filters, course_filters_header, ingredients, ingredients_header, culture, name, notes_header;
	private JTextArea notes;
	private ActionListener edit_recipe;
	
	private int id;
	
	public ViewRecipe(int id, FoodItemList f, String type)
	{
		setUpButtonListeners();
		
		this.id = id;
		
		if(type.equals("Text"))
		{
			textInstruction(id, f, type);
		}
		if(type.equals("Image"))
		{
			imageInstruction(id, f, type);
		}
	}
	
	public void textInstruction(int id, FoodItemList f, String type)
	{
		
		view_frame = new JFrame();
		view_frame.setTitle("View Recipe");
		view_frame.setSize(700, 730);
		view_frame.setLocation(200, 200);
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
		name.setBounds(30, 10, 640, 30);
		
		ingredients_header = new JLabel("Ingredients:");
		ingredients_header.setBounds(30, 70, 310, 15);
		
		ingredients = new JLabel();
		ingredients.setText(f.getById(id).getIngredients());
		ingredients.setBounds(30, 85, 310, 285);
		
		notes_header = new JLabel("Notes:");
		notes_header.setBounds(330, 70, 310, 15);
		
		notes = new JTextArea();
		notes.setText(f.getById(id).getNotes());
		notes.setBounds(330, 95, 340, 285);
		notes.setBackground(Color.GRAY);
		notes.setEditable(false);
		notes.setLineWrap(true);
		
		allergy_filters_header = new JLabel();
		allergy_filters_header.setBounds(30, 420, 640, 15);
		allergy_filters_header.setText("Allergens:");
		
		allergy_filters = new JLabel();
		allergy_filters.setBounds(40, 450, 630, 20);
		allergy_filters.setText("Filler Text");
		
		course_filters_header = new JLabel();
		course_filters_header.setBounds(30, 510, 640, 15);
		course_filters_header.setText("Course: ");
		
		course_filters = new JLabel();
		course_filters.setBounds(40, 540, 630, 20);
		course_filters.setText("Filler Text");
		
		culture = new JLabel();
		culture.setBounds(30, 600, 640, 30);
		if(f.getById(id).getCulture() != null)
		{
			culture.setText("Culture: " + f.getById(id).getCulture());
		}
		
		edit = new JButton("Edit");
		edit.setBounds(275, 650, 100, 30);
		edit.setForeground(Color.YELLOW);
		edit.setBackground(Color.GRAY);
		edit.addActionListener(edit_recipe);
		
		view_panel.add(name);
		view_panel.add(ingredients_header);
		view_panel.add(ingredients);
		view_panel.add(notes_header);
		view_panel.add(notes);
		view_panel.add(culture);
		view_panel.add(allergy_filters);
		view_panel.add(allergy_filters_header);
		view_panel.add(course_filters);
		view_panel.add(course_filters_header);
		view_panel.add(edit);
		
		view_frame.setVisible(true);
	}
	
	public void imageInstruction(int id, FoodItemList f, String type)
	{
		
		view_frame = new JFrame();
		view_frame.setTitle(f.getById(id).getName());
		view_frame.setSize(700, 730);
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
		
		edit = new JButton("Edit");
		edit.setBounds(275, 650, 100, 30);
		edit.setForeground(Color.YELLOW);
		edit.setBackground(Color.GRAY);
		edit.addActionListener(edit_recipe);
		
		view_panel.add(name);
		view_panel.add(edit);
		view_frame.setVisible(true);
	}

	
	private void setUpButtonListeners()
	{
		edit_recipe = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				view_frame.dispose();
				AddEditRecipe aer = new AddEditRecipe(id);
			}
			
		};
	}
	
}