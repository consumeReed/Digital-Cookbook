package cookbook;

public class Recipe {
	private String recipe_name;
	private int people_feeds;
	private Course course;
	TextRecipe text_recipe;														// Creates a new Text object
	private String formatted_recipe;										// Stores formatted version of the recipe
	
	public Recipe(String recipe_name, int people_feeds, Course course) {
		this.recipe_name = recipe_name;
		this.people_feeds = people_feeds;
		this.course = course;
		text_recipe = new TextRecipe(get_recipe_name(), get_people_feeds());
	}
	
	/**
	 * Creates a formatted String including the recipes name, ingredients, instructions and
	 * the amount of people that it feeds.
	 */
	void create_text_recipe(){
		String formatted_instructions = null;
		String formatted_ingredients = null;
		for(int i=0; i <= text_recipe.get_ingredients_length(); i++) {
			formatted_ingredients = formatted_ingredients + text_recipe.get_ingredients(i) + "\n";
		}
		for(int i=0; i <= text_recipe.get_instructions_length(); i++) {
			formatted_instructions = formatted_instructions + "Step " + i + ": " + text_recipe.get_insturctions(i) + "\n";
		}
		
		formatted_recipe = get_recipe_name() + "\n" + get_people_feeds() + "\n\n" + formatted_ingredients + "\n\n" + formatted_instructions;
	}
	
	/**
	 * Recipe name Setter.
	 * @param recipe_name
	 */
	void set_recipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}
	
	/**
	 * People feeds Setter.
	 * @param people_feeds
	 */
	void set_people_feeds(int people_feeds) {
		this.people_feeds = people_feeds;
	}
	
	/**
	 * Course type Setter.
	 * @param new_Course
	 */
	void set_course(Course course) {
		this.course = course;
	}
	
	/**
	 * Formatted recipe Getter.
	 * @return formatted_recipe
	 */
	String get_formatted_recipe() {
		return formatted_recipe;
	}
	
	/**
	 * Recipe name Getter.
	 * @return recipe_name
	 */
	String get_recipe_name() {
		return recipe_name;
	}
	
	/**
	 * Recipe Course type Getter
	 * @return course
	 */
	String get_course() {
		course.getCourse();
	}
	
	/**
	 * People feeds Getter.
	 * @return people_feeds
	 */
	int get_people_feeds() {
		return people_feeds;
	}
	
}
