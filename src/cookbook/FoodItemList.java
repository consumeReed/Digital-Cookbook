package cookbook;
import java.util.*;

public class FoodItemList {
	
	private HashMap<String, FoodItem> foodlist;
	
	public FoodItemList()
	{
		foodlist = new HashMap<String, FoodItem>(); //will become an if statment later that will auto check if the user has existing data
	}
	
	
	public void addFood(String name, String textInstructions)
	{
		FoodItem newFood = new FoodItem(textInstructions, name);
		String tmp = newFood.getName();
		foodlist.put(tmp, newFood);
	}
	
	
	public FoodItem searchName(String name)
	{
		return foodlist.get(name);
	}
	
	
	public void deleteName(String name)
	{
		foodlist.remove(name);
	}
	
	public Collection<FoodItem> displayAll()
	{
		return foodlist.values();
	}
	

}
