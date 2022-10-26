package cookbook;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;


public class UserInterface implements KeyListener{

	private JFrame initial_frame;
	private JButton open_recipe_add;
	private JTextField recipe_search_bar;
	private JButton recipe_search; 
	private JButton search_bar_clear;
	private JLabel test_label;
	
	private JFrame add_recipe_frame;
	
	private ActionListener open_recipe_frame;
	private ActionListener search_recipe_book; 
	private ActionListener clear_search_bar;
	
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
		
		initial_frame = new JFrame("Digital Recipe Book");						// Creates the frame that will be shown when code is ran
		initial_frame.setBounds(100, 100, 1080, 720);							// Sets the size of the frame (currently 1080 x 720 pixels) (100, 100 represents where on the device the frame will be created ie at pos (100, 100))
		initial_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			// When "X" in top right corner is click, this makes it so the frame closes
		initial_frame.getContentPane().setLayout(null);							// Sets layout of the frame (Useful )
		
		open_recipe_add = new JButton("Add Recipe");							// Button to add recipe (When clicked opens new window)
		open_recipe_add.setSize(300, 20);
		open_recipe_add.addActionListener(open_recipe_frame);
		initial_frame.getContentPane().add(open_recipe_add);
		open_recipe_add.setLocation(0, 0);
		
		recipe_search = new JButton("Search");									// Button to search for recipe (When clicked gets text from recipe_search_bar)
		recipe_search.setSize(100, 20);
		recipe_search.addActionListener(search_recipe_book);
		initial_frame.getContentPane().add(recipe_search);
		recipe_search.setLocation(790, 30);
		
		recipe_search_bar = new JTextField();									// Text Field for user to enter something to search for
		recipe_search_bar.setSize(500, 20);
		initial_frame.getContentPane().add(recipe_search_bar);
		recipe_search_bar.setLocation(290, 30);
		
		search_bar_clear = new JButton("X");									// Button to clear the recipe_search_bar (Avoids having to delete what's currently in search bar)
		search_bar_clear.setSize(50, 20);
		search_bar_clear.addActionListener(clear_search_bar);
		initial_frame.getContentPane().add(search_bar_clear);
		search_bar_clear.setLocation(880, 30);
		
		test_label = new JLabel();
		test_label.setSize(500, 40);
		initial_frame.getContentPane().add(test_label);
		test_label.setLocation(290, 50);
	}
	
	public void add_recipe_frame_maker() {
		add_recipe_frame = new JFrame("New Recipe");
		add_recipe_frame.setBounds(100, 100, 1080, 720);
		add_recipe_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		add_recipe_frame.getContentPane().setLayout(null);
		add_recipe_frame.setVisible(true);
	}
	
	public void setUpButtonListeners() {
		open_recipe_frame = new ActionListener() {								// When open_recipe_add is clicked, a new window will be created for adding 
			@Override
			public void actionPerformed(ActionEvent e) {
				add_recipe_frame_maker();
			}
		};
		
		search_recipe_book = new ActionListener() {								// When recipe_search is clicked, the text will be printed onto test_label
			@Override
			public void actionPerformed(ActionEvent e) {
				if(test_label.getText() == "") {
					test_label.setText(recipe_search_bar.getText());			// recipe_search_bar.getText() is used to get text thats stored in recipe_search_bar at time of button click
				}
				else {
					test_label.setText(recipe_search_bar.getText());
				}
			}
		};
		
		clear_search_bar = new ActionListener() {								// When search_bar_clear is clicked, the text in recipe_search_bar will be cleared (set to "")
			@Override
			public void actionPerformed(ActionEvent e) {
				recipe_search_bar.setText("");
			}
		};
	
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		 }

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER)// clicking enter button for search
		 { 
				if(test_label.getText() == "") {
					test_label.setText(recipe_search_bar.getText());			// recipe_search_bar.getText() is used to get text thats stored in recipe_search_bar at time of button click
				}
				else {
					test_label.setText(recipe_search_bar.getText());
				
	
	}}}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
