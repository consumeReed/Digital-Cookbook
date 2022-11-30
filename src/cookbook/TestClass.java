package cookbook;
import java.io.*;
import java.util.ArrayList;

public class TestClass {
	
	public static void main(String[] args)
	{
		/*
		 * Uncomment/comment out test methods you want to have shown in console.
		 */
		
		//testAddOne();
		//demo();
		//testAddMany();   //RUN CLEAR IF YOU WANT TO RUN THIS AGAIN OR DELETE DATA FILE CONTENTS
		testAddMany2();
		//testSearchInclusionExclusion();
		//testRetrievalID();
		//getID();
		//testDelete();
		//testRetrieval();
		//testAddRecipe();
		//testSearch();
		//testAddIngredientsToFood();
		//testRandomRecipe();
		//testRetrievalType();
		//testRetrievalCulture();
	}
	
	public static void testAddOne()
	{
		FoodItemList f = new FoodItemList();
		
		FoodItem food1 = new FoodItem("popopopopo");
		food1.addText("INSTRUCTIONS...");
		food1.courses.changePos1();
		food1.courses.changePos2();
		food1.allergens.changePos6();
		
		f.addFood(food1);
	}
	
	public static void demo()
	{
		FoodItemList f = new FoodItemList();
		
		Attributes a = new Attributes(true);  //allergy
		a.changePos1();
		a.changePos6();
		
		Attributes b = new Attributes(false);  //course
		b.changePos1();
		
		
		System.out.println(f.getById(2));
		System.out.println("\n\nSEARCHING WITH NO FILTERS\n-----------------------------\n" + f.search(null, null, null, false, false));
		System.out.println("\n\nSEARCHING RECIPES WITH NAME CONTAINING CHICKEN\n-----------------------------\n" + f.search("chicken", null, null, false, false));
		System.out.println("\n\nSEARCHING RECIPES WITH NAME CONTAINING CHICKEN AND LUNCH COURSE\n-----------------------------\n" + f.search("chicken", null, b, false, false));
		System.out.println("\n\nSEARCHING RECIPES WITH NAME CONTAINING CHICKEN AND NOT LUNCH COURSE\n-----------------------------\n" + f.search("chicken", null, b, false, true));
		System.out.println("\n\nSEARCHING RECIPES WITH ALLERGENS OF EGGS AND/OR WHEAT\n-----------------------------\n" + f.search(null, a, null, false, false));
		System.out.println("\n\nSEARCHING RECIPES WITH NAME CONTAINING PIE AND ALLERGENS OF EGGS AND/OR WHEAT\n-----------------------------\n" + f.search("pie", a, null, false, false));
		System.out.println("\n\nSEARCHING RECIPES WITHOUT ALLERGENS OF EGGS AND/OR WHEAT\n-----------------------------\n" + f.search(null, a, null, true, false));
		System.out.println("\n\nSEARCHING RECIPES WITH LUNCH COURSE\n-----------------------------\n" + f.search(null, null, b, false, false));
		System.out.println("\n\nORIGINAL RECIPE\n-----------------------------\n"+ f.getById(2));
		f.getById(2).addImage("IMAGE LOCATION/NAME");
		f.getById(2).allergens.changePos0();
		//f.updateFile();
		System.out.println("\n\nMODIFIED RECIPE\n-----------------------------\n"+ f.getById(2));
		
	}
	/**
	 * RUN A CLEAR OR DELETE DATA FILE CONTENTS BEFORE RUNNING AGAIN
	 */
	public static void testAddMany()
	{
		//true image         false text
		FoodItemList f = new FoodItemList();
		
		FoodItem food1 = new FoodItem("Chicken nuggets");
		food1.addText("INSTRUCTIONS...");
		//food1.courses.changePos1();
		//food1.courses.changePos2();
		food1.allergens.changePos6();
		food1.addIngredient("Chicken");
		food1.addIngredient("Nuggets");
		food1.changeCulture("Barn Animal");
		
		FoodItem food2 = new FoodItem("Chicken parmesan");
		food2.addText("INSTRUCTIONS...");
		food2.courses.changePos2();
		food2.courses.changePos7();
		food2.allergens.changePos6();
		food2.allergens.changePos0();
		food2.allergens.changePos1();
		
		FoodItem food3 = new FoodItem("Chicken Parm");
		food3.addImage("IMAGE LOCATION/NAME...");
		food3.courses.changePos2();
		food3.courses.changePos7();
		food3.allergens.changePos6();
		food3.allergens.changePos0();
		food3.allergens.changePos1();
		
		FoodItem food4 = new FoodItem("filet mignon");
		food4.addText("IMAGE LOCATION/NAME...");
		food4.courses.changePos2();
		food4.courses.changePos7();
		
		FoodItem food5 = new FoodItem("Chilean sea bass");
		food5.addImage("IMAGE LOCATION/NAME...");
		food5.courses.changePos2();
		food5.courses.changePos1();
		food5.courses.changePos7();
		food5.allergens.changePos2();
		
		FoodItem food6 = new FoodItem("Caesar Salad");
		food6.addText("INSTRUCTIONS...");
		food6.courses.changePos4();
		food6.courses.changePos5();
		food6.allergens.changePos6();
		
		FoodItem food7 = new FoodItem("Sweet Potato pie");
		food7.addText("INSTRUCTIONS...");
		food7.allergens.changePos1();
		food7.allergens.changePos6();
		food7.courses.changePos3();
		
		FoodItem food8 = new FoodItem("filet mignon");
		food8.addText("IMAGE LOCATION/NAME 2...");
		food8.courses.changePos2();
		food8.courses.changePos7();
		
		f.addFood(food1);
		f.addFood(food2);
		f.addFood(food3);
		f.addFood(food4);
		f.addFood(food5);
		f.addFood(food6);
		f.addFood(food7);
		f.addFood(food8);
		
		
	}
	
