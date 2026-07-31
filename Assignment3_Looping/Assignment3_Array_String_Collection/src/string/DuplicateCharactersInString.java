package stringPrograms;

import java.util.Scanner;

public class DuplicateCharactersInString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a string");
		String str = sc.nextLine().toLowerCase();

		System.out.println("Duplicate characters are:");
		boolean found = false;


		for(int i = 0; i < str.length(); i++)
		{
			int count = 0;

			for(int j = 0; j < str.length(); j++)
			{
				if(str.charAt(i) == str.charAt(j) && str.charAt(i) != ' ')
				{
					count++;
				}
			}

			// Print duplicate only once
			if(count > 1)
			{
				boolean alreadyPrinted = false;

				for(int k = 0; k < i; k++)
				{
					if(str.charAt(i) == str.charAt(k))
					{
						alreadyPrinted = true;
						break;
					}
				}
			
				if(!alreadyPrinted)
				{
					

					System.out.println(str.charAt(i));
				}
				
			}
		}
		if(!found)
		{
			System.out.println("No duplicates found");
		}
			
		
		
		sc.close();

	}

}
