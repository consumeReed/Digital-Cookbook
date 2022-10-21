package cookbook;
import java.util.*;

public class FoodItemList {
	
	public ArrayList<FoodItem> foodlist;
	
	public FoodItemList()
	{
		foodlist = new ArrayList<FoodItem>(); //will become an if statment later that will auto check if the user has existing data
	}
	
	
	/**
	 * 
	 * @param name name of new recipe
	 * @param textInstructions text instruction
	 */
	public void addFood(String name, String textInstructions)
	{
		FoodItem newFood = new FoodItem(textInstructions, name);
		newFood.id = foodlist.size()+1;
		foodlist.add(newFood);
	}
	
	/**
	 * Test method
	 * @param adder
	 */
	public void addFood(FoodItem adder) {
		FoodItem newFood = adder;
		newFood.id = foodlist.size()+1;
		foodlist.add(newFood);
	}
	
	
	/**
	 * IF YOU WANT TO ADD MORE THINGS TO SEARCH BY TALK TO REED ABOUT THIS FIRST
	 * 
	 */
	public ArrayList<FoodItem> search(String name, Attributes allergy, Attributes course)
	{
		ArrayList<FoodItem> searchedList = foodlist;
		ArrayList<FoodItem> tmp = new ArrayList<FoodItem>();
		if(name != null)
		{
			for(int i = 0; i < searchedList.size(); i++)
			{
				if(searchedList.get(i).getName().toLowerCase().contains(name.toLowerCase()))
					tmp.add(searchedList.get(i));
			}
			searchedList = tmp;
			
		}
	
		
		
		if(allergy != null)
		{
			ArrayList<FoodItem> tmp2 = new ArrayList<FoodItem>();
				
					for(FoodItem item : searchedList) 
					{
						if(item.hasAllergens(allergy))
							tmp2.add(item);
					}
					searchedList = tmp2;
				}
		
		if(course != null) {
			ArrayList<FoodItem> tmp3 = new ArrayList<>();
			for(FoodItem item : searchedList) {
				if(item.inCourse(course)) {
					tmp3.add(item);
				}
			}
			searchedList = tmp3; 
		}

		
		return searchedList;
		
		}
		
/**	
	/**
	 * 
	 * @param name query to search by
	 * @return list containing all matches of search query in name
	 
	public ArrayList<FoodItem> searchName(String name)
	{
		ArrayList<FoodItem> p = new ArrayList<FoodItem>();
		for(int i = 0; i < foodlist.size(); i++)
		{
			if(foodlist.get(i).getName().toLowerCase().contains(name.toLowerCase()))
				p.add(foodlist.get(i));
		}
		return p;
	}
	
	/**
	 * 
	 * @param c attributes to search by
	 * @return list containing all items with matching attributes
	 
	public ArrayList<FoodItem> searchCourse(Course c) {
		ArrayList<FoodItem> cs = new ArrayList<FoodItem>();
		if((c == null)||(c.getCourse()==0)) {
			System.err.println("Input Incorrect");
		} else {
			for(FoodItem item : foodlist) {
				if(item.hasCourse(c)) {
					cs.add(item);
				}
			}
		}
		return cs;
	}
	
	/**
	 * Overloaded method for if user wants to use both search means
	 * @param name query to search by
	 * @param c attributes to search by
	 * @return list containing all matches of name AND matching attributes
	 
	public ArrayList<FoodItem> searchName(String name, Course c)
	{
		ArrayList<FoodItem> p = new ArrayList<FoodItem>();
		for(int i = 0; i < foodlist.size(); i++)
		{
			if(foodlist.get(i).getName().toLowerCase().contains(name.toLowerCase()))
				p.add(foodlist.get(i));
		}
		
		if((c == null)||(c.getCourse()==0)) {
			System.err.println("Input Incorrect");
		} else {
			for(FoodItem item : foodlist) {
				if(item.hasCourse(c)) {
					p.add(item);
				}
			}
		}
		return p;
	}
**/
	/*
	 * Only if we go with 1 recipe per food name, otherwise we use id to delete
	 */
	public void deleteName(String name)
	{
		for(int i = 0; i< foodlist.size(); i++)
		{
			if(foodlist.get(i).getName().toLowerCase().equals(name.toLowerCase()))
				foodlist.remove(i);
		}
			
	}
	
	
	/**
	 * 
	 * @return every fooditem currently in the storage system
	 */
	public Collection<FoodItem> displayAll()
	{
		return foodlist;
	}
	
	
	/**
	 * 
	 * @return A random food from collection
	 */
	public FoodItem getRandom()
	{
		return foodlist.get(new Random().nextInt(foodlist.size()));
	}
	
	
	/**
	 * Removes all fooditems
	 * TESTing only function
	 */
	public void removeAll()
	{
		foodlist.clear();
	}
	

}
