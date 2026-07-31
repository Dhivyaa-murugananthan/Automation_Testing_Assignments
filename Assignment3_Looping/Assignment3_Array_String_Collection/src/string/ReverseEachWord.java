package stringPrograms;

import java.util.Scanner;

public class ReverseEachWord {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string");
		String str = sc.nextLine();
		String []s = str.split(" ");
		for(String x:s)
		{
			String rev = "";
			for(int i=x.length()-1; i>=0; i--)
			{
				rev = rev+x.charAt(i);
			}
			
			System.out.print(rev+ " ");
		}
		sc.close();

	}

}
