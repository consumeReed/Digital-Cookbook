package cookbook;

public class Attributes {
	
	/** Positions to meaning
	 * 0 Breakfast
	 * 1 Lunch
	 * 2 Dinner
	 * 3 Dessert
	 * 4 Appetizer
	 * 5 Snack
	 * 6 Side
	 * 7 Main
	 */
	public int attr = 0b00000000;
	
	public Attributes(){}
	
	public void changeBreakfast()
	{
		attr ^= 0b10000000;
	}
	
	public void changeLunch()
	{
		attr ^= 0b01000000;
	}
	
	public void changeDinner()
	{
		attr ^= 0b00100000;
	}
	
	public void changeDessert()
	{
		attr ^= 0b00010000;
	}
	
	public void changeAppetizer()
	{
		attr ^= 0b00001000;
	}
	
	public void changeSnack()
	{
		attr ^= 0b00000100;
	}
	
	public void changeSide()
	{
		attr ^= 0b00000010;
	}
	
	public void changeMain()
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
