package cookbook;

public class TestClass {
	
	public static void main(String[] args)
	{
		FoodItemList f = new FoodItemList();
		f.addFood("Chicken Parmesan", "Preheat an oven to 450 degrees F (230 degrees C).\r\n"
				+ "\r\n"
				+ "Place chicken breasts between two sheets of heavy plastic (resealable freezer bags work well) on a solid, level surface. Firmly pound chicken with the smooth side of a meat mallet to a thickness of 1/2-inch. Season chicken thoroughly with salt and pepper.\r\n"
				+ "\r\n"
				+ "Beat eggs in a shallow bowl and set aside.\r\n"
				+ "\r\n"
				+ "Mix bread crumbs and 1/2 cup Parmesan cheese in a separate bowl, set aside.\r\n"
				+ "\r\n"
				+ "Place flour in a sifter or strainer; sprinkle over chicken breasts, evenly coating both sides.\r\n"
				+ "\r\n"
				+ "Dip a flour-coated chicken breast in beaten eggs. Transfer breast to the bread crumb mixture, pressing crumbs into both sides. Repeat for each breast. Let chicken rest for 10 to 15 minutes.\r\n"
				+ "\r\n"
				+ "Heat 1/2 inch olive oil in a large skillet on medium-high heat until it begins to shimmer. Cook chicken in the hot oil until golden, about 2 minutes per side. The chicken will finish cooking in the oven.\r\n"
				+ "\r\n"
				+ "Transfer chicken to a baking dish. Top each breast with 2 tablespoons tomato sauce. Layer each chicken breast with equal amounts of mozzarella cheese, fresh basil, and provolone cheese. Sprinkle remaining Parmesan over top and drizzle each with 1/2 teaspoon olive oil.\r\n"
				+ "\r\n"
				+ "Bake in the preheated oven until cheese is browned and bubbly and chicken breasts are no longer pink in the center, 15 to 20 minutes. An instant-read thermometer inserted into the center should read at least 165 degrees F (74 degrees C).");
		
		
		f.addFood("Filet Mignon", "Preheat oven to 400�. In a large skillet over medium-high heat, heat oil. Season steak with salt and pepper on both sides. When oil is just about to smoke, add steak. Cook until very seared, about 5 minutes, then flip and add butter and rosemary. Baste with butter and cook another 3 to 5 minutes. \r\n"
				+ "Transfer skillet to oven and cook until cooked to your liking, about 5 minutes for medium. Pro tip: Check the temperature of your meat before transferring to the oven to see how far you are from the desired temperature. If you are within 10 degrees, you may need even less time. If your steak isn't done after 5 minutes, check every couple of minutes so you don't risk over cooking. \r\n"
				+ "Remove from pan and let rest 5 minutes before slicing.");
		
		f.addFood("Chicken Nuggets", "Frozen chicken nuggets into oven");
		
		f.addFood("Chicken Nuggets", "With Ketchup");
		
		System.out.println(f.searchName("Chicken Nuggets"));
		
		System.out.println(f.displayAll());
		
		System.out.println("\n\n\n\n\n");
		
		FoodItem k = new FoodItem("Oven", "Pecans");
		System.out.println(k);
		k.addIngredient("pecans");
		k.addIngredient("pecans");
		k.addIngredient("sugar");
		System.out.println(k);
		System.out.println(k.containsIngredient("water"));
		
		System.out.println("\n\n\n\n\n");
		System.out.println(f.getRandom());
		
		System.out.println("\n\n\n\n\n");
		System.out.println(f.searchName("hotdog"));
		
		System.out.println("\n\n\n\n\n");
		f.removeAll();
		f.addFood("chicken parm", "text");
		f.addFood("Chicken nuggets", "text2");
		f.addFood("pizza", "text3");
		f.addFood("chicKens", "text4");
		f.addFood("potato salad", "text5");
		System.out.println(f.searchName("chicken"));
		System.out.println("\n\n");
		System.out.println(f.searchName("chiCken par"));
		System.out.println("\n\n");
		System.out.println(f.searchName("hotdog"));
		System.out.println("\n\n");
		System.out.println(f.searchName("piz"));
		
		System.out.println("\n\n\n\n\n");
		f.deleteName("chicKen parm");
		System.out.println(f.displayAll());
		System.out.println("\n\n");
		
		f.removeAll();
		
		FoodItem item1 = new FoodItem("Freezer","Ice Cream");
		FoodItem item2 = new FoodItem("Fridge","Chicken");
		FoodItem item3 = new FoodItem("Stove","Breakfast Sausages");
		FoodItem item4 = new FoodItem("Oven", "Cookies");
		
		item1.addCourse(Course.DESSERT);
		item2.addCourse(Course.DINNER);
		item2.addCourse(Course.MAIN);
		item3.addCourse(Course.BREAKFAST);
		item3.addCourse(Course.SIDE);
		item4.addCourse(Course.DESSERT);
		
		f.addFood(item1);
		f.addFood(item2);
		f.addFood(item3);
		f.addFood(item4);
		
		System.out.println(f.displayAll());
		System.out.println("\n\n");
		
		System.out.println(f.searchCourse(null));
		System.out.println(f.searchCourse(Course.LUNCH));
		System.out.println(f.searchCourse(Course.BREAKFAST));
		System.out.println(f.searchCourse(Course.MAIN));
		System.out.println("\n\n");
		
	}

}
