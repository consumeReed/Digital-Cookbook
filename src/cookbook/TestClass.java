package cookbook;
import java.io.*;
import java.util.ArrayList;

public class TestClass {
	
	public static void main(String[] args)
	{
		/*
		 * Uncomment/comment out test methods you want to have shown in console.
		 */
		
		testRetrieval();
		//testAddRecipe();
		//testSearch();
		//testAddIngredientsToFood();
		//testRandomRecipe();
	}
	
	public static void testRetrieval()
	{
		FoodItemList f = new FoodItemList();
		
		f.addFood("Chicken Parmesan", " oven");
		f.addFood("Filet Mignon", "Preheat oven");
		f.addFood("Chicken Nuggets", "Frozen chicken nuggets into oven");
		f.addFood("Chicken Nuggets", "With Ketchup");
		f.addFood("Chilean Sea Bass", "pan sear the fish");
		f.foodlist.get(4).allergens.changePos2();
		f.foodlist.get(4).courses.changePos2();
		f.foodlist.get(4).courses.changePos1();
		f.updateFile();
		
		
		try{
		    FileInputStream readData = new FileInputStream("lib\\data.txt");
		    ObjectInputStream readStream = new ObjectInputStream(readData);

		    ArrayList<FoodItem> foo = (ArrayList<FoodItem>) readStream.readObject();
		    readStream.close();
		    System.out.println(foo.toString());
		    }catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	public static void testSearch()
	{
		FoodItemList f = new FoodItemList();
		f.addFood("chicken parm", "text");       //0
		f.addFood("Chicken nuggets", "text2");   //1
		f.addFood("pizza", "text3");             //2
		f.addFood("chicKens", "text4");          //3
		f.addFood("potato salad", "text5");      //4
		f.addFood("pizza steak", "text 6");      //5
		System.out.println("DISPLAYING ALL RECIPES\n-----------------------------");
		System.out.println(f.displayAll());
		System.out.println("\n\n");
		f.foodlist.get(0).allergens.changePos3();
		f.foodlist.get(1).allergens.changePos3();
		f.foodlist.get(2).allergens.changePos2();

		f.foodlist.get(0).courses.changePos3();
		f.foodlist.get(1).courses.changePos3();
		f.foodlist.get(2).courses.changePos2();
		f.foodlist.get(3).courses.changePos0();
		System.out.println("DISPLAYING ALL RECIPES WITH ATTRIBUTES\n-----------------------------\n" + f.displayAll());
		Attributes a = new Attributes(true);
		Attributes b = new Attributes(false);
		b.changePos3();
		a.changePos3();
		System.out.println("\n\nSEARCHING RECIPES WITH NAME CONTAINING PIZZA\n-----------------------------\n" + f.search("pizza", null, null));
		System.out.println("\n\nSEARCHING RECIPES WITH ALLERGY OF CRUSTACEAN SHELLFISH\n-----------------------------\n" + f.search(null, a, null));
		System.out.println("\n\nSEARCHING RECIPES WITH ALLERGY OF CRUSTACEAN SHELLFISH AND NAME CONTAINING PIZZA\n-----------------------------\n" + f.search("pizza", a, null));
		System.out.println("\n\nSEARCHING RECIPES WITH COURSE DESSERT AND NAME CONTAINING NUGGETS\n-----------------------------\n" + f.search("nuggets", null, b));
		System.out.println("\n\nSEARCHING RECIPES WITH ALLERGY OF CRUSTACEAN SHELLFISH AND COURSE DESSERT\n-----------------------------\n" + f.search(null, a, b));
		System.out.println("\n\nSEARCHING WITH NO FILTERS\n-----------------------------\n" + f.search(null, null, null));
	}
	
	public static void testAddRecipe()
	{
		FoodItemList f = new FoodItemList();
		
		f.addFood("Chicken Parmesan", " oven");
		f.addFood("Filet Mignon", "Preheat oven");
		f.addFood("Chicken Nuggets", "Frozen chicken nuggets into oven");
		f.addFood("Chicken Nuggets", "With Ketchup");
		
		System.out.println(f.displayAll());
	}
	
	public static void testAddIngredientsToFood()
	{
		FoodItem k = new FoodItem("Oven", "Pecans");
		System.out.println(k);
		
		k.addIngredient("pecans");
		k.addIngredient("pecans");
		k.addIngredient("sugar");
		System.out.println(k);
		
		System.out.println(k.containsIngredient("water"));
	}
	
	public static void testRandomRecipe()
	{
		FoodItemList f = new FoodItemList();
		f.addFood("Chicken Parmesan", " oven");
		f.addFood("Filet Mignon", "Preheat oven");
		f.addFood("Chicken Nuggets", "Frozen chicken nuggets into oven");
		f.addFood("Chicken Nuggets", "With Ketchup");
		System.out.println(f.getRandom());
	}
	

}
