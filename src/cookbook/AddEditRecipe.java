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

public class AddEditRecipe {
	
	private JFrame initial_frame;
	private JPanel main_panel;
	private JTextField food_name, text_instructions;
	private JButton done, choose_image;
	private JCheckBox breakfast_filter, lunch_filter, dinner_filter, dessert_filter, appetizer_filter, snack_filter,
	side_filter, main_filter, milk_filter, eggs_filter, fish_filter, crustacean_shellfish_filter, tree_nut_filter,
	peanut_filter, wheat_filter, soya_filter;
	private ArrayList<JCheckBox> allergyBoxes, courseBoxes;
	
	
	public AddEditRecipe()
	{
		initial_frame = new JFrame("Add Recipe");
		 food_name = new JTextField();
		 food_name.setBounds(100, 40, 500, 20);
		initialize();
		main_panel.add(food_name);
	}
	
	public AddEditRecipe(FoodItemList list, int id)
	{
		initial_frame = new JFrame("Edit Recipe");
		food_name = new JTextField();
		FoodItem tmpFood = list.getById(id);
		food_name.setText(tmpFood.getName());
		food_name.setBounds(100, 40, 500, 20);
		initialize();
		main_panel.add(food_name);
		for(int i = 0; i < 8; i++)
		{
			int tmp = (int) Math.pow(2, i);
			System.out.println(tmp);
			if((tmpFood.allergens.attr&tmp) == tmp)
			{
				allergyBoxes.get(i).setSelected(true);
			}
			if((tmpFood.courses.attr&tmp) == tmp)
			{
				courseBoxes.get(i).setSelected(true);
			}
		}
	}
	
	public void initialize()
	{
		initial_frame.setSize(700, 730);
		initial_frame.setResizable(false);
		initial_frame.setLocation(200, 200);
		initial_frame.setUndecorated(true);
		initial_frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		 MetalLookAndFeel.setCurrentTheme(new MyDefaultMetalTheme());
		 try {
		      UIManager.setLookAndFeel(new MetalLookAndFeel());
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		 SwingUtilities.updateComponentTreeUI(initial_frame);
		 initial_frame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
		 main_panel = new JPanel();
		 main_panel.setLayout(null);
		 initial_frame.getContentPane().add(main_panel);
		 checkboxes();
		 initial_frame.add(main_panel);
		 initial_frame.setVisible(true);
	}
	
	public void checkboxes()
	{
		
		milk_filter = new JCheckBox("Milk");
		milk_filter.setFocusable(false);
		milk_filter.setBounds(23, 120, 50, 20);
		
		eggs_filter = new JCheckBox("Eggs");
		eggs_filter.setFocusable(false);
		eggs_filter.setBounds(83, 120, 55, 20);
		
		fish_filter = new JCheckBox("Fish");
		fish_filter.setFocusable(false);
		fish_filter.setBounds(148, 120, 50, 20);
		
		crustacean_shellfish_filter = new JCheckBox("Crustacean Shellfish");
		crustacean_shellfish_filter.setFocusable(false);
		crustacean_shellfish_filter.setBounds(208, 120, 150, 20);
		
		tree_nut_filter = new JCheckBox("Tree Nut");
		tree_nut_filter.setFocusable(false);
		tree_nut_filter.setBounds(368, 120, 80, 20);
		
		peanut_filter = new JCheckBox("Peanut");
		peanut_filter.setFocusable(false);
		peanut_filter.setBounds(458, 120, 70, 20);
		
		wheat_filter = new JCheckBox("Wheat");
		wheat_filter.setFocusable(false);
		wheat_filter.setBounds(538, 120, 65, 20);
		
		soya_filter = new JCheckBox("Soya");
		soya_filter.setFocusable(false);
		soya_filter.setBounds(613, 120, 55, 20);
		 
		allergyBoxes = new ArrayList<JCheckBox>();
		
		allergyBoxes.add(soya_filter);
		allergyBoxes.add(wheat_filter);
		allergyBoxes.add(peanut_filter);
		allergyBoxes.add(tree_nut_filter);
		allergyBoxes.add(crustacean_shellfish_filter);
		allergyBoxes.add(fish_filter);
		allergyBoxes.add(eggs_filter);
		allergyBoxes.add(milk_filter);
		
		//for(int i = 0; i < 8; i++)
		//	allergyBoxes.get(i).setFont(new Font("Serif", Font.PLAIN, 11));
		
		 
		 breakfast_filter = new JCheckBox("Breakfast");
		 breakfast_filter.setFocusable(false);
		 breakfast_filter.setBounds(23, 80, 85, 20);
		 
		 lunch_filter = new JCheckBox("Lunch");
		 lunch_filter.setFocusable(false);
		 lunch_filter.setBounds(122, 80, 65, 20);
		 
		 dinner_filter = new JCheckBox("Dinner");
		 dinner_filter.setFocusable(false);
		 dinner_filter.setBounds(201, 80, 70, 20);
		 
		 dessert_filter = new JCheckBox("Dessert");
		 dessert_filter.setFocusable(false);
		 dessert_filter.setBounds(285, 80, 75, 20);
		 
		 appetizer_filter = new JCheckBox("Appetizer");
		 appetizer_filter.setFocusable(false);
		 appetizer_filter.setBounds(374, 80, 85, 20);
		 
		 snack_filter = new JCheckBox("Snack");
		 snack_filter.setFocusable(false);
		 snack_filter.setBounds(475, 80, 65, 20);
		 
		 side_filter = new JCheckBox("Side");
		 side_filter.setFocusable(false);
		 side_filter.setBounds(552, 80, 50, 20);
		 
		 main_filter = new JCheckBox("Main");
		 main_filter.setFocusable(false);
		 main_filter.setBounds(612, 80, 55, 20);
		 
		 courseBoxes = new ArrayList<JCheckBox>();
		 
		 courseBoxes.add(main_filter);
		 courseBoxes.add(side_filter);
		 courseBoxes.add(snack_filter);
		 courseBoxes.add(appetizer_filter);
		 courseBoxes.add(dessert_filter);
		 courseBoxes.add(dinner_filter);
		 courseBoxes.add(lunch_filter);
		 courseBoxes.add(breakfast_filter);
		 
		 
		// for(int i = 0; i < 8; i++)
			//	courseBoxes.get(i).setFont(new Font("Serif", Font.PLAIN, 11));
		 
		 
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
			
		 
		 main_panel.add(breakfast_filter);
		 main_panel.add(lunch_filter);
		 main_panel.add(dinner_filter);
		 main_panel.add(dessert_filter);
		 main_panel.add(appetizer_filter);
		 main_panel.add(snack_filter);
		 main_panel.add(side_filter);
		 main_panel.add(main_filter);
		 
		 main_panel.add(milk_filter);
		 main_panel.add(eggs_filter);
		 main_panel.add(fish_filter);
		 main_panel.add(crustacean_shellfish_filter);
		 main_panel.add(tree_nut_filter);
		 main_panel.add(peanut_filter);
		 main_panel.add(wheat_filter);
		 main_panel.add(soya_filter);
	}
}
