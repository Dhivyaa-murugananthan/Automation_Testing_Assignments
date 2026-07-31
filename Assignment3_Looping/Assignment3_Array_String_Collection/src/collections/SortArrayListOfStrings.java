package collectionsPrograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SortArrayListOfStrings {

	public static void main(String[] args) {
		List<String> s1 = new ArrayList<>();
		s1.add("Banana");
		s1.add("Mango");
		s1.add("Apple");
		s1.add("Orange");
		s1.add("Jackfruit");
		System.out.println("The given string is: "+s1);
		Collections.sort(s1);
		System.out.println("The Sorted given string is: "+s1);
		

	}

}
