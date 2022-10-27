package cookbook;
import java.util.*;

public class RemoveFoodItem implements Iterator {
	
	public ArrayList<FoodItem> foodlist;

	public RemoveFoodItem(ArrayList<FoodItem> foodlist)
	{
		this.foodlist = foodlist;
	}
	
	public ArrayList<FoodItem> remove(int id)
	{
		ListIterator<FoodItem> it = foodlist.listIterator();
		while(it.hasNext())
		{
			FoodItem tmp = (FoodItem) it.next();
			if(tmp.getId()==id)
				it.remove();
		}
		return foodlist;
	}
	

	public boolean hasNext() {
		return false;
	}

	@Override
	public Object next() {
		return null;
	}
	

}
