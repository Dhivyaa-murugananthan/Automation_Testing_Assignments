package arrayPrograms;

import java.util.Scanner;

public class DuplicateFinding {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int size = sc.nextInt();
		int []arr = new int[size];
		System.out.println("Enter the array elements");
		for(int i=0; i<size; i++)
		{
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Duplicate elements are:");

		
		for(int i=0; i<arr.length;i++)
		{
			for(int j=i+1; j<arr.length;j++)
			{
				if(arr[i]==arr[j]) 
				{
					System.out.println(arr[i]);
					break;
				}
			}
		}
		sc.close();

	}

}
