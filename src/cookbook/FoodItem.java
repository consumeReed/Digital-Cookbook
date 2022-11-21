package cookbook;

import java.awt.Image;
import java.util.*;
import java.io.*;

public class FoodItem implements Serializable{
	
	private String name;							// Name of the food
	
	private ArrayList<String> ingredients;			// Ingredients contained in the food
	public Attributes courses;								// An integer to count bits for each course
	public Attributes allergens;
	
	private String culture;							// Culture the food is associated with
	private String notes;							// Notes about the food
	
	private String textInstructions;				// Instructions on how to prepare the food
	private String imageInstructions; 				// may want to create our own class to store as image location???
	
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
	 * Constructor with only name param for UI
	 */
	public FoodItem(String name)
	{
		this.name = name;
		ingredients = new ArrayList<String>();
		allergens = new Attributes(true);
		courses = new Attributes(false);
	}
	
	public void addText(String textInstructions)
	{
		this.textInstructions = textInstructions;
		imageInstructions = null;
	}
	
	public void addImage(String imageInstructions)
	{
		this.imageInstructions = imageInstructions;
		textInstructions = null;
	}
	

	public void parseIngredients(String input)
	{
		Scanner scanner = new Scanner(input);
		ingredients.clear();
		while (scanner.hasNextLine()) {
		  String line = scanner.nextLine();
		  if(!ingredients.contains(line.toLowerCase()))
				ingredients.add(line.toLowerCase());
		}
		scanner.close();
	}
	
	public String getIngredients()
	{
		String txt = "";
		for(int i = 0; i < ingredients.size(); i++)
		{
			txt+=ingredients.get(i)+"\n";
		}
		return txt;
	}
	
	public void deleteIngredient(int input)
	{
		ingredients.remove(input);
	}
	
	/**
	 * Getter for the name of the food
	 */
	public String getName()
	{
		return name;
	}
	
	public void setNote(String notes)
	{
		this.notes = notes;
	}
	
	public String getNotes()
	{
		return notes;
	}
	
	public String getType()
	{
		if(textInstructions == null)
		{
			return "Image";
		}
		else {
			return "Text";
		}
	}
	
	public String getCulture()
	{
		return culture;
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
			//System.err.println("Input Incorrect");
		}
		else
		{
			int check = allergens.getAttributes() & a.getAttributes();
			if(check==0)
				found = true;
		}
		return found;
	}
	
	public boolean hasCourses(Attributes a)
	{
		boolean found = false;
		if(a == null || a.getAttributes() == 0)
		{
			//System.err.println("Input Incorrect");
		}
		else
		{
			int check = courses.getAttributes() & a.getAttributes();
			if(check==0)
				found = true;
		}
		return found;
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
		for(int i = 0; i< ingredients.size(); i++)
		{
			if(ingredients.get(i).contains(ing.toLowerCase()))
				return true;
		}
		return false;
	}
	
	/**
	 * toString for testing purposes
	 */
	public String toString()
	{
		if(textInstructions != null)
			return "Name: " + name + "\n Text Instructions: " + textInstructions + "\nAllergens: " + allergens +
				"\nCourses: " + courses + "\nID: " + id;
		else
			return "Name: " + name + "\n Image Path: " + imageInstructions  + "\nAllergens: " + allergens +
					"\nCourses: " + courses + "\nID: " + id;
	}

}
