package cookbook;

public class Attributes {
	
	/** Positions to meaning
	 * 0 Breakfast / Milk
	 * 1 Lunch / Eggs
	 * 2 Dinner / Fish
	 * 3 Dessert / Crustacean Shellfish
	 * 4 Appetizer / Tree Nuts
	 * 5 Snack / Peanuts
	 * 6 Side / Wheat
	 * 7 Main / Soya
	 */
	public int attr = 0b00000000;
	
	public Attributes(){}
	
	public void changePos0()
	{
		attr ^= 0b10000000;
	}
	
	public void changePos1()
	{
		attr ^= 0b01000000;
	}
	
	public void changePos2()
	{
		attr ^= 0b00100000;
	}
	
	public void changePos3()
	{
		attr ^= 0b00010000;
	}
	
	public void changePos4()
	{
		attr ^= 0b00001000;
	}
	
	public void changePos5()
	{
		attr ^= 0b00000100;
	}
	
	public void changePos6()
	{
		attr ^= 0b00000010;
	}
	
	public void changePos7()
	{
		attr ^= 0b00000001;
	}
	
	public int getAttributes()
	{
		return attr;
	}
	
	public String toString()
	{
		return attr + "";
	}
	
	/**public static void main(String[] args)
	{
		//Test with single attribute active
		System.out.println(attr);
		changeLunch();
		System.out.println(attr);
		changeLunch();
		System.out.println(attr);
		
		changeLunch();
		changeBreakfast();
		System.out.println("\n" + attr);
		changeBreakfast();
		System.out.println(attr);
	}**/

}
