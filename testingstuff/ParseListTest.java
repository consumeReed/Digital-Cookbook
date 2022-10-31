import java.util.ArrayList;
import java.util.Scanner;

public class ParseListTest {

	public static void main(String[] args)
	{
		//Taking in user input until hits the delimiter
		ArrayList<String> list = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter text\n");
		while (true) {
		    String str = sc.nextLine();
		    if (str.equalsIgnoreCase("~")) break;         
		    list.add(str);
		}
		
		System.out.println(list);
		
		//Takes in all user input as one string then parses
		ArrayList<String> list2 = new ArrayList<String>();
		String myString = "1\n2\n3\n4\n5";
		Scanner scanner = new Scanner(myString);
		while (scanner.hasNextLine()) {
		  String line = scanner.nextLine();
		  list2.add(line);
		}
		scanner.close();
		
		System.out.println(list2);
	}

}
