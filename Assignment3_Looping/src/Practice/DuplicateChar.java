/*Write a Java program to identify the duplicate char in the following string "Growskillit"*/

package Practice;

import java.util.HashSet;
import java.util.Set;

public class DuplicateChar {

	public static void main(String[] args) {
		String str = "Growskillit";
		Set <Character> seen = new HashSet<>();
		Set <Character> duplicates = new HashSet<>();
		for (char ch: str.toCharArray()) {
			if(!seen.add(ch)) {
				duplicates.add(ch);
			}
		}
		
		if (!duplicates.isEmpty()) {
			System.out.println("Duplicates are: " + duplicates);
		} else {
			System.out.println("No Duplictaes found");
		}

	}

}
