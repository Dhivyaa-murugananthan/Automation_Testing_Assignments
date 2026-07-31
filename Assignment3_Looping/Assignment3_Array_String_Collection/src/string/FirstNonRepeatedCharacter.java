package stringPrograms;

import java.util.Scanner;

public class FirstNonRepeatedCharacter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a string");
		String str = sc.nextLine().toLowerCase();

		char firstNonRepeated = ' ';

		for(int i = 0; i < str.length(); i++)
		{
			int count = 0;

			for(int j = 0; j < str.length(); j++)
			{
				if(str.charAt(i) == str.charAt(j))
				{
					count++;
				}
			}

			// Character appears only once
			if(count == 1)
			{
				firstNonRepeated = str.charAt(i);
				break;
			}
		}

		if(firstNonRepeated != ' ')
		{
			System.out.println("First non-repeated character is: " + firstNonRepeated);
		}
		else
		{
			System.out.println("No non-repeated character found");
		}

		sc.close();

	}

}
