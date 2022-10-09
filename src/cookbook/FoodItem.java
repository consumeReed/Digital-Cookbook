package cookbook;

import java.awt.Image;
import java.util.*;

public class FoodItem {
	
	private String name;
	
	private ArrayList<String> ingredients;
	private ArrayList<String> allergens;
	private ArrayList<String> foodType;
	
	private String culture;
	private String notes;
	
	private String textInstructions;
	private Image imageInstructions; // may want to create our own class to store as image location???
	
	
	/**
	 * Constructor for when creating a text instruction based recipe
	 * 
	 */
	public FoodItem(String textInstructions, String name)
	{
		if(imageInstructions == null)
		{
			this.textInstructions = textInstructions;
			this.name = name;
		}
		ingredients = new ArrayList<String>();
	}
	
	/**
	 * Constructor for when creating an image instruction based recipe
	 * 
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
	
	
	
	public String getName()
	{
		return name;
	}
	
	/**
	 * 
	 * Change culture tag ////no null check in case they want to delete this way (removing text)
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
	 */
	public void addIngredient(String i)
	{
		if(i == null)
			return;
		if(!ingredients.contains(i))
			ingredients.add(i);
	}
	
	/**
	 * Adds a list of ingredients to the ingredients list
	 * 
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
	 */
	public boolean containsIngredient(String ing)
	{
		if(ing == null)
			return false;
		return ingredients.contains(ing);
	}
	
	/**
	 * toString for testing purposes
	 */
	public String toString()
	{
		return "Name: " + name + "\n Text Instructions: " + textInstructions + "\n Ingredients: " + ingredients;
	}

}
