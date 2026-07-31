package stringPrograms;

import java.util.Arrays;
import java.util.Scanner;

public class StringAnagram {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter first string");
		String str1 = sc.nextLine();

		System.out.println("Enter second string");
		String str2 = sc.nextLine();

		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		if(str1.length()!=str2.length())
		{
			System.out.println("The given strings are not an anagram");
		}
		
		else
		{

		char arr1[] = str1.toCharArray();
		char arr2[] = str2.toCharArray();

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		if(Arrays.equals(arr1, arr2))
		{
			System.out.println("Strings are Anagrams");
		}
		else
		{
			System.out.println("Strings are Not Anagrams");
		}

		sc.close();

	}

}
}