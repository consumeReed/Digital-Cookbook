package cookbook;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;


public class UserInterface {

	// Implementation
	private FoodItemList food_item_list = new FoodItemList();
	private ArrayList<String> ingredients_list;
	//----------------------------------------
	// Main Panel w/ Buttons & Text Fields
	private JPanel search_panel;	
	private JPanel buttons_panel;
	private JPanel filter_panel;
	private JPanel filter_panel_2;
	private JPanel search_and_filter_panel;
	private JPanel results_panel;
	private JFrame initial_frame;
	private JButton open_recipe_add;
	private JButton open_recipe_remove;
	private JTextField recipe_search_bar;
	private JButton recipe_search;
	private JButton search_bar_clear;
	private JTextArea recipe_search_output;
	private JCheckBox exclude_course_filter;
	private JCheckBox breakfast_filter;
	private JCheckBox lunch_filter;
	private JCheckBox dinner_filter;
	private JCheckBox dessert_filter;
	private JCheckBox appetizer_filter;
	private JCheckBox snack_filter;
	private JCheckBox side_filter;
	private JCheckBox main_filter;
	private JCheckBox exclude_ingredient_filter;
	private JCheckBox milk_filter;
	private JCheckBox eggs_filter;
	private JCheckBox fish_filter;
	private JCheckBox crustacean_shellfish_filter;
	private JCheckBox tree_nut_filter;
	private JCheckBox peanut_filter;
	private JCheckBox wheat_filter;
	private JCheckBox soya_filter;
	//-----------------------------------------
	// Listeners for Main Panel
	private ActionListener open_recipe_frame;
	private ActionListener search_recipe_book;
	private ActionListener clear_search_bar;
	private KeyListener enter_for_search;
	private FocusListener text_prompt;
	private ActionListener filter_search;
	//-----------------------------------------
	// Panel for Adding a Recipe w/ Buttons & Text Fields
	private JPanel ingredient_handler_panel;
	private JPanel add_ingredient_handler_panel;
	private JPanel list_ingredient_handler_panel;
	private JPanel instruc_and_culture_panel;
	private JPanel save_panel;
	private JPanel choose_add_recipe_type;
	private JFrame add_recipe_frame;
	private JButton choose_text_add;
	private JButton choose_image_add;
	private JTextField add_ingredient;
	private JButton add_ingredient_button;
	private JTextArea add_instructions;
	private JScrollPane instructions_scroll;
	private JTextField add_culture;
	private JLabel added_ingredients;
	private JButton remove_ingredient_button;
	private JButton save_new_recipe_button;
	//-----------------------------------------
	// Listeners for Adding a Recipe
	private ActionListener text_recipe_type;
	private ActionListener image_recipe_type;
	private ActionListener ingredient_add;
	private ActionListener ingredient_remove;
	private KeyListener ingredient_add_enter;
	private FocusListener text_prompt_culture;
	private FocusListener text_prompt_ingredient;
	private ActionListener save_new_recipe;
	//-----------------------------------------
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
					window.initial_frame.setVisible(true);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public UserInterface() {
		initialize();
	}
	
