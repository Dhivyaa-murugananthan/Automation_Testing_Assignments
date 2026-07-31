package arrayPrograms;

import java.util.Scanner;

public class DuplicateArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the size of array");
		int size = sc.nextInt();

		int arr[] = new int[size];

		System.out.println("Enter array elements");

		for(int i = 0; i < size; i++)
		{
			arr[i] = sc.nextInt();
		}

		System.out.println("Array after removing duplicates:");

		for(int i = 0; i < size; i++)
		{
			boolean isDuplicate = false;

			for(int j = 0; j < i; j++)
			{
				if(arr[i] == arr[j])
				{
					isDuplicate = true;
					break;
				}
			}

			if(!isDuplicate)//
			{
				System.out.print(arr[i] + " ");
			}
		}

		sc.close();

	}

}
