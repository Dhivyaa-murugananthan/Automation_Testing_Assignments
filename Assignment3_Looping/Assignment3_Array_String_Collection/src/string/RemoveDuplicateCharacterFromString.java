package stringPrograms;

import java.util.Scanner;

public class RemoveDuplicateCharacterFromString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a string");
		String str = sc.nextLine();

		String result = "";

		for(int i = 0; i < str.length(); i++)
		{
			char ch = str.charAt(i);


			if(result.indexOf(ch) == -1)
			{
				result = result + ch;
			}
			
		}

		System.out.println("String after removing duplicates:");
		System.out.println(result);

		sc.close();

	}

}
