package cookbook;
import java.util.*;

public class FoodItemList {
	
	private ArrayList<FoodItem> foodlist;
	
	public FoodItemList()
	{
		foodlist = new ArrayList<FoodItem>(); //will become an if statment later that will auto check if the user has existing data
	}
	
	
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
	
	public Collection<FoodItem> displayAll()
	{
		return foodlist;
	}
	
	public FoodItem getRandom()
	{
		return foodlist.get(new Random().nextInt(foodlist.size()));
	}
	
	public void removeAll()
	{
		foodlist.clear();
	}
	

}
