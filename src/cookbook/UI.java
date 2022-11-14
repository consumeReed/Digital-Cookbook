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
	item1b, item2b, item3b, item4b, item5b, item6b, item7b, item8b;
	private JTextField recipe_search_bar;
	private JLabel recipe_search_output, page_number, item1, item2, item3, item4, item5, item6, item7, item8;
	
	private ArrayList<JLabel> labels;
	private ArrayList<JButton> buttons;
	private JCheckBox exclude_course_filter, breakfast_filter, lunch_filter, dinner_filter, dessert_filter, appetizer_filter, snack_filter,
	side_filter, main_filter, exclude_ingredient_filter, milk_filter, eggs_filter, fish_filter, crustacean_shellfish_filter, tree_nut_filter,
	peanut_filter, wheat_filter, soya_filter;
	
	private ActionListener open_recipe_frame, search_recipe_book, clear_search_bar, filter_search, next_page_l, prev_page_1;
	private KeyListener enter_for_search;
	private FocusListener text_prompt;
	
	private int page = 0;
	
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
			
		 item1 = new JLabel();
		 item1.setBounds(100, 260, 200, 30);
		 
		 item2 = new JLabel();
		 item2.setBounds(100, 340, 200, 30);
		 
		 item3 = new JLabel();
		 item3.setBounds(100, 420, 200, 30);
		 
		 item4 = new JLabel();
		 item4.setBounds(100, 500, 200, 30);
		 
		 item5 = new JLabel();
		 item5.setBounds(100, 580, 200, 30);
		 
		 item6 = new JLabel();
		 item6.setBounds(100, 660, 200, 30);
		 
		 item7 = new JLabel();
		 item7.setBounds(100, 740, 200, 30);
		 
		 item8 = new JLabel();
		 item8.setBounds(100, 820, 200, 30);
		 
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
		 item1b.setBounds(500, 260, 200, 30);
		 
		 item2b = new JButton();
		 item2b.setBounds(500, 340, 200, 30);
		 
		 item3b = new JButton();
		 item3b.setBounds(500, 420, 200, 30);
		 
		 item4b = new JButton();
		 item4b.setBounds(500, 500, 200, 30);
		 
		 item5b = new JButton();
		 item5b.setBounds(500, 580, 200, 30);
		 
		 item6b = new JButton();
		 item6b.setBounds(500, 660, 200, 30);
		 
		 item7b = new JButton();
		 item7b.setBounds(500, 740, 200, 30);
		 
		 item8b = new JButton();
		 item8b.setBounds(500, 820, 200, 30);
		 
		 buttons = new ArrayList<JButton>();
		 
		 buttons.add(item1b);
		 buttons.add(item2b);
		 buttons.add(item3b);
		 buttons.add(item4b);
		 buttons.add(item5b);
		 buttons.add(item6b);
		 buttons.add(item7b);
		 buttons.add(item8b);
		 
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
		 
		 updatePage();
		 
		 initial_frame.setVisible(true);
	}
	
	public void updatePage()
	{
		fl = f.search(null, null, null, false, false);
		
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
			buttons.get(i).setText("Add " + fl.get(i+offset).getName());
		}
		
		//removing items that were displayed if necessary
		for(int i = rep; i < 8; i++)
		{
			labels.get(i).setText("");
			buttons.get(i).setText("");
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
