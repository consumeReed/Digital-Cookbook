package cookbook;

import java.util.ArrayList;
import java.io.*;

public class Attributes implements Serializable{
	
	private boolean type; //Determines if course or allergy
	/**
	 * False  Course
	 * True   Allergy
	 */
	
	
	/** Positions to meaning: # Courses / Allergens
	 * 0 Breakfast / Milk
	 * 1 Lunch / Eggs
	 * 2 Dinner / Fish
	 * 3 Dessert / Crustacean Shellfish
	 * 4 Appetizer / Tree Nuts
	 * 5 Snack / Peanuts
	 * 6 Side / Wheat
	 * 7 Main / Soya
	 */
	
	private ArrayList<String> attrText = new ArrayList<String>();
	public int attr = 0b00000000;  //Default empty attributes
	
	
	public Attributes(boolean type){
		this.type = type;
	}
	
	public void changePos0()
	{
		attr ^= 0b10000000;
		updateStrings();
	}
	
	public void changePos1()
	{
		attr ^= 0b01000000;
		updateStrings();
	}
	
	public void changePos2()
	{
		attr ^= 0b00100000;
		updateStrings();
	}
	
	public void changePos3()
	{
		attr ^= 0b00010000;
		updateStrings();
	}
	
	public void changePos4()
	{
		attr ^= 0b00001000;
		updateStrings();
	}
	
	public void changePos5()
	{
		attr ^= 0b00000100;
		updateStrings();
	}
	
	public void changePos6()
	{
		attr ^= 0b00000010;
		updateStrings();
	}
	
	public void changePos7()
	{
		attr ^= 0b00000001;
		updateStrings();
	}
	
	public void updateStrings()
	{
		ArrayList<String> tmp = new ArrayList<String>();
		if((attr & 0b10000000) == 0b10000000)
		{
			if(type)
				tmp.add("Milk");
			else
				tmp.add("Breakfast");
		}
		if((attr & 0b01000000) == 0b01000000)
		{
			if(type)
				tmp.add("Eggs");
			else
				tmp.add("Lunch");
		}
		if((attr & 0b00100000) == 0b00100000)
		{
			if(type)
				tmp.add("Fish");
			else
				tmp.add("Dinner");
		}
		if((attr & 0b00010000) == 0b00010000)
		{
			if(type)
				tmp.add("Crustacean Shellfish");
			else
				tmp.add("Dessert");
		}
		if((attr & 0b00001000) == 0b00001000)
		{
			if(type)
				tmp.add("Tree Nuts");
			else
				tmp.add("Appetizer");
		}
		if((attr & 0b00000100) == 0b00000100)
		{
			if(type)
				tmp.add("Peanuts");
			else
				tmp.add("Snack");
		}
		if((attr & 0b00000010) == 0b00000010)
		{
			if(type)
				tmp.add("Wheat");
			else
				tmp.add("Side");
		}
		if((attr & 0b00000001) == 0b00000001)
		{
			if(type)
				tmp.add("Soya");
			else
				tmp.add("Main");
		}
		attrText = tmp;
	}
	
	public int getAttributes()
	{
		return attr;
	}
	
	public String toString()
	{
		return attrText.toString();
	}
	
	public static void main(String[] args)
	{
		//Test with single attribute active
		Attributes a = new Attributes(false);
		System.out.println(a);
		a.changePos1();
		System.out.println(a);
		a.changePos1();
		System.out.println(a);
		
		a.changePos1();
		a.changePos0();
		System.out.println("\n" + a);
		a.changePos0();
		System.out.println(a);
	}

}
