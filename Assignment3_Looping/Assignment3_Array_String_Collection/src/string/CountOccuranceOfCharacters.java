package stringPrograms;

import java.util.Scanner;

public class CountOccuranceOfCharacters {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a string:");
		String str = sc.nextLine().toLowerCase();

		// Convert string into character array
		char[] ch = str.toCharArray();

		System.out.println("Character Occurrences:");

		for (int i = 0; i < ch.length; i++)
		{

			int count = 1;

			// Skip already counted characters
			if (ch[i] == '0') //v//a//
			{
				continue;
			}

			for (int j = i + 1; j < ch.length; j++)
			{

				if (ch[i] == ch[j] && ch[i] != ' ') 
				{

					count++;

					// Mark counted character
					ch[j] = '0';
				}
			}

			// Ignore spaces
			if (ch[i] != ' ')
			{
				System.out.println(ch[i] + " = " + count);
			}
		}

		sc.close();

	}

}
