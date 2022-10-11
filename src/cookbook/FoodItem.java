package cookbook;

import java.awt.Image;
import java.util.*;

public class FoodItem {
	
	private String name;
	
	private ArrayList<String> ingredients;
	private ArrayList<String> allergens;
	private ArrayList<String> foodType;
	private ArrayList<Course> courses;
	
	private String culture;
	private String notes;
	
	private String textInstructions;
	private Image imageInstructions; // may want to create our own class to store as image location???
	
	public int id;

	
	
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
		if(!ingredients.contains(i.toLowerCase()))
			ingredients.add(i.toLowerCase());
	}
	
	/**
	 * Add course types to the course list, not allowing duplicates
	 */
	public void addCourse(Course courseAdd) {
		if(courses.isEmpty()) {
			courses.add(courseAdd);
		} else {
			for(Course courseCheck : courses) {
				if(courseCheck.equals(courseAdd)) {
					return;
				}
			}
			courses.add(courseAdd);
		}
	}
	
	/**
	 * Lists all the courses in this fooditem.
	 */
	public void listCourse() {
		if(courses.isEmpty()) {
			System.out.println("No Courses Selected.");
		} else {
			for(Course course_print : courses) {
				System.out.println(course_print.getCourse());
			}
		}
	}
	
	/**
	 * Checks if the item is apart of a course;
	 * @return true if fooditem is apart of search_course
	 */
	public boolean courseTime(Course search_course) {
		if(courses.isEmpty()) {
			return false;
		} else {
			return courses.contains(search_course);
		}
			
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
		return ingredients.contains(ing.toLowerCase());
	}
	
	/**
	 * toString for testing purposes
	 */
	public String toString()
	{
		return "Name: " + name + "\n Text Instructions: " + textInstructions + "\n Ingredients: " + ingredients;
	}

}