	private void initialize() {
		setUpButtonListeners();
		
		// Frame and Panel setup
		search_panel = new JPanel();
		buttons_panel = new JPanel();
		filter_panel = new JPanel();
		filter_panel_2 = new JPanel();
		search_and_filter_panel = new JPanel();
		results_panel = new JPanel();
		initial_frame = new JFrame("Digital Recipe Book");						// Creates the frame that will be shown when code is ran
		initial_frame.add(search_panel);										// Sets the size of the frame (currently 1080 x 720 pixels) (100, 100 represents where on the device the frame will be created ie at pos (100, 100))
		initial_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			// When "X" in top right corner is click, this makes it so the frame closes
		initial_frame.pack();
		initial_frame.setSize(1080, 720);
		initial_frame.setLocation(100, 100);
		
		// Sets layouts for initial_frame
		BorderLayout main_border = new BorderLayout();
		FlowLayout main_flow = new FlowLayout(FlowLayout.CENTER, 10, 5);
		BoxLayout main_box = new BoxLayout(buttons_panel, BoxLayout.PAGE_AXIS);
		BoxLayout search_filter_box = new BoxLayout(search_and_filter_panel, BoxLayout.PAGE_AXIS);
		FlowLayout filter_flow = new FlowLayout(FlowLayout.CENTER, 10, 5);
		
		initial_frame.setLayout(main_border);
		search_panel.setLayout(main_flow);
		buttons_panel.setLayout(main_box);
		search_and_filter_panel.setLayout(search_filter_box);
		filter_panel.setLayout(filter_flow);
		filter_panel_2.setLayout(filter_flow);
		
		search_and_filter_panel.add(search_panel);
		search_and_filter_panel.add(filter_panel);
		search_and_filter_panel.add(filter_panel_2);
		initial_frame.add(search_and_filter_panel, BorderLayout.NORTH);
		initial_frame.add(results_panel, BorderLayout.CENTER);
		initial_frame.add(buttons_panel, BorderLayout.EAST);
		
		// Component initializations
		recipe_search_bar = new JTextField();
		recipe_search = new JButton("Search");
		search_bar_clear = new JButton("X");
		open_recipe_add = new JButton("Add Recipe");
		open_recipe_remove = new JButton("Remove Recipe");
		recipe_search_output = new JTextArea();
		
		exclude_course_filter = new JCheckBox("Exclude Course");
		breakfast_filter = new JCheckBox("Breakfast");
		lunch_filter = new JCheckBox("Lunch");
		dinner_filter = new JCheckBox("Dinner");
		dessert_filter = new JCheckBox("Dessert");
		appetizer_filter = new JCheckBox("Appetizer");
		snack_filter = new JCheckBox("Snack");
		side_filter = new JCheckBox("Side");
		main_filter = new JCheckBox("Main");
		
		exclude_ingredient_filter = new JCheckBox("Exclude Ingredient");
		milk_filter = new JCheckBox("Milk");
		eggs_filter = new JCheckBox("Eggs");
		fish_filter = new JCheckBox("Fish");
		crustacean_shellfish_filter = new JCheckBox("Crustacean Shellfish");
		tree_nut_filter = new JCheckBox("Tree Nut");
		peanut_filter = new JCheckBox("Peanut");
		wheat_filter = new JCheckBox("Wheat");
		soya_filter = new JCheckBox("Soya");
		
		// Component setups
//		results_panel.setBorder(BorderFactory.createEmptyBorder(60, 0, 30, 0));
		recipe_search_bar.setPreferredSize(new Dimension(300, 20));
		recipe_search_bar.setText("Search Recipe");
		recipe_search_output.setPreferredSize(new Dimension(initial_frame.getWidth() - buttons_panel.getWidth() - 30, initial_frame.getHeight() - search_and_filter_panel.getHeight()));
		recipe_search_output.setLineWrap(true);
		recipe_search_output.setWrapStyleWord(true);
		recipe_search_output.setEditable(false);
		
		// Listeners
		open_recipe_add.addActionListener(open_recipe_frame);
		recipe_search.addActionListener(search_recipe_book);
		recipe_search_bar.addKeyListener(enter_for_search);
		recipe_search_bar.addFocusListener(text_prompt);
		search_bar_clear.addActionListener(clear_search_bar);		
		
		// Color setup															// *Just put this for testing purposes, feel free to edit*
		search_panel.setBackground(Color.DARK_GRAY);
		results_panel.setBackground(Color.WHITE);
		results_panel.setBounds(0, 0, initial_frame.getWidth() - buttons_panel.getWidth() - 30, initial_frame.getHeight() - search_and_filter_panel.getHeight() - 30);
		buttons_panel.setBackground(Color.DARK_GRAY);
		search_and_filter_panel.setBackground(Color.DARK_GRAY);
		search_panel.setBackground(Color.DARK_GRAY);
		filter_panel.setBackground(Color.DARK_GRAY);
		filter_panel_2.setBackground(Color.DARK_GRAY);
		exclude_course_filter.setBackground(Color.DARK_GRAY);
		exclude_course_filter.setForeground(Color.WHITE);
		breakfast_filter.setBackground(Color.DARK_GRAY);
		breakfast_filter.setForeground(Color.WHITE);
		lunch_filter.setBackground(Color.DARK_GRAY);
		lunch_filter.setForeground(Color.WHITE);
		dinner_filter.setBackground(Color.DARK_GRAY);
		dinner_filter.setForeground(Color.WHITE);
		dessert_filter.setBackground(Color.DARK_GRAY);
		dessert_filter.setForeground(Color.WHITE);
		appetizer_filter.setBackground(Color.DARK_GRAY);
		appetizer_filter.setForeground(Color.WHITE);
		snack_filter.setBackground(Color.DARK_GRAY);
		snack_filter.setForeground(Color.WHITE);
		side_filter.setBackground(Color.DARK_GRAY);
		side_filter.setForeground(Color.WHITE);
		main_filter.setBackground(Color.DARK_GRAY);
		main_filter.setForeground(Color.WHITE);
		exclude_ingredient_filter.setBackground(Color.DARK_GRAY);
		exclude_ingredient_filter.setForeground(Color.WHITE);
		milk_filter.setBackground(Color.DARK_GRAY);
		milk_filter.setForeground(Color.WHITE);
		eggs_filter.setBackground(Color.DARK_GRAY);
		eggs_filter.setForeground(Color.WHITE);
		fish_filter.setBackground(Color.DARK_GRAY);
		fish_filter.setForeground(Color.WHITE);
		crustacean_shellfish_filter.setBackground(Color.DARK_GRAY);
		crustacean_shellfish_filter.setForeground(Color.WHITE);
		tree_nut_filter.setBackground(Color.DARK_GRAY);
		tree_nut_filter.setForeground(Color.WHITE);
		peanut_filter.setBackground(Color.DARK_GRAY);
		peanut_filter.setForeground(Color.WHITE);
		wheat_filter.setBackground(Color.DARK_GRAY);
		wheat_filter.setForeground(Color.WHITE);
		soya_filter.setBackground(Color.DARK_GRAY);
		soya_filter.setForeground(Color.WHITE);
		open_recipe_add.setBackground(Color.DARK_GRAY);
		open_recipe_add.setForeground(Color.GREEN);
		open_recipe_remove.setBackground(Color.DARK_GRAY);
		open_recipe_remove.setForeground(Color.RED);
		recipe_search.setBackground(Color.DARK_GRAY);
		recipe_search.setForeground(Color.WHITE);
		search_bar_clear.setBackground(Color.DARK_GRAY);
		search_bar_clear.setForeground(Color.WHITE);
		recipe_search_output.setForeground(Color.BLACK);
		
		
		// Layout creation
		search_panel.add(recipe_search_bar);
		search_panel.add(recipe_search);
		search_panel.add(search_bar_clear);
		filter_panel.add(exclude_course_filter);
		filter_panel.add(breakfast_filter);
		filter_panel.add(lunch_filter);
		filter_panel.add(dinner_filter);
		filter_panel.add(dessert_filter);
		filter_panel.add(appetizer_filter);
		filter_panel.add(snack_filter);
		filter_panel.add(side_filter);
		filter_panel.add(main_filter);
		filter_panel_2.add(exclude_ingredient_filter);
		filter_panel_2.add(milk_filter);
		filter_panel_2.add(eggs_filter);
		filter_panel_2.add(fish_filter);
		filter_panel_2.add(crustacean_shellfish_filter);
		filter_panel_2.add(tree_nut_filter);
		filter_panel_2.add(peanut_filter);
		filter_panel_2.add(wheat_filter);
		filter_panel_2.add(soya_filter);
		results_panel.add(recipe_search_output);
		buttons_panel.add(open_recipe_add);
		buttons_panel.add(open_recipe_remove);
		
	}
	