	public static void testAddMany2()
	{
		//true image         false text
		FoodItemList f = new FoodItemList();
		
		FoodItem food1 = new FoodItem("spaghetti and meatballs");
		food1.addText("INSTRUCTIONS...");
		food1.courses.changePos1();
		food1.courses.changePos2();
		food1.courses.changePos7();
		food1.allergens.changePos1();
		food1.allergens.changePos6();
		
		FoodItem food2 = new FoodItem("smiley hashbrowns");
		food2.addText("INSTRUCTIONS...");
		food2.courses.changePos6();
		
		FoodItem food3 = new FoodItem("pancakes");
		food3.addImage("IMAGE LOCATION/NAME...");
		food3.courses.changePos0();
		food3.courses.changePos7();
		food3.allergens.changePos0();
		food3.allergens.changePos6();
		
		FoodItem food4 = new FoodItem("grilled cheese");
		food4.addText("IMAGE LOCATION/NAME...");
		food4.courses.changePos1();
		food4.courses.changePos2();
		food4.allergens.changePos0();
		food4.allergens.changePos6();
		food4.allergens.changePos1();
		
		FoodItem food5 = new FoodItem("peanut butter and jelly");
		food5.addImage("IMAGE LOCATION/NAME...");
		food5.courses.changePos1();
		food5.allergens.changePos5();
		food5.allergens.changePos6();
		
		FoodItem food6 = new FoodItem("2003 honda civic");
		food6.addText("INSTRUCTIONS...");
		food6.courses.changePos0();
		
		FoodItem food7 = new FoodItem("salsbury steak");
		food7.addText("INSTRUCTIONS...");
		food7.allergens.changePos2();
		food7.allergens.changePos7();
		food7.courses.changePos0();
		
		FoodItem food8 = new FoodItem("chocolate milkshake");
		food8.addText("IMAGE LOCATION/NAME 2...");
		food8.courses.changePos3();
		food8.allergens.changePos4();
		food8.allergens.changePos0();
		
		f.addFood(food1);
		f.addFood(food2);
		f.addFood(food3);
		f.addFood(food4);
		f.addFood(food5);
		f.addFood(food6);
		f.addFood(food7);
		f.addFood(food8);
		
		
	}
	
	public static void testSearchInclusionExclusion()
	{
		FoodItemList f = new FoodItemList();
		//System.out.println(f.displayAll());
		Attributes a = new Attributes(true);
		Attributes b = new Attributes(false);
		b.changePos3();
		a.changePos3();
		f.getById(2).allergens.changePos3();
		//search name, allergy, course, includeallergy, includecourse
		System.out.println("\n\nSEARCHING RECIPES WITH NAME CONTAINING PIZZA\n-----------------------------\n" + f.search(null, a, null, false, false));
	}
	
	public static void testRetrievalID()
	{
		FoodItemList f = new FoodItemList();
		//System.out.println(f.displayAll());
		//System.out.println(f.displayAll());
		f.addFood("chocolate","cocoa powder");
		//System.out.println(f.displayAll());
		f.removeAll();
		System.out.println(f.displayAll());
		f.addFood("test", "text");
		System.out.println(f.displayAll());
		
	}
	
	public static void getID()
	{
		FoodItemList f = new FoodItemList();
		f.addFood("Chicken Parmesan", " oven");
		f.addFood("Filet Mignon", "Preheat oven");
		f.addFood("Chicken Nuggets", "Frozen chicken nuggets into oven");
		f.addFood("Chicken Nuggets", "With Ketchup");
		f.addFood("Chilean Sea Bass", "pan sear the fish");
		f.deleteFood(4);
		f.addFood("chicken soup", "pot with food");
		System.out.println(f.displayAll());
		System.out.println("\n\n\n"+f.getById(3));
	}
	
	public static void testDelete()
	{
		
		FoodItemList f = new FoodItemList();
		f.addFood("Chicken Parmesan", " oven");
		f.addFood("Filet Mignon", "Preheat oven");
		f.addFood("Chicken Nuggets", "Frozen chicken nuggets into oven");
		f.addFood("Chicken Nuggets", "With Ketchup");
		f.addFood("Chilean Sea Bass", "pan sear the fish");
		System.out.println(f.displayAll());
		f.deleteFood(4);
		System.out.println(f.displayAll());
		f.addFood("chicken soup", "pot with food");
		System.out.println(f.displayAll());
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
	
	public static void testRetrievalType()
	{
		FoodItem k = new FoodItem("Do slice", "Apple");
		FoodItem l = new FoodItem("Banana");
		
		System.out.println(k.getType());
		System.out.println(l.getType());
		
	}
	
	public static void testRetrievalCulture()
	{
		FoodItem k = new FoodItem("Do slice", "Apple");
		k.changeCulture("Culture");
		
		System.out.println(k.getCulture());
	}
	
}
