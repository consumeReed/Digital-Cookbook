package cookbook;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class UserInterface {

	private JFrame initial_frame;
	
	private JButton open_recipe_add;
	
	private JTextField recipe_search_bar;
	private JButton recipe_search;
	
	
	private ActionListener open_recipe_frame;
	private ActionListener search_recipe_book;
	
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
		
		initial_frame = new JFrame("Digital Recipe Book");
		initial_frame.setBounds(100, 100, 1080, 720);
		initial_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		initial_frame.getContentPane().setLayout(null);
		
		open_recipe_add = new JButton("Add Recipe");
		open_recipe_add.setSize(300, 20);
		open_recipe_add.addActionListener(open_recipe_frame);
		initial_frame.getContentPane().add(open_recipe_add);
		open_recipe_add.setLocation(0, 0);
		
		recipe_search = new JButton("Search");
		recipe_search.setSize(100, 20);
		recipe_search.addActionListener(search_recipe_book);
		initial_frame.getContentPane().add(recipe_search);
		recipe_search.setLocation(790, 30);
		
		recipe_search_bar = new JTextField();
		recipe_search_bar.setSize(500, 20);
		initial_frame.getContentPane().add(recipe_search_bar);
		recipe_search_bar.setLocation(290, 30);
	}
	
	public void setUpButtonListeners() {
		open_recipe_frame = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		};
		
		search_recipe_book = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		};
	}
	
	
}