	public void add_recipe_frame_maker() {
		
		// Frame and Panel setup
		choose_add_recipe_type = new JPanel();
		instruc_and_culture_panel = new JPanel();
		ingredient_handler_panel = new JPanel();
		add_ingredient_handler_panel = new JPanel();
		list_ingredient_handler_panel = new JPanel();
		save_panel = new JPanel();
		add_recipe_frame = new JFrame("New Recipe");
		add_recipe_frame.setVisible(true);
		add_recipe_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		add_recipe_frame.pack();
		add_recipe_frame.setSize(1080, 720);
		add_recipe_frame.setLocation(125, 125);
		
		// Sets layout for the add_recipe_frame
		BorderLayout border = new BorderLayout();
		FlowLayout flow = new FlowLayout(FlowLayout.CENTER, 25, 5);
		BoxLayout box = new BoxLayout(instruc_and_culture_panel, BoxLayout.PAGE_AXIS);
		BoxLayout box_ingredient = new BoxLayout(ingredient_handler_panel, BoxLayout.PAGE_AXIS);
		FlowLayout flow_ingredient = new FlowLayout(FlowLayout.CENTER, 5, 5);
		FlowLayout flow_remove_ingredient = new FlowLayout(FlowLayout.CENTER, 5, 5);
		
		add_recipe_frame.setLayout(border);
		choose_add_recipe_type.setLayout(flow);
		instruc_and_culture_panel.setLayout(box);
		ingredient_handler_panel.setLayout(box_ingredient);
		add_ingredient_handler_panel.setLayout(flow_ingredient);
		list_ingredient_handler_panel.setLayout(flow_remove_ingredient);
		
		add_recipe_frame.add(choose_add_recipe_type, BorderLayout.NORTH);
		add_recipe_frame.add(instruc_and_culture_panel, BorderLayout.CENTER);
		add_recipe_frame.add(ingredient_handler_panel, BorderLayout.EAST);
		ingredient_handler_panel.add(add_ingredient_handler_panel);
		ingredient_handler_panel.add(list_ingredient_handler_panel);
		add_recipe_frame.add(save_panel, BorderLayout.SOUTH);
		
		// Component initializations
		choose_text_add = new JButton("Text");
		choose_image_add = new JButton("Image");
		add_instructions = new JTextArea();
		instructions_scroll = new JScrollPane(add_instructions);
		add_culture = new JTextField();
		add_ingredient = new JTextField();
		add_ingredient_button = new JButton("+");
		added_ingredients = new JLabel();
		remove_ingredient_button = new JButton("Remove Ingredient");
		save_new_recipe_button = new JButton("Save");
		
		// Component setups
		choose_add_recipe_type.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		choose_text_add.setPreferredSize(new Dimension(170, 25));
		choose_image_add.setPreferredSize(new Dimension(170, 25));
		
		instructions_scroll.setPreferredSize(new Dimension(20, 40));
		instructions_scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add_culture.setMaximumSize(new Dimension(450, 30));
		instruc_and_culture_panel.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 75));
		
		add_ingredient.setPreferredSize(new Dimension(250, 20));
		add_ingredient_button.setPreferredSize(new Dimension(50, 20));
		added_ingredients.setPreferredSize(new Dimension(300, 100));
		remove_ingredient_button.setPreferredSize(new Dimension(140, 20));
		ingredient_handler_panel.setBorder(BorderFactory.createEmptyBorder(200, 0, 310, 25));
		
		save_new_recipe_button.setPreferredSize(new Dimension(add_recipe_frame.getX(), 30));
		
		
		// Listeners
		
		
		// Color setup
		choose_add_recipe_type.setBackground(Color.DARK_GRAY);
		instruc_and_culture_panel.setBackground(Color.DARK_GRAY);
		ingredient_handler_panel.setBackground(Color.DARK_GRAY);
		add_ingredient_handler_panel.setBackground(Color.DARK_GRAY);
		list_ingredient_handler_panel.setBackground(Color.DARK_GRAY);
		save_panel.setBackground(Color.DARK_GRAY);
		add_recipe_frame.setBackground(Color.DARK_GRAY);
		
		// Layout creation
		choose_add_recipe_type.add(choose_text_add);
		choose_add_recipe_type.add(choose_image_add);
		instruc_and_culture_panel.add(Box.createRigidArea(new Dimension(450, 200)));
		instruc_and_culture_panel.add(instructions_scroll);
		instruc_and_culture_panel.add(Box.createRigidArea(new Dimension(450, 100)));
		instruc_and_culture_panel.add(add_culture);
		instruc_and_culture_panel.add(Box.createRigidArea(new Dimension(450, 200)));
		add_ingredient_handler_panel.add(add_ingredient);
		add_ingredient_handler_panel.add(add_ingredient_button);
		add_ingredient_handler_panel.add(remove_ingredient_button);
		list_ingredient_handler_panel.add(added_ingredients);
		save_panel.add(save_new_recipe_button);
	}
	
	
	
	
	public void setUpButtonListeners() {
		open_recipe_frame = new ActionListener() {								// When open_recipe_add is clicked, a new window will be created for adding 
			@Override
			public void actionPerformed(ActionEvent e) {
				add_recipe_frame_maker();
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
				else {
					
				}
			}
		};
		
		
		
		// Listeners for the Add Recipe frame
		text_recipe_type = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		
		image_recipe_type = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		};

		ingredient_add = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		
		ingredient_remove = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		};

		save_new_recipe = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		
		ingredient_add_enter = new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
			}
		};
		
		text_prompt_culture = new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				
			}
		};
		
		text_prompt_ingredient = new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				
			}
		};
	}
	
	/**
	 * breakfast_filter = new JCheckBox("Breakfast");
		lunch_filter = new JCheckBox("Lunch");
		dinner_filter = new JCheckBox("Dinner");
		dessert_filter = new JCheckBox("Dessert");
		appetizer_filter = new JCheckBox("Appetizer");
		snack_filter = new JCheckBox("Snack");
		side_filter = new JCheckBox("Side");
		main_filter = new JCheckBox("Main");
		milk_filter = new JCheckBox("Milk");
		eggs_filter = new JCheckBox("Eggs");
		fish_filter = new JCheckBox("Fish");
		crustacean_shellfish_filter = new JCheckBox("Crustacean Shellfish");
		tree_nut_filter = new JCheckBox("Tree Nut");
		peanut_filter = new JCheckBox("Peanut");
		wheat_filter = new JCheckBox("Wheat");
		soya_filter = new JCheckBox("Soya");
	 */
}
