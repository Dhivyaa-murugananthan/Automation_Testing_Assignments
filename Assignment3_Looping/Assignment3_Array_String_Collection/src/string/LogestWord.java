package stringPrograms;

import java.util.Scanner;

public class LogestWord {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a sentence");
		String sentence = sc.nextLine();

		String words[] = sentence.split(" ");

		String longestWord = "";

		for(int i = 0; i < words.length; i++)//i=0,0<3
		{
			if(words[i].length() > longestWord.length())
			{
				longestWord = words[i];
			}
		}

		System.out.println("Longest word is: " + longestWord);
		System.out.println("Length is: " + longestWord.length());

		sc.close();


	}

}
