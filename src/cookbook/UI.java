package cookbook;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;

import java.awt.geom.*;

public class UI {

	private JPanel search_panel;
	private JFrame initial_frame;
	private JButton open_recipe_add, open_recipe_remove, recipe_search, search_bar_clear;
	private JTextField recipe_search_bar;
	private JLabel recipe_search_output;
	private JCheckBox exclude_course_filter, breakfast_filter, lunch_filter, dinner_filter, dessert_filter, appetizer_filter, snack_filter,
	side_filter, main_filter, exclude_ingredient_filter, milk_filter, eggs_filter, fish_filter, crustacean_shellfish_filter, tree_nut_filter,
	peanut_filter, wheat_filter, soya_filter;
	
	private ActionListener open_recipe_frame, search_recipe_book, clear_search_bar, filter_search;
	private KeyListener enter_for_search;
	private FocusListener text_prompt;
	
	public static void main(String[] args)
	{
		UI u = new UI();
	}
	
	public UI()
	{
		initialize();
	}
	
	public void initialize()
	{
		initial_frame = new JFrame("Digital Cookbook");
		initial_frame.setTitle("Digital Cookbook");
		initial_frame.setSize(900, 900);
		initial_frame.setLocationRelativeTo(null);
		initial_frame.setResizable(false);
		
		setUpButtonListeners();
		
		initial_frame.setUndecorated(true);
		initial_frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		 MetalLookAndFeel.setCurrentTheme(new MyDefaultMetalTheme());
		 try {
		      UIManager.setLookAndFeel(new MetalLookAndFeel());
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		 SwingUtilities.updateComponentTreeUI(initial_frame);
		 
		 search_panel = new JPanel();
		 initial_frame.getContentPane().add(search_panel);
		 
		 initial_frame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
		 search_panel.setLayout(null);
		 
		 recipe_search_output = new JLabel();
		 recipe_search_output.setBounds(400, 450, 200, 200);
		 
		 //Buttons
		 recipe_search_bar = new JTextField();
		 recipe_search_bar.setBounds(100, 40, 500, 20);
		 
		 recipe_search = new JButton("Search");
		 recipe_search.setBounds(630, 40, 100, 20);
		 recipe_search.setFocusable(false);
		 
		 search_bar_clear = new JButton("X");
		 search_bar_clear.setBounds(750, 40, 50, 20);
		 search_bar_clear.setFocusable(false);
		 
		 open_recipe_add = new JButton("Add Recipe");
		 open_recipe_add.setFocusable(false);
		 
		 open_recipe_remove = new JButton("Remove Recipe");
		 open_recipe_remove.setFocusable(false);
		 
		 open_recipe_add.addActionListener(open_recipe_frame);
		 recipe_search.addActionListener(search_recipe_book);
		 recipe_search_bar.addKeyListener(enter_for_search);
		 recipe_search_bar.addFocusListener(text_prompt);
		 search_bar_clear.addActionListener(clear_search_bar);	
			
		 //Adding course checkboxes
		 exclude_course_filter = new JCheckBox("Exclude Course");
		 exclude_course_filter.setFocusable(false);
		 exclude_course_filter.setBounds(50, 80, 120, 20);
		 
		 breakfast_filter = new JCheckBox("Breakfast");
		 breakfast_filter.setFocusable(false);
		 breakfast_filter.setBounds(180, 80, 85, 20);
		 
		 lunch_filter = new JCheckBox("Lunch");
		 lunch_filter.setFocusable(false);
		 lunch_filter.setBounds(275, 80, 65, 20);
		 
		 dinner_filter = new JCheckBox("Dinner");
		 dinner_filter.setFocusable(false);
		 dinner_filter.setBounds(350, 80, 70, 20);
		 
		 dessert_filter = new JCheckBox("Dessert");
		 dessert_filter.setFocusable(false);
		 dessert_filter.setBounds(430, 80, 75, 20);
		 
		 appetizer_filter = new JCheckBox("Appetizer");
		 appetizer_filter.setFocusable(false);
		 appetizer_filter.setBounds(515, 80, 85, 20);
		 
		 snack_filter = new JCheckBox("Snack");
		 snack_filter.setFocusable(false);
		 snack_filter.setBounds(610, 80, 65, 20);
		 
		 side_filter = new JCheckBox("Side");
		 side_filter.setFocusable(false);
		 side_filter.setBounds(685, 80, 50, 20);
		 
		 main_filter = new JCheckBox("Main");
		 main_filter.setFocusable(false);
		 main_filter.setBounds(745, 80, 55, 20);
			
		 
		 
   //Adding allergy checkboxes
		exclude_ingredient_filter = new JCheckBox("Exclude Ingredient");
		exclude_ingredient_filter.setFocusable(false);
		exclude_ingredient_filter.setBounds(50, 120, 135, 20);
		
		milk_filter = new JCheckBox("Milk");
		milk_filter.setFocusable(false);
		milk_filter.setBounds(195, 120, 50, 20);
		
		eggs_filter = new JCheckBox("Eggs");
		eggs_filter.setFocusable(false);
		eggs_filter.setBounds(255, 120, 55, 20);
		
		fish_filter = new JCheckBox("Fish");
		fish_filter.setFocusable(false);
		fish_filter.setBounds(320, 120, 50, 20);
		
		crustacean_shellfish_filter = new JCheckBox("Crustacean Shellfish");
		crustacean_shellfish_filter.setFocusable(false);
		crustacean_shellfish_filter.setBounds(380, 120, 150, 20);
		
		tree_nut_filter = new JCheckBox("Tree Nut");
		tree_nut_filter.setFocusable(false);
		tree_nut_filter.setBounds(540, 120, 80, 20);
		
		peanut_filter = new JCheckBox("Peanut");
		peanut_filter.setFocusable(false);
		peanut_filter.setBounds(630, 120, 70, 20);
		
		wheat_filter = new JCheckBox("Wheat");
		wheat_filter.setFocusable(false);
		wheat_filter.setBounds(710, 120, 65, 20);
		
		soya_filter = new JCheckBox("Soya");
		soya_filter.setFocusable(false);
		soya_filter.setBounds(785, 120, 55, 20);
		 
		 
		//Colors
		 exclude_course_filter.setBackground(Color.BLACK);
			exclude_course_filter.setForeground(Color.WHITE);
			breakfast_filter.setBackground(Color.BLACK);
			breakfast_filter.setForeground(Color.WHITE);
			lunch_filter.setBackground(Color.BLACK);
			lunch_filter.setForeground(Color.WHITE);
			dinner_filter.setBackground(Color.BLACK);
			dinner_filter.setForeground(Color.WHITE);
			dessert_filter.setBackground(Color.BLACK);
			dessert_filter.setForeground(Color.WHITE);
			appetizer_filter.setBackground(Color.BLACK);
			appetizer_filter.setForeground(Color.WHITE);
			snack_filter.setBackground(Color.BLACK);
			snack_filter.setForeground(Color.WHITE);
			side_filter.setBackground(Color.BLACK);
			side_filter.setForeground(Color.WHITE);
			main_filter.setBackground(Color.BLACK);
			main_filter.setForeground(Color.WHITE);
			
			exclude_ingredient_filter.setBackground(Color.BLACK);
			exclude_ingredient_filter.setForeground(Color.WHITE);
			milk_filter.setBackground(Color.BLACK);
			milk_filter.setForeground(Color.WHITE);
			eggs_filter.setBackground(Color.BLACK);
			eggs_filter.setForeground(Color.WHITE);
			fish_filter.setBackground(Color.BLACK);
			fish_filter.setForeground(Color.WHITE);
			crustacean_shellfish_filter.setBackground(Color.BLACK);
			crustacean_shellfish_filter.setForeground(Color.WHITE);
			tree_nut_filter.setBackground(Color.BLACK);
			tree_nut_filter.setForeground(Color.WHITE);
			peanut_filter.setBackground(Color.BLACK);
			peanut_filter.setForeground(Color.WHITE);
			wheat_filter.setBackground(Color.BLACK);
			wheat_filter.setForeground(Color.WHITE);
			soya_filter.setBackground(Color.BLACK);
			soya_filter.setForeground(Color.WHITE);
			
			
			recipe_search_output.setForeground(Color.WHITE);
			
		 //Adding stuff to panel
		 search_panel.add(recipe_search_bar);
		 search_panel.add(recipe_search);
		 search_panel.add(search_bar_clear);
		 search_panel.add(recipe_search_bar);
		 search_panel.add(open_recipe_add);
		 search_panel.add(open_recipe_remove);
		 
		 search_panel.add(exclude_course_filter);
		 search_panel.add(breakfast_filter);
		 search_panel.add(lunch_filter);
		 search_panel.add(dinner_filter);
		 search_panel.add(dessert_filter);
		 search_panel.add(appetizer_filter);
		 search_panel.add(snack_filter);
		 search_panel.add(side_filter);
		 search_panel.add(main_filter);
		 
		 search_panel.add(exclude_ingredient_filter);
		 search_panel.add(milk_filter);
		 search_panel.add(eggs_filter);
		 search_panel.add(fish_filter);
		 search_panel.add(crustacean_shellfish_filter);
		 search_panel.add(tree_nut_filter);
		 search_panel.add(peanut_filter);
		 search_panel.add(wheat_filter);
		 search_panel.add(soya_filter);
		 
		 search_panel.add(recipe_search_output);
		 
		 initial_frame.add(search_panel);
		 initial_frame.setVisible(true);
	}
	
	public void setUpButtonListeners() {
		open_recipe_frame = new ActionListener() {								// When open_recipe_add is clicked, a new window will be created for adding 
			@Override
			public void actionPerformed(ActionEvent e) {
				//add_recipe_frame_maker();
			}
		};
		
		search_recipe_book = new ActionListener() {								// When recipe_search is clicked, the text will be printed onto recipe_search_output
			@Override
			public void actionPerformed(ActionEvent e) {
				if (recipe_search_bar.getText().equals("Search Recipe")) {
					recipe_search_output.setText("x");
				}
				else {
					recipe_search_output.setText(recipe_search_bar.getText());
				}
			}
		};
		
		clear_search_bar = new ActionListener() {								// When search_bar_clear is clicked, the text in recipe_search_bar and recipe_search_output will be cleared (set to "")
			@Override
			public void actionPerformed(ActionEvent e) {
				recipe_search_bar.setText("Search Recipe");
				recipe_search_output.setText("");
			}
		};
		
		filter_search = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		
		enter_for_search = new KeyListener() {									// Clicking enter button will search
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					if(recipe_search_output.getText() == "") {
						recipe_search_output.setText(recipe_search_bar.getText());
					}
					else {
						recipe_search_output.setText(recipe_search_bar.getText());
					}
				}
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				
			}
		};
		
		text_prompt = new FocusListener() {										// Creates a text prompt on the search recipe text field that disappears when clicked on and only reappears if no text entered
			@Override
			public void focusGained(FocusEvent e) {
				if (recipe_search_bar.getText().trim().equals("Search Recipe")) {
					recipe_search_bar.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (recipe_search_bar.getText().trim().equals("")) {
					recipe_search_bar.setText("Search Recipe");
				}
			}
		};
		
		
		

	}
}
