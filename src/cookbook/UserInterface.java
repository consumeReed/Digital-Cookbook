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
	private KeyListener enter;
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
		recipe_search_bar = new JTextField("Search Recipe");
		recipe_search = new JButton("Search");
		search_bar_clear = new JButton("X");
		open_recipe_add = new JButton("Add Recipe");
		recipe_search_output = new JLabel();
		
		// Component setups
		recipe_search_bar.setPreferredSize(new Dimension(300, 20));
		
		// Listeners
		open_recipe_add.addActionListener(open_recipe_frame);
		recipe_search.addActionListener(search_recipe_book);
		recipe_search_bar.addKeyListener(enter);
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
		GridLayout grid = new GridLayout();
		
		add_recipe_frame.setLayout(border);
		choose_add_recipe_type.setLayout(flow);
		instruc_and_culture_panel.setLayout(box);
		ingredient_handler_panel.setLayout(grid);
		
		add_recipe_frame.add(choose_add_recipe_type);
		add_recipe_frame.add(instruc_and_culture_panel, BorderLayout.LINE_START);
		add_recipe_frame.add(ingredient_handler_panel, BorderLayout.LINE_END);
		
		// Component initializations
		choose_text_add = new JButton("Text");
		choose_image_add = new JButton("Image");
		add_instructions = new JTextArea();
		add_culture = new JTextField();
		add_ingredient = new JTextField();
		add_ingredient_button = new JButton("+");
		added_ingredients = new JLabel();
		remove_ingredient_button = new JButton();
		remove_ingredient = new JComboBox<String>();
		
		JLabel filler1 = new JLabel();
		JLabel filler2 = new JLabel();
		JLabel filler3 = new JLabel();
		
		// Component setups
		choose_text_add.setPreferredSize(new Dimension(170, 25));
		choose_image_add.setPreferredSize(new Dimension(170, 25));
		
		filler3.setPreferredSize(new Dimension(350, 200));
		add_instructions.setPreferredSize(new Dimension(350, 40));
		filler2.setPreferredSize(new Dimension(350, 50));
		add_culture.setPreferredSize(new Dimension(350, 20));
		filler1.setPreferredSize(new Dimension(350, 200));
		
		
		
		// Listeners
		
		
		// Color setup
		choose_add_recipe_type.setBackground(Color.DARK_GRAY);
		filler1.setBackground(Color.DARK_GRAY);
		filler2.setBackground(Color.DARK_GRAY);
		filler3.setBackground(Color.DARK_GRAY);
		
		// Layout creation
		choose_add_recipe_type.add(choose_text_add);
		choose_add_recipe_type.add(choose_image_add);
		instruc_and_culture_panel.add(filler3);
		instruc_and_culture_panel.add(add_instructions);
		instruc_and_culture_panel.add(filler2);
		instruc_and_culture_panel.add(add_culture);
		instruc_and_culture_panel.add(filler1);
		
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
				if (recipe_search_output.getText() == "") {
					recipe_search_output.setText(recipe_search_bar.getText());	// Current issue where if button is pressed with nothing enters, "Search Recipe" is sent to recipe_search_output
				}
				else {
					recipe_search_output.setText(recipe_search_bar.getText());
				}
			}
		};
		
		clear_search_bar = new ActionListener() {								// When search_bar_clear is clicked, the text in recipe_search_bar and recipe_search_output will be cleared (set to "")
			@Override
			public void actionPerformed(ActionEvent e) {
				recipe_search_bar.setText("");
				recipe_search_output.setText("");
			}
		};
		
		enter = new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {						// Clicking enter button for search
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
