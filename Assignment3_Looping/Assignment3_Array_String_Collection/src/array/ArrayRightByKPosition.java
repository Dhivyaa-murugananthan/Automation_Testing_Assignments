package arrayPrograms;

import java.util.Scanner;

public class ArrayRightByKPosition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter size of array");
		int size = sc.nextInt();

		int arr[] = new int[size];

		System.out.println("Enter array elements");

		for(int i = 0; i < size; i++)
		{
			arr[i] = sc.nextInt();
		}

		System.out.println("Enter K value");
		int k = sc.nextInt();

		// Right rotation
		for(int i = 1; i <= k; i++)
		{
			int last = arr[arr.length - 1];

			for(int j = arr.length - 1; j > 0; j--)
			{
				arr[j] = arr[j - 1];
			}

			arr[0] = last;
		}

		System.out.println("Array after right rotation:");

		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}

		sc.close();

	}

}
