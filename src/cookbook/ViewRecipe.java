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
	private JButton edit;
	private JLabel allergy_filters, allergy_filters_header, course_filters, course_filters_header, ingredients_header, culture, name, notes_header, instructions_header;
	private JTextArea notes, ingredients, instructions;
	private ActionListener edit_recipe;
	
	private int id;
	
	
	public ViewRecipe(int id)
	{
		setUpButtonListeners();
		
		FoodItemList list = new FoodItemList();
		FoodItem tmpFood = list.getById(id);
		
		this.id = id;
		String type = tmpFood.getType();
		
		if(type.equals("Text"))
		{
			textInstruction(id, tmpFood);
		}
		if(type.equals("Image"))
		{
			imageInstruction(id, tmpFood);
		}
	}
	
	public void textInstruction(int id, FoodItem f)
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
		name.setText(f.getName());
		name.setFont(new Font("Serif", Font.BOLD, 24));
		name.setBounds(30, 10, 640, 30);
		
		ingredients_header = new JLabel("Ingredients:");
		ingredients_header.setBounds(30, 70, 310, 15);
		
		ingredients = new JTextArea();
		ingredients.setText(f.getIngredients());
		ingredients.setBounds(30, 95, 280, 285);
		ingredients.setBackground(Color.DARK_GRAY);
		ingredients.setEditable(false);
		ingredients.setLineWrap(true);
		
		instructions_header = new JLabel("Instructions:");
		instructions_header.setBounds(330, 70, 310, 15);
		
		instructions = new JTextArea();
		instructions.setText(f.getText());
		instructions.setBounds(330, 95, 340, 285);
		instructions.setEditable(false);
		instructions.setLineWrap(true);
		
		notes_header = new JLabel("Notes:");
		notes_header.setBounds(330, 420, 310, 15);
		
		notes = new JTextArea();
		notes.setText(f.getNotes());
		notes.setBounds(330, 445, 340, 185);
		notes.setEditable(false);
		notes.setLineWrap(true);
		notes.setBackground(Color.GRAY);
		
		allergy_filters_header = new JLabel();
		allergy_filters_header.setBounds(30, 420, 310, 15);
		allergy_filters_header.setText("Allergens:");
		
		allergy_filters = new JLabel();
		allergy_filters.setBounds(40, 450, 310, 20);
		if(f.getAllergens() != "[]")
		{
			allergy_filters.setText(f.getAllergens());
		}
		else
		{
			allergy_filters.setText("N/A");
		}
			
		course_filters_header = new JLabel();
		course_filters_header.setBounds(30, 510, 310, 15);
		course_filters_header.setText("Course: ");
		
		course_filters = new JLabel();
		course_filters.setBounds(40, 540, 310, 20);
		if(f.getCourses() != "[]")
		{
			course_filters.setText(f.getCourses());
		}
		else
		{
			course_filters.setText("N/A");
		}
		
		culture = new JLabel();
		culture.setBounds(30, 600, 310, 30);
		if(f.getCulture() != null)
		{
			culture.setText("Culture:   " + f.getCulture());
		}
		
		edit = new JButton("Edit");
		edit.setBounds(275, 650, 100, 30);
		edit.setForeground(Color.YELLOW);
		edit.setBackground(Color.GRAY);
		edit.addActionListener(edit_recipe);
		
		view_panel.add(name);
		view_panel.add(ingredients_header);
		view_panel.add(ingredients);
		view_panel.add(instructions);
		view_panel.add(instructions_header);
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
	
	public void imageInstruction(int id, FoodItem f)
	{
		
		view_frame = new JFrame();
		view_frame.setTitle(f.getName());
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
		name.setText(f.getName());
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