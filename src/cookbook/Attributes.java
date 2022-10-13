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
	public static int attr = 0b00000000;
	
	public Attributes(){}
	
	public static void changeBreakfast()
	{
		attr ^= 0b10000000;
	}
	
	public static void changeLunch()
	{
		attr ^= 0b01000000;
	}
	
	public static void changeDinner()
	{
		attr ^= 0b00100000;
	}
	
	public static void changeDessert()
	{
		attr ^= 0b00010000;
	}
	
	public static void changeAppetizer()
	{
		attr ^= 0b00001000;
	}
	
	public static void changeSnack()
	{
		attr ^= 0b00000100;
	}
	
	public static void changeSide()
	{
		attr ^= 0b00000010;
	}
	
	public static void changeMain()
	{
		attr ^= 0b00000001;
	}
	
	
	public static void main(String[] args)
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
	}

}
