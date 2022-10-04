package cookbook;

public class Text extends Recipe {
	public Text(String recipe_name, int people_feeds) {
		super(recipe_name, people_feeds);
	}

	private String[] ingredients;										// String array of ingredients
	private String[] instructions;										// String array of instructions

	/**
	 * Adds an ingredient to the ingredients array.
	 * @param ingredient	String entered from Text Field in GUI
	 */
	void add_ingredient(String ingredient) {
		ingredients[ingredients.length] = ingredient;
	}
	
	/**
	 * Removes an ingredient from the ingredients array.
	 * @param button_number		Int returned from Button press in GUI
	 */
	void remove_ingredient(int button_number) {
		ingredients[button_number] = null;
	}
	
	/**
	 * Adds an instruction to the instructions array.
	 * @param instruction	String entered from Text Field in GUI
	 */
	void add_instruction(String instruction) {
		instructions[instructions.length] = instruction;
	}
	
	/**
	 * Removes an ingredient from the ingredients array.
	 * @param button_number		Int returned from Button press in GUI
	 */
	void remove_instruction(int button_number) {
		instructions[button_number] = null;
	}
	
	/**
	 * Getter for ingredient in specified position.
	 * @param i		Int used to retrieve ingredient in specified position
	 * @return ingredients[i]	String stored in ingredients array at position i
	 */
	String get_ingredients(int i) {
		return ingredients[i];
	}
	
	/**
	 * Getter for instruction in specified position.
	 * @param i		Int used to retrieve instruction in specified position
	 * @return instruction[i]	String stored in instruction array at position i
	 */
	String get_insturctions(int i) {
		return instructions[i];
	}
	
	/**
	 * Getter for ingredient arrays length.
	 * @return ingredients.length	Int representing amount of ingredients in ingredients array
	 */
	int get_ingredients_length() {
		return ingredients.length;
	}
	
	/**
	 * Getter for instruction arrays length.
	 * @return instructions.length	Int representing amount of instructions in instructions array
	 */
	int get_instructions_length() {
		return instructions.length;
	}
	
}
