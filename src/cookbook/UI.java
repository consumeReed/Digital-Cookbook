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

	private FoodItemList f;
	private ArrayList<FoodItem> fl;
	
	private JPanel search_panel;
	private JFrame initial_frame;
	private JButton open_recipe_add, open_recipe_remove, recipe_search, search_bar_clear, next_page, prev_page,
	item1b, item2b, item3b, item4b, item5b, item6b, item7b, item8b, item1v, item2v, item3v, item4v, item5v, item6v,
	item7v, item8v;
	private JTextField recipe_search_bar;
	private JLabel recipe_search_output, page_number, item1, item2, item3, item4, item5, item6, item7, item8;
	
	private ViewRecipe vr;
	private ArrayList<JLabel> labels;
	private ArrayList<JButton> buttons, views;
	private ArrayList<JCheckBox> allergyBoxes, courseBoxes;
	private JCheckBox exclude_course_filter, breakfast_filter, lunch_filter, dinner_filter, dessert_filter, appetizer_filter, snack_filter,
	side_filter, main_filter, exclude_ingredient_filter, milk_filter, eggs_filter, fish_filter, crustacean_shellfish_filter, tree_nut_filter,
	peanut_filter, wheat_filter, soya_filter;
	
	private ActionListener rm1, rm2, rm3, rm4, rm5, rm6, rm7, rm8, v1, v2, v3, v4, v5, v6, v7, v8;
	private ActionListener open_recipe_frame, search_recipe_book, clear_search_bar, filter_search, next_page_l, prev_page_1;
	private KeyListener enter_for_search;
	private FocusListener text_prompt;
	
	private int page = 0;
	
	Color c1 = new Color(50, 168, 64);
	
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
		f = new FoodItemList();
		initial_frame = new JFrame("Digital Cookbook");
		initial_frame.setTitle("Digital Cookbook");
		initial_frame.setSize(900, 930);
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
		 
		 next_page = new JButton(new ImageIcon("userdata\\right_arrow.png"));
		 next_page.setBounds(574, 140, 80 ,80);
		 next_page.setFocusable(false);
		 
		 prev_page = new JButton(new ImageIcon("userdata\\left_arrow.png"));
		 prev_page.setBounds(247, 140, 80, 80);
		 prev_page.setFocusable(false);
		 
		 page_number = new JLabel();
		 int dummy = page+1;
		 page_number.setText("Page " + dummy);
		 page_number.setBounds(430, 140, 80, 80);
		 
		 open_recipe_add = new JButton("Add Recipe");
		 open_recipe_add.setBounds(80, 165, 150, 30);
		 open_recipe_add.setFocusable(false);
		 open_recipe_add.setBackground(c1);
		 open_recipe_add.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
		 
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
		 
		 courseBoxes = new ArrayList<JCheckBox>();
		 courseBoxes.add(breakfast_filter);
		 courseBoxes.add(lunch_filter);
		 courseBoxes.add(dinner_filter);
		 courseBoxes.add(dessert_filter);
		 courseBoxes.add(appetizer_filter);
		 courseBoxes.add(snack_filter);
		 courseBoxes.add(side_filter);
		 courseBoxes.add(main_filter);
		 
		 
		 item1 = new JLabel();
		 item1.setBounds(100, 250, 200, 30);
		 
		 item2 = new JLabel();
		 item2.setBounds(100, 335, 200, 30);
		 
		 item3 = new JLabel();
		 item3.setBounds(100, 420, 200, 30);
		 
		 item4 = new JLabel();
		 item4.setBounds(100, 505, 200, 30);
		 
		 item5 = new JLabel();
		 item5.setBounds(100, 590, 200, 30);
		 
		 item6 = new JLabel();
		 item6.setBounds(100, 675, 200, 30);
		 
		 item7 = new JLabel();
		 item7.setBounds(100, 760, 200, 30);
		 
		 item8 = new JLabel();
		 item8.setBounds(100, 845, 200, 30);
		 
		 labels = new ArrayList<JLabel>();
				 
		 labels.add(item1);
		 labels.add(item2);
		 labels.add(item3);
		 labels.add(item4);
		 labels.add(item5);
		 labels.add(item6);
		 labels.add(item7);
		 labels.add(item8);
		 

		 item1b = new JButton();
		 item1b.setBounds(500, 250, 200, 30);
		 item1b.setFocusable(false);
		 item1b.setVisible(true);
		 
		 item2b = new JButton();
		 item2b.setBounds(500, 335, 200, 30);
		 item2b.setFocusable(false);
		 item2b.setVisible(true);
		 
		 item3b = new JButton();
		 item3b.setBounds(500, 420, 200, 30);
		 item3b.setFocusable(false);
		 item3b.setVisible(true);
		 
		 item4b = new JButton();
		 item4b.setBounds(500, 505, 200, 30);
		 item4b.setFocusable(false);
		 item4b.setVisible(true);
		 
		 item5b = new JButton();
		 item5b.setBounds(500, 590, 200, 30);
		 item5b.setFocusable(false);
		 item5b.setVisible(true);
		 
		 item6b = new JButton();
		 item6b.setBounds(500, 675, 200, 30);
		 item6b.setFocusable(false);
		 item6b.setVisible(true);
		 
		 item7b = new JButton();
		 item7b.setBounds(500, 760, 200, 30);
		 item7b.setFocusable(false);
		 item7b.setVisible(true);
		 
		 item8b = new JButton();
		 item8b.setBounds(500, 845, 200, 30);
		 item8b.setFocusable(false);
		 item8b.setVisible(true);
		 
		 buttons = new ArrayList<JButton>();
		 
		 buttons.add(item1b);
		 buttons.add(item2b);
		 buttons.add(item3b);
		 buttons.add(item4b);
		 buttons.add(item5b);
		 buttons.add(item6b);
		 buttons.add(item7b);
		 buttons.add(item8b);
		 
		 
		 item1v = new JButton();
		 item1v.setBounds(700, 250, 200, 30);
		 item1v.setText("View");
		 item1v.setFocusable(false);
		 
		 item2v = new JButton();
		 item2v.setBounds(700, 335, 200, 30);
		 item2v.setText("View");
		 item2v.setFocusable(false);
		 
		 item3v = new JButton();
		 item3v.setBounds(700, 420, 200, 30);
		 item3v.setText("View");
		 item3v.setFocusable(false);
		 
		 item4v = new JButton();
		 item4v.setBounds(700, 505, 200, 30);
		 item4v.setText("View");
		 item4v.setFocusable(false);
		 
		 item5v = new JButton();
		 item5v.setBounds(700, 590, 200, 30);
		 item5v.setText("View");
		 item5v.setFocusable(false);
		 
		 item6v = new JButton();
		 item6v.setBounds(700, 675, 200, 30);
		 item6v.setText("View");
		 item6v.setFocusable(false);
		 
		 item7v = new JButton();
		 item7v.setBounds(700, 760, 200, 30);
		 item7v.setText("View");
		 item7v.setFocusable(false);
		 
		 item8v = new JButton();
		 item8v.setBounds(700, 845, 200, 30);
		 item8v.setText("View");
		 item8v.setFocusable(false);
		 
		 views = new ArrayList<JButton>();
		 
		 views.add(item1v);
		 views.add(item2v);
		 views.add(item3v);
		 views.add(item4v);
		 views.add(item5v);
		 views.add(item6v);
		 views.add(item7v);
		 views.add(item8v);
		 
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
		 
		allergyBoxes = new ArrayList<JCheckBox>();
		allergyBoxes.add(milk_filter);
		allergyBoxes.add(eggs_filter);
		allergyBoxes.add(fish_filter);
		allergyBoxes.add(crustacean_shellfish_filter);
		allergyBoxes.add(tree_nut_filter);
		allergyBoxes.add(peanut_filter);
		allergyBoxes.add(wheat_filter);
		allergyBoxes.add(soya_filter);
		
		
		//IMAGES
		
		JLabel im1 = new JLabel(new ImageIcon("userdata\\gold_bar.png"));
		im1.setBounds(0, 220, 900, 10);
		im1.setVisible(true);
		initial_frame.add(im1);
		
		JLabel im2 = new JLabel(new ImageIcon("userdata\\gray_bar.png"));
		im2.setBounds(0, 305, 900, 5);
		im2.setVisible(true);
		initial_frame.add(im2);

		JLabel im3 = new JLabel(new ImageIcon("userdata\\gray_bar.png"));
		im3.setBounds(0, 390, 900, 5);
		im3.setVisible(true);
		initial_frame.add(im3);
		
		JLabel im4 = new JLabel(new ImageIcon("userdata\\gray_bar.png"));
		im4.setBounds(0, 475, 900, 5);
		im4.setVisible(true);
		initial_frame.add(im4);
		
		JLabel im5 = new JLabel(new ImageIcon("userdata\\gray_bar.png"));
		im5.setBounds(0, 560, 900, 5);
		im5.setVisible(true);
		initial_frame.add(im5);
		
		JLabel im6 = new JLabel(new ImageIcon("userdata\\gray_bar.png"));
		im6.setBounds(0, 645, 900, 5);
		im6.setVisible(true);
		initial_frame.add(im6);
		
		JLabel im7 = new JLabel(new ImageIcon("userdata\\gray_bar.png"));
		im7.setBounds(0, 730, 900, 5);
		im7.setVisible(true);
		initial_frame.add(im7);
		
		JLabel im8 = new JLabel(new ImageIcon("userdata\\gray_bar.png"));
		im8.setBounds(0, 815, 900, 5);
		im8.setVisible(true);
		initial_frame.add(im8);
		
		 
		
		//Listeners
		next_page.addActionListener(next_page_l);
		prev_page.addActionListener(prev_page_1);
		
		item1b.addActionListener(rm1);
		item2b.addActionListener(rm2);
		item3b.addActionListener(rm3);
		item4b.addActionListener(rm4);
		item5b.addActionListener(rm5);
		item6b.addActionListener(rm6);
		item7b.addActionListener(rm7);
		item8b.addActionListener(rm8);
		
		item1v.addActionListener(v1);
		item2v.addActionListener(v2);
		item3v.addActionListener(v3);
		item4v.addActionListener(v4);
		item5v.addActionListener(v5);
		item6v.addActionListener(v6);
		item7v.addActionListener(v7);
		item8v.addActionListener(v8);
		
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
		 search_panel.add(next_page);
		 search_panel.add(prev_page);
		 search_panel.add(page_number);
		 
		 search_panel.add(item1);
		 search_panel.add(item2);
		 search_panel.add(item3);
		 search_panel.add(item4);
		 search_panel.add(item5);
		 search_panel.add(item6);
		 search_panel.add(item7);
		 search_panel.add(item8);
		 
		 
		 search_panel.add(item1b);
		 search_panel.add(item2b);
		 search_panel.add(item3b);
		 search_panel.add(item4b);
		 search_panel.add(item5b);
		 search_panel.add(item6b);
		 search_panel.add(item7b);
		 search_panel.add(item8b);
		 
		 
		 search_panel.add(item1v);
		 search_panel.add(item2v);
		 search_panel.add(item3v);
		 search_panel.add(item4v);
		 search_panel.add(item5v);
		 search_panel.add(item6v);
		 search_panel.add(item7v);
		 search_panel.add(item8v);
		 
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
		 
		 search_panel.add(open_recipe_add);
		 search_panel.add(recipe_search_output);
		 
		 initial_frame.add(search_panel);
		 
		 updatePage();
		 initial_frame.setVisible(true);
	}
	
	
	public void updatePage()
	{
		Attributes allergy = new Attributes(true);
		Attributes course = new Attributes(false);
		
			if(allergyBoxes.get(0).isSelected())
				allergy.changePos0();
			if(allergyBoxes.get(1).isSelected())
				allergy.changePos1();
			if(allergyBoxes.get(2).isSelected())
				allergy.changePos2();
			if(allergyBoxes.get(3).isSelected())
				allergy.changePos3();
			if(allergyBoxes.get(4).isSelected())
				allergy.changePos4();
			if(allergyBoxes.get(5).isSelected())
				allergy.changePos5();
			if(allergyBoxes.get(6).isSelected())
				allergy.changePos6();
			if(allergyBoxes.get(7).isSelected())
				allergy.changePos7();

			
			if(courseBoxes.get(0).isSelected())
				course.changePos0();
			if(courseBoxes.get(1).isSelected())
				course.changePos1();
			if(courseBoxes.get(2).isSelected())
				course.changePos2();
			if(courseBoxes.get(3).isSelected())
				course.changePos3();
			if(courseBoxes.get(4).isSelected())
				course.changePos4();
			if(courseBoxes.get(5).isSelected())
				course.changePos5();
			if(courseBoxes.get(6).isSelected())
				course.changePos6();
			if(courseBoxes.get(7).isSelected())
				course.changePos7();
			
		fl = f.search(recipe_search_bar.getText(), allergy, course, exclude_ingredient_filter.isSelected(), exclude_course_filter.isSelected());
		
		//setting up variables to check for number of items to display on page
		int s = fl.size();
		int offset = page*8;
		int rem = s-offset;
		int rep = 8;
		if(rem<8)
			rep = rem;
		
		//items that get displayed by updating
		for(int i = 0; i < rep; i++)
		{
			labels.get(i).setText(fl.get(i+offset).getName());
			buttons.get(i).setText("Remove"); //+ fl.get(i+offset).getName());
			search_panel.add(buttons.get(i));
			search_panel.add(views.get(i));
			initial_frame.revalidate();
			initial_frame.repaint();
		}
		
		//removing items that were displayed if necessary
		for(int i = rep; i < 8; i++)
		{
			labels.get(i).setText("");
			search_panel.remove(buttons.get(i));
			search_panel.remove(views.get(i));
			initial_frame.revalidate();
			initial_frame.repaint();
		}
		
		
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
					page  = 0;
					int dummy = page+1;
					page_number.setText("Page "+dummy);
					updatePage();
				

				
			}
		};
		
		clear_search_bar = new ActionListener() {								// When search_bar_clear is clicked, the text in recipe_search_bar and recipe_search_output will be cleared (set to "")
			@Override
			public void actionPerformed(ActionEvent e) {
				recipe_search_bar.setText("");
				exclude_ingredient_filter.setSelected(false);
				exclude_course_filter.setSelected(false);
				for(int i = 0; i < 8; i++)
				{
					allergyBoxes.get(i).setSelected(false);
					courseBoxes.get(i).setSelected(false);
				}
				updatePage();
			}
		};
		
		filter_search = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		
		rm1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int offset = page*8;
				int id = fl.get(offset).getId();
				f.deleteFood(id);
				updatePage();
			}
		};
		
		rm2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int offset = page*8;
				int id = fl.get(offset+1).getId();
				f.deleteFood(id);
				updatePage();
			}
		};
		
		rm3 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int offset = page*8;
				int id = fl.get(offset+2).getId();
				f.deleteFood(id);
				updatePage();
			}
		};
		rm4 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int offset = page*8;
				int id = fl.get(offset+3).getId();
				f.deleteFood(id);
				updatePage();
			}
		};
		
		rm5 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int offset = page*8;
				int id = fl.get(offset+4).getId();
				f.deleteFood(id);
				updatePage();
			}
		};
		rm6 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int offset = page*8;
				int id = fl.get(offset+5).getId();
				f.deleteFood(id);
				updatePage();
			}
		};
		rm7 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int offset = page*8;
				int id = fl.get(offset+6).getId();
				f.deleteFood(id);
				updatePage();
			}
		};
		rm8 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int offset = page*8;
				int id = fl.get(offset+7).getId();
				f.deleteFood(id);
				updatePage();
			}
		};
		
		v1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int offset = page*8;
				int id = fl.get(offset).getId();
				vr = new ViewRecipe(id, f, fl.get(id).getType());
				updatePage();
			}
		};
		v2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int offset = page*8;
				int id = fl.get(offset+1).getId();
				vr = new ViewRecipe(id, f, fl.get(id).getType());
				updatePage();
			}
		};
		v3 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int offset = page*8;
				int id = fl.get(offset+2).getId();
				vr = new ViewRecipe(id, f, fl.get(id).getType());
				updatePage();
			}
		};
		v4 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int offset = page*8;
				int id = fl.get(offset+3).getId();
				vr = new ViewRecipe(id, f, fl.get(id).getType());
				updatePage();
			}
		};
		v5 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int offset = page*8;
				int id = fl.get(offset+4).getId();
				vr = new ViewRecipe(id, f, fl.get(id).getType());
				updatePage();
			}
		};
		v6 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int offset = page*8;
				int id = fl.get(offset+5).getId();
				vr = new ViewRecipe(id, f, fl.get(id).getType());
				updatePage();
			}
		};
		v7 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int offset = page*8;
				int id = fl.get(offset+6).getId();
				vr = new ViewRecipe(id, f, fl.get(id).getType());
				updatePage();
			}
		};
		v8 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int offset = page*8;
				int id = fl.get(offset+7).getId();
				vr = new ViewRecipe(id, f, fl.get(id).getType());
				updatePage();
			}
		};
		
		next_page_l = new ActionListener() {								// When search_bar_clear is clicked, the text in recipe_search_bar and recipe_search_output will be cleared (set to "")
			@Override
			public void actionPerformed(ActionEvent e) {
				page++;
				if(page >= fl.size()/8+1)
					page--;
				int dummy = page+1;
				page_number.setText("Page "+dummy);
				updatePage();
			}
		};
		
		prev_page_1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				page--;
				if(page < 0)
					page = 0;
				int dummy = page+1;
				page_number.setText("Page "+dummy);
				updatePage();
			}
		};
		
		enter_for_search = new KeyListener() {									// Clicking enter button will search
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					page = 0;
					int dummy = page+1;
					page_number.setText("Page "+dummy);
					updatePage();
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
