package cookbook;

import java.awt.Image;
import java.util.*;
import java.io.*;

public class FoodItem implements Serializable{
	
	private String name;							// Name of the food
	
	private ArrayList<String> ingredients;			// Ingredients contained in the food
	private ArrayList<String> foodType;				// The type list of foods
	public Attributes courses;								// An integer to count bits for each course
	public Attributes allergens;
	
	private String culture;							// Culture the food is associated with
	private String notes;							// Notes about the food
	
	private String textInstructions;				// Instructions on how to prepare the food
	private Image imageInstructions; 				// may want to create our own class to store as image location???
	
	public int id;									// Unique ID for the food item

	
	
	/**
	 * Constructor for when creating a text instruction based recipe
	 *
	 * @param textInstructions The instructions for a food item
	 * @param name The name of the food item
	 */
	public FoodItem(String textInstructions, String name)
	{
		if(imageInstructions == null)
		{
			this.textInstructions = textInstructions;
			this.name = name;
		}
		ingredients = new ArrayList<String>();
		allergens = new Attributes(true);
		courses = new Attributes(false);
	}
	
	/**
	 * Constructor for when creating an image instruction based recipe
	 *
	 * @param textInstructions The instructions for a food item
	 * @param name The name of the food item
	 */
	public FoodItem(Image imageInstructions, String name)
	{
		if(textInstructions == null)
		{
			this.imageInstructions = imageInstructions;
			this.name = name;
		}
		ingredients = new ArrayList<String>();
	}
	
	
	/**
	 * Getter for the name of the food
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Change culture tag //// no null check in case they want to delete this way (removing text)
	 *
	 * @param a The culture that we want to change the food item to
	 */
	public void changeCulture(String a)
	{
		culture = a;
	}
	
	/**
	 * Remove culture tag //// in case they want to delete this way (button)
	 */
	public void removeCulture()
	{
		culture = null;
	}
	
	/**
	 * Adds an ingredient if it doesn't exist already in the ingredients list and is not null
	 * 
	 * @param i The ingredient we want to add the to the ingredients list
	 */
	public void addIngredient(String i)
	{
		if(i == null)
			return;
		if(!ingredients.contains(i.toLowerCase()))
			ingredients.add(i.toLowerCase());
	}
	
	public boolean hasAllergens(Attributes a)
	{
		boolean found = false;
		if(a == null || a.getAttributes() == 0)
		{
			System.err.println("Input Incorrect");
		}
		else
		{
			int check = allergens.getAttributes() & a.getAttributes();
			if(check!=0)
				found = true;
		}
		return found;
	}
	
	public boolean inCourse(Attributes a)
	{
		boolean found = false;
		if(a == null || a.getAttributes() == 0)
		{
			System.err.println("Input Incorrect");
		}
		else
		{
			int check = courses.getAttributes() & a.getAttributes();
			if(check!=0)
				found = true;
		}
		return found;
	}
	
	/**
	 * Adds a list of ingredients to the ingredients list
	 *
	 * @param ing A list of ingredients to add to the ingredients list
	 */
	public void addIngredients(ArrayList<String> ing)
	{
		if(ing.isEmpty())
			return;
		for(int i = 0; i < ing.size(); i++)
		{
			addIngredient(ing.get(i));
		}
	}
	
	/**
	 * Get method for ID
	 * @return int id.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Outputs all ingredients
	 */
	public void listIngredients()
	{
		if(ingredients.isEmpty())
			System.out.println("No ingredients");
		for(int i = 0; i < ingredients.size(); i++)
		{
			System.out.println(ingredients.get(i));
		}
	}
	
	/**
	 * Check to see if the food contains an ingredient
	 *
	 * @param ing The ingredient we are searching for in a food item
	 */
	public boolean containsIngredient(String ing)
	{
		if(ing == null)
			return false;
		return ingredients.contains(ing.toLowerCase());
	}
	
	/**
	 * toString for testing purposes
	 */
	public String toString()
	{
		return "Name: " + name + "\n Text Instructions: " + textInstructions + "\n Ingredients: " + ingredients + "\nAllergens: " + allergens +
				"\nCourses: " + courses + "\nID: " + id;
	}

}
