package stringPrograms;

import java.util.Scanner;

public class StringPolindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a string");
		String str = sc.nextLine();

		String reverse = "";

		for(int i = str.length() - 1; i >= 0; i--)
		{
			reverse = reverse + str.charAt(i);
		}

		System.out.println("Reversed String: " + reverse);
		
		if(str.equals(reverse))
		{
			System.out.println("The given string is a Polindrome");
		}
		else
		{
			System.out.println("The given string is not a Polindrome");
		}

		sc.close();


	}

}
