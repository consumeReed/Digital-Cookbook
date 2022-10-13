package cookbook;
/*
 * This is a test idea, as to save on some fields for the Recipe.java class
 * Ideas are welcome, and getString method is a thought-experiment.
 */
public enum Course {
	BREAKFAST, LUNCH, DINNER, DESSERT, APPETIZER, SNACK, SIDE, MAIN;

public int getCourse() {
		//Returns a string of the Enum, just to save some lines of code
		switch(this) {
		case BREAKFAST:
			return 1;
	
		case LUNCH:
			return 2;
	
		case DINNER: 
			return 4;
	
		case DESSERT:
			return 8;
		
		case APPETIZER: 
			return 16;
		
		case SNACK: 
			return 32;
			
		case SIDE:
			return 64;
			
		case MAIN:
			return 128;
			
		default:
			return 0;
		}
	}
}