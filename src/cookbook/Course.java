package cookbook;
/*
 * This is a test idea, as to save on some fields for the Recipe.java class
 * Ideas are welcome, and getString method is a thought-experiment.
 */
public enum Course {
	BREAKFAST, LUNCH, DINNER, DESSERT, APPETIZER, SNACK;

public String getCourse() {
		//Returns a string of the Enum, just to save some lines of code
		switch(this) {
		case BREAKFAST:
			return "Breakfast";
	
		case LUNCH:
			return "Lunch";
	
		case DINNER: 
			return "Dinner";
	
		case DESSERT:
			return "Dessert";
		
		case APPETIZER: 
			return "Appetizer";
		
		case SNACK: 
			return "Snack";
			
		default:
			return null;
		}
	}
}