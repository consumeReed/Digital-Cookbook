package cookbook;
import java.util.*;
import java.io.*;

public class FoodItemList implements Serializable {
	
	public ArrayList<FoodItem> foodlist;
	public int globalid = 0;
	
	public FoodItemList()
	{
		foodlist = new ArrayList<FoodItem>();
		
		try{
			
		    FileInputStream readData = new FileInputStream("lib\\data.txt");
		    ObjectInputStream readStream = new ObjectInputStream(readData);

		    ArrayList<FoodItem> foo = (ArrayList<FoodItem>) readStream.readObject();
		    readStream.close();
		    foodlist = foo;
		    globalid = foodlist.get(foodlist.size()-1).getId();
		    }catch (Exception e) {
		    	foodlist = new ArrayList<FoodItem>();
		}
		
	}
	
	public void updateFile()
	{
		try{
			PrintWriter writer = new PrintWriter("lib\\data.txt");
			writer.print("");
			writer.close();
			
		    FileOutputStream writeData = new FileOutputStream("lib\\data.txt");
		    ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

		    writeStream.writeObject(foodlist);
		    writeStream.flush();
		    writeStream.close();

		}catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param name name of new recipe
	 * @param textInstructions text instruction
	 */
	public void addFood(String name, String textInstructions)
	{
		FoodItem newFood = new FoodItem(textInstructions, name);
		newFood.id = globalid+1;
		globalid++;
		foodlist.add(newFood);
		
		updateFile();
	}
	
	/**
	 * Test method
	 * @param adder
	 */
	public void addFood(FoodItem adder) {
		FoodItem newFood = adder;
		newFood.id = globalid+1;
		foodlist.add(newFood);
	}
	
	  /**
	   * Delete fooditem by ID
	   * @param ids
	   */
	  public void deleteFood(int ids) {
	  		RemoveFoodItem rfi = new RemoveFoodItem(foodlist);
	  		foodlist = rfi.remove(ids);	
	  		updateFile();
	 }

	
	public FoodItem getById(int ids) 
	{
		for(FoodItem f : foodlist)
		{
			if(f.getId()==ids)
				return f;
		}
		return null;
	}
	

	/**
	 * Search method
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
	 * Search method with inclusion/exclusion
	 * 
	 */
	public ArrayList<FoodItem> search(String name, Attributes allergy, Attributes course, boolean includeAllergy, boolean includeCourse)
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
						if(item.hasAllergens(allergy)&&includeAllergy)
							tmp2.add(item);
					}
					searchedList = tmp2;
				}
		
		if(course != null) {
			ArrayList<FoodItem> tmp3 = new ArrayList<>();
			for(FoodItem item : searchedList) {
				if(item.inCourse(course)&&includeCourse) {
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

	
	/**
	 * 
	 * @return every fooditem currently in the storage system
	 */
	public String displayAll()
	{
		String tmp = "";
		for(int i = 0; i < foodlist.size(); i++)
		{
			tmp+=foodlist.get(i)+"\n\n";
		}
		return tmp;
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
		updateFile();
	}
	

}
