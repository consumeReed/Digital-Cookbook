package cookbook;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;


public class UserInterface {

	// Implementation
	
	//----------------------------------------
	// Main Panel w/ Buttons & Text Fields
	private JPanel search_panel;	
	private JFrame initial_frame;
	private JButton open_recipe_add;
	private JTextField recipe_search_bar;
	private JButton recipe_search;
	private JButton search_bar_clear;
	private JLabel recipe_search_output;
	//-----------------------------------------
	// Listeners for Main Panel
	private ActionListener open_recipe_frame;
	private ActionListener search_recipe_book;
	private ActionListener clear_search_bar;
	private KeyListener enter_for_search;
	private FocusListener text_prompt;
	//-----------------------------------------
	// Panel for Adding a Recipe w/ Buttons & Text Fields
	private JPanel ingredient_handler_panel;
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
	private JComboBox<String> remove_ingredient;
	//-----------------------------------------
	// Listeners for Adding a Recipe
	
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
		initial_frame = new JFrame("Digital Recipe Book");						// Creates the frame that will be shown when code is ran
		initial_frame.add(search_panel);										// Sets the size of the frame (currently 1080 x 720 pixels) (100, 100 represents where on the device the frame will be created ie at pos (100, 100))
		initial_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			// When "X" in top right corner is click, this makes it so the frame closes
		initial_frame.pack();
		initial_frame.setSize(1080, 720);
		initial_frame.setLocation(100, 100);
		
		// Component initializations
		recipe_search_bar = new JTextField();
		recipe_search = new JButton("Search");
		search_bar_clear = new JButton("X");
		open_recipe_add = new JButton("Add Recipe");
		recipe_search_output = new JLabel();
		
		// Component setups
		recipe_search_bar.setPreferredSize(new Dimension(300, 20));
		recipe_search_bar.setText("Search Recipe");
		
		// Listeners
		open_recipe_add.addActionListener(open_recipe_frame);
		recipe_search.addActionListener(search_recipe_book);
		recipe_search_bar.addKeyListener(enter_for_search);
		recipe_search_bar.addFocusListener(text_prompt);
		search_bar_clear.addActionListener(clear_search_bar);		
		
		// Color setup															// *Just put this for testing purposes, feel free to edit*
		search_panel.setBackground(Color.DARK_GRAY);
		open_recipe_add.setBackground(Color.GRAY);
		open_recipe_add.setForeground(Color.GREEN);
		recipe_search.setBackground(Color.GRAY);
		recipe_search.setForeground(Color.WHITE);
		search_bar_clear.setBackground(Color.GRAY);
		search_bar_clear.setForeground(Color.RED);
		recipe_search_output.setForeground(Color.WHITE);
		
		// Layout creation
		search_panel.add(open_recipe_add);
		search_panel.add(recipe_search);
		search_panel.add(recipe_search_bar);
		search_panel.add(search_bar_clear);
		search_panel.add(recipe_search_output);
		
		
	}
	
	public void add_recipe_frame_maker() {
		
		// Frame and Panel setup
		choose_add_recipe_type = new JPanel();
		instruc_and_culture_panel = new JPanel();
		ingredient_handler_panel = new JPanel();
		JPanel holder = new JPanel();
		add_recipe_frame = new JFrame("New Recipe");
		add_recipe_frame.setVisible(true);
		add_recipe_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		add_recipe_frame.pack();
		add_recipe_frame.setSize(1080, 720);
		add_recipe_frame.setLocation(125, 125);
		
		// Sets layout for the add_recipe_frame
		BorderLayout border = new BorderLayout();
		FlowLayout flow = new FlowLayout(FlowLayout.CENTER, 5, 20);
		BoxLayout box = new BoxLayout(instruc_and_culture_panel, BoxLayout.PAGE_AXIS);
		BorderLayout grid_border = new BorderLayout();
		GridLayout grid = new GridLayout(20, 20);
		
		add_recipe_frame.setLayout(border);
		choose_add_recipe_type.setLayout(flow);
		instruc_and_culture_panel.setLayout(box);
		ingredient_handler_panel.setLayout(grid);
		holder.setLayout(grid_border);
		
		add_recipe_frame.add(choose_add_recipe_type, BorderLayout.CENTER);
		add_recipe_frame.add(instruc_and_culture_panel, BorderLayout.WEST);
		add_recipe_frame.add(holder, BorderLayout.EAST);
		holder.add(ingredient_handler_panel, BorderLayout.EAST);
		
		// Component initializations
		choose_text_add = new JButton("Text");
		choose_image_add = new JButton("Image");
		add_instructions = new JTextArea();
		instructions_scroll = new JScrollPane(add_instructions);
		add_culture = new JTextField();
		add_ingredient = new JTextField();
		add_ingredient_button = new JButton("+");
		added_ingredients = new JLabel();
		remove_ingredient_button = new JButton();
		remove_ingredient = new JComboBox<String>();
		
		
		// Component setups
		choose_text_add.setPreferredSize(new Dimension(170, 25));
		choose_image_add.setPreferredSize(new Dimension(170, 25));
		
		instructions_scroll.setPreferredSize(new Dimension(20, 40));
		instructions_scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add_culture.setMaximumSize(new Dimension(450, 30));
		instruc_and_culture_panel.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
		
		add_ingredient.setPreferredSize(new Dimension(250, 20));;
		ingredient_handler_panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
		
		
		// Listeners
		
		
		// Color setup
		choose_add_recipe_type.setBackground(Color.DARK_GRAY);
		instruc_and_culture_panel.setBackground(Color.DARK_GRAY);
		ingredient_handler_panel.setBackground(Color.DARK_GRAY);
		add_recipe_frame.setBackground(Color.DARK_GRAY);
		
		// Layout creation
		choose_add_recipe_type.add(choose_text_add);
		choose_add_recipe_type.add(choose_image_add);
		instruc_and_culture_panel.add(Box.createRigidArea(new Dimension(450, 200)));
		instruc_and_culture_panel.add(instructions_scroll);
		instruc_and_culture_panel.add(Box.createRigidArea(new Dimension(450, 100)));
		instruc_and_culture_panel.add(add_culture);
		instruc_and_culture_panel.add(Box.createRigidArea(new Dimension(450, 200)));
		ingredient_handler_panel.add(add_ingredient);
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
	}
	
	
}
